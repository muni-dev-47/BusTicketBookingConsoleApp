package view.auth.signup;

import config.ServiceLocator;
import controllers.ownercontrollers.OwnerController;
import models.Owner;
import util.InputUtil;
import util.PasswordHasher;
import util.PropertyFileHandler;
import view.auth.authInterfaces.SignUp;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

public class OwnerSignUpView implements SignUp {
    private static OwnerSignUpView osv;

    private OwnerSignUpView() {
    }

    public static OwnerSignUpView getInstance() {
        if (osv == null) {
            osv = new OwnerSignUpView();
        }
        return osv;
    }

    @Override
    public void signUp() {
        String mobileNumber = InputUtil.OwnerFormInputUtil.readMobileNumber();
        if (!OwnerController.isMobileAvailable(mobileNumber)) {
            System.out.println("❌ Error: This mobile number is already registered with an existing account. Please use a different number or try logging in.");
            return;
        }
        String companyName = InputUtil.OwnerFormInputUtil.getCompanyName();
        String headOfficeCity = InputUtil.OwnerFormInputUtil.getCity("🏙️ Enter Company Head Office City");
        if (!OwnerController.isCityAndCompanyNameAvailable(headOfficeCity, companyName)) {
            System.out.println("❌ Error: This Company Name (and Head Office City) is already registered by another operator. Please verify the company details or contact support if you believe this is an error.");
            return;
        }
        String GST_NUMBER = InputUtil.OwnerFormInputUtil.readGSTNumber();
        if (!OwnerController.isGSTNumberAvailable(GST_NUMBER)) {
            System.out.println("❌ Error: This GST Number is already registered in our system. \n" +
                    "Each company requires a unique GSTIN. \n" +
                    "If this is your company, please use the correct login credentials or contact our Admin team for assistance.");
            return;
        }
        String userName = InputUtil.OwnerFormInputUtil.readName();
        try {
            String password = PasswordHasher.hashPassword(InputUtil.OwnerFormInputUtil.readPassword());
            long id = OwnerController.handlePassengerSignUp(new Owner(userName, password, mobileNumber, companyName, GST_NUMBER, headOfficeCity));
            PropertyFileHandler.saveProperty("userId", String.valueOf(id));
            ServiceLocator.getInstance().getOwnerView().view();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
