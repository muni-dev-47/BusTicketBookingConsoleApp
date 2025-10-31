package repository.querys.passengerQuerys;

public enum PassengerQuery {
    FIND_BY_MOBILE_NUMBER("SELECT * FROM Passenger WHERE mobileNumber = ?"),
    INSERT_PASSENGER_AND_RETURN_ID("INSERT INTO Passenger (userName, password, mobileNumber) VALUES (?, ?, ?) RETURNING userId"),
    FIND_BY_MOBILE_NUMBER_AND_PASSWORD("SELECT userId , password FROM Passenger WHERE MOBILENUMBER = ?");
    private final String query;

    PassengerQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
