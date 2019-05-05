package sample.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static sample.Main.*;

public class DeleteUserPanelController implements Initializable {

    @FXML private ListView userView;
    @FXML private Label userToDel;
    @FXML private TextField adminLogin;
    @FXML private TextField adminPasswd;

    private ArrayList<String> userLogins = new ArrayList<>();
    private ObservableList<String> items;


    @Override
    public void initialize(java.net.URL location, java.util.ResourceBundle resources){

        systemUsers.forEach(user->{
            userLogins.add(user.login);
        });

        items = FXCollections.observableArrayList(userLogins);

        userView.setItems(items);

        userView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                userToDel.setText(newValue);
            }
        });
    }


    public void mainPanel(ActionEvent event) throws IOException {

        userLogins.clear();
        fxmlController.changeScene(event, "adminPanel.fxml");

    }

    public void deleteUser(ActionEvent event) throws IOException, SQLException {

        String username = userToDel.getText();

        String aLogin = adminLogin.getText();
        String aPasswd = adminPasswd.getText();
        Boolean adminOK = cUtil.checkAdminCredentials(aLogin, aPasswd);

        if (adminOK){
            for(int i = 0; i < systemUsers.size(); i++) {
               if (username.equals(systemUsers.get(i).login)){

                   systemUsers.remove(systemUsers.get(i));
                   items.remove(items.get(i));
                   dbUtil.removeUser(username);

                   adminLogin.setText("");
                   adminPasswd.setText("");
               }
            }

        }
        else{
            adminLogin.setText("Invalid admin login or password!");
            adminPasswd.setText("");
        }

    }

}

