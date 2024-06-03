package com.myapp.sscmybatis_02._04_service;

import com.myapp.sscmybatis_02._01_mapper.AnswerMapper;
import com.myapp.sscmybatis_02._02_dto.AnswerDTO;
import com.myapp.sscmybatis_02._03_vo.AnswerVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AnswerService {

  private final AnswerMapper answerMapper;

  public void saveAnswer(AnswerDTO answerDTO) {
    if (answerDTO == null) {
      throw new IllegalArgumentException("AnswerDTO 는 null 값은 안됩니다");
    }
    AnswerVO answerVO = new AnswerVO();

    answerVO.setAnswerNo(answerDTO.getAnswerNo());
    answerVO.setQuestionNo(answerDTO.getQuestionNo());
    answerVO.setContent(answerDTO.getContent());
    answerVO.setUploadDate(answerDTO.getUploadDate());
    answerVO.setUserNo(answerDTO.getUserNo());

    answerMapper.insertAnswer(answerVO);
  }
}

