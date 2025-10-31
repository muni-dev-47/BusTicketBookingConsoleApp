package repository.ownerRepo;

import models.Owner;
import repository.querys.ownerQuerys.OwnerQuery;
import util.DBQueryExecutorUtil;
import util.PasswordHasher;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AuthRepository {

    private static AuthRepository or;

    private AuthRepository() {

    }

    public static AuthRepository getInstance() {
        if (or == null) {
            or = new AuthRepository();
        }
        return or;
    }


    public long save(Owner owner) throws SQLException {
        return DBQueryExecutorUtil.executeInsertAndReturnKey(OwnerQuery.INSERT_OWNER_AND_RETURN_ID.getQuery(), new ArrayList<>(Arrays.asList(owner.getUserName(), owner.getPassword(), owner.getMobileNumber(), owner.getCompanyName(), owner.getGstNumber(), owner.getHeadOfficeCity())));
    }

    public boolean findByUserMobileNumber(String mobileNumber) {
        try {
            ResultSet rs = DBQueryExecutorUtil.executeQueryWithResultSet(OwnerQuery.FIND_BY_MOBILE_NUMBER.getQuery(), new ArrayList<>(Collections.singletonList(mobileNumber)));
            while (rs.next()) {
                return true;
            }
        } catch (SQLException _) {
        }
        return false;
    }

    public boolean findByCityAndCompanyName(String city, String companyName) {
        try {
            ResultSet rs = DBQueryExecutorUtil.executeQueryWithResultSet(OwnerQuery.FIND_BY_COMPANY_NAME_AND_CITY.getQuery(), new ArrayList<>(Arrays.asList(city, companyName)));
            while (rs.next()) {
                return true;
            }
        } catch (SQLException se) {
            System.out.println(se);
        }
        return false;
    }


    public boolean findByGSTNumber(String gstNumber) {
        try {
            ResultSet rs = DBQueryExecutorUtil.executeQueryWithResultSet(OwnerQuery.FIND_BY_GST_NUMBER.getQuery(), new ArrayList<>(Collections.singleton(gstNumber)));
            while (rs.next()) {
                return true;
            }
        } catch (SQLException se) {
            System.out.println(se);
        }
        return false;
    }

    public long findUser(Owner owner) {
        try {
            ResultSet rs = DBQueryExecutorUtil.executeQueryWithResultSet(OwnerQuery.FIND_BY_MOBILE_NUMBER_AND_PASSWORD.getQuery(), new ArrayList<>(Arrays.asList(owner.getMobileNumber())));
            while (rs.next()) {
                if (PasswordHasher.verifyPassword(owner.getPassword(), rs.getString("password"))) {
                    return rs.getLong("userId");
                } else {
                    return 0;
                }
            }
        } catch (SQLException se) {
            System.out.println(se);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
