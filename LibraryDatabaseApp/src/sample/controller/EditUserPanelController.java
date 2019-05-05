package sample.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static sample.Main.*;

public class EditUserPanelController implements Initializable{


    @FXML private ListView userView;
    @FXML private Label userToEdit;
    @FXML private TextField adminLogin;
    @FXML private TextField adminPasswd;
    @FXML private ToggleGroup accountType;
    @FXML private TextField newPassword;

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
                userToEdit.setText(newValue);
            }
        });
    }


    public void mainPanel(ActionEvent event) throws IOException {

        userLogins.clear();
        fxmlController.changeScene(event, "adminPanel.fxml");

    }

    public void editUser(ActionEvent event) throws IOException, SQLException {

        String username = userToEdit.getText();

        String aLogin = adminLogin.getText();
        String aPasswd = adminPasswd.getText();
        Boolean adminOK = cUtil.checkAdminCredentials(aLogin, aPasswd);

        if (adminOK){
            for(int i = 0; i < systemUsers.size(); i++) {
                if (username.equals(systemUsers.get(i).login)){

                    RadioButton selectedRadioButton = (RadioButton) accountType.getSelectedToggle();
                    String toogleGroupValue = selectedRadioButton.getText();
                    int accountTypeId = 2;

                    if(toogleGroupValue.equals("Admin")){
                        accountTypeId = 1;
                    }

                    systemUsers.get(i).passwd = newPassword.getText();
                    dbUtil.editUser(username, newPassword.getText(), accountTypeId);

                    adminLogin.setText("");
                    adminPasswd.setText("");
                    newPassword.setText("");
                }
            }

        }
        else{
            adminLogin.setText("Invalid admin login or password!");
            adminPasswd.setText("");
        }

    }

}

