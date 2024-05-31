package com.myapp.sscmybatis_02._01_mapper;

import com.myapp.sscmybatis_02._03_vo.AnswerVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnswerMapper {
    List<AnswerVO> getAnswerList(int AnswerNo);

    @Insert("INSERT INTO answer (questionNo, userNo, content, uploadDate) VALUES (#{questionNo}, #{userNo}, #{content}, #{uploadDate})")
    void insertAnswer(Answer answer);
}

