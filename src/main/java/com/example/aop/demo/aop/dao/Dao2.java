package com.example.aop.demo.aop.dao;

import com.example.aop.demo.aop.aspect.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class Dao2 {
    @TrackTime
    public String retrieveSomething() {
        return "Dao 2";
    }
}
