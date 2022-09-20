package pro.sky.coursework2.service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.Question;
import pro.sky.coursework2.exception.QuestionAlreadyExistException;
import pro.sky.coursework2.exception.QuestionNotFoundExistException;


import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions; // коллекция не заполнена
    private final Random random; // для метода случайных вопросов
    public JavaQuestionService(){
        this.questions = new HashSet<>();
        this.random = new Random();
    }
    /*  = new HashSet<>(List.of(

            new Question("Что такое «переменная»?", "Переменная — это ячейка в памяти компьютера," +
                    " которой можно присвоить имя и в которой можно хранить данные."),
            new Question("По каким параметрам переменные различаются?",
                    "Какие данные хранятся в переменной, сколько данных хранится и сколько займет места в памяти компьютера"),
            new Question("Что такое «цикл»?",
                    "Конструкция языка, позволяющая выполнять один и тот же код многократно в зависимости от условий"),
            new Question("Дайте определение строке",
                    " Неизменяемый массив символов, является объектом"),
            new Question("Что такое «метод»?", "блок кода, который выполняет определенную функцию..."),
            new Question("Что означает инициализация?", "присваивание какого-то значения переменной")
    )); */

    @Override
    public Question add(String question, String answer) {
        return add(new Question (question, answer));
    }
    @Override
    public Question add(Question question) {
        if(!questions.add(question)){
            throw new QuestionAlreadyExistException();
        }
        return question;
    }

    @Override
    public Question remove(Question question) {
         if(!questions.remove(question)){
             throw new QuestionNotFoundExistException();
         }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return new HashSet<>(questions);
    }

    @Override
    public Question getRandomQuestion() { // случайные вопросы
        return new ArrayList<>(questions).get(random.nextInt(questions.size()));
    }
}

