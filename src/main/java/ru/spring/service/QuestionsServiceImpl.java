package ru.spring.service;

import org.springframework.stereotype.Service;
import ru.spring.dao.QuestionsDao;
import ru.spring.domain.QuestionCollection;

@Service
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
