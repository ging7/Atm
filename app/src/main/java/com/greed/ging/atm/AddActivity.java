package com.greed.ging.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    private EditText edDate, edInfo, edAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        findView();
    }

    public void add(View view){

    }

    private void findView(){
        edDate = findViewById(R.id.ed_date);
        edInfo = findViewById(R.id.ed_info);
        edAmount = findViewById(R.id.ed_amount);
    }


}
