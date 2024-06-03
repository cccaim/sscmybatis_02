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

  @GetMapping("/{noticeNo}")
  public String getNotices(@PathVariable int noticeNo, Model model) {
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

  @GetMapping("/new")
  public String createNoticeForm(Model model) {
    model.addAttribute("notice", new NoticeDTO());
    return "createNotice";
  }

  @PostMapping("/new")
  public String createNotice(@ModelAttribute NoticeDTO notice) {
    noticeService.createNotice(notice);
    return "redirect:/notices/1";
  }

  @GetMapping("/search")
  public String searchNotices(@RequestParam("keyword") String keyword, Model model) {
    List<NoticeDTO> noticeList = noticeService.searchNotices(keyword);
    model.addAttribute("noticeList", noticeList);
    return "notices";
  }

  @PostMapping("/edit")
  public String editNotice(@ModelAttribute NoticeDTO notice) {
    noticeService.updateNotice(notice);
    return "redirect:/notices/details/" + notice.getNoticeNo();
  }
}
