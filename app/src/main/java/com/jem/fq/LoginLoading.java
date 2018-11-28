package com.jem.fq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginLoading extends AppCompatActivity {
    private Map<String, String> user_map;
    private static final String TAG = "database...";
    private static final String TAG2 = "myInput..";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_loading);



        // read a file, and put its contents into a HashMap
        Scanner dataBaseUsers = new Scanner(
                getResources().openRawResource(R.raw.sql)
        );
        user_map = new HashMap<>();
        // split the text by "\t" and even number indexes into Keys and odd number indexes into Values
        Log.e(TAG, "test");
        while (dataBaseUsers.hasNextLine()){
            String line = dataBaseUsers.nextLine();
            String[] parts = line.split("\t");
            user_map.put(parts[0],parts[1]);
        }
        dataBaseUsers.close();

        Intent user = getIntent();
        String userID = user.getStringExtra("id");

        Intent returnPage = new Intent();
//        extract "Extra" data from the intent that loaded this class
        for (String i: user_map.keySet()){
            if (i.equals(userID)) {
                Log.i(TAG, "you made it!");
                returnPage.putExtra("name", user_map.get(i));
                returnPage.putExtra("result","pass");
                setResult(RESULT_OK, returnPage);
                finish();
            }
        }
        returnPage.putExtra("result", "fail");
        setResult(RESULT_OK, returnPage);
        finish();
    }
}
