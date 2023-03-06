package com.blog.mapper;

import com.blog.pojo.User;
import java.util.List;

public interface UserMapper {
    //一个mapper接口对应映射文件中的一个sql语句
    //一个数据库中的表对应一个Mapper接口，对应一个配置文件，对应一个实体类
    int insertUser();

    void updateUser();

    void deleteUser();

    User getUserById();

    List<User> getAllUser();
}
