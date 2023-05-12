package Login;
import java.sql.*;
public class database {
       private static final String url ="jdbc:mysql://localhost:3306/laksh";
       private static final String user ="root";
       private static final String password="140102";
    
       public static Connection getConnection() throws SQLException{
                return DriverManager.getConnection(url, user, password);
       }
    
}
