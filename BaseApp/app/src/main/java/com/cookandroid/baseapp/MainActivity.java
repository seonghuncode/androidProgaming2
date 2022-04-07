package com.cookandroid.baseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    
    Button button1;  //Button변수 추가작업(alt + enter -> import해주기)

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //레이아웃 화면을 표시 해준다

        button1 = (Button)findViewById(R.id.button1);
        //activity_main.xml에서 만든 버튼 객체에 접속하기 위한 메서드 사용

        //세팅틀?? 이벤트가 발생하는 곳??
        button1.setOnClickListener(new View.OnClickListener() {

            //버튼을 클릭했을때 작동하기를 원하는 모든 코드를 onClick메서드안에 입력
            @Override
            public void onClick(View view) {
                //현재 에플리케이션의 컨텍스트를 구해준다.
                Toast.makeText(getApplicationContext(), "버튼을 눌렀어요",
                        Toast.LENGTH_SHORT).show(); //length_short == 잠깐만 보여줘라

            }
        });
    }
}