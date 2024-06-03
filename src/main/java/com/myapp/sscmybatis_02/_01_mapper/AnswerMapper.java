package com.myapp.sscmybatis_02._01_mapper;

import com.myapp.sscmybatis_02._03_vo.AnswerVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AnswerMapper {
  void insertAnswer(AnswerVO answerVO);

  @Select("SELECT COUNT(*) FROM answer WHERE questionNo = #{questionNo}")
  int countAnswersByQuestionNo(int questionNo);

  @Select("SELECT content FROM answer WHERE questionNo = #{questionNo} ORDER BY uploadDate DESC LIMIT 1")
  String findLatestAnswerContentByQuestionNo(int questionNo); // 질문 번호로 가장 최근 답변 내용 조회
}
