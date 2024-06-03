package com.myapp.sscmybatis_02._01_mapper;

import com.myapp.sscmybatis_02._03_vo.QuestionVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {

    int existsByQuestionNo(int questionNo);

    List<QuestionVO> getQuestionList(int questionNo);
}