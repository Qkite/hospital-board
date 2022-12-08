package com.springboot.hospitalboard.service;


import com.springboot.hospitalboard.domain.User;
import com.springboot.hospitalboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public User getUserByUserName(String userName) {

        Optional<User> userOptional = userRepository.findByUserName(userName);


        if(userOptional.isEmpty()){
            throw new RuntimeException("해당 아이디를 가진 사용자를 찾을 수 없습니다.");
        }

        return userOptional.get();

    }
}
