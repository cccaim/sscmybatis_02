package com.myapp.sscmybatis_02._01_mapper;


import com.myapp.sscmybatis_02._03_vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
  List<UserVO> getUserList(int userNo);
  void deleteUser(int userNo);
  UserVO getUserDetails(int userNo);
}
