package com.myapp.sscmybatis_02._05_controller;


import com.myapp.sscmybatis_02._02_dto.NoticeDTO;
import com.myapp.sscmybatis_02._04_service.NoticeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping("/details/{noticeNo}")
  public String getNoticeDetails(@PathVariable int noticeNo, Model model) {
    NoticeDTO notice = noticeService.getNoticeById(noticeNo);
    model.addAttribute("notice", notice);
    return "noticeDetails";
  }

  // 새 공지사항 작성 페이지 메서드
  @GetMapping("/new")
  public String createNoticeForm(Model model) {
    model.addAttribute("notice", new NoticeDTO());
    return "createNotice";
  }

  // 새 공지사항 작성 처리 메서드
  @PostMapping("/new")
  public String createNotice(@ModelAttribute NoticeDTO notice) {
    noticeService.createNotice(notice);
    return "redirect:/notices/1";
  }
}