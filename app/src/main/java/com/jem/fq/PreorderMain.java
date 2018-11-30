package com.jem.fq;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Queue;

public class PreorderMain extends AppCompatActivity {
    private String user_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preorder);

        Log.i("Current Activity", "PreorderMain"); /* For Debugging purpose! */

        user_name = getIntent().getStringExtra("name");
        Toast.makeText(this, "Welcome " + user_name, Toast.LENGTH_SHORT).show();

        // create toolbar!
        Toolbar myToolbar = findViewById(R.id.fqToolbar);
        setSupportActionBar(myToolbar);
    }

    public void gotoQueue(View view) {
        Intent queue = new Intent(this, QueueMain.class);
        queue.putExtra("name", user_name);
        startActivity(queue);
        finish();
    }

    public void gotoPreorder(View view) {
//        do nothing
    }

    public void gotoSettings(View view) {
        Intent settings = new Intent(this,SettingsMain.class);
        settings.putExtra("name", user_name);
        startActivity(settings);
        finish();
    }
}
