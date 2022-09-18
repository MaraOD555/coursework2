package pro.sky.coursework2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursework2.Question;
import pro.sky.coursework2.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private static QuestionService questionService; // именно сервис, не реализацию

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
@GetMapping("add")
    public Question add (@RequestParam ("question") String question,
                         @RequestParam ("answer") String answer){
            return questionService.add(question, answer);
    }
@GetMapping("remove")
    public Question remove (@RequestParam ("question") String question,
                            @RequestParam ("answer") String answer){
   // Question questions = new Question(question, answer);
    return questionService.remove(new Question(question, answer));
    }
@GetMapping
    public Collection<Question> getAll(){
        return questionService.getAll();
    }
}
