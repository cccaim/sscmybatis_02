package com.myapp.sscmybatis_02._02_dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {

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
