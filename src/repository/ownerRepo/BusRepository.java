package repository.ownerRepo;

import models.Bus;
import models.Seat;
import repository.querys.ownerQuerys.BusQuery;
import util.DBQueryExecutorUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BusRepository {
    private static BusRepository br;

    private BusRepository() {
    }

    public static BusRepository getInstance() {
        if (br == null) {
            br = new BusRepository();
        }
        return br;
    }

    public boolean findByBusRegistrationNumber(String busNo) {
        try {
            ResultSet rs = DBQueryExecutorUtil.executeQueryWithResultSet(BusQuery.FIND_BY_BUS_NUMBER.getQuery(), new ArrayList<>(Collections.singleton(busNo)));
            while (rs.next()) {
                return true;
            }
        } catch (SQLException se) {
            System.out.println(se);
        }
        return false;
    }

    public long save(Bus bus) throws SQLException {
        return DBQueryExecutorUtil.executeInsertAndReturnKey(BusQuery.INSERT_NEW_BUS.getQuery(), new ArrayList<>(Arrays.asList(bus.getTotalSeats(), bus.getUserId(), bus.getRegistrationNumber(), bus.getBusName(), bus.getBusType(), bus.getAmenities(), bus.getMinTurnaroundTimeHours())));
    }

    public void saveSeats(Seat seat) throws SQLException {
        long id = DBQueryExecutorUtil.executeInsertAndReturnKey(BusQuery.INSERT_SEATS.getQuery(), new ArrayList<>(Arrays.asList(seat.getSeatNumber(), seat.getSeatRow(), seat.getSeatColumn(), seat.getSeatType(), seat.getDeckType(), seat.getGenderPreference(), seat.isWindowSeat(), seat.getBusId())));
    }

    public Bus findBusByBudId(long busId) throws SQLException {
        ResultSet rs = DBQueryExecutorUtil.executeQueryWithResultSet(BusQuery.FIND_BUS_BY_ID.getQuery(), new ArrayList<>(Collections.singleton(busId)));
        rs.next();
        return new Bus(rs.getString("AMENITIES"), rs.getString("busType"), rs.getString("busName"), rs.getString("registrationNumber"), rs.getInt("totalSeats"), rs.getLong("userId"), rs.getDouble("minTurnaroundTimeHours"));
    }
}
