package com.myapp.sscmybatis_02._01_mapper;


import com.myapp.sscmybatis_02._03_vo.NoticeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
  List<NoticeVO> getNoticeList(int noticeNo);
}
