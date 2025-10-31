package repository.ownerRepo;

import models.Bus;
import models.Seat;
import repository.querys.ownerQuerys.BusRegistrationQuery;
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
            ResultSet rs = DBQueryExecutorUtil.executeQueryWithResultSet(BusRegistrationQuery.FIND_BY_BUS_NUMBER.getQuery(), new ArrayList<>(Collections.singleton(busNo)));
            while (rs.next()) {
                return true;
            }
        } catch (SQLException se) {
            System.out.println(se);
        }
        return false;
    }

    public long save(Bus bus) throws SQLException {
        long id = DBQueryExecutorUtil.executeInsertAndReturnKey(BusRegistrationQuery.INSERT_NEW_BUS.getQuery(), new ArrayList<>(Arrays.asList(bus.getTotalSeats(), bus.getUserId(), bus.getRegistrationNumber(), bus.getBusName(), bus.getBusType(), bus.getAmenities())));
        return id;
    }

    public void saveSeats(Seat seat) throws SQLException {
        long id = DBQueryExecutorUtil.executeInsertAndReturnKey(BusRegistrationQuery.INSERT_SEATS.getQuery(), new ArrayList<>(Arrays.asList(seat.getSeatNumber(), seat.getSeatRow(), seat.getSeatColumn(), seat.getSeatType(), seat.getDeckType(), seat.getGenderPreference(), seat.isWindowSeat(), seat.getBusId())));
    }

}
