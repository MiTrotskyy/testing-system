package ru.spring.domain;

import java.util.ArrayList;

public class QuestionCollection {

    private ArrayList<Question> questions;

    public QuestionCollection() {
        this.questions = new ArrayList<>();
    }

    public String getByNumber(int i) {
        return questions.get(i).toString();
    }

    public void add(Question question) {
        questions.add(question);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Question question : questions) {
            result.append(question.toString());
        }
        return result.toString();
    }
}
