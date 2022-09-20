package pro.sky.coursework2.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.Question;
import pro.sky.coursework2.exception.QuestionsLimitExceededException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks

    private ExaminerServiceImpl examinerServiceImpl;

    @BeforeEach
    public void setUp() {
        Collection<Question> questions = Stream.of(

                new Question("question text1", "answer text1"),
                new Question("question text2", "answer text2"),
                new Question("question text3", "answer text3"),
                new Question("question text4", "answer text4"),
                new Question("question text5", "answer text5")

        ).collect(Collectors.toSet());
        when(javaQuestionService.getAll()).thenReturn(questions);
    }

    @Test
    public void getQuestionsPositiveTest() { //  в этом тесте не будет добавлен элемент с одинаковым индексом, т.к. getAll с уникальными вопросами
        List<Question> questions = new ArrayList<>(javaQuestionService.getAll());
            when(javaQuestionService.getRandomQuestion()).thenReturn(
                questions.get(0),
                questions.get(1),
                questions.get(0),
                questions.get(2)
        );
            assertThat(examinerServiceImpl.getQuestions(3)).containsExactly(questions.get(0),questions.get(1),questions.get(2));

            when(javaQuestionService.getRandomQuestion()).thenReturn(
                questions.get(0),
                questions.get(1),
                questions.get(2),
                questions.get(2),
                questions.get(3),
                questions.get(4)
        );
             assertThat(examinerServiceImpl.getQuestions(5)).containsExactly(questions.get(0),questions.get(1),questions.get(2), questions.get(3), questions.get(4));
    }
    @Test
    public void getQuestionsNegativeTest(){
        QuestionsLimitExceededException thrown1 = Assertions.assertThrows(QuestionsLimitExceededException.class,
                () -> examinerServiceImpl.getQuestions(6));
        QuestionsLimitExceededException thrown2 = Assertions.assertThrows(QuestionsLimitExceededException.class,
                () -> examinerServiceImpl.getQuestions(-1));
        QuestionsLimitExceededException thrown3 = Assertions.assertThrows(QuestionsLimitExceededException.class,
                () -> examinerServiceImpl.getQuestions(0));
    }
}