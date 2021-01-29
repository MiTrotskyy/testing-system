package ru.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.spring.domain.QuestionCollection;
import ru.spring.service.QuestionsService;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionsService service = context.getBean(QuestionsService.class);
        QuestionCollection collection = service.getCollection();
        System.out.println(collection.toString());
    }
}
