package com.myapp.sscmybatis_02._04_service;

import com.myapp.sscmybatis_02._01_mapper.AnswerMapper;
import com.myapp.sscmybatis_02._01_mapper.QuestionMapper;
import com.myapp.sscmybatis_02._02_dto.AnswerDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AnswerService {
  private final AnswerMapper answerMapper;
  private final QuestionMapper questionMapper;

  public void saveAnswer(AnswerDTO answerDTO) {
    answerMapper.insertAnswer(answerDTO);
  }

  public boolean questionExists(int questionNo) {
    return questionMapper.existsByQuestionNo(questionNo) > 0;
  }
}