package ru.spring.service;

import ru.spring.domain.Question;
import ru.spring.domain.QuestionCollection;

public interface QuestionsService {
    QuestionCollection getCollection();
    Question getQuestionByNumber(int i);
}
