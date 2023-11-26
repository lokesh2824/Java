import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
    static Connection connect;
    public static Connection createConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "root";
            String pass = "nopasswd";
            String url = "jdbc:mysql://localhost:3306/mydatabase";

            connect = DriverManager.getConnection(url,user,pass);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

        return connect;
    }

}
