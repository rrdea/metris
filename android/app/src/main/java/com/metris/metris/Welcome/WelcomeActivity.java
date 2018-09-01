package com.metris.metris.Welcome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.metris.metris.R;
import com.metris.metris.Splash.SplashActivity;

public class WelcomeActivity extends AppCompatActivity {

    private Button welcome_button_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcome_button_start = (Button) findViewById(R.id.welcome_button_start);
        welcome_button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent welcomeIntent = new Intent(WelcomeActivity.this, IntroductionActivity.class);
                startActivity(welcomeIntent);
            }
        });
    }
}
