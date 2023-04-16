package com.example.homework10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView text,text2,text3,answer1,answer2;
    double root,line1p,line1m,sofp,sofm;
    boolean ans1=false,ans2=false,ans3=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent gi=getIntent();
        int a=gi.getIntExtra("first",1);
        int b=gi.getIntExtra("second",1);
        int c=gi.getIntExtra("third",1);
        int pb=Math.abs(b);
        String sa=String.valueOf(a);
        String sb=String.valueOf(b);
        String sc=String.valueOf(c);
        if(a<0){
            ans1=true;
        }
        if(b<0){
            ans2=true;
        }
        if(c<0){
            ans3=true;
        }
        text=findViewById(R.id.textView4);
        answer1=findViewById(R.id.textView2);
        text2=findViewById(R.id.textView5);
        answer2=findViewById(R.id.textView3);
        text3=findViewById(R.id.textView6);
        root=Math.sqrt(b*b-4*a*c);
        line1p=(b*-1)+root;
        line1m=(b*-1)-root;
        sofp=line1p/(2*a);
        sofm=line1m/(2*a);
        if(sofm==sofp){
            text.setText(Double.toString(sofp));
            if(!ans2) {
                answer1.setText("(-"+sb+"+Math.sqrt("+sb+"^2-4*"+sa+"*"+sc+"))/(2*"+sa+")=");
            }
            else{
                answer1.setText("("+pb+"+Math.sqrt("+sb+"^2-4*"+sa+"*"+sc+"))/(2*"+sa+")=");
            }
            text2.setText("NaN");
            answer2.setText("NaN");
        }
        else{
            text.setText(Double.toString(sofp));
            if(!ans2) {
                answer1.setText("(-"+sb+"+Math.sqrt("+sb+"^2-4*"+sa+"*"+sc+"))/(2*"+sa+")=");
            }
            else{
                answer1.setText("("+pb+"+Math.sqrt("+sb+"^2-4*"+sa+"*"+sc+"))/(2*"+sa+")=");
            }
            text2.setText(Double.toString(sofm));
            if(!ans2) {
                answer2.setText("(-"+sb+"-Math.sqrt("+sb+"^2-4*"+sa+"*"+sc+"))/(2*"+sa+")=");
            }
            else{
                answer2.setText("("+pb+"-Math.sqrt("+sb+"^2-4*"+sa+"*"+sc+"))/(2*"+sa+")=");
            }
        }
        if(!ans2&&!ans3){
            text3.setText(sa+"x^2 + "+sb+"x + "+sc+" = 0");
        }
        else if(ans2&&ans3){
            text3.setText(sa+"x^2 "+sb+"x "+sc+" = 0");
        }
        else if(ans2){
            text3.setText(sa+"x^2 "+sb+"x + "+sc+" = 0");
        }
        else if(ans3){
            text3.setText(sa+"x^2 "+sb+"x "+sc+" = 0");
        }
    }

    public void btn7(View view) {
        Intent si=new Intent(this,MainActivity.class);
        si.putExtra("sofp",sofp);
        si.putExtra("sofm",sofm);
        startActivityForResult(si,1);
        setResult(RESULT_OK,si);
        finish();
    }
}