package com.prodevsmx.dogod;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoginActivity extends Activity {

    TextView title;
    Typeface aliens;

    TextView createNewAccount;
    TextView resetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //id declarations
        title = (TextView) findViewById(R.id.tvTitle);
        createNewAccount = (TextView) findViewById(R.id.tvCreateAccount);
        resetPassword = (TextView) findViewById(R.id.tvForgotPassword);

        //fonts
        aliens = Typeface.createFromAsset(getAssets(), "fonts/aliens.ttf");
        title.setTypeface(aliens);

        //Go to create new account
        createNewAccount.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent createAccount = new Intent(LoginActivity.this, NewAccountActivity.class);
                startActivity(createAccount);
            }
        });

        //Go to reset password
        resetPassword.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent restartPassword = new Intent(LoginActivity.this, resetPassword.class);
                startActivity(restartPassword);
            }
        });

    }


}

