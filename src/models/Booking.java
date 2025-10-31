package models;

import java.time.LocalDateTime;

public class Booking {

    private long bookingId;
    private int userId;
    private long tripId;
    private int seatId;
    private double totalAmount;
    private String passengerName;
    private String passengerGender;
    private int passengerAge;
    private String bookingStatus;
    private LocalDateTime bookingTime;

    public Booking(long bookingId, int userId, long tripId, int seatId, double totalAmount, String passengerName, String passengerGender, int passengerAge, String bookingStatus, LocalDateTime bookingTime) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.tripId = tripId;
        this.seatId = seatId;
        this.totalAmount = totalAmount;
        this.passengerName = passengerName;
        this.passengerGender = passengerGender;
        this.passengerAge = passengerAge;
        this.bookingTime = bookingTime;
        this.bookingStatus = bookingStatus;
    }

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getTripId() {
        return tripId;
    }

    public void setTripId(long tripId) {
        this.tripId = tripId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerGender() {
        return passengerGender;
    }

    public void setPassengerGender(String passengerGender) {
        this.passengerGender = passengerGender;
    }

    public int getPassengerAge() {
        return passengerAge;
    }

    public void setPassengerAge(int passengerAge) {
        this.passengerAge = passengerAge;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }
}