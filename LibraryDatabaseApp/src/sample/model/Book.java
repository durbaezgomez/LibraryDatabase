package sample.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.SQLException;

import static sample.Main.dbUtil;

public class Book {

    private final SimpleIntegerProperty id;
    private final SimpleStringProperty title;
    private final SimpleStringProperty author;
    private final SimpleIntegerProperty edition;
    private final SimpleIntegerProperty year;
    private final SimpleStringProperty publisher;

    public Book(int _id, String _title, String _author, int _edition, int _year, String _publisher)throws SQLException {

        this.id = new SimpleIntegerProperty(_id);
        this.title = new SimpleStringProperty(_title);
        this.author = new SimpleStringProperty(_author);
        this.edition = new SimpleIntegerProperty(_edition);
        this.year = new SimpleIntegerProperty(_year);
        this.publisher = new SimpleStringProperty(_publisher);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int temp) {
        id.set(temp);
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String temp) {
        title.set(temp);
    }

    public String getAuthor() {
        return author.get();
    }

    public void setAuthor(String temp) {
        author.set(temp);
    }

    public int getEdition() {
        return edition.get();
    }

    public void setEdition(int temp) {
        edition.set(temp);
    }

    public int getYear() {
        return year.get();
    }

    public void setYear(int temp) {
        year.set(temp);
    }

    public String getPublisher() {
        return publisher.get();
    }

    public void setPublisher(String temp) {
        publisher.set(temp);
    }

}
