package models;

import java.time.LocalDateTime;

public class Cancellation {

    private long cancellationId;
    private long bookingId;
    private long tripId;
    private LocalDateTime cancellationTime;
    private String cancellationReason;
    private double refundAmount;
    private double cancellationCharge;
    private String initiatedBy;
    private String refundStatus;

    public Cancellation(long cancellationId, long bookingId, long tripId, LocalDateTime cancellationTime, String cancellationReason, double refundAmount, double cancellationCharge, String initiatedBy, String refundStatus) {
        this.cancellationId = cancellationId;
        this.bookingId = bookingId;
        this.tripId = tripId;
        this.cancellationTime = cancellationTime;
        this.cancellationReason = cancellationReason;
        this.refundAmount = refundAmount;
        this.cancellationCharge = cancellationCharge;
        this.initiatedBy = initiatedBy;
        this.refundStatus = refundStatus;
    }

    public long getCancellationId() {
        return cancellationId;
    }

    public void setCancellationId(long cancellationId) {
        this.cancellationId = cancellationId;
    }

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public long getTripId() {
        return tripId;
    }

    public void setTripId(long tripId) {
        this.tripId = tripId;
    }

    public LocalDateTime getCancellationTime() {
        return cancellationTime;
    }

    public void setCancellationTime(LocalDateTime cancellationTime) {
        this.cancellationTime = cancellationTime;
    }

    public String getCancellationReason() {
        return cancellationReason;
    }

    public void setCancellationReason(String cancellationReason) {
        this.cancellationReason = cancellationReason;
    }

    public double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public double getCancellationCharge() {
        return cancellationCharge;
    }

    public void setCancellationCharge(double cancellationCharge) {
        this.cancellationCharge = cancellationCharge;
    }

    public String getInitiatedBy() {
        return initiatedBy;
    }

    public void setInitiatedBy(String initiatedBy) {
        this.initiatedBy = initiatedBy;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }
}