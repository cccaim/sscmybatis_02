package com.myapp.sscmybatis_02._05_controller;


import com.myapp.sscmybatis_02._02_dto.AnswerDTO;
import com.myapp.sscmybatis_02._02_dto.QuestionDTO;
import com.myapp.sscmybatis_02._04_service.AnswerService;
import com.myapp.sscmybatis_02._04_service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@Controller
@RequestMapping("/questions")
public class QuestionController {

  private final QuestionService questionService;
  private final AnswerService answerService;

  //  메인화면을 만들어야 temp를 사용
  @GetMapping
  public String questionMain(){
    return "questions";
  }

  @GetMapping("/{questionNo}")
  public String getQuestion(@PathVariable int questionNo, Model model) {
    List<QuestionDTO> questionList = questionService.getAllQuestions(questionNo);
    model.addAttribute("questionList", questionList);
    return "questions";
  }

}
