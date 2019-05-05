package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TreeTableColumn;
import sample.model.LogRecord;

import static sample.Main.*;


import java.io.IOException;
import java.sql.SQLException;

public class AdminPanelController implements Initializable {

    @FXML private TreeTableColumn<LogRecord, Integer> logIdCol;
    @FXML private TreeTableColumn<LogRecord, String> logDateCol;
    @FXML private TreeTableColumn<LogRecord, String> logTimeCol;
    @FXML private TreeTableColumn<LogRecord, String> logUserCol;

    @Override
    public void initialize(java.net.URL location, java.util.ResourceBundle resources){


    }

    public void logout(ActionEvent event) throws IOException, SQLException {

        dbUtil.dbDisconnect();
        fxmlController.changeScene(event, "login.fxml");

    }

    public void addUserPanel(ActionEvent event) throws IOException {

        fxmlController.changeScene(event, "addUserPanel.fxml");

    }

    public void deleteUserPanel(ActionEvent event) throws IOException {

        fxmlController.changeScene(event, "deleteUserPanel.fxml");


    }

    public void editUserPanel(ActionEvent event) throws IOException {

        fxmlController.changeScene(event, "editUserPanel.fxml");

    }





}
