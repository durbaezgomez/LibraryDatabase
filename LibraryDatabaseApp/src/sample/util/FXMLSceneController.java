package sample.util;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMLSceneController {

    public void changeScene(ActionEvent event, String path) throws IOException {

        Parent mainScreenParent = FXMLLoader.load(getClass().getResource("/sample/view/"+path));
        Scene mainScreenScene = new Scene(mainScreenParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(mainScreenScene);
        window.show();
    }
}
