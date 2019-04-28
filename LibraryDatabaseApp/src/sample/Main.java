package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.model.SystemUser;
import sample.util.DBUtil;

import java.util.ArrayList;


public class Main extends Application {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static ArrayList<SystemUser> systemUsers = new ArrayList<SystemUser>();


    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("view/login.fxml"));
        primaryStage.setTitle("Library Database App");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();


        DBUtil dbUtil = new DBUtil();
        dbUtil.dbConnect();

        dbUtil.getUserCredentials();


    }

    public static void main(String[] args) {
        launch(args);
    }


}
