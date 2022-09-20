package pro.sky.coursework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Вопрос уже существует")
public class QuestionAlreadyExistException extends RuntimeException {
}
