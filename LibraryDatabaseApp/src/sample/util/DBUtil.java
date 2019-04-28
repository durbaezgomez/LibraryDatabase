package sample.util;

import sample.model.SystemUser;

import java.sql.*;

import static sample.Main.*;


public class DBUtil {

    private static Connection con = null;

    public void dbConnect(){

        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;database=library_database;"+
                    "user=sa;password=strongPasswd1234;");

            System.out.println(ANSI_GREEN + "Log: Connection established successfully." + ANSI_RESET);
        }
        catch(SQLException error_polaczenie) {
            System.out.println(ANSI_RED + "Log: Connection failed!" + ANSI_RESET);
        }
        catch(ClassNotFoundException error_sterownik) {
            System.out.println(ANSI_RED + "Log: Database driver missing." + ANSI_RESET);
        }
    }

    public static void dbDisconnect() throws SQLException {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (Exception e){
            throw e;
        }
    }


    public void getUserCredentials() throws SQLException{

        Statement query = con.createStatement();
        String sql="select * from SystemUsers";
        ResultSet queryResult= query.executeQuery(sql);

        while(queryResult.next()) {

            int id = Integer.valueOf(queryResult.getString(1));
            String login = (queryResult.getString(2));
            String passwd = (queryResult.getString(3));
            String name = (queryResult.getString(4));
            String surname = (queryResult.getString(5));
            int accountTypeId = Integer.valueOf(queryResult.getString(6));

            systemUsers.add( new SystemUser(id, login, passwd, name, surname, accountTypeId));
        }

        System.out.println(systemUsers);
    }
}
