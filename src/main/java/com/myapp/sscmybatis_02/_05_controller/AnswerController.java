package com.myapp.sscmybatis_02._05_controller;


import com.myapp.sscmybatis_02._02_dto.AnswerDTO;
import com.myapp.sscmybatis_02._04_service.AnswerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/answers")
public class AnswerController {
  private final AnswerService answerService;

  @GetMapping("/{answerNo}")
  public String getAnswer(@PathVariable int answerNo, Model model) {
    List<AnswerDTO> answerList = answerService.getAllAnswers(answerNo);
    model.addAttribute("answerList", answerList);
    return "answer";
  }

  @PostMapping
  @ResponseBody
  public ResponseEntity<?> addAnswer(@RequestBody AnswerDTO answerDTO) {
    if (!answerService.isValidQuestionNo(answerDTO.getQuestionNo())) {
      return ResponseEntity.badRequest().body("Invalid question number");
    }

    answerService.saveAnswer(answerDTO);
    return ResponseEntity.ok().body("Answer saved successfully");
  }
}

