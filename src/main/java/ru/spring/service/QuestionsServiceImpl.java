package ru.spring.service;

import ru.spring.dao.QuestionsDao;
import ru.spring.domain.QuestionCollection;

public class QuestionsServiceImpl implements QuestionsService {
    private final QuestionsDao dao;

    public QuestionsServiceImpl(QuestionsDao dao) {
        this.dao = dao;
    }

    @Override
    public QuestionCollection getCollection() {
        return dao.getQuestions();
    }
}
