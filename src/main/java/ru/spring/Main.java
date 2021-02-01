package ru.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.spring.domain.QuestionCollection;
import ru.spring.service.QuestionsService;

@ComponentScan
@Configuration
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        QuestionsService service = context.getBean(QuestionsService.class);

        QuestionCollection collection = service.getCollection();
        System.out.println(collection.toString());
    }
}
