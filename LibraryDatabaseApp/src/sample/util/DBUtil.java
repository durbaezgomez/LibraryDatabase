package sample.util;
import java.sql.*;

import static sample.Main.*;

import sample.model.LogRecord;
import sample.model.SystemUser;


public class DBUtil {

    private static Connection con = null;


//    DATABASE CONNECTION MANAGEMENT

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

    public void dbDisconnect() throws SQLException {
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

        int id, accountTypeId = 0;
        String login, passwd,name,surname = "";

        while(queryResult.next()) {

            id = Integer.valueOf(queryResult.getString(1));
            login = (queryResult.getString(2));
            passwd = (queryResult.getString(3));
            name = (queryResult.getString(4));
            surname = (queryResult.getString(5));
            accountTypeId = Integer.valueOf(queryResult.getString(6));

            systemUsers.add( new SystemUser(id, login, passwd, name, surname, accountTypeId));
        }
    }

    public void registerLogin(String login)throws SQLException{

        Statement query = con.createStatement();
        String sql= "select id from SystemUsers where login ='" + login + "'";
        ResultSet queryResult= query.executeQuery(sql);
        int userId = 0;

        while(queryResult.next()) {
            userId = Integer.valueOf(queryResult.getString(1));
        }

        Statement query2 = con.createStatement();
        String sql2="insert into LogInfo values((select getdate()), "+userId+")";
        query2.executeUpdate(sql2);
    }

//    ADMIN ACCOUNT MANAGEMENT

    public void addNewUser(SystemUser usr) throws SQLException{

        Statement query = con.createStatement();
        String sql="insert into SystemUsers values('"+usr.login+"', '"+usr.passwd+"', '"+usr.name+"', '"+usr.surname+"', '"+usr.accountTypeId+"')";
        query.executeUpdate(sql);

        Statement query2 = con.createStatement();
        String sql2="select * from SystemUsers where login = '"+usr.login+"'";
        ResultSet queryResult = query2.executeQuery(sql2);

        int id = 0;
        while(queryResult.next()) {

            id = Integer.valueOf(queryResult.getString(1));
        }

        usr.id = id;
        systemUsers.add( new SystemUser(id, usr.login, usr.passwd, usr.name, usr.surname, usr.accountTypeId));

    }

    public void removeUser(String login) throws SQLException{

        Statement query = con.createStatement();
        String sql="delete from SystemUsers where login = '" + login+ "'";
        query.executeUpdate(sql);

    }

    public void editUser(String login, String  passwd,  int  acType) throws SQLException {

        Statement query = con.createStatement();
        String sql = "update SystemUsers set passwd = '" + passwd + "', accountTypeId = " + acType + " where login = '" + login + "'";
        query.executeUpdate(sql);
    }

//    ADMIN PANEL INFO GETTERS

    public void getLogInfo() throws SQLException {

        Statement query = con.createStatement();
        String sql="select * from LogInfo";
        ResultSet queryResult= query.executeQuery(sql);

        int id, userId = 0;
        String dateTemp, date, time = "";

        while(queryResult.next()) {

            id = Integer.valueOf(queryResult.getString(1));
            dateTemp = (queryResult.getString(2));
            userId = Integer.valueOf(queryResult.getString(3));

            date = dateTemp.substring(0,10);
            time = dateTemp.substring(11,16);

            logInfo.add(new LogRecord(id, date, time, userId));
        }

//        System.out.println(logInfo);
    }

    public String getUserLogin(int userId) throws SQLException{

        String userLogin = "";

        Statement query = con.createStatement();
        String sql="select login from SystemUsers where id = "+ userId;
        ResultSet queryResult= query.executeQuery(sql);

        while(queryResult.next()) {
            userLogin = queryResult.getString(1);
        }

        return userLogin;
    }

}
