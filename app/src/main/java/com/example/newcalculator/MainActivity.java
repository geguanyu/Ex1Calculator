package com.example.newcalculator;

import android.content.res.Configuration;

import android.os.Bundle;
import android.text.Spannable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    //堆栈的设置
    private Stack<Double> numberStack = new Stack<Double>();//数栈
    private Stack<Character> symbolStack = new Stack<Character>();//符号栈
    private TextView show1, show2;
    private String strRecord = "";
    private String strCurrent = "";
    private Spannable spannable;
    String s = "";//总的计算表达式

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //横竖屏判断
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {//竖屏
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            //final TextView tv=(TextView) findViewById(R.id.t1);
            show1 = findViewById(R.id.text1);
            show2 = findViewById(R.id.text2);
            Button butEqual = findViewById(R.id.buttonEqual);//等于号
            butEqual.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s = show2.getText().toString();//获取总运算表达式
                    if ("".equals(s)) {//空则提示错误
                        Toast.makeText(MainActivity.this, "表达式为空！", Toast.LENGTH_SHORT).show();
                    } else {//否则开始运算，其实应该再检查运算表达式是否合法
                        //show1.setText(s);
                        s += "=";
                        show1.setText(s);
                        double r = 0;//开始计算
                        try {
                            r = calculate(s);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        String ru = "" + r;//将double转换为字符串
                        show2.setText(ru);//显示结果
                    }
                }
            });

            Button butClear = findViewById(R.id.buttonClear);//清空
            butClear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show1.setText("");
                    show2.setText("");
                }
            });

            Button butDelete = findViewById(R.id.buttonDelete);//删除
            butDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String s1 = show2.getText().toString();
                    s1 = s1.substring(0, s1.length() - 1);
                    show2.setText(s1);
                }
            });

            Button butMinus = findViewById(R.id.buttonMinus);//减法
            butMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("-");
                }
            });

            Button butPlus = findViewById(R.id.buttonPlus);//加法
            butPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("+");
                }
            });
            Button butMul = findViewById(R.id.buttonMul);//乘法
            butMul.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("*");
                }
            });

            Button butDiv = findViewById(R.id.buttonDiv);//除法
            butDiv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("/");
                }
            });
            Button butPow = findViewById(R.id.buttonPow);
            butPow.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    show2.append("^");
                }
            });
            Button butQiuyu = findViewById(R.id.buttonQiuyu);
            butQiuyu.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    show2.append("%");
                }
            });

            Button butPoint = findViewById(R.id.buttonPoint);//小数点
            butPoint.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append(".");
                }
            });
            Button butLeft = findViewById(R.id.buttonLeft);//左括号
            butLeft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("(");
                }
            });
            Button butRight = findViewById(R.id.buttonRight);//右括号
            butRight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append(")");
                }
            });
            //数字0-9
            Button butZero = findViewById(R.id.buttonZero);
            butZero.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("0");
                }
            });

            Button butOne = findViewById(R.id.buttonOne);
            butOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("1");
                }
            });

            Button butTwo = findViewById(R.id.buttonTwo);
            butTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("2");
                }
            });

            Button butThree = findViewById(R.id.buttonThree);
            butThree.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("3");
                }
            });

            Button butFour = findViewById(R.id.buttonFour);
            butFour.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("4");
                }
            });

            Button butFive = findViewById(R.id.buttonFive);
            butFive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("5");
                }
            });


            Button butSix = findViewById(R.id.buttonSix);
            butSix.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("6");
                }
            });

            Button butSeven = findViewById(R.id.buttonSeven);
            butSeven.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("7");
                }
            });

            Button butEight = findViewById(R.id.buttonEight);
            butEight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("8");
                }
            });

            Button butNine = findViewById(R.id.buttonNine);
            butNine.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("9");
                }
            });
            Button butPress = findViewById(R.id.buttonPress);
            butPress.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "解压模式！", Toast.LENGTH_SHORT).show();
                }
            });

        } else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {//横屏
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            //final TextView tv=(TextView) findViewById(R.id.t1);
            show1 = findViewById(R.id.text1);
            show2 = findViewById(R.id.text2);

            //
            Button butEqual = findViewById(R.id.buttonEqual);
            butEqual.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s = show2.getText().toString();
                    s += "=";
                    show1.setText(s);
                    double r = 0;
                    try {
                        r = calculate(s);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    String ru = "" + r;
                    show2.setText(ru);
                }
            });

            Button butClear = findViewById(R.id.buttonClear);
            butClear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show1.setText("");
                    show2.setText("");
                }
            });


            Button butDelete = findViewById(R.id.buttonDelete);
            butDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String s1 = show2.getText().toString();
                    s1 = s1.substring(0, s1.length() - 1);
                    show2.setText(s1);
                }
            });

            Button butMinus = findViewById(R.id.buttonMinus);
            butMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("-");
                }
            });

            Button butPlus = findViewById(R.id.buttonPlus);
            butPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("+");
                }
            });
            Button butMul = findViewById(R.id.buttonMul);
            butMul.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("*");
                }
            });

            Button butDiv = findViewById(R.id.buttonDiv);
            butDiv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("/");
                }
            });

            Button butPoint = findViewById(R.id.buttonPoint);
            butPoint.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append(".");
                }
            });
            Button butLeft = findViewById(R.id.buttonLeft);
            butLeft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("(");
                }
            });
            Button butRight = findViewById(R.id.buttonRight);
            butRight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append(")");
                }
            });
            Button butZero = findViewById(R.id.buttonZero);
            butZero.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("0");
                }
            });

            Button butOne = findViewById(R.id.buttonOne);
            butOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("1");
                }
            });

            Button butTwo = findViewById(R.id.buttonTwo);
            butTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("2");
                }
            });

            Button butThree = findViewById(R.id.buttonThree);
            butThree.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("3");
                }
            });

            Button butFour = findViewById(R.id.buttonFour);
            butFour.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("4");
                }
            });

            Button butFive = findViewById(R.id.buttonFive);
            butFive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("5");
                }
            });


            Button butSix = findViewById(R.id.buttonSix);
            butSix.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("6");
                }
            });

            Button butSeven = findViewById(R.id.buttonSeven);
            butSeven.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("7");
                }
            });

            Button butEight = findViewById(R.id.buttonEight);
            butEight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("8");
                }
            });

            Button butNine = findViewById(R.id.buttonNine);
            butNine.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("9");
                }
            });

            Button butx2 = findViewById(R.id.buttonx2);//平方
            butx2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    s = show2.getText().toString();
                    show1.setText(s + "^2=");

                    double r = Double.parseDouble(s);
                    r *= r;

                    String ru = "" + r;
                    show2.setText(ru);

                }
            });

            Button butln = findViewById(R.id.buttonln);//ln函数
            butln.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    s = show2.getText().toString();
                    show1.setText("ln " + s + "=");

                    double r = Double.parseDouble(s);
                    r = Math.log(r);

                    String ru = "" + r;
                    show2.setText(ru);

                }
            });

            Button butsin = findViewById(R.id.buttonsin);//sin函数
            butsin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    s = show2.getText().toString();
                    show1.setText("sin " + s + "=");

                    double r = Double.parseDouble(s);
                    r = Math.sin(r);

                    String ru = "" + r;
                    show2.setText(ru);

                }
            });
            Button butcos = findViewById(R.id.buttoncos);//cos函数
            butcos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    s = show2.getText().toString();
                    show1.setText("cos " + s + "=");

                    double r = Double.parseDouble(s);
                    r = Math.cos(r);

                    String ru = "" + r;
                    show2.setText(ru);

                }
            });
            Button buttan = findViewById(R.id.buttontan);//tan函数
            buttan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    s = show2.getText().toString();
                    show1.setText("tan " + s + "=");

                    double r = Double.parseDouble(s);
                    r = Math.tan(r);

                    String ru = "" + r;
                    show2.setText(ru);

                }
            });

            Button butPai = findViewById(R.id.buttonPai);//π
            butPai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s = show2.getText().toString();
                    show2.setText(s + "3.1415926535");
                }
            });

            Button butE = findViewById(R.id.buttonE);//es
            butE.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s = show2.getText().toString();
                    show2.setText(s + "2.7182818284");
                }
            });
            Button butHex = findViewById(R.id.buttonHex);//十六进制
            butHex.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s = show2.getText().toString();
                    show1.setText("HEX(" + s + ")=");
                    int r = Integer.valueOf(s).intValue();
                    show2.setText(Integer.toHexString(r));

                }
            });
            Button butOct = findViewById(R.id.buttonOct);//八进制
            butOct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s = show2.getText().toString();
                    show1.setText("OCT(" + s + ")=");
                    int r = Integer.valueOf(s).intValue();
                    show2.setText(Integer.toOctalString(r));
                }
            });
            Button butBin = findViewById(R.id.buttonBin);//二进制
            butBin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s = show2.getText().toString();
                    show1.setText("BIN(" + s + ")=");
                    int r = Integer.valueOf(s).intValue();
                    show2.setText(Integer.toBinaryString(r));
                }
            });
        }
    }

    //计算函数
    public double calculate(String str) throws Exception
    {

        str=str.substring(strRecord.length(),str.length());
        str.trim();
        Log.d("MainActivity","str:"+str+"\nstrRecord:"+strRecord);
        Double result=0.0;
        numberStack=new Stack<Double>();
        symbolStack=new Stack<Character>();
        StringBuffer number=new StringBuffer();
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if((ch>='0'&&ch<='9')||ch=='.')
            {
                number.append(ch);
            }else{
                if(number.length()!=0)
                {
                    numberStack.push(Double.parseDouble(number.toString()));
                    number.setLength(0);
                }
                //数字入栈，处理是否运算
                while(compare(ch))
                {
                    Double b=numberStack.pop();
                    Double a=numberStack.pop();
                    switch ((char)symbolStack.pop())
                    {
                        case '+':
                            numberStack.push(a+b);
                            break;

                        case '-':
                            numberStack.push(a-b);
                            break;
                        case '*':
                            numberStack.push(a*b);
                            break;
                        case '/':
                            numberStack.push(a/b);
                            break;
                        case'%':
                            numberStack.push(a%b);
                            break;
                        case '^':
                            numberStack.push(Math.pow(a,b));
                            break;
                    }
                }
                //运算结束，处理运算符ch
                if(ch=='='&&!numberStack.isEmpty())
                    result=numberStack.pop();
                else {
                    if(ch==')')
                    {
                        symbolStack.pop();
                    }else {
                        symbolStack.push(ch);
                    }
                }
            }
        }

        return result;
    }
    //判断优先级
    private boolean compare(char symbol){

        if(symbolStack.isEmpty())
        {
            return false;
        }else{
            char pop=symbolStack.peek();
            switch (pop)
            {
                case '^':
                    if (symbol!='(')
                        return true;
                case '*':
                case '/':
                case '%':
                    if(symbol!='^'&&symbol!='(')
                        return true;
                case '+':
                case '-':
                    if(symbol=='+'||symbol=='-'||symbol==')'||symbol=='=')
                        return true;
                default://pop=='('
                    return false;
            }
        }
    }
    //根据运算符进行运算

}