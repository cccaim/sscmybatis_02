package com.myapp.sscmybatis_02._02_dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class QuestionDTO {

    private int questionNo;
    private int userNo;
    private String content;
    private Date uploadDate;
    private int productNo;
    private String userName;
    private String productName;

}