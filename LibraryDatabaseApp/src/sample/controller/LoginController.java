package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static sample.Main.*;

import java.io.IOException;

public class LoginController {


    @FXML private TextField input_login;
    @FXML private PasswordField input_passwd;
    @FXML private Label infoLabel;

    private int accountType = 0;

    public void changeScreenAfterLogin(ActionEvent event) throws IOException{

        if(authenticateLogin()&& accountType == 1){
            System.out.println(ANSI_GREEN + "SUCCESSFULLY LOGGED IN AS ADMIN" + ANSI_RESET);

            Parent mainScreenParent = FXMLLoader.load(getClass().getResource("/sample/view/adminPanel.fxml"));
            Scene mainScreenScene = new Scene(mainScreenParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(mainScreenScene);
            window.show();
        }
        else if(authenticateLogin()&& accountType == 2){

            System.out.println(ANSI_GREEN + "SUCCESSFULLY LOGGED IN AS USER" + ANSI_RESET);

            Parent mainScreenParent = FXMLLoader.load(getClass().getResource("/sample/view/userPanel.fxml"));
            Scene mainScreenScene = new Scene(mainScreenParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(mainScreenScene);
            window.show();
        }
        else{
            infoLabel.setText("Incorrect, try again!");
            input_login.setText("");
            input_passwd.setText("");
        }

    }

    private Boolean authenticateLogin() {

        String login = input_login.getText();
        String passwd = input_passwd.getText();

        for(int i = 0; i < systemUsers.size(); i++) {
            if (login.equals(systemUsers.get(i).login) && passwd.equals(systemUsers.get(i).passwd)) {

                accountType = systemUsers.get(i).accountTypeId;
                return true;

            }
        }
        return false;
    }


}


