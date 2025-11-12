package models;

import java.time.LocalDate;

public class Driver {

    private int driverId;
    private int ownerId;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String address;
    private String licenseNumber;
    private LocalDate licenseExpiryDate;
    private String licenseType;
    private String driverStatus; // E.g., "Active", "On Leave", "Fired"
    private LocalDate dateOfJoining;

    public Driver(int driverId, int operatorId, String fullName, String phoneNumber, String email, String address, String licenseNumber, LocalDate licenseExpiryDate, String licenseType, String driverStatus, LocalDate dateOfJoining) {
        this.driverId = driverId;
        this.ownerId = operatorId;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.licenseNumber = licenseNumber;
        this.licenseExpiryDate = licenseExpiryDate;
        this.licenseType = licenseType;
        this.driverStatus = driverStatus;
        this.dateOfJoining = dateOfJoining;
    }

    public Driver(int driverId, String fullName) {
        this.driverId = driverId;
        this.fullName = fullName;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getOperatorId() {
        return ownerId;
    }

    public void setOperatorId(int operatorId) {
        this.ownerId = operatorId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public LocalDate getLicenseExpiryDate() {
        return licenseExpiryDate;
    }

    public void setLicenseExpiryDate(LocalDate licenseExpiryDate) {
        this.licenseExpiryDate = licenseExpiryDate;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public String getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(String driverStatus) {
        this.driverStatus = driverStatus;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }
}