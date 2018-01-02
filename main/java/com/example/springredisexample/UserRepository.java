package com.example.springredisexample;

import com.example.springredisexample.Model.User;

import java.util.Map;

/**
 * Created by ouzun on 1/2/2018.
 */
public interface UserRepository {
  void save (User user);
  void update (User user);
  Map<String, User> findAll();
  void delete(String id);
  User findById(String id);
}
