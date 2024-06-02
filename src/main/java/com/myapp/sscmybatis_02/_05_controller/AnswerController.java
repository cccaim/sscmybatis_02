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
@Controller
@RequestMapping("/answers")
public class AnswerController {
  private final AnswerService answerService;

  @GetMapping("/{answerNO}")
  public String getAnswer(@PathVariable int answerNO , Model model) {
    List<AnswerDTO> answerList = answerService.getAllAnswers(answerNO);
    model.addAttribute("answerList", answerList);
    return "answer";
  }
  @PostMapping
  @ResponseBody
  public ResponseEntity<?> addAnswer(@RequestBody AnswerDTO answerDTO) {
    answerService.saveAnswer(answerDTO);
    return ResponseEntity.ok().body("Answer saved successfully");
  }
}
