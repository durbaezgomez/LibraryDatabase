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

import java.io.IOException;
import java.sql.SQLException;


import static sample.Main.*;

public class BorrowViewController implements Initializable {

    @FXML
    private ListView searchResults;
    @FXML
    private Label title;

    private ObservableList<String> foundBooks;
    private ObservableList<String> foundFilms;

    public void userPanel(ActionEvent event) throws IOException {

        fxmlController.changeScene(event, "userPanel.fxml");
    }

    @Override
    public void initialize(java.net.URL location, java.util.ResourceBundle resources){

        foundBooks = FXCollections.observableArrayList(searchBookResults);
        foundFilms = FXCollections.observableArrayList(searchFilmResults);

        if(!searchBookResults.isEmpty()){
            searchResults.setItems(foundBooks);

        }
        else{
            searchResults.setItems(foundFilms);
        }

        searchResults.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                title.setText(newValue);
            }
        });
    }

    public void borrowItem(ActionEvent event) throws IOException, SQLException {

        String itemTitle = title.getText();
        int itemType = 3;

        if(!searchBookResults.isEmpty()){
            itemType = 1;
        }

        dbUtil.borrowItem(itemTitle, itemType);

    }
}
