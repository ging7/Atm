package com.greed.ging.atm;

import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText edUserid, edPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUserid = this.findViewById(R.id.ed_userid);
        edPassword = this.findViewById(R.id.ed_passwd);
        SharedPreferences setting =
                getSharedPreferences("atm", MODE_PRIVATE);
        edUserid.setText(setting.getString("PREF_USERID", ""));
    }
    public void login(View v){
        String uid = edUserid.getText().toString();
        String pw = edPassword.getText().toString();
        if (uid.equals("luffy") && pw.equals("1234")){
            //登入成功
            SharedPreferences setting =
                    getSharedPreferences("atm", MODE_PRIVATE);
            setting.edit()
                    .putString("PREF_USERID", uid)
                    .apply();
            Toast.makeText(this, "登入成功", Toast.LENGTH_LONG).show();
            getIntent().putExtra("LOGIN_USERID", uid);
            getIntent().putExtra("LOGIN_PASSWD", pw);
            setResult(RESULT_OK, getIntent());
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
