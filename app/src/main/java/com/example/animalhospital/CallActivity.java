package com.example.animalhospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class CallActivity extends AppCompatActivity {

    EditText edit_name,edit_phone,consulting;
    CheckBox check_agree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        edit_name=findViewById((R.id.edit_name));
        edit_phone=findViewById((R.id.edit_phone));
        consulting=findViewById((R.id.consulting));
        check_agree=findViewById((R.id.check));
    findViewById(R.id.btn_request).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + "01066669999"));
            startActivity(intent);
        }
    });
    findViewById(R.id.btn_message).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String str_name=edit_name.getText().toString();
            String str_phone=edit_phone.getText().toString();
            String str_consulting=consulting.getText().toString();
            String str_check=check_agree.getText().toString();
            String str_message="상담신청자:"+str_name+"\n"+"상담내용:"+str_consulting;

            if(str_consulting.trim().length()==0){
                Toast.makeText(CallActivity.this,"상담내용이 비어있습니다.",Toast.LENGTH_SHORT).show();
                consulting.requestFocus();
                return;
            }

            if(check_agree.isChecked()){
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:" + str_phone));
                intent.putExtra("sms_body",str_message);
                startActivity(intent);
            }else{
                Toast.makeText(CallActivity.this, "개인정보처리방침에 동의해주세요.",Toast.LENGTH_SHORT).show();
            }
        }
    });
    }

}