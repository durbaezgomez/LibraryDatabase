package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import static sample.Main.*;

import java.io.IOException;
import java.sql.SQLException;

public class UserPanelController {

    @FXML
    public void logout(ActionEvent event) throws IOException, SQLException {

        dbUtil.dbDisconnect();
        fxmlController.changeScene(event, "login.fxml");


    }
}
