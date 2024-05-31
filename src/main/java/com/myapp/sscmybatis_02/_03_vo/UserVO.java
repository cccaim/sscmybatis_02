package com.myapp.sscmybatis_02._03_vo;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserVO {

    private int userNo;
    private String name;
    private String birth;
    private String tel;
    private int gender;
    private String email;
    private String id;
    private String pw;
    private String refundAccount;
    private int userGradeNo;
    private String grade;

}