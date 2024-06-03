package com.myapp.sscmybatis_02._04_service;


import com.myapp.sscmybatis_02._01_mapper.NoticeMapper;
import com.myapp.sscmybatis_02._02_dto.NoticeDTO;
import com.myapp.sscmybatis_02._03_vo.NoticeVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class NoticeService {
  private final NoticeMapper noticeMapper;

  // 모든 공지사항을 반환
  public List<NoticeDTO> getAllNotices(int noticeNo) {
    List<NoticeVO> voList = noticeMapper.getNoticeList(noticeNo);
    // 모든 공지 가져오기
    for(NoticeVO vo : voList){
      System.out.println(vo);
    }
    List<NoticeDTO> dtoList = new ArrayList<>();
    for (NoticeVO vo : voList) {
      NoticeDTO dto = new NoticeDTO();

      dto.setNoticeNo(vo.getNoticeNo());
      dto.setContent(vo.getContent());
      dto.setStartDate(vo.getStartDate());
      dto.setEndDate(vo.getEndDate());
      dto.setUploadDate(vo.getUploadDate());
      dto.setTitle(vo.getTitle());
      dto.setUserNo(vo.getUserNo());
      dto.setName(vo.getName());

      dtoList.add(dto);
    }
    return dtoList;
  }

  // 단일 공지사항 조회
  public NoticeDTO getNoticeById(int noticeNo) {
    NoticeVO vo = noticeMapper.getNoticeById(noticeNo);
    return new NoticeDTO(vo.getNoticeNo(), vo.getContent(), vo.getStartDate(), vo.getEndDate(), vo.getUploadDate(), vo.getTitle(), vo.getUserNo(), vo.getName());
  }

  // 새 공지사항 생성 메서드
  public void createNotice(NoticeDTO notice) {
    NoticeVO vo = new NoticeVO(notice.getNoticeNo(), notice.getContent(), notice.getStartDate(), notice.getEndDate(), notice.getUploadDate(), notice.getTitle(), notice.getUserNo(), notice.getName());
    noticeMapper.insertNotice(vo);
  }

  public List<NoticeDTO> searchNotices(String keyword) {
    List<NoticeVO> voList = noticeMapper.searchNotices(keyword);
    List<NoticeDTO> dtoList = new ArrayList<>();
    for (NoticeVO vo : voList) {
      NoticeDTO dto = new NoticeDTO(
              vo.getNoticeNo(), vo.getContent(), vo.getStartDate(), vo.getEndDate(), vo.getUploadDate(), vo.getTitle(), vo.getUserNo(), vo.getName()
      );
      dtoList.add(dto);
    }
    return dtoList;
  }

  public void updateNotice(NoticeDTO notice) {
    notice.setUploadDate(new Date());
    NoticeVO vo = new NoticeVO(
            notice.getNoticeNo(), notice.getContent(), notice.getStartDate(), notice.getEndDate(), notice.getUploadDate(), notice.getTitle(), notice.getUserNo(), notice.getName()
    );
    noticeMapper.updateNotice(vo);
  }
}