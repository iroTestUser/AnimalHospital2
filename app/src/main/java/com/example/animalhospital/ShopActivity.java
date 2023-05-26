package com.example.animalhospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class ShopActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView img_product_main;
    RadioButton radio1,radio2,radio3;
    Button btn_minus,btn_plus,btn_pay;
    EditText edit_count;
    TextView txt_price,txt_delivery,txt_pay;
    CheckBox chk_agree;

    String selectedCnt;
    int selectedPrice=1500;
    int delivery;
    String totalPrice;
    String selectedName="소고기와 치즈맛";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);


        img_product_main=findViewById(R.id.img_product_main);
        findViewById(R.id.radio1).setOnClickListener(this);
        findViewById(R.id.radio2).setOnClickListener(this);
        findViewById(R.id.radio3).setOnClickListener(this);
        findViewById(R.id.btn_minus).setOnClickListener(this);
        findViewById(R.id.btn_plus).setOnClickListener(this);
        findViewById(R.id.btn_pay).setOnClickListener(this);
        edit_count=findViewById(R.id.edit_count);
        txt_price=findViewById(R.id.txt_price);
        txt_delivery=findViewById(R.id.txt_delivery);
        txt_pay=findViewById(R.id.txt_pay);
        chk_agree=findViewById(R.id.chk_agree);
//        radio1.setOnClickListener(this);
//        radio2.setOnClickListener(this);
//        radio3.setOnClickListener(this);
//        btn_pay.setOnClickListener(this);
//        btn_minus.setOnClickListener(this);
//        btn_plus.setOnClickListener(this);

    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.radio1:
                img_product_main.setImageResource((R.drawable.product1));
                selectedPrice=1500;
                sumTotal();
                break;
            case R.id.radio2:
                img_product_main.setImageResource((R.drawable.product2));
                selectedPrice=2000;
                sumTotal();
                break;
            case R.id.radio3:
                img_product_main.setImageResource((R.drawable.product3));
                selectedPrice=3000;
                sumTotal();
                break;
            case R.id.btn_minus:
                int count = Integer.parseInt(edit_count.getText().toString());
                if(count==1){
                    Toast.makeText( this,"최소 수량:1",Toast.LENGTH_SHORT).show();
                }
                else{
                    count-=1;
                }
                edit_count.setText(String.valueOf(count));
                sumTotal();
                break;
            case R.id.btn_pay:

                if(chk_agree.isChecked()){
                    sumTotal();
                    Intent intent = new Intent(ShopActivity.this,PayActivity.class);
                    intent.putExtra("itemName",selectedName);
                    intent.putExtra("itemCount",selectedCnt);
                    intent.putExtra("itemPrice",totalPrice);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(this,"결제에 동의해주세요.",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_plus:
                int count1 = Integer.parseInt(edit_count.getText().toString());
                if(count1==5){
                    Toast.makeText(this,"최대 수량:5",Toast.LENGTH_SHORT).show();
                }
                else{
                    count1+=1;
                }
                edit_count.setText(String.valueOf(count1));
                sumTotal();
                break;
        }
    }

    private void sumTotal() {
        int selectedCount=Integer.parseInt(edit_count.getText().toString());
        selectedName=findViewById(R.id.radio1).getTag().toString();


        if((selectedCount*selectedPrice)>=10000){
            txt_delivery.setText("0원");
            delivery=0;
        }
        else{
            txt_delivery.setText("2500원");
            delivery=2500;
        }
        txt_price.setText(selectedCount*selectedPrice+"원");
        txt_pay.setText(selectedCount*selectedPrice+delivery+"원");

        totalPrice=selectedCount*selectedPrice+delivery+"원";
        selectedCnt=selectedCount+"원";
    }
}