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

  private NoticeDTO convertToDTO(NoticeVO vo) {
    return new NoticeDTO(vo.getNoticeNo(), vo.getContent(), vo.getStartDate(), vo.getEndDate(), vo.getUploadDate(), vo.getTitle(), vo.getUserNo(), vo.getName());
  }

  private NoticeVO convertToVO(NoticeDTO dto) {
    return new NoticeVO(dto.getNoticeNo(), dto.getContent(), dto.getStartDate(), dto.getEndDate(), dto.getUploadDate(), dto.getTitle(), dto.getUserNo(), dto.getName());
  }

  public List<NoticeDTO> getAllNotices(int noticeNo) {
    List<NoticeVO> voList = noticeMapper.getNoticeList(noticeNo);
    List<NoticeDTO> dtoList = new ArrayList<>();
    for (NoticeVO vo : voList) {
      dtoList.add(convertToDTO(vo));
    }
    return dtoList;
  }

  public NoticeDTO getNoticeById(int noticeNo) {
    NoticeVO vo = noticeMapper.getNoticeById(noticeNo);
    return convertToDTO(vo);
  }

  public void createNotice(NoticeDTO notice) {
    NoticeVO vo = convertToVO(notice);
    noticeMapper.insertNotice(vo);
  }

  public List<NoticeDTO> searchNotices(String keyword) {
    List<NoticeVO> voList = noticeMapper.searchNotices(keyword);
    List<NoticeDTO> dtoList = new ArrayList<>();
    for (NoticeVO vo : voList) {
      dtoList.add(convertToDTO(vo));
    }
    return dtoList;
  }

  public void updateNotice(NoticeDTO notice) {
    notice.setUploadDate(new Date());
    NoticeVO vo = convertToVO(notice);
    noticeMapper.updateNotice(vo);
  }
}
