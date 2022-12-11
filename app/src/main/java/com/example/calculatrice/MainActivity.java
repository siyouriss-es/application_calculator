package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    // variables :
        private TextView edtResult,edtOperation;
        private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnMinus,btnPlus,btnMultiply,btnDivide;
        private Button btnSquare,btnSqrt,btnEqual,btnPoint,btnSign,btnInv,btnPercent,btnC,btnCE,btnDel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // setting variables :
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btn0=findViewById(R.id.btn0);
        btnMinus=findViewById(R.id.btnMinus);
        btnPlus=findViewById(R.id.btnPlus);
        btnMultiply=findViewById(R.id.btnMultiply);
        btnDivide=findViewById(R.id.btnDivide);
        btnEqual=findViewById(R.id.btnEqual);
        btnSign=findViewById(R.id.btnSign);
        btnPoint=findViewById(R.id.btnPoint);
        btnDel=findViewById(R.id.btnDel);
        btnC=findViewById(R.id.btnC);
        btnCE=findViewById(R.id.btnCE);
        btnSquare=findViewById(R.id.btnSquare);
        btnSqrt=findViewById(R.id.btnSqrt);
        btnPercent=findViewById(R.id.btnPercent);
        btnInv=findViewById(R.id.btnInv);
        edtResult=findViewById(R.id.edtResult);
        edtOperation=findViewById(R.id.edtOperation);

    }

    @Override
    public void onClick(View view) {
        Button clickedBtn= (Button) view;
        String btnNom= (String) clickedBtn.getText();
        Pattern pattern = Pattern.compile("[0-9]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(btnNom);
        boolean matchFound =matcher.matches();
        if(matchFound)
        Toast.makeText(MainActivity.this, btnNom, Toast.LENGTH_SHORT).show();
        //if()

    }
}