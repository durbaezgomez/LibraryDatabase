package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.model.LogRecord;
import sample.model.SystemUser;
import sample.util.CredentialsUtil;
import sample.util.DBUtil;
import sample.util.FXMLSceneController;

import java.util.ArrayList;
import java.util.List;


public class Main extends Application {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static List<SystemUser> systemUsers = new ArrayList<SystemUser>();
    public static List<LogRecord> logInfo = new ArrayList<LogRecord>();

    public static DBUtil dbUtil = new DBUtil();
    public static CredentialsUtil cUtil = new CredentialsUtil();
    public static FXMLSceneController fxmlController = new FXMLSceneController();


    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("/sample/view/login.fxml"));
        primaryStage.setTitle("Library Database App");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }


}
