package repository.querys.ownerQuerys;

public enum BusRegistrationQuery {
    FIND_BY_BUS_NUMBER("SELECT * FROM BUS WHERE REGISTRATIONNUMBER = ?"),
    INSERT_NEW_BUS("INSERT INTO BUS (TOTALSEATS ,userId, REGISTRATIONNUMBER , BUSNAME , BUSTYPE , AMENITIES ) VALUES(?,?,?,?,? ,?) RETURNING busId"),
    INSERT_SEATS("INSERT INTO SEAT (seatNumber , seatRow , seatColumn , seatType , deckType , genderpreference , iswindowseat , busId) VALUES(?,?,?,?,?,?,?,?) RETURNING seatId");

    private final String query;

    BusRegistrationQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
