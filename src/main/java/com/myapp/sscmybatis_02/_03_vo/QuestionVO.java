package com.myapp.sscmybatis_02._03_vo;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class QuestionVO {

  private int questionNo;
  private int userNo;
  private String content;
  private Date uploadDate;
  private int productNo;
  private String userName;
  private String productName;

}
