package com.greed.ging.atm;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
    public void login(View v){
        EditText edUserid = findViewById(R.id.ed_userid);
        EditText edPassword = findViewById(R.id.ed_passwd);
        String uid = edUserid.getText().toString();
        String pw = edPassword.getText().toString();
        if (uid.equals("luffy") && pw.equals("1234")){
            //登入成功
            Toast.makeText(this, "登入成功", Toast.LENGTH_LONG).show();
            finish();
        }else {
            //登入失敗
            new AlertDialog.Builder(this)
                    .setTitle("ATM")
                    .setMessage("登入失敗")
                    .setPositiveButton("OK", null)
                    .show();
        }
    }
    public void cancel(View v){

    }
}
