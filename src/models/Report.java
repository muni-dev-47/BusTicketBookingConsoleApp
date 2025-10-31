package models;

import java.time.LocalDateTime;

public class Report {
    private long reportId;
    private int userId;
    private Long tripId;

    private String reportSubject;
    private String reportDetails;

    private LocalDateTime reportTime;
    private String reportStatus;

    public Report(long reportId, int userId, Long tripId, String reportSubject, String reportDetails, LocalDateTime reportTime, String reportStatus) {
        this.reportId = reportId;
        this.userId = userId;
        this.tripId = tripId;
        this.reportSubject = reportSubject;
        this.reportDetails = reportDetails;
        this.reportTime = reportTime;
        this.reportStatus = reportStatus;
    }

    public long getReportId() {
        return reportId;
    }

    public void setReportId(long reportId) {
        this.reportId = reportId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public String getReportSubject() {
        return reportSubject;
    }

    public void setReportSubject(String reportSubject) {
        this.reportSubject = reportSubject;
    }

    public String getReportDetails() {
        return reportDetails;
    }

    public void setReportDetails(String reportDetails) {
        this.reportDetails = reportDetails;
    }

    public LocalDateTime getReportTime() {
        return reportTime;
    }

    public void setReportTime(LocalDateTime reportTime) {
        this.reportTime = reportTime;
    }

    public String getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }
}
