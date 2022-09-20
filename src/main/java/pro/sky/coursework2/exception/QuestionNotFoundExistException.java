package pro.sky.coursework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Вопрос не найден")
public class QuestionNotFoundExistException extends RuntimeException {
}
