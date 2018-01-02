package com.example.springredisexample;

import com.example.springredisexample.Model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by ouzun on 1/2/2018.
 */
@RestController
@RequestMapping("/rest/user")
public class UserResource {
  private UserRepository userRepository;

  public UserResource(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  @GetMapping("/add/{id}/{name}/{surname}")
  public User add(@PathVariable("id") final String id, @PathVariable("name") final String name, @PathVariable("surname") final String surname){
    userRepository.save(new User(id,name,surname));

    return userRepository.findById(id);
  }

  @GetMapping("/update/{id}/{name}/{surname}")
  public User update(@PathVariable("id") final String id, @PathVariable("name") final String name, @PathVariable("surname") final String surname){
    userRepository.update(new User(id,name,surname));

    return userRepository.findById(id);
  }

  @GetMapping("/all")
  public Map<String, User> findAll(){
    return userRepository.findAll();
  }
}
