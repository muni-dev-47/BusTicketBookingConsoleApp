package util;

import config.ServiceLocator;

import java.sql.*;
import java.util.List;

public class DBQueryExecutorUtil {
    private DBQueryExecutorUtil() {

    }

    private static void setParameters(PreparedStatement statement, List<Object> params) throws SQLException {
        if (params == null) return;

        for (int i = 0; i < params.size(); i++) {
            Object param = params.get(i);
            if (param instanceof String) {
                statement.setString(i + 1, (String) param);
            } else if (param instanceof Integer) {
                statement.setInt(i + 1, (Integer) param);
            } else if (param instanceof Long) {
                statement.setLong(i + 1, (Long) param);
            } else if (param instanceof Double) {
                statement.setDouble(i + 1, (Double) param);
            } else if (param != null) {
                statement.setObject(i + 1, param);
            } else {
                statement.setObject(i + 1, null);
            }
        }
    }

    public static int executeUpdateQuery(String sqlQuery, List<Object> params) throws SQLException {
        try (PreparedStatement preparedStatement = ServiceLocator.getInstance().getConnection().prepareStatement(sqlQuery)) {

            setParameters(preparedStatement, params);
            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Database update error for query: " + sqlQuery + " - " + e.getMessage());
            throw e;
        }
    }

    public static ResultSet executeQueryWithResultSet(String sqlQuery, List<Object> params) throws SQLException {

        PreparedStatement preparedStatement = ServiceLocator.getInstance().getConnection().prepareStatement(sqlQuery);
        try {
            setParameters(preparedStatement, params);
            return preparedStatement.executeQuery();

        } catch (SQLException e) {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) { /* ignored */ }
            }
            System.err.println("Database query error for query: " + sqlQuery + " - " + e.getMessage());
            throw e;
        }
    }


    public static long executeInsertAndReturnKey(String sqlQuery, List<Object> params) throws SQLException {

        try (PreparedStatement preparedStatement = ServiceLocator.getInstance().getConnection().prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {

            setParameters(preparedStatement, params);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getLong(1);
                    }
                }
            }
            return -1;

        } catch (SQLException e) {
            System.err.println("Database INSERT error for query: " + sqlQuery + " - " + e.getMessage());
            throw e;
        }
    }
}
