package pro.sky.coursework2.service;
import org.springframework.stereotype.Service;
import pro.sky.coursework2.Question;
import pro.sky.coursework2.exception.QuestionsLimitExceededException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService; //класс сервиса не реализации

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
       if (amount > questionService.getAll().size() || amount <= 0) {
           throw new QuestionsLimitExceededException();
       }
       Set<Question> questions = new HashSet<>();
        while (questions.size() < amount){
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }
}
