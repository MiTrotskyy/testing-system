package ru.spring.dao;

import ru.spring.domain.Question;
import ru.spring.domain.QuestionCollection;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class QuestionsDaoSimple implements QuestionsDao{
    private final String filePath;

    public QuestionsDaoSimple(String filePath) {
        this.filePath = filePath;
    }

    private Scanner getScanner(String path) {
        InputStream inputStream = QuestionsDaoSimple.class.getResourceAsStream(path);
        return new Scanner(inputStream);
    }

    @Override
    public QuestionCollection getQuestions() {
        QuestionCollection collection = new QuestionCollection();
        Scanner in = getScanner(filePath);
        while (in.hasNext()){
            String input = in.nextLine();
            ArrayList<String> resultList = new ArrayList<>(Arrays.asList(input.split(";")));
            String question = resultList.remove(0);
            collection.add(new Question(question, resultList));
        }
        return collection;
    }
}
