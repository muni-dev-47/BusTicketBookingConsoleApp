package models;

import java.time.LocalDateTime;

public class Owner extends User {
    private String companyName;     // E.g., "KSRTC", "SRM Travels"
    private String gstNumber;       // GST Identification for business
    private String headOfficeCity;
    private String status;          // E.g., "Active", "Suspended"
    private LocalDateTime dateJoined;


    public Owner(String userName, String password, String mobileNumber, String companyName, String gstNumber, String headOfficeCity) {
        super(userName, mobileNumber, password);
        this.companyName = companyName;
        this.gstNumber = gstNumber;
        this.headOfficeCity = headOfficeCity;
    }

    public Owner(long userId, String userName, String password, String mobileNumber, String companyName, String gstNumber, String headOfficeCity, String status, LocalDateTime dateJoined) {
        super(userId, userName, password, mobileNumber);
        this.companyName = companyName;
        this.gstNumber = gstNumber;
        this.headOfficeCity = headOfficeCity;
        this.status = status;
        this.dateJoined = dateJoined;
    }

    public Owner(String mobileNumber, String password) {
        super(mobileNumber, password);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public String getHeadOfficeCity() {
        return headOfficeCity;
    }

    public void setHeadOfficeCity(String headOfficeCity) {
        this.headOfficeCity = headOfficeCity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDateTime dateJoined) {
        this.dateJoined = dateJoined;
    }
}
