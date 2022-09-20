package pro.sky.coursework2.service;
import pro.sky.coursework2.Question;
import java.util.Collection;
import java.util.Set;

public interface ExaminerService { // содержит один метод, который возвращает список вопросов
    Collection<Question> getQuestions(int amount);
}
