package com.myapp.sscmybatis_02._02_dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class NoticeDTO {

    private int noticeNo;
    private String content;
    private Date startDate;
    private Date endDate;
    private Date uploadDate;
    private String title;
    private int userNo;
    private String name;

}