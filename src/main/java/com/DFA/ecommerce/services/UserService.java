package com.DFA.ecommerce.services;

import com.DFA.ecommerce.models.Users;
import com.DFA.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(Users users) {
        userRepository.save(users);
    }

    public void deleteUser(long id) {
        Users users = userRepository.findById(id).get();
        userRepository.delete(users);
    }

}
