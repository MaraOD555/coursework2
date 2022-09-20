package pro.sky.coursework2;

//import org.springframework.stereotype.Component;

import java.util.Objects;
// @Component
public class Question { // хранение данных по вопросу
        private String question;
        private String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question1 = (Question) o;
        return getQuestion().equals(question1.getQuestion()) && getAnswer().equals(question1.getAnswer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestion(), getAnswer());
    }

    @Override
    public String toString() {
        return  "Вопрос =' " + question + '\'' +
                ", ответ =' " + answer + '\'' +
                '}';
    }
}
