package com.example.ehco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class Loading_screenn extends AppCompatActivity {

    Handler handler;
    private long backPressedTime;
    private Toast backToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screenn);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent newIntent = new Intent(Loading_screenn.this, Translate_screen.class);
                Bundle bundle = getIntent().getExtras();
                if (bundle != null) {
                    newIntent.putExtras(bundle);
                }
                startActivity(newIntent);
                finish();

            }
        }, 3000);

    }
    @Override
    public void onBackPressed() {

        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            handler.removeCallbacksAndMessages(null);
            Intent intent = new Intent(this, LTS_screen.class);
            startActivity(intent);
            finish();

            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Press again to go back", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}