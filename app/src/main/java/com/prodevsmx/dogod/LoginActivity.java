package com.prodevsmx.dogod;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class LoginActivity extends Activity {

    Typeface aliens;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        title = (TextView) findViewById(R.id.tvTitle);

        //fonts
        aliens = Typeface.createFromAsset(getAssets(), "fonts/aliens.ttf");

        title.setTypeface(aliens);

    }
}

