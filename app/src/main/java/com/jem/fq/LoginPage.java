package com.jem.fq;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class LoginPage extends AppCompatActivity {
    private final int REQ_CODE_LOGIN = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Log.i("Current Activity", "LoginPage"); /* For Debugging purpose! */

        Toast.makeText(this, ".", Toast.LENGTH_SHORT).show();
        Button loginButton = findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText userID = findViewById(R.id.storeID);
                Intent loginLoad = new Intent(getApplicationContext(), LoginLoading.class);
                String user_id = userID.getText().toString();
                loginLoad.putExtra("id", user_id);
                startActivityForResult(loginLoad,REQ_CODE_LOGIN);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Intent successfulLogin = new Intent(this, QueueMain.class);
        TextView loginError = findViewById(R.id.loginError);
        if (requestCode == REQ_CODE_LOGIN && resultCode == RESULT_OK){
            String result = data.getStringExtra("result");
            if (result.equals("pass")) {
                String name = data.getStringExtra("name");
                successfulLogin.putExtra("name", name);
                startActivity(successfulLogin);
                finish();
            }
            else{
                loginError.setText(R.string.login_error_prompt);
            }
        }
    }
}
