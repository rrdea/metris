package com.metris.metris.Authorization;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.metris.metris.R;

public class ForgetPasswordActivity extends AppCompatActivity {

    private Button forgetButtonForget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        forgetButtonForget = (Button) findViewById(R.id.forget_button_setup);
    }
}
