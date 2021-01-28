package by.epam.tc.dto;

import by.epam.tc.entity.Text;

import java.io.Serializable;

public class Response implements Serializable {
    private Text text;
    private Object result;

    public Response() {}

    public Response(Text text, Object result) {
        this.text = text;
        this.result = result;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
