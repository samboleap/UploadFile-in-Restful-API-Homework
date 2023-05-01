package com.istad.homeworkrestfulapi.service.serviceimpl;

import com.istad.homeworkrestfulapi.model.User;
import com.istad.homeworkrestfulapi.repository.UserRepository;
import com.istad.homeworkrestfulapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }
}
