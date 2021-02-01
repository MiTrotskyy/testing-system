package ru.spring.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.spring.domain.Question;
import ru.spring.domain.QuestionCollection;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

@Component
public class QuestionsDaoSimple implements QuestionsDao{

    private final String filePath;
    private final QuestionCollection questionCollection;

    @Override
    public QuestionCollection getQuestions() {
        return questionCollection;
    }

    public QuestionsDaoSimple(@Value("/questions.csv") String filePath) {
        this.filePath = filePath;
        this.questionCollection = getQuestionsFromFile();
    }

    private Scanner getScanner(String path) {
        InputStream inputStream = QuestionsDaoSimple.class.getResourceAsStream(path);
        return new Scanner(inputStream);
    }

    private Question getQuestionFromString(String string) {
        ArrayList<String> resultList = new ArrayList<>(Arrays.asList(string.split(";")));
        String question = resultList.remove(0);
        String rightAnswer = resultList.get(0);
        Collections.shuffle(resultList);
        return new Question(question, rightAnswer, resultList);
    }

    public QuestionCollection getQuestionsFromFile() {
        QuestionCollection collection = new QuestionCollection();
        Scanner in = getScanner(filePath);
        while (in.hasNext()){
            String input = in.nextLine();
            collection.add(getQuestionFromString(input));
        }
        return collection;
    }

}
