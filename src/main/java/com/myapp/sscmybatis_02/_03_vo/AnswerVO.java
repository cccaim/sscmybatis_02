package com.myapp.sscmybatis_02._03_vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class AnswerVO {

  private int answerNo;
  private int questionNo; //-
  private String content;
  private String uploadDate;
  private int userNo; //-
}
