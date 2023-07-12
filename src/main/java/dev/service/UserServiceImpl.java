package dev.service;

import dev.entity.User;

import dev.repository.UserRepository;
import dev.dto.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


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


}
