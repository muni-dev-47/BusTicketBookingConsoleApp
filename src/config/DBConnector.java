package config;

import repository.querys.TableCreationQuery;
import util.PropertyFileHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {
    private static Connection connection = null;

    private DBConnector() {
    }

    static {
        createTable();
    }

    public static Connection getConnection() {
        try {
            if (connection == null) {
                String url = PropertyFileHandler.getProperty("db.url");
                String username = PropertyFileHandler.getProperty("db.username");
                String password = PropertyFileHandler.getProperty("db.password");
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return connection;
    }

    private static void createTable() {
        try (Statement st = getConnection().createStatement()) {
            st.executeUpdate(TableCreationQuery.CREATE_ADMIN_TABLE.getQuery());
            st.executeUpdate(TableCreationQuery.CREATE_PASSENGER_TABLE.getQuery());
            st.executeUpdate(TableCreationQuery.CREATE_OPERATOR_TABLE.getQuery());
            st.executeUpdate(TableCreationQuery.CREATE_BUS_TABLE.getQuery());
            st.executeUpdate(TableCreationQuery.CREATE_DRIVER_TABLE.getQuery());
            st.executeUpdate(TableCreationQuery.CREATE_SEAT_TABLE.getQuery());
            st.executeUpdate(TableCreationQuery.CREATE_ROUTE_TABLE.getQuery());
            st.executeUpdate(TableCreationQuery.CREATE_ROUTE_STOPS_TABLE.getQuery());
            st.executeUpdate(TableCreationQuery.CREATE_TRIP_TABLE.getQuery());
            st.executeUpdate(TableCreationQuery.CREATE_BOOKING_TABLE.getQuery());
            st.executeUpdate(TableCreationQuery.CREATE_CANCELLATION_TABLE.getQuery());
            st.executeUpdate(TableCreationQuery.CREATE_REPORT_TABLE.getQuery());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
