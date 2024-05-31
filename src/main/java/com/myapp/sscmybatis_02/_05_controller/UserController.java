package com.myapp.sscmybatis_02._05_controller;


import com.myapp.sscmybatis_02._02_dto.UserDTO;
import com.myapp.sscmybatis_02._04_service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
