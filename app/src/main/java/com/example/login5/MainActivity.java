package com.example.login5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnLogOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, InsertItems.class);
        this.startActivity(intent);
        btnLogOut=(Button)findViewById(R.id.btnLogOut);
        btnLogOut.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.btnLogOut:

                Intent intent = new Intent(this, Login.class);
                this.startActivity(intent);
                break;


        }
    }
}
