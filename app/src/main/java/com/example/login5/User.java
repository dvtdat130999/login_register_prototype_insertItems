package com.example.login5;

public class User {
    String firstName,lastName,username,password,phone,birthDate,address,userType;

    public User(String fname,String lname,String username,String password,String phone,String address,String birthdate,String usertype)
    {
        this.firstName=fname;
        this.lastName=lname;
        this.username=username;
        this.password=password;
        this.phone=phone;
        this.birthDate=birthdate;
        this.address=address;
        this.userType=usertype;
    }

    public User(String username,String password)
    {
        this.username=username;
        this.password=password;
        this.firstName="";
        this.lastName="";
        this.phone="";
        this.address="";
        this.birthDate="";
        this.userType="";

    }

}
