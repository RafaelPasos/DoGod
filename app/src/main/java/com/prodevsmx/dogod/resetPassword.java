package com.prodevsmx.dogod;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import org.w3c.dom.Text;

public class resetPassword extends Activity {

    Typeface alien;

    TextView resetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_reset_password);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        resetPassword = (TextView) findViewById(R.id.tvResetPassword);
        alien = Typeface.createFromAsset(getAssets(), "fonts/aliens.ttf");
        resetPassword.setTypeface(alien);

    }
}
