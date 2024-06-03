package com.myapp.sscmybatis_02._03_vo;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class NoticeVO {

    private int noticeNo;
    private String content;
    private Date startDate;
    private Date endDate;
    private Date uploadDate;
    private String title;
    private int userNo;
    private String name;

}