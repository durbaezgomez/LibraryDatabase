package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main extends Application {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";



    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("Library Database App");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        LoginController loginController = new LoginController();

        loginController.authenticateLogin();

        TryConnecting();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public void TryConnecting(){
        Connection con;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://"+
                    "153.19.7.13:1401;databaseName=durbaezgomez;"+
                    "user=durbaezgomez;password=253906;");

            System.out.println(ANSI_GREEN + "Log: Connection established successfully." + ANSI_RESET);
            con.close();
        }
        catch(SQLException error_polaczenie) {
            System.out.println(ANSI_RED + "Log: Connection failed!" + ANSI_RESET);
        }
        catch(ClassNotFoundException error_sterownik) {
            System.out.println(ANSI_RED + "Log: Database driver missing." + ANSI_RESET);
        }
    }
}
