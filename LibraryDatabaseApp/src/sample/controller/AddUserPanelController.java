package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.model.SystemUser;

import java.io.IOException;
import java.sql.SQLException;

import static sample.Main.*;

public class AddUserPanelController {

    @FXML private TextField new_login;
    @FXML private PasswordField new_passwd;
    @FXML private PasswordField r_passwd;
    @FXML private TextField new_name;
    @FXML private TextField new_surname;
    @FXML private ToggleGroup admin_user;
    @FXML private Label infoLabel;

    public void mainPanel(ActionEvent event) throws IOException {

        fxmlController.changeScene(event, "adminPanel.fxml");

    }

    public void addNewUser(ActionEvent event) throws IOException, SQLException{

        String login = new_login.getText();
        String passwd = new_passwd.getText();
        String rpasswd = r_passwd.getText();
        String name = new_name.getText();
        String surname = new_surname.getText();

        int validation = verifyNewCredentials(login, passwd, rpasswd, name, surname);

        switch(validation){
            case 0:
                infoLabel.setText("User already exists, change login!");
                new_login.setText("");
                new_passwd.setText("");
                r_passwd.setText("");
                break;
            case 1:
                infoLabel.setText("Passwords don't match!");
                new_passwd.setText("");
                r_passwd.setText("");
                break;
            case 2:
                infoLabel.setText("Insert all the data first!");
                break;
            case 3:
                sendNewUserToDB(login, passwd,name,surname);

                infoLabel.setText("Successfully added new user!");
                new_login.setText("");
                new_passwd.setText("");
                r_passwd.setText("");
                new_name.setText("");
                new_surname.setText("");
            default:
                break;
        }
    }

    private void sendNewUserToDB(String login, String passwd, String name, String surname) throws SQLException {

        RadioButton selectedRadioButton = (RadioButton) admin_user.getSelectedToggle();
        String toogleGroupValue = selectedRadioButton.getText();
        int accountTypeId = 2;

        if(toogleGroupValue.equals("Admin Account")){
            accountTypeId = 1;
        }

        int tempId = systemUsers.size()+1;

        dbUtil.addNewUser(new SystemUser(tempId, login, passwd, name, surname, accountTypeId));

    }

    private int verifyNewCredentials(String login, String passwd, String rpasswd, String name, String surname){

        for(int i = 0; i < systemUsers.size(); i++) {
            if (login.equals(systemUsers.get(i).login)) {
                return 0;
            }
        }
        if(!passwd.equals(rpasswd)){
            return 1;
        }
        if(login.equals("") || passwd.equals("") || name.equals("") || surname.equals("")){
            return 2;
        }
        return 3;

    }



}
