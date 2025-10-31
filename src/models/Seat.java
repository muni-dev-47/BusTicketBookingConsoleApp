package models;

public class Seat {
    private long busId;
    private long seatId;
    private String seatNumber;
    private String seatType;
    private int seatRow;
    private int seatColumn;
    private boolean isWindowSeat;
    private String deckType;
    private String genderPreference;

    public Seat(long busId, long seatId, String genderPreference, String seatNumber, String seatType, int seatRow, int seatColumn, boolean isWindowSeat, String deckType) {
        this.busId = busId;
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.genderPreference = genderPreference;
        this.seatType = seatType;
        this.seatRow = seatRow;
        this.seatColumn = seatColumn;
        this.isWindowSeat = isWindowSeat;
        this.deckType = deckType;
    }

    public Seat(String seatNumber, String genderPreference, String seatType, int seatRow, int seatColumn, boolean isWindowSeat, String deckType) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.genderPreference = genderPreference;
        this.seatRow = seatRow;
        this.seatColumn = seatColumn;
        this.isWindowSeat = isWindowSeat;
        this.deckType = deckType;
    }

    public String getDeckType() {
        return deckType;
    }

    public void setDeckType(String deckType) {
        this.deckType = deckType;
    }

    public long getSeatId() {
        return seatId;
    }

    public void setSeatId(long seatId) {
        this.seatId = seatId;
    }

    public long getBusId() {
        return busId;
    }

    public void setBusId(long busId) {
        this.busId = busId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatColumn() {
        return seatColumn;
    }

    public void setSeatColumn(int seatColumn) {
        this.seatColumn = seatColumn;
    }

    public String getGenderPreference() {
        return genderPreference;
    }

    public void setGenderPreference(String genderPreference) {
        this.genderPreference = genderPreference;
    }

    public boolean isWindowSeat() {
        return isWindowSeat;
    }

    public void setWindowSeat(boolean windowSeat) {
        isWindowSeat = windowSeat;
    }

    @Override
    public String toString() {
        return "Seat{" + "genderPreference='" + genderPreference + '\'' + ", deckType='" + deckType + '\'' + ", isWindowSeat=" + isWindowSeat + ", seatColumn=" + seatColumn + ", seatRow=" + seatRow + ", seatType='" + seatType + '\'' + ", seatNumber='" + seatNumber + '\'' + '}';
    }
}