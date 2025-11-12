package repository.ownerRepo;

import models.Driver;
import repository.querys.ownerQuerys.DriverQuery;
import util.DBQueryExecutorUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverRepository {
    private static DriverRepository driverRepository;

    private DriverRepository() {
    }

    public static DriverRepository getInstance() {
        if (driverRepository == null) driverRepository = new DriverRepository();
        return driverRepository;
    }

    public boolean findDriverById(long driverId) throws SQLException {
        ResultSet rs = DBQueryExecutorUtil.executeQueryWithResultSet(DriverQuery.FIND_BY_DRIVER_ID.getQuery(), new ArrayList<>(List.of(driverId)));
        return rs.next();
    }

    public List<Driver> getAllDriverList(long userId) throws SQLException {
        ResultSet rs = DBQueryExecutorUtil.executeQueryWithResultSet(DriverQuery.GET_ALL_DRIVER.getQuery(), List.of(userId));
        List<Driver> driverList = new ArrayList<>();
        while (rs.next()) {
            Driver driver = new Driver(rs.getInt("driverId"), rs.getString("fullname"));
            driverList.add(driver);
        }
        return driverList;
    }
}
