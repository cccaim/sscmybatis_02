package com.myapp.sscmybatis_02._01_mapper;

import com.myapp.sscmybatis_02._03_vo.AnswerVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnswerMapper {
  void insertAnswer(AnswerVO answerVO);
}
