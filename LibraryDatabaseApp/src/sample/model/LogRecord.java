package sample.model;

public class LogRecord {
    int logId;
    String date;
    String  time;
    int userId;

    public LogRecord(int _logId, String _date, String _time, int _userId){
        logId = _logId;
        date = _date;
        time = _time;
        userId = _userId;
    }
}
