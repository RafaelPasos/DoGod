package com.prodevsmx.dogod;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class NewAccountActivity extends Activity {

    Typeface aliens;
    TextView JoinUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_new_account);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //id fonts declarations
        JoinUs = (TextView) findViewById(R.id.tvJoinUs);

        //fonts
        aliens = Typeface.createFromAsset(getAssets(), "fonts/aliens.ttf");
        JoinUs.setTypeface(aliens);


    }


}
