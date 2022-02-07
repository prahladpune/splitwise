package com.prahlad.study.splitwise.service;

import com.prahlad.study.splitwise.models.User;
import com.prahlad.study.splitwise.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User registerUser(final String userName, final String phoneNumber, final String password) {

        return userRepository.save(User.builder().name(userName).phoneNumber(phoneNumber).hashedPassword(password).build());
    }

    public User updateUserProfile(Long userId, String newPassword) {
        User user = userRepository.getById(userId);
        if (user != null) {
            user.setHashedPassword(newPassword);
            return userRepository.save(user);
        }

        return null;
    }
}
