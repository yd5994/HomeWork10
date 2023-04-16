 package com.example.homework10;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {
     int a,b,c;
     Random rn=new Random();
     TextView tx1,tx2,tx3,tx4;
     EditText ET1,ET2,ET3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tx1=findViewById(R.id.textView1);
        tx2=findViewById(R.id.textView2);
        tx3=findViewById(R.id.textView3);
        ET1=findViewById(R.id.editTextNumber);
        ET2=findViewById(R.id.editTextNumber2);
        ET3=findViewById(R.id.editTextNumber3);
    }

     public void btn1(View view)  {//save;
        //a=Double.parseDouble(ET1.getText().toString());
         a=Integer.parseInt(ET1.getText().toString());
    }

     public void btn2(View view) {//save
         b=Integer.parseInt(ET2.getText().toString());
     }

     public void btn3(View view) {//save
         c=Integer.parseInt(ET3.getText().toString());
     }

     public void btn4(View view) {//random
         a=rn.nextInt(99)+1;
         tx1.setText(Integer.toString(a));
     }

     public void btn5(View view) {//random
         b=rn.nextInt(99)+1;
         tx2.setText(Integer.toString(b));
     }

     public void btn6(View view) {//random
         c=rn.nextInt(99)+1;
         tx3.setText(Integer.toString(c));
     }


     public void btn7(View view) {
//         String name = Integer.toString(c);
//         Toast.makeText(MainActivity.this,name,Toast.LENGTH_SHORT).show();
         Intent si = new Intent(getApplicationContext(),MainActivity2.class);
         si.putExtra("first",a);
         si.putExtra("second",b);
         si.putExtra("third",c);
         startActivity(si);
     }
 }