package com.example.pedidef;

import android.widget.ImageButton;

public class Card {
    private String title;
    private String description;

    public Card(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}

