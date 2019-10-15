package com.example.login5;

import android.content.Context;
import android.content.SharedPreferences;

public class UserLocalStore {
    public static final String SP_NAME="userDetails";
    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context)
    {
        userLocalDatabase=context.getSharedPreferences(SP_NAME,0);
    }

    public void storeUserData(User user)
    {
        SharedPreferences.Editor spEditor=userLocalDatabase.edit();
        spEditor.putString("firstname",user.firstName);
        spEditor.putString("lastname",user.lastName);
        spEditor.putString("phone",user.phone);
        spEditor.putString("address",user.address);
        spEditor.putString("birthDate",user.birthDate);
        spEditor.putString("username",user.username);
        spEditor.putString("password",user.password);
        spEditor.putString("userType",user.userType);
        spEditor.commit();
    }

    public User getLoggedInUser()
    {
        String fname=userLocalDatabase.getString("firstname","");
        String lname=userLocalDatabase.getString("lastname","");
        String phone=userLocalDatabase.getString("phone","");
        String address=userLocalDatabase.getString("address","");
        String username=userLocalDatabase.getString("username","");
        String password=userLocalDatabase.getString("password","");
        String usertype=userLocalDatabase.getString("userType","");
        String birthdate=userLocalDatabase.getString("birthDate","");

        User storedUser=new User(fname,lname,username,password,phone,address,birthdate,usertype);
        return storedUser;
    }

    public void setUserLoggedin(boolean loggedIn)
    {
        SharedPreferences.Editor spEditor=userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn",loggedIn);
        spEditor.commit();
    }

    public boolean getUserLoggedIn()
    {
        if(userLocalDatabase.getBoolean("loggedIn",false)==true)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
    public void clearUserData()
    {
        SharedPreferences.Editor spEditor=userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }

}
