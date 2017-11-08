package com.example.tdd2.hello.mapper;

import com.example.tdd2.hello.entity.User;
import org.apache.ibatis.annotations.*;

/**
 * Created by zhengqiang on 2017/11/7 20:39.
 * desc:
 */

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM t_user WHERE id = #{id}")
    User findById(@Param("id") int id);

    @Insert("insert into t_user(name,age)values(#{name},#{age})")
    void saveNewUser(User user);

    @Delete("delete from t_user where id =#{id}")
    void deleteUser(@Param("id") int id);
}
