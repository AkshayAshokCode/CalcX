package com.example.calcx;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    Button plusSign;
    Button minusSign;
    Button divideSign;
    Button multiplySign;
    Button equalSign;
    Button deleteSign;
    Button clearSign;
    Button dotSign;
    Button perSign;
    Button num0;
    Button num1;
    Button num2;
    Button num3;
    Button num4;
    Button num5;
    Button num6;
    Button num7;
    Button num8;
    Button num9;
    String process="";
    String str=null , i;     //for deletion
    double a,b,c=0, part1;
    int count;
    int dot=0;      //for dot errors
    int equal=0;    //for equal sign errors
    int opr=0;      //for operator errors
    int t;




    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        plusSign=findViewById(R.id.plusSign);
        minusSign=findViewById(R.id.minusSign);
        divideSign=findViewById(R.id.divideSign);
        multiplySign=findViewById(R.id.multiplySign);
        equalSign=findViewById(R.id.equalSign);
        deleteSign=findViewById(R.id.deleteSign);
        clearSign=findViewById(R.id.clearSign);
        dotSign=findViewById(R.id.dotSign);
        perSign=findViewById(R.id.perSign);
        num0=findViewById(R.id.num0);
        num1=findViewById(R.id.num1);
        num2=findViewById(R.id.num2);
        num3=findViewById(R.id.num3);
        num4=findViewById(R.id.num4);
        num5=findViewById(R.id.num5);
        num6=findViewById(R.id.num6);
        num7=findViewById(R.id.num7);
        num8=findViewById(R.id.num8);
        num9=findViewById(R.id.num9);
        num0.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);
        equalSign.setOnClickListener(this);
        plusSign.setOnClickListener(this);
        minusSign.setOnClickListener(this);
        multiplySign.setOnClickListener(this);
        divideSign.setOnClickListener(this);
        perSign.setOnClickListener(this);
        clearSign.setOnClickListener(this);
        deleteSign.setOnClickListener(this);
        dotSign.setOnClickListener(this);
        }
        public void insert(String i)
        {
            if(equal==1)
            {
                textView.setText("");
                part1=0;
                b=0;
                c=0;
                a=0;
            }
            textView.setText((textView.getText().toString() +i));
           str=textView.getText().toString();
            process=process + i;
            equal=0;
            dot=0;
        }
        public void operation(int p,String i)
        {
            if(t==0&&equal==0&&opr==0) {
            if(textView.getText().length()!=0) {

                    count = p;
                    if(process!="") {
                        part1 = Double.parseDouble(process);
                    }
                        dot = 1;
                    process = "";
                    textView.setText(textView.getText().toString() + i);
                    str=textView.getText().toString();
                 t = 1;
                 opr=1;
                }
            }
        }
        public void calculate()
        {
            dot=0;
            if(count==1)
            {
                a=part1;
                b=Double.parseDouble(process);
                c =a+b;
            }
            else if(count==2)
            {
                a=part1;
                b=Double.parseDouble(process);
                c =a-b;
            }
            else if(count==3)
            {
                a=part1;
                b=Double.parseDouble(process);
                c=a/b;
            }
            else if(count==4)
            {
                a=part1;
                b=Double.parseDouble(process);
                c=a*b;
            }
            else if(count==5)
            {
                a=part1;
                b=Double.parseDouble(process);
                c=a*b/100;
            }
        }
    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.plusSign:
                operation(1,"+");
                    break;
            case R.id.minusSign:
               operation(2,"-");
                break;
            case R.id.divideSign:
               operation(3,"÷");
                break;
            case R.id.multiplySign:
               operation(4,"×");
                break;
            case R.id.perSign:
                operation(5,"%");
                break;
            case R.id.equalSign:

                if (textView.getText().length()!=0&&textView.getText().toString()!=""&& equal==0&&t==1) {
                    calculate();
                    DecimalFormat dec = new DecimalFormat("#.00");
                    textView.setText(String.valueOf(dec.format(c)));
                    process = "";
                    equal = 1;
                    c = 0;
                    part1 = 0;
                    b = 0;
                    t=0;
                    opr=0;
                }
                break;
            case R.id.dotSign:
                if(textView.getText().length()!=0) {
                    if(dot==0) {
                        textView.setText((textView.getText().toString() + "."));
                        process = process + ".";
                        dot = 1;
                    }
                }
                break;
            case R.id.clearSign:
                textView.setText("");
                process="";
                break;
            case R.id.deleteSign:
                if(textView.getText().length()!=0) {

                    if (str.length() >= 1) {
                        str = str.substring(0, str.length() - 1);
                        textView.setText(str + "");
                        if(process!="") {
                            process = process.substring(0, process.length() - 1);
                        }
                        if(equal==1) {
                            textView.setText("");
                        }
                        opr=0;

                    }
                }
                break;
            case R.id.num0:
                if(textView.getText().length()!=0) {
                    insert("0");
                }
                break;
            case R.id.num1:
                insert("1");
                break;
            case R.id.num2:
                insert("2");
                break;
            case R.id.num3:
                insert("3");
                break;
            case R.id.num4:
                insert("4");
                break;
            case R.id.num5:
                insert("5");
                break;
            case R.id.num6:
                insert("6");
                break;
            case R.id.num7:
                insert("7");
                break;
            case R.id.num8:
                insert("8");
                break;
            case R.id.num9:
                insert("9");
                break;
        }
    }
}

