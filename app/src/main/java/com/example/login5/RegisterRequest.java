package com.example.login5;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL="link/Register.php";
    private Map<String,String> params;

    public RegisterRequest(String firstName, String lastName, String username, String password,
                           String phone, String birthDate, String address, String userType, Response .Listener<String> listener)
    {
        super(Request.Method.POST,REGISTER_REQUEST_URL,listener,null);
        params=new HashMap<>();
        params.put("firstName",firstName);
        params.put("lastName",lastName);
        params.put("username",username);
        params.put("password",password);
        params.put("phone",phone);
        params.put("birthDate",birthDate);
        params.put("address",address);
        params.put("userType",userType);

    }

    @Override
    public Map<String, String> getParams() {



        return params;
    }
}
