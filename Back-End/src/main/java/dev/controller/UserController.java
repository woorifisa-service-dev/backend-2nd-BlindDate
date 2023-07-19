//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package dev.controller;

import dev.dto.UserRequest;

import dev.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpCookie;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping({"/users"})
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    public String getUserName(HttpSession httpSession) {
        UserRequest user = (UserRequest) httpSession.getAttribute("user");
        return user.getName();
    }

    @PostMapping
    public UserRequest signUp(@RequestBody UserRequest userRequest) {
        return userService.save(userRequest);
    }

    @PostMapping("/login")
    public String logIn(@RequestBody UserRequest userRequest, HttpSession httpSession, HttpServletResponse response){
        UserRequest userRequestLogin = userService.findId(userRequest);
        httpSession.setAttribute("user", userRequestLogin);

        return userRequestLogin.getName();
    }

    @PostMapping("/logout")
    public void logOut(HttpSession httpSession){
        httpSession.invalidate();
    }
    // 사용자 이름 가져오기



}
