package pro.sky.coursework2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursework2.Question;
import pro.sky.coursework2.service.ExaminerService;
import java.util.Collection;

@RestController
public class ExamController {
    private static ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping(value = "/exam/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount){//@PathVariable чтобы внести параметр {amount}
        return examinerService.getQuestions(amount);
    }
}
