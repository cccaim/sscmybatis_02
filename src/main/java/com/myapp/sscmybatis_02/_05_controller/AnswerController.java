package com.myapp.sscmybatis_02._05_controller;


import com.myapp.sscmybatis_02._02_dto.AnswerDTO;
import com.myapp.sscmybatis_02._04_service.AnswerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/answers")
public class AnswerController {

  private final AnswerService answerService;

  @PostMapping
  public ResponseEntity<String> submitAnswer(@RequestBody AnswerDTO answerDTO) {
    // 질문 번호가 실제로 존재하는지 확인
    if (answerService.questionExists(answerDTO.getQuestionNo())) {
      answerService.saveAnswer(answerDTO);
      return ResponseEntity.ok("답변이 저장되었습니다.");
    } else {
      return ResponseEntity.status(400).body("Invalid question number.");
    }
  }
}