package com.example.storybook;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class Page8 extends AppCompatActivity {

    float x1, x2, y1, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page8);
    }

    public void goToPage7(View v) {
        Intent i = new Intent(this, Page7.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();
    }

    public void goToPage9(View v) {
        Intent i = new Intent(this, Page9.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent touchEvent) {
        switch (touchEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if (x1 < x2) {
                    Intent i = new Intent(Page8.this, Page7.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                    finish();
                } else if (x1 > x2) {
                    Intent i = new Intent(Page8.this, Page9.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                }
                break;
        }
        return false;
    }

    int j = 1;

    @Override
    public void onBackPressed() {
        if (j == 1) {
            j++;
            Intent i = new Intent(this, Page7.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            finish();
        } else {
            super.onBackPressed();
        }
    }
}
