package com.istad.homeworkrestfulapi.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    @NotBlank(message = "Username is required!!")
    private String username;
    @NotBlank(message = "Gender is required!!")
    private String gender;

    private String address;
    private String userImg;
}
