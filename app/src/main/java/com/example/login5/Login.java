package com.example.login5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.login5.DAO.UserDao;
import com.example.login5.Utils.Database;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends AppCompatActivity implements View.OnClickListener{
    TextView txtvRegister;

    EditText edtUsername,edtPassword;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtvRegister=(TextView)findViewById(R.id.txtvRegister);
        edtUsername=(EditText)findViewById(R.id.edtUsername);
        edtPassword=(EditText)findViewById(R.id.edtPassword);
        btnSignIn=(Button)findViewById(R.id.btnSignIn);


        btnSignIn.setOnClickListener(this);
        txtvRegister.setOnClickListener(this);


    }



    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.btnSignIn:
                String username=edtUsername.getText().toString();
                String password=edtPassword.getText().toString();

                boolean test=false;

                test=UserDao.CheckLogin(username,password);

                if(test==true)
                {
                    AlertDialog.Builder builder=new AlertDialog.Builder(Login.this);
                    builder.setMessage("Login success!").create().show();
                    Intent intent=new Intent(Login.this,MainActivity.class);

                    Login.this.startActivity(intent);

                }
                else
                {
                    AlertDialog.Builder builder=new AlertDialog.Builder(Login.this);
                    builder.setMessage("Login failed!").setNegativeButton("Retry",null).create().show();

                }
                /*final String username=edtUsername.getText().toString();
                final String password=edtPassword.getText().toString();
                Response.Listener<String> responseListener=new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse=new JSONObject(response);
                            boolean success=jsonResponse.getBoolean("success");

                            if(success)
                            {
                                String fname=jsonResponse.getString("firstName");
                                String lname=jsonResponse.getString("lastName");
                                String phone=jsonResponse.getString("phone");
                                String address=jsonResponse.getString("address");
                                String birthDate=jsonResponse.getString("birthDate");
                                String userType=jsonResponse.getString("userType");

                                Intent intent=new Intent(Login.this,MainActivity.class);
                                intent.putExtra("firstName",fname);
                                intent.putExtra("lastName",lname);
                                intent.putExtra("phone",phone);
                                intent.putExtra("address",address);
                                intent.putExtra("birthDate",birthDate);
                                intent.putExtra("userType",userType);

                                Login.this.startActivity(intent);
                            }
                            else
                            {
                                AlertDialog.Builder builder=new AlertDialog.Builder(Login.this);
                                builder.setMessage("Login failed!").setNegativeButton("Retry",null).create().show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };


                LoginRequest loginRequest=new LoginRequest(username,password,responseListener);
                RequestQueue queue= Volley.newRequestQueue(Login.this);
                queue.add(loginRequest);

*/
                break;
            case R.id.txtvRegister:
                startActivity(new Intent(this, Register.class));
                break;

        }
    }

}
