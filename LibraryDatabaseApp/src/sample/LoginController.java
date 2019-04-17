package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML private TextField input_login;
    @FXML private TextField input_passwd;

    public void authenticateLogin(){
//        String login = input_login.getText();
//        String passwd = input_passwd.getText();

        System.out.println(Main.ANSI_GREEN + "TEST PASSED" + Main.ANSI_RESET);
    }

}


