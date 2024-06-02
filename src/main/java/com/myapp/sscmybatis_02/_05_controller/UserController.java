package com.myapp.sscmybatis_02._05_controller;


import com.myapp.sscmybatis_02._02_dto.UserDTO;
import com.myapp.sscmybatis_02._04_service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/users")
public class UserController {
  private UserService userService;

  @GetMapping("/{userNo}")
  public String getUsers(@PathVariable int userNo, Model model) {
    List<UserDTO> userList = userService.getAllUsers(userNo);
    model.addAttribute("userList", userList);
    return "users";
  }

  @GetMapping("/details/{userNo}")
  @ResponseBody
  public UserDTO getUserDetails(@PathVariable int userNo) {
    List<UserDTO> userList = userService.getAllUsers(userNo);
    if (!userList.isEmpty()) {
      return userList.get(0);  // userNo로 조회했으므로 하나의 결과만 반환될 것으로 가정
    } else {
      return null;
    }
  }
}
