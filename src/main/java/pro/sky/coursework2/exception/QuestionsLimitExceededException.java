package pro.sky.coursework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Превышен лимит вопросов")
public class QuestionsLimitExceededException extends RuntimeException {

}
