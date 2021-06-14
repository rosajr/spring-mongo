package com.rosajr.springmongo.service;

import com.rosajr.springmongo.domain.User;
import com.rosajr.springmongo.exceptions.ObjectNotFoundException;
import com.rosajr.springmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
