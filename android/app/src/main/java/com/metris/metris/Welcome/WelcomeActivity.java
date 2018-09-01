package com.metris.metris.Welcome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.metris.metris.Authorization.LoginActivity;
import com.metris.metris.Authorization.RegisteredActivity;
import com.metris.metris.R;
import com.metris.metris.Splash.SplashActivity;

import org.w3c.dom.Text;

public class WelcomeActivity extends AppCompatActivity {

    private Button welcomeButtonStart;
    private TextView welcomeTextViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcomeButtonStart = (Button) findViewById(R.id.welcome_button_start);
        welcomeButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent welcomeIntent = new Intent(WelcomeActivity.this, IntroductionActivity.class);
                startActivity(welcomeIntent);
            }
        });

        welcomeTextViewLogin = (TextView) findViewById(R.id.welcome_textview_login);
        welcomeTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent welcomeIntent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(welcomeIntent);
            }
        });
    }
}
