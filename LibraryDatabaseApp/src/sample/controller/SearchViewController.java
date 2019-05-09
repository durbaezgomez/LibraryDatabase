package sample.controller;

import com.sun.tools.javac.util.Name;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.model.Book;
import sample.model.BorrowedItem;
import sample.model.Film;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static sample.Main.*;

public class SearchViewController implements Initializable{

    @FXML private TextField searchPhrase;
    @FXML private ToggleGroup ite;
    @FXML private TableView borrowedItemsTable;
    @FXML private TableColumn idTab;
    @FXML private TableColumn titleTab;
    @FXML private TableColumn authorTab;
    @FXML private TableColumn dateStartTab;
    @FXML private TableColumn dateEndTab;

    @FXML private Label infoLabel;

    private ObservableList<BorrowedItem> borrowedItems;

    @Override
    public void initialize(java.net.URL location, java.util.ResourceBundle resources){

        borrowedItems = FXCollections.observableArrayList(borrowedItemsList);

        setBorrowedTable();
    }

    public void userPanel(ActionEvent event) throws IOException {

        borrowedItemsList.clear();

        fxmlController.changeScene(event, "userPanel.fxml");
    }

    public void borrowViewPanel(ActionEvent event) throws IOException {

        borrowedItemsList.clear();
        fxmlController.changeScene(event, "borrowViewPanel.fxml");
    }

    public void searchPhrase(ActionEvent event) throws IOException, SQLException {

        String srch = searchPhrase.getText();
        int itemType = 0;

        RadioButton selectedRadioButton = (RadioButton) ite.getSelectedToggle();
        String toogleGroupValue = selectedRadioButton.getText();

        if(toogleGroupValue.equals("Book")){
            itemType = 1;
            dbUtil.searchItem(srch,itemType);
        }
        else{
            itemType = 3;
            dbUtil.searchItem(srch,itemType);
        }

        borrowViewPanel(event);
    }

    public void setBorrowedTable() {

        borrowedItemsTable.setEditable(true);

        idTab.setCellValueFactory(new PropertyValueFactory<>("id"));
        titleTab.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorTab.setCellValueFactory(new PropertyValueFactory<>("author"));
        dateStartTab.setCellValueFactory(new PropertyValueFactory<>("dateStart"));
        dateEndTab.setCellValueFactory(new PropertyValueFactory<>("dateEnd"));

        borrowedItemsTable.setItems(borrowedItems);

    }

}
