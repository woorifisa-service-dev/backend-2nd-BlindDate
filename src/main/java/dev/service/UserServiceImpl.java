package dev.service;

import dev.dto.BoardRequest;
import dev.entity.User;

import dev.repository.UserRepository;
import dev.dto.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserRequest save(UserRequest userRequest) {
        User user = userRepository.save(User.from(userRequest));
        return UserRequest.from(user);
    }

    @Override
    public UserRequest findId(UserRequest userRequest) {
        String email = userRequest.getEmail();
        String password = userRequest.getPassword();
        return UserRequest.from(userRepository.findByEmailAndPassword(email, password).get());
    }

    @Override
    public Long findByEmail(String email) {
        return userRepository.findByEmail(email).get().getUserId();
    }

    @Override
    public String findByUserId(Long userId) {

        return userRepository.findByUserId(userId).get().getName();
    }


}
