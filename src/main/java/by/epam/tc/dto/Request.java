package by.epam.tc.dto;

import java.io.Serializable;

public class Request implements Serializable {
    private String text;
    private int action;

    public Request() {}

    public Request(String text, int action) {
        this.text = text;
        this.action = action;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }
}
