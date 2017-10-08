package com.itmuch.cloud.study.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.study.user.entity.User;
import com.itmuch.cloud.study.user.feign.UserFeignClient;

@RestController
public class MovieController {
  @Autowired
  private UserFeignClient userFeignClient;

  @RequestMapping(value="/user/{id}",method=RequestMethod.GET)
  public User findById(@PathVariable Long id) {
    return this.userFeignClient.findById(id);
  }
}
