package com.example.flagquizapp;

import java.util.List;

public class Question {
    private String question;
    private List<String> options;
    private String answer;
    private String image;

    public Question(String question, List<String> options, String answer, String image) {
        this.question = question;
        this.options = options;
        this.answer = answer;
        this.image = image;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getAnswer() {
        return answer;
    }

    public String getImage() {
        return image;
    }
}


