package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.model.LogRecord;

import static sample.Main.*;


import java.io.IOException;
import java.sql.SQLException;

public class AdminPanelController implements Initializable {

    @FXML private TableView logTable;
    @FXML private TableColumn logId;
    @FXML private TableColumn logDate;
    @FXML private TableColumn logTime;
    @FXML private TableColumn logUser;

    private ObservableList<LogRecord> logsData;

    @Override
    public void initialize(java.net.URL location, java.util.ResourceBundle resources){

        logsData = FXCollections.observableArrayList(logInfo);
        setLogTable();

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

    private void setLogTable(){

        logTable.setEditable(true);

        logId.setCellValueFactory(new PropertyValueFactory<>("logId"));
        logDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        logTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        logUser.setCellValueFactory(new PropertyValueFactory<>("userLogin"));

        logTable.setItems(logsData);

    }


}
