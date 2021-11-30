package com.moringaschool.yummlyapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.getstartedButton) Button mGetstartedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mGetstartedButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, SignupActivity.class);
        startActivity(intent);
    }
}