package com.metris.metris.Authorization;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.metris.metris.R;

public class RegisteredActivity extends AppCompatActivity {

    Button registeredButtonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);

        registeredButtonLogin = (Button) findViewById(R.id.registered_button_login);
        registeredButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent welcomeIntent = new Intent(RegisteredActivity.this, LoginActivity.class);
                startActivity(welcomeIntent);
                finish();
            }
        });
    }
}
