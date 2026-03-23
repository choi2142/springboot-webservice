package com.choi.springwebservice.service;

import com.choi.springwebservice.domain.user.User;
import com.choi.springwebservice.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found with email: " + email));
    }

    @Transactional
    public User save(User user) {
        validatePhoneNumber(user.getPhoneNumber());
        return userRepository.save(user);
    }

    private void validatePhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^010-\d{4}-\d{4}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid phone number format. Must be 010-XXXX-XXXX.");
        }
    }
}