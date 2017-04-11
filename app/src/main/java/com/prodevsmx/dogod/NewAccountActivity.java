package com.prodevsmx.dogod;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class NewAccountActivity extends Activity {

    Typeface aliens;
    TextView JoinUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        aliens = Typeface.createFromAsset(getAssets(), "fonts/aliens.ttf");
        JoinUs.setTypeface(aliens);
        JoinUs =  (TextView) findViewById(R.id.tvJoinUs);

    }


}
