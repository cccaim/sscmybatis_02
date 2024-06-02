package com.myapp.sscmybatis_02._01_mapper;

import com.myapp.sscmybatis_02._03_vo.AnswerVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnswerMapper {
    List<AnswerVO> getAnswerList(int AnswerNo);

    void insertAnswer(AnswerVO answerVO);
}

