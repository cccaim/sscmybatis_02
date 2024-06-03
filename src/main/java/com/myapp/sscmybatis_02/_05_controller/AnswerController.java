package com.myapp.sscmybatis_02._05_controller;


import com.myapp.sscmybatis_02._02_dto.AnswerDTO;
import com.myapp.sscmybatis_02._04_service.AnswerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/answers")
public class AnswerController {

  private final AnswerService answerService;

  @PostMapping
  public ResponseEntity<String> saveAnswer(@RequestBody AnswerDTO answerDTO) {
    answerService.saveAnswer(answerDTO);
    return ResponseEntity.ok("Answer saved successfully");
  }
}