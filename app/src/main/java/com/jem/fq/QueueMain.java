package com.jem.fq;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class QueueMain extends AppCompatActivity {
    private String user_name;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue_main);

        Log.i("Current Activity", "QueueMain"); /* For Debugging purpose! */

        user_name = getIntent().getStringExtra("name");
        Toast.makeText(this, "Welcome " + user_name, Toast.LENGTH_SHORT).show();


        // plays music when enter Queue Main. Primarily used just for debugging right now!
        mp = MediaPlayer.create(this,R.raw.jeopardy);
        mp.start();
        mp.setLooping(true);

        Toolbar myToolbar = findViewById(R.id.fqToolbar);
        setSupportActionBar(myToolbar);

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
//        getMenuInflater().inflate(R.menu.menu,menu);
//    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mp.start();
    }

    public void gotoPreorder(View view) {
        Intent preorder = new Intent(this,PreorderMain.class);
        preorder.putExtra("name", user_name);
        startActivity(preorder);
    }

    public void gotoSettings(View view) {
        Intent settings = new Intent(this,SettingsMain.class);
        settings.putExtra("name", user_name);
        startActivity(settings);
    }

    public void gotoQueue(View view) {
//        do nothing
    }
}
