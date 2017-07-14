package ro.teamnet.zth.api.database;

import java.sql.*;

import static ro.teamnet.zth.api.database.DBProperties.PASS;
import static ro.teamnet.zth.api.database.DBProperties.USER;

/**
 * Created by Robert.Dumitrescu on 7/13/2017.
 */
public class DBManager {

    private static final String CONNECTION_STRING = "jdbc:oracle:thin:@" + DBProperties.IP + ":" + DBProperties.PORT +":xe";

    private DBManager()throws UnsupportedOperationException{
    }

    private static void  registerDriver(){
            try {
                Class.forName(DBProperties.DRIVER_CLASS);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Error: unable to load driver class!");
                System.exit(1);
            }
    }

    public static String checkConnection(Connection connection){
        String firsName = null;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery("SELECT 1 FROM DUAL ");
            while(rs.next()){

                firsName = rs.getString("1");
                System.out.println(firsName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return firsName;
    }

    public static Connection getConnection() throws SQLException{
        registerDriver();
       return  DriverManager.getConnection(CONNECTION_STRING, USER, PASS);


    }
}
