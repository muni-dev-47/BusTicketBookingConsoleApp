package repository.querys.ownerQuerys;

public enum BusQuery {
    FIND_BY_BUS_NUMBER("SELECT * FROM BUS WHERE REGISTRATIONNUMBER = ?"),
    INSERT_NEW_BUS("INSERT INTO BUS (TOTALSEATS ,userId, REGISTRATIONNUMBER , BUSNAME , BUSTYPE , AMENITIES , minTurnaroundHours) VALUES(?,?,?,?,?,?,?) RETURNING busId"),
    INSERT_SEATS("INSERT INTO SEAT (seatNumber , seatRow , seatColumn , seatType , deckType , genderpreference , iswindowseat , busId) VALUES(?,?,?,?,?,?,?,?) RETURNING seatId"),
    FIND_BUS_BY_ID("SELECT * FROM BUS WHERE busId = ?"),
    GET_ALL_BUS("SELECT * FROM BUS WHERE USERID = ?");

    private final String query;

    BusQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
