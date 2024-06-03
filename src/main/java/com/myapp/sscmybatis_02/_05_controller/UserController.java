package com.myapp.sscmybatis_02._05_controller;


import com.myapp.sscmybatis_02._02_dto.UserDTO;
import com.myapp.sscmybatis_02._04_service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    return userService.getUserDetails(userNo);
  }

  @DeleteMapping("/delete/{userNo}")
  @ResponseBody
  public ResponseEntity<Void> deleteUser(@PathVariable int userNo) {
    userService.deleteUser(userNo);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/search")
  public String searchUsers(@RequestParam String keyword, Model model) {
    List<UserDTO> userList = userService.searchUsers(keyword);
    model.addAttribute("userList", userList);
    return "users";
  }
}
