package com.example.footballquiz;

import android.widget.ImageView;

public class Question {
    public static final String LEVEL_1 = "level 1";
    public static final String LEVEL_2 = "level 2";
    public static final String LEVEL_3 = "level 3";

    private byte[] question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private int answer;
    private String difficulty;

    public Question() {
    }

    public Question(byte[] question, String optionA, String optionB, String optionC, String optionD, int answer, String difficulty) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.answer = answer;
        this.difficulty = difficulty;
    }

    public byte[] getQuestion() {
        return question;
    }

    public void setQuestion(byte[] question) {
        this.question = question;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}