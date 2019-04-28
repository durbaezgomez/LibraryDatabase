package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminPanelController {

    public void logout(ActionEvent event) throws IOException {


        Parent mainScreenParent = FXMLLoader.load(getClass().getResource("/sample/view/login.fxml"));
        Scene mainScreenScene = new Scene(mainScreenParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(mainScreenScene);
        window.show();
    }

    public void addDeleteUser(ActionEvent event) throws IOException {


        Parent mainScreenParent = FXMLLoader.load(getClass().getResource("/sample/view/addDeleteUserPanel.fxml"));
        Scene mainScreenScene = new Scene(mainScreenParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(mainScreenScene);
        window.show();
    }
    
}
