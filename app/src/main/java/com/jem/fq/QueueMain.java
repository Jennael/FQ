package com.jem.fq;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class QueueMain extends AppCompatActivity {
    private String user_name;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue_main);

        Intent queueMain = getIntent();

        user_name = queueMain.getStringExtra("name");
        Utils.showToast("Welcome, "+user_name,this);


        // plays music when enter Queue Main. Primarily used just for debugging right now!
        mp = MediaPlayer.create(this,R.raw.jeopardy);
        mp.start();
    }

}
