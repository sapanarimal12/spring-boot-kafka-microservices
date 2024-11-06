package com.sapana.unitTesting.service;

import com.sapana.unitTesting.model.User;
import com.sapana.unitTesting.repo.UserRepository;

/**
 * Author: Sapana Rimal
 * Date: 10/29/2024
 */
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id);
    }
}
