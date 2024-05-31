package com.myapp.sscmybatis_02._03_vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class AnswerVO {

  private int answerNo;
  private int questionNo;
  private String content;
  private Date uploadDate;
  private String userNo;
}
