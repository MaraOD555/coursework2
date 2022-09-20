package pro.sky.coursework2.service;
import pro.sky.coursework2.Question;
import java.util.Collection;
import java.util.Set;

public interface QuestionService { //все методы по работе с вопросами определенного предмета
        Question add (String question, String answer);
        Question add (Question question);
        Question remove (Question question);
        Collection<Question> getAll();
        Question getRandomQuestion();
}
