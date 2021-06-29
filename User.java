package com.miko.test.miko.model;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {

    @Id

    @SequenceGenerator(name = "user_sequence" ,
            sequenceName = "user_sequence",
            allocationSize = 1)

    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_sequence" )
    private  Integer Id;
    @Column(name = "username")
    private String userName;
    @Column(name = "email" ,nullable =  false)
    private  String email;
    @Column(name = "password" , nullable = false)
    private String password ;

    public User()
    {

    }
    public User(Integer id , String userName , String email, String password)
    {
        this.Id = id ;
         this.userName = userName ;
          this.email = email;
           this.password = password ;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
