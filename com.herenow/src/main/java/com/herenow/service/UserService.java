package com.herenow.service;

import com.herenow.account.model.Profile;

public interface UserService {
    void save(Profile user);

    Profile findByUsername(String username);
}
