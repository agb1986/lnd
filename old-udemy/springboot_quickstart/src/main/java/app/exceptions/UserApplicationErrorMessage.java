package app.exceptions;

import java.util.Date;

public class UserApplicationErrorMessage {
    private Date timeStamp;
    private String message;

    public UserApplicationErrorMessage() {
    }

    public UserApplicationErrorMessage(Date timeStamp, String message) {
        this.timeStamp = timeStamp;
        this.message = message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;

    }
}