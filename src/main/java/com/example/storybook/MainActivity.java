package com.example.storybook;

import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize MediaPlayer
        mediaPlayer = MediaPlayer.create(this, R.raw.driftveil);

        // Start playing the background music
        mediaPlayer.start();

    }

    @Override
    protected void onDestroy() {
        // Release the MediaPlayer when the activity is destroyed
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }

        super.onDestroy();

    }
    public void goToPage2(View v){
        Intent i = new Intent(this, Page2.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        finish();
    }

    int j = 1;
    public void onBackPressed(){
        if (j == 1){
            j++;
            Toast.makeText(this, "Press the back button again to exit.",
                    Toast.LENGTH_SHORT).show();
        }
        else {
            finish();
        }
    }
}