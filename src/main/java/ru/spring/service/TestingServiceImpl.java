package ru.spring.service;

import org.springframework.stereotype.Service;
import ru.spring.domain.Question;

@Service
public class TestingServiceImpl implements TestingService {

    private QuestionsService questionsService;
    private IOService ioService;

    public TestingServiceImpl(QuestionsService service, IOService ioService) {
        this.questionsService = service;
        this.ioService = ioService;
    }

    @Override
    public void run() {
        String userName = getUser();
        int result = test();
        String status = result > 2 ? "succeeded" : "failed";
        ioService.printMessage(userName + ", you " + status + " this test\n");
        ioService.printMessage("Your test result is : " + Integer.toString(result) + " out of 5");
    }

    private String getUser() {
        ioService.printMessage("Enter your first and last name : ");
        return ioService.getLine();
    }

    private int test() {
        int score = 0;
        for (Question question : questionsService.getCollection().getQuestions()) {
            if (askQuestion(question)) score++;
        }
        return score;
    }

    private boolean askQuestion(Question question) {
        ioService.printMessage(question.toString());
        ioService.printMessage("Enter your answer : ");
        String answer = ioService.getLine();
        return question.checkAnswer(answer);
    }

}
