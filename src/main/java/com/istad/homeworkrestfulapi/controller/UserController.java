package com.istad.homeworkrestfulapi.controller;

import com.istad.homeworkrestfulapi.model.User;
import com.istad.homeworkrestfulapi.service.UserService;
import com.istad.homeworkrestfulapi.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/allUsers")
    public Response<List<User>> getALlUSer(){
        try {
            List<User> response = userService.getAllUser();
            return Response.<List<User>>ok().setPayload(response).setMessage("Successfully retrieved all user!!!");
        }catch (Exception e){
            return Response.<List<User>>exception().setMessage("Failed to retrieved the users!!!! Exception occurs");
        }
    }
}
