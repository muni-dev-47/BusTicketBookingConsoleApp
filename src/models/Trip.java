package models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Trip {

    private long tripId;
    private long driverId;
    private int routeId;
    private int busId;
    private LocalDate tripDate;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private double baseFare;
    private String tripStatus;

    public Trip(long tripId, int routeId, int busId, LocalDate tripDate, LocalTime departureTime, LocalTime arrivalTime, double baseFare, String tripStatus) {
        this.tripId = tripId;
        this.routeId = routeId;
        this.busId = busId;
        this.tripDate = tripDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.baseFare = baseFare;
        this.tripStatus = tripStatus;
    }

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    public long getTripId() {
        return tripId;
    }

    public void setTripId(long tripId) {
        this.tripId = tripId;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public LocalDate getTripDate() {
        return tripDate;
    }

    public void setTripDate(LocalDate tripDate) {
        this.tripDate = tripDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(double baseFare) {
        this.baseFare = baseFare;
    }

    public String getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(String tripStatus) {
        this.tripStatus = tripStatus;
    }
}