package com.example.login5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.login5.DAO.UserDao;
import com.example.login5.DTO.UserDto;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Register extends AppCompatActivity implements View.OnClickListener {
    TextView txtvLogin;
    EditText edtFName,edtLName,edtAddress,edtPhone,edtUsername,edtPassword,edtBirthdate;
    RadioGroup radUserType;
    RadioButton radShop;
    RadioButton radShipper;
    RadioButton radCustomer;
    Button btnSignUp,btnSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        radUserType=(RadioGroup )findViewById(R.id.radioGroupUserType);
        radShop=(RadioButton)findViewById(R.id.radShop);
        radShipper=(RadioButton)findViewById(R.id.radShipper);
        radCustomer=(RadioButton)findViewById(R.id.radShipper);
        txtvLogin=(TextView)findViewById(R.id.txtvLogin);
        btnSignUp=(Button)findViewById(R.id.btnSignUp);
        btnSelect=(Button)findViewById(R.id.btnSelect);


        edtFName=(EditText)findViewById(R.id.edtFirstName);
        edtLName=(EditText)findViewById(R.id.edtLastName);
        edtAddress=(EditText)findViewById(R.id.edtAddress);
        edtPhone=(EditText)findViewById(R.id.edtPhone);
        edtBirthdate=(EditText)findViewById(R.id.edtBirthdate);
        edtUsername=(EditText)findViewById(R.id.edtUsername);
        edtPassword=(EditText)findViewById(R.id.edtPassword);


        btnSignUp.setOnClickListener(this);
        txtvLogin.setOnClickListener(this);
        btnSelect.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.btnSignUp:

                String fname=edtFName.getText().toString();
                String lname=edtLName.getText().toString();
                String address=edtAddress.getText().toString();
                String phone=edtPhone.getText().toString();
                String birthdate=edtBirthdate.getText().toString();
                String username=edtUsername.getText().toString();
                String password=edtPassword.getText().toString();

                int selectedUserType=radUserType.getCheckedRadioButtonId();
                String usertype=((RadioButton)findViewById(selectedUserType)).getText().toString();

                Date currentTime = Calendar.getInstance().getTime();
                String createdDate=currentTime.toString();
                UserDto userDto=new UserDto(username,password,fname,lname,birthdate,address,phone,usertype,createdDate);
                UserDao.Insert(userDto);



               /* Response.Listener<String>responseListener=new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse=new JSONObject(response);

                            boolean success=jsonResponse.getBoolean("success");

                            if(success)
                            {
                                Intent intent = new Intent(Register.this, Login.class);
                                Register.this.startActivity(intent);
                            }
                            else
                            {
                                AlertDialog.Builder builder=new AlertDialog.Builder(Register.this);
                                builder.setMessage("Register failed!").setNegativeButton("Retry",null).create().show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RegisterRequest registerRequest=new RegisterRequest(fname,lname,username,password,phone,birthdate,address,usertype,responseListener);
                RequestQueue queue= Volley.newRequestQueue(Register.this);
                queue.add(registerRequest);*/

                startActivity(new Intent(this, MainActivity.class));

                break;
            case R.id.txtvLogin:
                startActivity(new Intent(this, Login.class));
                break;
            case R.id.btnSelect:
                pickDate();
                break;
        }
    }
    private void pickDate(){
        final Calendar calendar=Calendar.getInstance();
        int day=calendar.get(Calendar.DATE);
        int month=calendar.get(Calendar.MONTH);
        int year=calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(i,i1,i2);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
                edtBirthdate.setText(simpleDateFormat.format(calendar.getTime()));
            }
        },year,month,day);
        datePickerDialog.show();
    }
}
