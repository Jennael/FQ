package com.jem.fq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {
    private String[] sql = {
            "9028267311", "1234567890", "0987654321"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // check if there is an intent
        Intent anyIntent = getIntent();
        if (anyIntent != null && anyIntent.getStringExtra("name") != null){
            TextView loginError = findViewById(R.id.loginError);
            loginError.setText(R.string.login_error_prompt);
        }

        final Intent startLogin = new Intent(this, LoginLoading.class);

        final EditText storeID = findViewById(R.id.storeID);
        storeID.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String id = storeID.getEditableText().toString();
                if (actionId == EditorInfo.IME_ACTION_DONE){
                    startLogin.putExtra("id",id);
                    startActivity(startLogin);

                    return true;
                }
                return false;
            }
        });
    }
}
