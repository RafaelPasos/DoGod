package com.prodevsmx.dogod;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class LoginActivity extends Activity {

    Typeface aliens;
    TextView title;

    Typeface aliens;
    TextView JoinUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        title = (TextView) findViewById(R.id.tvTitle);

        //fonts
        aliens = Typeface.createFromAsset(getAssets(), "fonts/aliens.ttf");

        title.setTypeface(aliens);

    }


}

