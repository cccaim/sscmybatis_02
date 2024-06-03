package com.myapp.sscmybatis_02._04_service;

import com.myapp.sscmybatis_02._02_dto.QuestionDTO;
import com.myapp.sscmybatis_02._01_mapper.QuestionMapper;

import com.myapp.sscmybatis_02._03_vo.QuestionVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class QuestionService {
  private final QuestionMapper questionMapper;
  //모든 질문목록을 반환
  public List<QuestionDTO> getAllQuestions(int questionId) {
    List<QuestionVO> voList = questionMapper.getQuestionList(questionId);
    //확인용 sout
    for(QuestionVO vo : voList){
      System.out.println(vo);
    }

    List<QuestionDTO> dtoList = new ArrayList<>();
    for (QuestionVO vo : voList) {
      QuestionDTO dto = new QuestionDTO();

      dto.setQuestionNo(vo.getQuestionNo());
      dto.setUserNo(vo.getUserNo());
      dto.setContent(vo.getContent());
      dto.setUploadDate(vo.getUploadDate());
      dto.setProductNo(vo.getProductNo());
      dto.setUserName(vo.getUserName());
      dto.setProductName(vo.getProductName());

      dtoList.add(dto);
    }
    return dtoList;
  }
}
