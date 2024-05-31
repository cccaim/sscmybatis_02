package com.myapp.sscmybatis_02._05_controller;


import com.myapp.sscmybatis_02._02_dto.NoticeDTO;
import com.myapp.sscmybatis_02._04_service.NoticeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/notices")
public class NoticeController {

  private NoticeService noticeService;

  // 공지 목록 조회 메서드
  @GetMapping("/{noticeNo}")
  public String getNotices(@PathVariable int noticeNo , Model model) {
    // 공지 목록 로직
    List<NoticeDTO> noticeList = noticeService.getAllNotices(noticeNo);
    model.addAttribute("noticeList", noticeList);
    return "notices";
  }
}