package sample;

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

import java.io.IOException;

public class LoginController {


    @FXML private TextField input_login;
    @FXML private PasswordField input_passwd;
    @FXML private Label infoLabel;

    private int accountType = 0;


    @FXML
    public void changeScreenAfterLogin(ActionEvent event) throws IOException{

        if(authenticateLogin()&& accountType == 1){
            Parent mainScreenParent = FXMLLoader.load(getClass().getResource("adminPanel.fxml"));
            Scene mainScreenScene = new Scene(mainScreenParent);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(mainScreenScene);
            window.show();
        }
        else if(authenticateLogin()&& accountType == 0){
            Parent mainScreenParent = FXMLLoader.load(getClass().getResource("userPanel.fxml"));
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

    public Boolean authenticateLogin(){

        String login = input_login.getText();
        String passwd = input_passwd.getText();

        if(login.equals("admin1") && passwd.equals("admin1")){
            accountType = 1;
            System.out.println(Main.ANSI_GREEN + "SUCCESSFULLY LOGGED IN AS ADMIN" + Main.ANSI_RESET);
            return true;
        }
        else if(login.equals("user1") && passwd.equals("user1")){
            accountType = 0;
            System.out.println(Main.ANSI_GREEN + "SUCCESSFULLY LOGGED IN AS USER" + Main.ANSI_RESET);
            return true;
        }
        else{
            return false;
        }


    }




}


