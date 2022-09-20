package pro.sky.coursework2.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pro.sky.coursework2.Question;
import pro.sky.coursework2.exception.QuestionAlreadyExistException;
import pro.sky.coursework2.exception.QuestionNotFoundExistException;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    private final JavaQuestionService out = new JavaQuestionService();

    @AfterEach
    public void afterEach(){
        out.getAll().forEach(out::remove);
    }

    @Test
    void addTest() {
        assertThat(out.getAll()).isEmpty();
        Question expected = new Question("question", "answer");
        Question expected1 = new Question("question1", "answer1");
        Question result = out.add(expected);
        Question result1 = out.add(expected1);
        assertEquals(expected, result);
        assertEquals(expected1, result1);
        System.out.println(out.getAll());
    }

   @Test
    void shouldNotAdd() {
       assertThat(out.getAll()).hasSize(0);
        Question expected = new Question("question", "answer");
        out.add(expected);
        assertThatExceptionOfType(QuestionAlreadyExistException.class)
                .isThrownBy(() -> out.add(expected));
    }

    @Test
    void removeTest() {
        assertThat(out.getAll()).isEmpty();
        Question expected = new Question("question", "answer");
        out.add(expected);
        assertThat(out.getAll()).contains(expected);
        assertThatExceptionOfType(QuestionNotFoundExistException.class)
                .isThrownBy(() -> out.remove(new Question("question1", "answer1")));
        out.remove(expected);
        assertThat(out.getAll()).isEmpty();
        }

    @Test
    void getRandomQuestion() {
        assertThat(out.getAll()).isEmpty();
        int size = 5;
        for (int i = 1; i <= size ; i++) {
            addOneQuestion("question" + i, "answer" + i);
        }
        assertThat(out.getAll()).hasSize(size);
        assertThat(out.getRandomQuestion()).isIn(out.getAll());
    }
    private Question addOneQuestion(String question, String answer){
        int size = out.getAll().size();
        Question expected = new Question(question, answer);
        out.add(expected);
        assertThat(out.getAll()).hasSize(size + 1);
        assertThat(out.getAll()).contains(expected);
        return expected;
    }
}