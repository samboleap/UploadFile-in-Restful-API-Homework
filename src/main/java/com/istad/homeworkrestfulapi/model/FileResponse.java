package com.istad.homeworkrestfulapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileResponse<T> {
    private T payload;
    private String message;
    private Integer status;
}