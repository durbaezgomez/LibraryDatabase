package sample.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.SQLException;

import static sample.Main.dbUtil;

public class LogRecord {

    final SimpleIntegerProperty logId;
    final SimpleStringProperty date;
    final SimpleStringProperty  time;
    final SimpleStringProperty userLogin;

    public LogRecord(int _logId, String _date, String _time, int _userId) throws SQLException {
        this.logId = new SimpleIntegerProperty(_logId);
        this.date = new SimpleStringProperty(_date);
        this.time = new SimpleStringProperty(_time);
        this.userLogin = new SimpleStringProperty(dbUtil.getUserLogin(_userId));
    }

    public int getLogId() {
        return logId.get();
    }

    public void setLogId(int flogId) {
        logId.set(flogId);
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(String fDate) {
        date.set(fDate);
    }

    public String getTime() {
        return time.get();
    }

    public void setTime(String fTime) {
        time.set(fTime);
    }

    public String getUserLogin() {
        return userLogin.get();
    }

    public void setUserLogin(String fUserLogin) {
        userLogin.set(fUserLogin);
    }

    @Override
    public String toString() {

        String s = "";
        s += logId +" ";
        s += date +" ";
        s += time +" ";
        s += userLogin +"\n";

        return s;
    }
}
