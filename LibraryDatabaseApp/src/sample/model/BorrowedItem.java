package sample.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.SQLException;

public class BorrowedItem {

    private final SimpleIntegerProperty id;
    private final SimpleStringProperty title;
    private final SimpleStringProperty author;
    private final SimpleStringProperty dateStart;
    private final SimpleStringProperty dateEnd;

    public BorrowedItem(int _id, String _title, String _author, String _dateStart, String _dateEnd)throws SQLException {

        this.id = new SimpleIntegerProperty(_id);
        this.title = new SimpleStringProperty(_title);
        this.author = new SimpleStringProperty(_author);
        this.dateStart = new SimpleStringProperty(_dateStart);
        this.dateEnd = new SimpleStringProperty(_dateEnd);
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

    public String getDateStart() {
        return dateStart.get();
    }

    public void setDateStart(String temp) {
        dateStart.set(temp);
    }

    public String getDateEnd() {
        return dateEnd.get();
    }

    public void setDateEnd(String temp) {
        dateEnd.set(temp);
    }
}
