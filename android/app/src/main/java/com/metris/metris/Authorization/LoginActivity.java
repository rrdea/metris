package com.metris.metris.Authorization;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.metris.metris.Home.HomeActivity;
import com.metris.metris.R;

import java.net.HttpURLConnection;

public class LoginActivity extends AppCompatActivity {

    private Button loginButtonLogin;
    private TextView loginTextViewRegister;
    private TextView loginTextViewForget;

    private String webcontent;
    private String nama;
    private HttpURLConnection httpConn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //instantiation
        loginButtonLogin = (Button) findViewById(R.id.login_button_login);
        loginTextViewRegister = (TextView) findViewById(R.id.login_textview_register);
        loginTextViewForget = (TextView) findViewById(R.id.login_textview_forget);

        //action
        loginTextViewForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
                startActivity(intent);
            }
        });
        loginTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
        loginButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });
    }

}
