package sample.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.SQLException;

public class Film {

    private final SimpleIntegerProperty id;
    private final SimpleStringProperty title;
    private final SimpleStringProperty director;
    private final SimpleIntegerProperty year;
    private final SimpleStringProperty genre;

    public Film(int _id, String _title, String _director, int _year, String _genre)throws SQLException {

        this.id = new SimpleIntegerProperty(_id);
        this.title = new SimpleStringProperty(_title);
        this.director = new SimpleStringProperty(_director);
        this.year = new SimpleIntegerProperty(_year);
        this.genre = new SimpleStringProperty(_genre);
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

    public String getDirector() {
        return director.get();
    }

    public void setDirector(String temp) {
        director.set(temp);
    }

    public int getYear() {
        return year.get();
    }

    public void setYear(int temp) {
        year.set(temp);
    }

    public String getGenre() {
        return genre.get();
    }

    public void setGenre(String temp) {
        genre.set(temp);
    }
}
