package com.myapp.sscmybatis_02._02_dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AnswerDTO {

    private int answerNo;
    private int questionNo;
    private String content;
    private String uploadDate;
    private String userNo;
}
