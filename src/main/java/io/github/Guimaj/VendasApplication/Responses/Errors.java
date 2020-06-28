package io.github.Guimaj.VendasApplication.Responses;

public class Errors {
    private String message;

    public Errors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
