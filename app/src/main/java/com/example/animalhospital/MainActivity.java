package com.example.animalhospital;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edt_userid,edt_password;
    private android.content.Intent Intent;//아래애서 정의 시 안 보내도 됨.

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_login=findViewById(R.id.btn_login);
        edt_userid=findViewById(R.id.edt_userid);
        edt_password=findViewById(R.id.edt_password);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this,"로그인 버튼 클릭",Toast.LENGTH_SHORT).show();
                //아이디 6자리 : system
                //비밀번호 6-12자리 : 123456
                String str_userid=edt_userid.getText().toString();
                String str_password=edt_password.getText().toString();
                Log.d("IRO","str_userid:"+str_userid);
                Log.d("IRO","str_password:"+str_password);

                if(str_userid.length()!=6){
                    Toast.makeText(MainActivity.this, "아이디는 6자입니다.", Toast.LENGTH_SHORT).show();
                }
                else if(str_password.length()<6 || str_password.length()>8){
                    Toast.makeText(MainActivity.this, "비밀번호는 6-8자입니다.", Toast.LENGTH_SHORT).show();
                }
                else if(str_userid.equals("system")&&str_password.equals("123456")){
                    Toast.makeText(MainActivity.this, str_userid+"님 환영합니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "입력한 로그인 정보를 확인하세요.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //창 넘김.
        findViewById(R.id.btn_info).setOnClickListener(this);
        findViewById(R.id.btn_guide).setOnClickListener(this);
        findViewById(R.id.btn_call).setOnClickListener(this);
        findViewById(R.id.btn_shop).setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        //Intent intent=null;//intent미리 정의.
        switch (view.getId()){
            case R.id.btn_info:
                Intent = new Intent(MainActivity.this, InfoActivity.class);
                Intent.putExtra("MSG","안녕하세요");
                break;
            case R.id.btn_guide:
                Intent = new Intent(MainActivity.this, GuideActivity.class);
                break;
            case R.id.btn_call:
                Intent = new Intent(MainActivity.this, CallActivity.class);
                break;
            case R.id.btn_shop:
                Intent = new Intent(MainActivity.this, ShopActivity.class);
                break;
        }
        startActivity(Intent);
    }

}