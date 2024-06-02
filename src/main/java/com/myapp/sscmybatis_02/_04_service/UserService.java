package com.myapp.sscmybatis_02._04_service;

import com.myapp.sscmybatis_02._01_mapper.UserMapper;
import com.myapp.sscmybatis_02._02_dto.UserDTO;
import com.myapp.sscmybatis_02._03_vo.UserVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class UserService {
  private final UserMapper userMapper;

  //모든 유저정보 반환
  public List<UserDTO> getAllUsers(int userNo){
    List<UserVO> voList = userMapper.getUserList(userNo);
    for(UserVO vo : voList){
      System.out.println(vo);
    }
    List<UserDTO> dtoList = new ArrayList<>();
    for (UserVO vo : voList) {
      UserDTO dto = new UserDTO();

      dto.setUserNo(vo.getUserNo());
      dto.setName(vo.getName());
      dto.setBirth(vo.getBirth());
      dto.setTel(vo.getTel());
      dto.setGender(vo.getGender());
      dto.setEmail(vo.getEmail());
      dto.setId(vo.getId());
      dto.setPw(vo.getPw());
      dto.setRefundAccount(vo.getRefundAccount());
      dto.setUserGradeNo(vo.getUserGradeNo());
      dto.setGrade(vo.getGrade());

      dtoList.add(dto);
    }
    return dtoList;
  }
}
