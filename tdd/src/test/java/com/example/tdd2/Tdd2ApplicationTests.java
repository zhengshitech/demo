package com.example.tdd2;

import com.example.tdd2.hello.entity.User;
import com.example.tdd2.hello.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Tdd2ApplicationTests {

    @Autowired
    private MockMvc mvc;


    @Autowired
    private UserMapper userMapper;


    @Test
    public void contextLoads() {
        System.out.println("zz contextLoads");
    }


    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/zz/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
    }


    @Test
    public void post2Hello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/zz/post/hello tom cat").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    public void findUserById() throws Exception {
        User user = userMapper.findById(1);
        Assert.assertNotNull(user);
        System.out.println(user);
    }


    @Test
    public void saveUser() throws Exception {
        User user = new User();
        user.setName("Jany");
        user.setAge(55);
        userMapper.saveNewUser(user);
        System.out.println("saved new user with id:"+user.getId());
    }


    @Test
    public void deleteUser() throws Exception {
        userMapper.deleteUser(4);
        System.out.println("delete success");
    }



}
