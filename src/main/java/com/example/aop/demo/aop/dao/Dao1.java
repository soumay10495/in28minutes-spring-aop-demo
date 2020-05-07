package com.example.aop.demo.aop.dao;

import com.example.aop.demo.aop.aspect.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {
    @TrackTime
    public String retrieveSomething() {
        return "Dao 1";
    }
}
