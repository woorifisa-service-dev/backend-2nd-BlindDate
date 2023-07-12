//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package dev.controller;

import dev.dto.UserRequest;

import dev.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping({"/users"})
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserRequest signUp(@RequestBody UserRequest userRequest) {
        return userService.save(userRequest);
    }

    @PostMapping("/login")
    public void logIn(@RequestBody UserRequest userRequest, HttpSession httpSession, HttpServletResponse response){
        UserRequest userRequestLogin = userService.findId(userRequest);
        httpSession.setAttribute("email", userRequestLogin.getEmail());

        String id = httpSession.getId();
        System.out.println(id);
        Cookie cookie = new Cookie("id", id);

        cookie.setMaxAge(30 * 60);
        cookie.setHttpOnly(false);

        response.addCookie(cookie);



    }

}
