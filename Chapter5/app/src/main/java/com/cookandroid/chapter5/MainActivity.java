package com.cookandroid.chapter5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    //전역 변수를 선언 해주는 작업
    EditText edit1, edit2;
    Button buttonAdd, buttonSub, buttonMul, buttonDiv, buttonDivA;
    TextView textResult;

    String num1, num2;
    Integer result;
    
   //Button타입의 10칸짜리 배열을 만들어 준다 
   Button[] numbers = new Button[10];
   //추후에 findByViewid로 mebersid를 반복문을 돌리면서 mebers에 넣어줄 것이기 때문에 Integer 타입으로 만들어 준다
   Integer[] numberId = { R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6
                            ,R.id.button7, R.id.button8, R.id.button9};
    //추후에 for문에서 반복문을 사용을 위해 변수 지정
    int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //상위 배젤에 표시해주는 작업
        setTitle("GridLayout을 이용한 계산기 입니다.");

        //선언한 전역변수들에 값을 대입해주는 작업
        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        
        buttonAdd = (Button) findViewById(R.id.add);
        buttonSub = (Button) findViewById(R.id.sub);
        buttonMul = (Button) findViewById(R.id.mul);
        buttonDiv = (Button) findViewById(R.id.div);
        buttonDivA = (Button) findViewById(R.id.divA);
        
        textResult = (TextView) findViewById(R.id.result);

        //더학기 기능을 터치 했을때 동작하는 기능
        buttonAdd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());

                return false;
            }
        });

        //빼기를 했을때 실행 되는 코드 작성
        buttonSub.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                textResult.setText("계산 결과 :" + result.toString());
                return false;
            }
        });

        //나누기 버튼을 터치 했을때 이루어지는 기능 구현
        buttonDiv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if(num2.equals("0")){
                    Toast.makeText(getApplicationContext(), "o으로 나눌 수 없습니다!!", Toast.LENGTH_SHORT).show();
                }else {

                    result = Integer.parseInt(num1) / Integer.parseInt(num2);
                    textResult.setText("계산 결과 : " + result.toString());
                }
                return false;
            }
        });


        //곱하기 버튼을 터치 했을때 이루어지는 기능 구현
        buttonMul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());

                return false;
            }
        });

        //나머지 값을 구하는 기능 구현
        buttonDivA.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                result = Integer.parseInt(num1) % Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());

                return false;
            }
        });

        //numbers에 numberId들을 넣어 저장해 준다
        for(i = 0; i < numberId.length; i++){
            numbers[i] = (Button) findViewById(numberId[i]);
        }
        
        
        //i에 0부터 10까지(numbers안에 있는 배열이 한번씩 돌수 있도록)까지를 반복하게 해준다
        for(i = 0; i < numberId.length; i++){
//            final을 쓰게 되면 지역 변수는 상수화 되어서 계속 해서 지속되게 된다
//            Listener로 전달하고 싶은 지역변수는 final 로 처리해야 한다
//            조금 더 자세히 이야기 하자면, Oncreate에 선언한 변수들은 지역변수로서 Oncreate function이 종료하면 사라지게 된다.
            final int index;
            index = i;


            //현재 numbers배열에 각각 버튼 id값이 들어 있는데 배열 전체를 한바퀴 덜면서 클릭이 일어나면 아래의 기능을 실현 시켜라
            numbers[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //edit1이 선택이 되었으면 기존의 edit1에 있는 숫자 + 선택된 숫자를 edit1에 넣어 출력해라
                    if(edit1.isFocused() == true){
                        num1 = edit1.getText().toString() + numbers[index].getText().toString();
                        edit1.setText(num1);
                    }
                    //edit2가 선택이 되었을때 아래의 기능을 edit2화면에 출력해 줘라
                    else if(edit2.isFocused() == true){
                        num2 = edit2.getText().toString() + numbers[index].getText().toString();
                        edit2.setText(num2);
                    }
                    //edit가 선택이 되지 않았다면 토스트 메세지로 선택하라고 메세지를 보여줘라
                    else{
                        Toast.makeText(getApplicationContext(), "먼저 숫자를 입력할 edit를 선택해 주세요", Toast.LENGTH_SHORT).show();
                    }

                }
            });
            
            
        }
        
  









    }
}