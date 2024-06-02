package com.myapp.sscmybatis_02._04_service;

import com.myapp.sscmybatis_02._02_dto.AnswerDTO;
import com.myapp.sscmybatis_02._01_mapper.AnswerMapper;

import com.myapp.sscmybatis_02._03_vo.AnswerVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class AnswerService {
  private final AnswerMapper answerMapper;

  public List<AnswerDTO> getAllAnswers(int answerNo) {
    List<AnswerVO> voList = answerMapper.getAnswerList(answerNo);

    List<AnswerDTO> dtoList = new ArrayList<>();
    for (AnswerVO vo : voList) {
      AnswerDTO dto = new AnswerDTO();

      dto.setAnswerNo(vo.getAnswerNo());
      dto.setQuestionNo(vo.getQuestionNo());
      dto.setContent(vo.getContent());
      dto.setUploadDate(vo.getUploadDate());
      dto.setUserNo(vo.getUserNo());

      dtoList.add(dto);
    }
    return dtoList;
  }
  public void saveAnswer(AnswerDTO answerDTO) {
    AnswerVO answerVO = new AnswerVO(
            answerDTO.getAnswerNo(),
            answerDTO.getQuestionNo(),
            answerDTO.getContent(),
            answerDTO.getUploadDate(),
            answerDTO.getUserNo()
    );
    answerMapper.insertAnswer(answerVO);
  }
}
