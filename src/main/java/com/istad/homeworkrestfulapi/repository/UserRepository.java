package com.istad.homeworkrestfulapi.repository;

import com.istad.homeworkrestfulapi.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserRepository {
    @Select("select * from users_tb")
    List<User> getAllUser();
}
