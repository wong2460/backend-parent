package com.wong.backend_test.db.mongodb;

import com.alibaba.fastjson.JSON;
import com.wong.backend_test.BackendTestApplicationTests;
import com.wong.backend_test.db.mongodb.dao.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.ArrayList;
import java.util.List;

public class MyMongoTemplateTest extends BackendTestApplicationTests {

    @Autowired
    private MyMongoTemplate myMongoTemplate;

    @Test
    public void saveTest() {
        User user = User.builder().id(1).age(31).name("wong").build();
        System.out.println(user);
        myMongoTemplate.save(user);
    }

    @Test
    public void saveListTest() {
        List<User> userList = new ArrayList<User>();
        for (int i = 1; i <5; i++) {
            User user = User.builder().id(i).age(31+i).name("wong"+i).build();
            userList.add(user);
        }
        System.out.println(JSON.toJSONString(userList,true));
        myMongoTemplate.save(userList,User.class);
    }

    @Test
    public void dropCollectionTest() {
        myMongoTemplate.dropCollection(User.class);
    }

    @Test
    public void queryTest() {
        List userList =  myMongoTemplate.query(User.class, Sort.Direction.DESC,"age",3,null);
        System.out.println(JSON.toJSONString(userList,true));
    }

    @Test
    public void removeTest() {
        long dels = myMongoTemplate.remove(User.class, Criteria.where("age").gt(33));
        System.out.println(dels);

    }
}
