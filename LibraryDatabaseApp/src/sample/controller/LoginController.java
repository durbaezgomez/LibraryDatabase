package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.model.SystemUser;

import static sample.Main.*;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {


    @FXML private TextField input_login;
    @FXML private PasswordField input_passwd;
    @FXML private Label infoLabel;

    private int accountType = 0;

    public LoginController() throws SQLException {

        dbUtil.dbConnect();
        dbUtil.getUserCredentials();

    }

    public void changeScreenAfterLogin(ActionEvent event) throws IOException, SQLException{

        if(authenticateLogin()&& accountType == 1){
            System.out.println(ANSI_GREEN + "SUCCESSFULLY LOGGED IN AS ADMIN" + ANSI_RESET);
            dbUtil.registerLogin(input_login.getText());



            fxmlController.changeScene(event, "adminPanel.fxml");
        }
        else if(authenticateLogin()&& accountType == 2){

            System.out.println(ANSI_GREEN + "SUCCESSFULLY LOGGED IN AS USER" + ANSI_RESET);
            dbUtil.registerLogin(input_login.getText());

            fxmlController.changeScene(event, "userPanel.fxml");
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

                sessionUser = new SystemUser(systemUsers.get(i).id,login, passwd, systemUsers.get(i).name,systemUsers.get(i).surname,systemUsers.get(i).accountTypeId);

                accountType = systemUsers.get(i).accountTypeId;
                return true;

            }
        }
        return false;
    }

}


