package ru.spring.domain;

import java.util.ArrayList;

public class Question {
    private String question;
    private ArrayList<String> answers;
    private String rightAnswer;

    public String getRightAnswer() {
        return rightAnswer;
    }

    public Question(String question, String rightAnswer, ArrayList<String> answers) {
        this.rightAnswer = rightAnswer;
        this.question = question;
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question : " + question + "\nAnswers : " + answers.toString() + "\n";
    }
}
