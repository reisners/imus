package com.herenow.service;

import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.herenow.account.model.Profile;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private MongoCollection profiles;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Profile user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        profiles.save(user);
    }

    @Override
    public Profile findByUsername(String username) {
        Profile profile = profiles.findOne("{#: #}", Profile.USERNAME, username).as(Profile.class);
        return profile;
    }

}
