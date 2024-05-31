package com.myapp.sscmybatis_02._03_vo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductVO {
  private int photoNo;
  private String photoName;


  private int productNo;
  private String productName;
  private int price;

  private int category2No;
  private String category2Name;
  private String category2NameKo;

  private int category1No;
  private String category1Name;
  private String category1NameKo;

//  private int colorNo;
//  private String colorName;

}
