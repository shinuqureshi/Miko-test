package com.miko.test.miko.model;

import com.amazonaws.services.licensemanager.model.LicenseStatus;
import com.miko.test.miko.model.User;
import com.miko.test.miko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/user")
public class UserController {

  private final UserService  userService ; // we will  inject service class here
    @Autowired
    public  UserController(UserService userService)
       {
         this.userService = userService ;
       }


    @PostMapping("/signup")
    public void saveUser(@RequestBody User user)
    {
        userService.addUser(user);
        System.out.println("User  Sign up  Successfully" +user);
    }


    @PostMapping( path = "/login")
    public  void login(@RequestParam(required = false) String email
                       , @RequestParam(required = false) String password)
     {
      userService.Login(email ,password);
        System.out.println("Login SuccessFully" +email   + " "+ password);
    }










}
