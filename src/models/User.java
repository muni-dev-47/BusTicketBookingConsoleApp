package models;

public abstract class User {
    private long userId;
    private String userName;
    private String password;
    private String mobileNumber;

    public User(long userId, String userName, String password, String mobileNumber) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.mobileNumber = mobileNumber;
    }

    public User(String mobileNumber, String password) {
        this.password = password;
        this.mobileNumber = mobileNumber;
    }

    public User(String userName, String mobileNumber, String password) {
        this.userName = userName;
        this.password = password;
        this.mobileNumber = mobileNumber;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
