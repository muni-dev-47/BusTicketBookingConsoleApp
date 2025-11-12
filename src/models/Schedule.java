package models;

import java.time.Duration;
import java.time.LocalTime;

public class Schedule {
    private Long scheduleId;
    private Long busId;
    private Long driverId;
    private long routeId;
    private LocalTime startingTime;
    private LocalTime endingTime;
    private double totalDistanceKm;
    private double restTimeMinutes;
    private String day;

    public Schedule(Long busId, Long driverId, long routeId, LocalTime startingTime, LocalTime endingTime, double totalDistanceKm, double restTimeMinutes) {
        this.busId = busId;
        this.driverId = driverId;
        this.routeId = routeId;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.totalDistanceKm = totalDistanceKm;
        this.restTimeMinutes = restTimeMinutes;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Long getBusId() {
        return busId;
    }

    public void setBusId(Long busId) {
        this.busId = busId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    public LocalTime getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(LocalTime startingTime) {
        this.startingTime = startingTime;
    }

    public LocalTime getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(LocalTime endingTime) {
        this.endingTime = endingTime;
    }

    public long getTotalTravelTime() {
        return calculateTripDurationHours(this.startingTime, this.endingTime);
    }

    public double getTotalDistanceKm() {
        return totalDistanceKm;
    }

    public void setTotalDistanceKm(double totalDistanceKm) {
        this.totalDistanceKm = totalDistanceKm;
    }

    public double getRestTimeMinutes() {
        return restTimeMinutes;
    }

    public void setRestTimeMinutes(int restTimeMinutes) {
        this.restTimeMinutes = restTimeMinutes;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public static long calculateTripDurationHours(LocalTime startingTime, LocalTime endingTime) {

        Duration duration;

        if (endingTime.isAfter(startingTime)) {
            duration = Duration.between(startingTime, endingTime);

        } else if (endingTime.equals(startingTime)) {
            duration = Duration.ZERO;

        } else {
            Duration durationUntilMidnight = Duration.between(startingTime, LocalTime.MAX).plus(Duration.ofMinutes(1)); // 24:00:00

            Duration durationAfterMidnight = Duration.between(LocalTime.MIDNIGHT, endingTime);

            duration = durationUntilMidnight.plus(durationAfterMidnight);
        }

        return duration.toMinutes();
    }
}
