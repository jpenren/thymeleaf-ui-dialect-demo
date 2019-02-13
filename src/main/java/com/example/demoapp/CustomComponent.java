package com.example.demoapp;

import io.github.thymeleaf.ui.Component;

public class CustomComponent extends Component {

    private final String message;

    public CustomComponent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
