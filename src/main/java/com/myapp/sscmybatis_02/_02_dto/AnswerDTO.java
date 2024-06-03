package com.myapp.sscmybatis_02._02_dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AnswerDTO {

    private int answerNo;
    private int questionNo;
    private String content;
    private Date uploadDate;
    private int userNo;
}
