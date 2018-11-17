package com.jem.fq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginLoading extends AppCompatActivity {
    private Map<String, String> user_map;
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
        while (dataBaseUsers.hasNextLine()){
            String line = dataBaseUsers.nextLine();
            String[] parts = line.split("\t");
            user_map.put(parts[0],parts[1]);
        }
        // Login Failed ~~~~~~
        Intent failedLogin = new Intent(this, LoginPage.class);

        // Login Successful!
        Intent successfulLogin = new Intent(this, QueueMain.class);

//        extract "Extra" data from the intent that loaded this class
        Intent storeID = getIntent();
        String userID = storeID.getStringExtra("id");
        Toast.makeText(this, userID, Toast.LENGTH_LONG);
        for (String i: user_map.values()){
            if (userID == i) {
                successfulLogin.putExtra("name", i);
                startActivity(successfulLogin);
            }
            else{
                failedLogin.putExtra("name", userID);
                startActivity(failedLogin);
            }
        }
    }
}
