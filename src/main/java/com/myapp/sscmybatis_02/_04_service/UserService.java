package com.myapp.sscmybatis_02._04_service;

import com.myapp.sscmybatis_02._01_mapper.UserMapper;
import com.myapp.sscmybatis_02._02_dto.UserDTO;
import com.myapp.sscmybatis_02._03_vo.UserVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
  private final UserMapper userMapper;

  public List<UserDTO> getAllUsers(int userNo) {
    List<UserVO> voList = userMapper.getUserList(userNo);
    return convertToDTOList(voList);
  }

  public UserDTO getUserDetails(int userNo) {
    UserVO vo = userMapper.getUserDetails(userNo);
    return convertToDTO(vo);
  }

  public void deleteUser(int userNo) {
    userMapper.deleteUser(userNo);
  }

  private List<UserDTO> convertToDTOList(List<UserVO> voList) {
    List<UserDTO> dtoList = new ArrayList<>();
    for (UserVO vo : voList) {
      dtoList.add(convertToDTO(vo));
    }
    return dtoList;
  }

  private UserDTO convertToDTO(UserVO vo) {
    if (vo == null) return null;
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
    return dto;
  }
}
