package com.miko.test.miko.service;

import com.miko.test.miko.Repository.userRepository;
import com.miko.test.miko.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final userRepository  userRepository ;

    @Autowired
    public UserService(userRepository userRepository )
       {
        this.userRepository = userRepository;
       }

       public  void addUser(User user)
       {
           User user1 = new User(1 ,"Rohan" ,"Rohan@Gmail.com" ,
                   "123345") ;

           List<User>userList = new LinkedList<User>() ;
            userList.add(user1) ;
           Optional<User> userOptional = userRepository.
                            findUserByEmail(user.getEmail());

           if (userOptional.isPresent())
           {
               String message = "THIS EMAIL IS ALREADY PRESENT" ;
                throw  new IllegalStateException(message);
           }
           userRepository.save(user);
           // if u want to see on console  override toString method in model and print
           System.out.println("  User data  :"  +user);
           System.out.println(" name " + user.getUserName());

       }


       public void Login(String email ,String password)
       {

           User user = userRepository.findUserByEmail(email)
                   . orElseThrow(() -> new IllegalStateException(" does not exist"));

            if (email==null && email.length()>0 && !Objects.equals(user.getEmail(),email))
            {
                Optional<User>userOptional = userRepository.findUserByEmail(email);

                if (userOptional.isPresent())
                {
                    throw  new IllegalStateException(" user already present") ;
                }

                user.setEmail(email);
            }

            if (password==null &&password.length()>0 &&!Objects.equals(user.getPassword(),password))
            {
                 boolean userOptional = userRepository.equals(user.getPassword());
                  if (!userOptional)
                  {
                      throw new IllegalStateException("Enter Wrong password" + password) ;
                  }
                  else
                  {
                      user.setPassword(password);
                  }

            }



       }
}
