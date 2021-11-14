package com.example.chapter6_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edNum1, edNum2;

    Button[] numButtons = new Button[10];
    // Button btnNum0, btnNum1, btnNum2, btnNum3, btnNum4, btnNum5, btnNum6, btnNum7, btnNum8, btnNum9;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView tvResult;

    String strNum1, strNum2;
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setTitle("간단한 계산기");

        edNum1 = (EditText) findViewById(R.id.edNum1);
        edNum2 = (EditText) findViewById(R.id.edNum2);

        Integer[] btnIDs = {R.id.btnNum0, R.id.btnNum1, R.id.btnNum2, R.id.btnNum3, R.id.btnNum4,
                R.id.btnNum5, R.id.btnNum6, R.id.btnNum7, R.id.btnNum8, R.id.btnNum9};
        
        // 10개의 버튼을 쉽게 위젯변수와 id를 연결하기 위해 반복문 활요
        for (int i = 0; i < numButtons.length; i++) {
            numButtons[i] = (Button) findViewById(btnIDs[i]);
        }

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnDiv = (Button) findViewById(R.id.btnDiv);

        tvResult = (TextView) findViewById(R.id.tvResult);
        
        // 숫자 버튼 10개의 이벤트 리스너를 반복문으로 수행
        for (int i = 0; i < numButtons.length; i++) {
            final int index;
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (edNum1.isFocused() == true) { // 커서가 첫번째 입력란에 있는 경우
                        strNum1 = edNum1.getText().toString() + numButtons[index].getText();
                        edNum1.setText(strNum1);
                    } else if (edNum2.isFocused() == true) { // 커서가 두번째 입력란에 있는 경우
                        strNum2 = edNum2.getText().toString() + numButtons[index].getText();
                        edNum2.setText(strNum2);
                    } else { // 커서가 첫번째와 두번째 입력란 둘 다 없는 경우 경고메시지 출력
                        Toast.makeText(getApplicationContext(), "먼저 입력란을 선택하세요!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        // 덧셈 기능
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNum1 = edNum1.getText().toString();
                strNum2 = edNum2.getText().toString();

                // 입력창이 비어있으면 경고문구 발생
                if ((strNum1.isEmpty() == true) || (strNum2.isEmpty() == true) ){
                    Toast.makeText(getApplicationContext(), "숫자를 입력하세요!", Toast.LENGTH_SHORT).show();
                } else {
                    result = Integer.parseInt(strNum1) + Integer.parseInt(strNum2);

                    tvResult.setText("계산결과 : " + result);
                }
            }
        });

        // 뺄셈 기능
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNum1 = edNum1.getText().toString();
                strNum2 = edNum2.getText().toString();

                // 입력창이 비어있으면 경고문구 발생
                if ((strNum1.isEmpty() == true) || (strNum2.isEmpty() == true)) {
                    Toast.makeText(getApplicationContext(), "숫자를 입력하세요!", Toast.LENGTH_SHORT).show();
                } else {
                    result = Integer.parseInt(strNum1) - Integer.parseInt(strNum2);

                    tvResult.setText("계산결과 : " + result);
                }


            }
        });

        // 곱셈 기능
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNum1 = edNum1.getText().toString();
                strNum2 = edNum2.getText().toString();

                // 입력창이 비어있으면 경고문구 발생
                if ((strNum1.isEmpty() == true) || (strNum2.isEmpty() == true)) {
                    Toast.makeText(getApplicationContext(), "숫자를 입력하세요!", Toast.LENGTH_SHORT).show();
                } else {
                    result = Integer.parseInt(strNum1) * Integer.parseInt(strNum2);

                    tvResult.setText("계산결과 : " + result);
                }
            }
        });

        // 나눗셈 기능
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNum1 = edNum1.getText().toString();
                strNum2 = edNum2.getText().toString();

                // 입력창이 비어있으면 경고문구 발생
                if ((strNum1.isEmpty() == true) || (strNum2.isEmpty() == true)) {
                    Toast.makeText(getApplicationContext(), "숫자를 입력하세요!", Toast.LENGTH_SHORT).show();
                } else {
                    result = Integer.parseInt(strNum1) / Integer.parseInt(strNum2);

                    tvResult.setText("계산결과 : " + result);
                }
            }
        });
    }
}