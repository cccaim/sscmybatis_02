package com.myapp.sscmybatis_02._01_mapper;

import com.myapp.sscmybatis_02._03_vo.NoticeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
  List<NoticeVO> getNoticeList(int noticeNo);

  NoticeVO getNoticeById(int noticeNo);

  void insertNotice(NoticeVO notice);

  List<NoticeVO> searchNotices(String keyword);

  void updateNotice(NoticeVO notice);
}
