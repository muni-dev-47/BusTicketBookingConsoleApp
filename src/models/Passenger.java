package models;

public class Passenger extends User {

    public Passenger(String mobileNumber, String password) {
        super(mobileNumber, password);
    }

    public Passenger(String userName, String mobileNumber, String password) {
        super(userName, mobileNumber, password);
    }

    public Passenger(long userId, String userName, String password, String mobileNumber) {
        super(userId, userName, password, mobileNumber);
    }
}
