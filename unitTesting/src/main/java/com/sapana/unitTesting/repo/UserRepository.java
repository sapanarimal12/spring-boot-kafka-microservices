package com.sapana.unitTesting.repo;

import com.sapana.unitTesting.model.User;

/**
 * Author: Sapana Rimal
 * Date: 10/29/2024
 */
public interface UserRepository {

    User findById(Long id);

}
