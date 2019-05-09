package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.model.Book;
import sample.model.Film;

import static sample.Main.*;

import java.io.IOException;
import java.sql.SQLException;

public class UserPanelController implements Initializable {

    @FXML private TableView booksTable;
    @FXML private TableColumn booksId;
    @FXML private TableColumn booksTitle;
    @FXML private TableColumn booksAuthor;
    @FXML private TableColumn booksEdition;
    @FXML private TableColumn booksYear;
    @FXML private TableColumn booksPublisher;

    @FXML private TableView filmsTable;
    @FXML private TableColumn filmsId;
    @FXML private TableColumn filmsTitle;
    @FXML private TableColumn filmsDirector;
    @FXML private TableColumn filmsYear;
    @FXML private TableColumn filmsGenre;

    private ObservableList<Book> books;
    private ObservableList<Film> films;


    @Override
    public void initialize(java.net.URL location, java.util.ResourceBundle resources){

        books = FXCollections.observableArrayList(booksData);
        films = FXCollections.observableArrayList(filmsData);

        setBooksTable();
        setFilmsTable();
    }


    @FXML
    public void logout(ActionEvent event) throws IOException, SQLException {

        dbUtil.dbDisconnect();
        fxmlController.changeScene(event, "login.fxml");

    }

    @FXML
    public void goToSearchView(ActionEvent event) throws IOException, SQLException {

        dbUtil.seeBorrowedProc();

        fxmlController.changeScene(event, "searchView.fxml");

    }


    public void setBooksTable() {

        booksTable.setEditable(true);

        booksId.setCellValueFactory(new PropertyValueFactory<>("id"));
        booksTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        booksAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        booksEdition.setCellValueFactory(new PropertyValueFactory<>("edition"));
        booksYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        booksPublisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));

        booksTable.setItems(books);

    }

    public void setFilmsTable() {

        filmsTable.setEditable(true);

        filmsId.setCellValueFactory(new PropertyValueFactory<>("id"));
        filmsTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        filmsDirector.setCellValueFactory(new PropertyValueFactory<>("director"));
        filmsYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        filmsGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));

        filmsTable.setItems(films);

    }

}
