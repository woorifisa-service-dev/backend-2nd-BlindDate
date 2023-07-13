//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package dev.service;


import dev.dto.UserRequest;
import dev.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserRequest save(UserRequest userRequest);

    UserRequest findId(UserRequest userRequest);
    Long findByEmail(String email);

    String findByUserId(Long userId);

}
