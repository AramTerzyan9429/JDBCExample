package jdbcexample.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionProvider {

    private static DbConnectionProvider instance =new DbConnectionProvider();

private Connection connection;
    private final String DRIVE_NAME="com.mysql.jdbc.Driver";
private final String DB_URL="jdbc:mysql://localhost:3306/user ?characterEncoding=latin1&useConfigs=maxPerformance";
private final String USERNAME="root";
private final String PASSWORD="root";
    private DbConnectionProvider(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

public static DbConnectionProvider getInstance(){
        return instance;
}
public Connection getConnection()  {
    try {
        if (connection==null||connection.isClosed()){
          connection=  DriverManager.getConnection(DB_URL,
                    USERNAME, PASSWORD);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return connection;

}

}
