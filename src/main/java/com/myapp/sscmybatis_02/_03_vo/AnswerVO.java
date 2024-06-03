package com.myapp.sscmybatis_02._03_vo;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AnswerVO {

  private int answerNo;
  private int questionNo;
  private String content;
  private Date uploadDate;
  private int userNo;
}
