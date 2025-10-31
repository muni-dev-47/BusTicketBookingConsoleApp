package repository.passengerRepo;

import models.User;
import repository.querys.passengerQuerys.PassengerQuery;
import util.DBQueryExecutorUtil;
import util.PasswordHasher;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class AuthRepository {

    private static AuthRepository pr;

    private AuthRepository() {

    }

    public static AuthRepository getInstance() {
        if (pr == null) {
            pr = new AuthRepository();
        }
        return pr;
    }

    public long save(User user) throws SQLException {
        long id = DBQueryExecutorUtil.executeInsertAndReturnKey(PassengerQuery.INSERT_PASSENGER_AND_RETURN_ID.getQuery(), new ArrayList<>(Arrays.asList(user.getUserName(), user.getPassword(), user.getMobileNumber())));
        return id;
    }

    public User signUp(User user) {
        return null;
    }

    public boolean findByUserMobileNumber(String mobileNumber) {
        try {
            ResultSet rs = DBQueryExecutorUtil.executeQueryWithResultSet(PassengerQuery.FIND_BY_MOBILE_NUMBER.getQuery(), new ArrayList<>(Collections.singletonList(mobileNumber)));
            while (rs.next()) {
                return true;
            }
        } catch (SQLException se) {
            System.out.println(se);
        }
        return false;
    }

    public long findUser(User user) {
        try {
            ResultSet rs = DBQueryExecutorUtil.executeQueryWithResultSet(PassengerQuery.FIND_BY_MOBILE_NUMBER_AND_PASSWORD.getQuery(), new ArrayList<>(Arrays.asList(user.getMobileNumber())));
            while (rs.next()) {
                if (PasswordHasher.verifyPassword(user.getPassword(), rs.getString("password"))) {
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

