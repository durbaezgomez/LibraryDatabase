package sample.util;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static sample.Main.*;

import sample.model.*;


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


//    USER PANEL GETTERS

    public void getBooksData() throws SQLException{

        Statement query = con.createStatement();
        String sql="select Books.id, title, A.surname, edition, year, P.name from Books \n" +
                "join Authors A on Books.authorId = A.id \n" +
                "join Publishers P on Books.publisherId = P.id \n";
        ResultSet queryResult= query.executeQuery(sql);

        int id, edition, year = 0;
        String title, author, publisher = "";

        while(queryResult.next()) {

            id = Integer.valueOf(queryResult.getString(1));
            title = (queryResult.getString(2));
            author = (queryResult.getString(3));
            edition = Integer.valueOf(queryResult.getString(4));
            year = Integer.valueOf(queryResult.getString(5));
            publisher = (queryResult.getString(6));

            booksData.add(new Book(id, title, author, edition, year, publisher));
        }
    }

    public void getFilmsData() throws SQLException{

        Statement query = con.createStatement();
        String sql="select Films.id, title, D.surname as director, year, G.genre as genre from Films \n" +
                "join Directors D on Films.directorId = D.id \n" +
                "join Genres G on Films.genreId = G.id \n";
        ResultSet queryResult= query.executeQuery(sql);

        int id, year = 0;
        String title, director, genre = "";

        while(queryResult.next()) {

            id = Integer.valueOf(queryResult.getString(1));
            title = (queryResult.getString(2));
            director = (queryResult.getString(3));
            year = Integer.valueOf(queryResult.getString(4));
            genre = (queryResult.getString(5));

            filmsData.add(new Film(id, title, director, year, genre));
        }
    }


//    USER PANEL FUNCTIONALITIES

    public void searchItem(String srch, int itemType) throws SQLException{

        Statement query = con.createStatement();
        String sql="";

        String title = "";

        if(itemType == 1){

            sql = "select Books.id, title, A.surname, edition, year, P.name from Books\n" +
                    "join Authors A on Books.authorId = A.id\n" +
                    "join Publishers P on Books.publisherId = P.id\n" +
                    "  where title LIKE '%"+ srch +"%'";
            int id, edition, year = 0;
             String author, publisher = "";

            ResultSet queryResult= query.executeQuery(sql);

            while(queryResult.next()) {
                title = (queryResult.getString(2));
                searchBookResults.add(title);
            }
        }
        else{

            sql = "select Films.id, title, D.surname as director, year, G.genre as genre from Films\n" +
                    "join Directors D on Films.directorId = D.id\n" +
                    "join Genres G on Films.genreId = G.id\n" +
                    "where title LIKE '%"+ srch +"%'";

            int id, year = 0;
            String director, genre = "";

            ResultSet queryResult= query.executeQuery(sql);

            while(queryResult.next()) {
                title = (queryResult.getString(2));
                searchFilmResults.add(title);
            }

        }

    }

    public void borrowItem(String itemTitle, int itemType) throws SQLException{

        int itemId = 0;

        for(int i = 0; i < booksData.size(); i++){
            if (booksData.get(i).getTitle().equals(itemTitle)){
                itemId = booksData.get(i).getId();
            }
        }

        int userId = sessionUser.id;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.now();


        Statement query2 = con.createStatement();
        String sql2="insert into BorrowedLogs values("+userId + ", "+itemId+", '"+date+ "', '"+date.plusDays(30)+"')";
        query2.executeUpdate(sql2);
    }

    public void seeBorrowedProc() throws SQLException{

        Statement query = con.createStatement();
        String sql="exec seeBorrowed";
        ResultSet results = query.executeQuery(sql);

        int id = 0;
        String title, author, dateStart, dateEnd = "";

        while(results.next()){
            id = results.getInt(1);
            title = results.getString(2);
            author = results.getString(3);
            dateStart = results.getString(4);
            dateEnd = results.getString(5);

            borrowedItemsList.add(new BorrowedItem(id, title, author, dateStart, dateEnd));
        }

    }
}
