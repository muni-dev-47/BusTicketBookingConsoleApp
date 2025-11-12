package models;

public class Bus {
    private long busId;
    private long userId;
    private int totalSeats;
    private String registrationNumber;
    private String busName;
    private String busType;
    private String amenities;
    private String status;
    private double minTurnaroundTimeHours;

    public Bus(long busId, long userId, int totalSeats, String registrationNumber, String busName, String busType, String amenities, double minTurnaroundTimeHours, String status) {
        this.busId = busId;
        this.userId = userId;
        this.totalSeats = totalSeats;
        this.registrationNumber = registrationNumber;
        this.busName = busName;
        this.busType = busType;
        this.amenities = amenities;
        this.status = status;
        this.minTurnaroundTimeHours = minTurnaroundTimeHours;
    }

    public Bus(String amenities, String busType, String busName, String registrationNumber, int totalSeats, long userId, double minTurnaroundTimeHours) {
        this.amenities = amenities;
        this.busType = busType;
        this.busName = busName;
        this.registrationNumber = registrationNumber;
        this.totalSeats = totalSeats;
        this.minTurnaroundTimeHours = minTurnaroundTimeHours;
        this.userId = userId;
    }

    public double getMinTurnaroundTimeHours() {
        return minTurnaroundTimeHours;
    }

    public void setMinTurnaroundTimeHours(double minTurnaroundTimeHours) {
        this.minTurnaroundTimeHours = minTurnaroundTimeHours;
    }

    public long getBusId() {
        return busId;
    }

    public void setBusId(long busId) {
        this.busId = busId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

