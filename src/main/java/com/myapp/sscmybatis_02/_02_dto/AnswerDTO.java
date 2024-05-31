package com.myapp.sscmybatis_02._02_dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AnswerDTO {

    //answer
    private int answerNo;
    private int questionNo; //외래
    private String content;
    private Date uploadDate;
    private String userNo;  //외래


//    //question
//    private String questionNo;
//    private int userNo;
//    private String content;
//    private Date uploadDate;
//    private int productNo;  //외래

}
