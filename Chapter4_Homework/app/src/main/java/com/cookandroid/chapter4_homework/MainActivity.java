package com.cookandroid.chapter4_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1;
    ImageView image;
    int degree = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("연습문제9번");

        button1 = (Button) findViewById(R.id.button1);
        image = (ImageView) findViewById(R.id.image);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.setRotation(degree);
                degree+=10;
            }
        });









    }
}