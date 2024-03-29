package DatabaseAccess.Utils;

import oracle.jdbc.OracleDriver;

import java.sql.*;

public class DatabaseConnection {


    private static final String DBURL = "jdbc:oracle:thin:@//localhost:32118/XEPDB1";
    private static final String DBUSER = "admin";
    private static final String DBPASS = "Oracle18";
    private static DatabaseConnection instance;
    private Connection connection;


    private DatabaseConnection() {
        try {
            DriverManager.registerDriver(new OracleDriver());
            connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) instance = new DatabaseConnection();
        return instance;
    }

    public ResultSet ExecuteQuery(String query, Tuple<Object, JDBCType>[] args) {
        ResultSet result = null;
        try {
            PreparedStatement s = instantiantePrepareStatement(query, args);
            result = s.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ResultSet Execute(String query, Tuple<Object, JDBCType>[] args) throws SQLException {
        PreparedStatement s = null;
        s = instantiantePrepareStatement(query, args);
        s.execute();
        return s.getGeneratedKeys();
    }

    private PreparedStatement instantiantePrepareStatement(String query, Tuple<Object, JDBCType>[] args) throws SQLException {
        PreparedStatement s = connection.prepareStatement(query, new int[]{1});
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                Tuple<Object, JDBCType> arg = args[i];
                s.setObject(i + 1, arg.x, arg.y);
            }
        }
        return s;
    }

    public void CloseStatement(Statement s) {
        try {
            s.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
