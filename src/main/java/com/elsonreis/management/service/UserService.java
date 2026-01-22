package com.elsonreis.management.service;

import com.elsonreis.management.entity.User;
import com.elsonreis.management.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createuser(User user) {
        User exisitingUser = userRepository.findByEmail(user.getEmail());

        if(exisitingUser != null) {
            throw new RuntimeException("o email está sendo usado");
        }

        return userRepository.save(user);
    }

    public java.util.List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserId(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("id ainda não existente"));
    }

    public void deleteUser(Long id) {
        getUserId(id);
        userRepository.deleteById(id);
    }
}
