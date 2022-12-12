package com.example.calculatrice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
        private String input,output,nvInput;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.standard:
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                //Toast.makeText(this, "Calc Standard", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.scientific:
                startActivity(new Intent(getApplicationContext(), MainActivity2.class));
                //Toast.makeText(this, "Calc Scientifique", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.graphic:
                startActivity(new Intent(getApplicationContext(), MainActivity3.class));
                Toast.makeText(this, "Calc graphique", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return
                        super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // setting variables :
        btn1=findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2=findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn3=findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn4=findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        btn5=findViewById(R.id.btn5);
        btn5.setOnClickListener(this);
        btn6=findViewById(R.id.btn6);
        btn6.setOnClickListener(this);
        btn7=findViewById(R.id.btn7);
        btn7.setOnClickListener(this);
        btn8=findViewById(R.id.btn8);
        btn8.setOnClickListener(this);
        btn9=findViewById(R.id.btn9);
        btn9.setOnClickListener(this);
        btn0=findViewById(R.id.btn0);
        btn0.setOnClickListener(this);
        btnMinus=findViewById(R.id.btnMinus);
        btnMinus.setOnClickListener(this);
        btnPlus=findViewById(R.id.btnPlus);
        btnPlus.setOnClickListener(this);
        btnMultiply=findViewById(R.id.btnMultiply);
        btnMultiply.setOnClickListener(this);
        btnDivide=findViewById(R.id.btnDivide);
        btnDivide.setOnClickListener(this);
        btnEqual=findViewById(R.id.btnEqual);
        btnEqual.setOnClickListener(this);
        btnSign=findViewById(R.id.btnSign);;
        btnSign.setOnClickListener(this);
        btnPoint=findViewById(R.id.btnPoint);
        btnPoint.setOnClickListener(this);
        btnDel=findViewById(R.id.btnDel);
        btnDel.setOnClickListener(this);
        btnC=findViewById(R.id.btnC);
        btnC.setOnClickListener(this);
        btnCE=findViewById(R.id.btnCE);
        btnCE.setOnClickListener(this);
        btnSquare=findViewById(R.id.btnSquare);
        btnSquare.setOnClickListener(this);
        btnSqrt=findViewById(R.id.btnSqrt);
        btnSqrt.setOnClickListener(this);
        btnPercent=findViewById(R.id.btnPercent);
        btnPercent.setOnClickListener(this);
        btnInv=findViewById(R.id.btnInv);
        btnInv.setOnClickListener(this);
        edtResult=findViewById(R.id.edtResult);
        edtOperation=findViewById(R.id.edtOperation);

    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data) {
            case "C":
                input = null;
                output=null;
                nvInput =null;
                edtOperation.setText("");
                break;
            case "Del":
                edtOperation.setText(edtOperation.getText().toString().substring(0,edtOperation.getText().toString().length()-1));
                break;
            case "x²":
                calculateOperation();
                input += "²";
                edtResult.setText(input);
                break;
            case "x":
                calculateOperation();
                input += "x";
                edtResult.setText(input);
                break;
            case "=":
                calculateOperation();
                break;
            case "%":
                input += "%";
                double d = Double.parseDouble(edtResult.getText().toString()) / 100;
                edtOperation.setText(String.valueOf(d));
                edtResult.setText(input);
                break;
            default:
                if (input == null) {
                    input = "";
                }
                if (data.equals("+") ||
                        data.equals("/") || data.equals("-")) {
                    calculateOperation();
                }
                input += data;
                edtResult.setText(input);
        }
    }
    private void calculateOperation() {
        if (input.split("\\+").length == 2) {
            String numbers[] = input.split("\\+");
            try {
                double d =
                        Double.parseDouble(numbers[0]) +Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                nvInput = RemoveDec(output);
                edtOperation.setText(nvInput);
                input = d +"";
            }catch (Exception e) {
                edtOperation.setText(e.getMessage().toString());
            }
        }
        if (input.split("\\*").length == 2) {
            String numbers[] = input.split("\\*");
            try {
                double d =
                        Double.parseDouble(numbers[0]) *
                                Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                nvInput = RemoveDec(output);
                edtOperation.setText(nvInput);
                input = d +"";
            }catch (Exception e){
                edtOperation.setText(e.getMessage().toString());
            }
        }
        if (input.split("\\/").length == 2) {
            String numbers[] = input.split("\\/");
            try {
                double d =
                        Double.parseDouble(numbers[0]) /
                                Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                nvInput = RemoveDec(output);
                edtOperation.setText(nvInput);
                input = d +"";
            }catch (Exception e){
                edtOperation.setText(e.getMessage().toString());
            }
        }
        if (input.split("\\^").length == 2) {
            String numbers[] = input.split("\\^");
            try {
                double d =
                        Math.pow(Double.parseDouble(numbers[0]),
                                Double.parseDouble(numbers[1]));
                output = Double.toString(d);
                nvInput = RemoveDec(output);
                edtOperation.setText(nvInput);
                input = d +"";
            }catch (Exception e){
                edtOperation.setText(e.getMessage().toString());
            }
        }
        if (input.split("\\-").length == 2) {
            String numbers[] = input.split("\\-");
            try {
                if (Double.parseDouble(numbers[0])
                        < Double.parseDouble(numbers[1])){
                    double d =Double.parseDouble(numbers[1]) -
                            Double.parseDouble(numbers[0]);
                    output = Double.toString(d);
                    nvInput = RemoveDec(output);
                    edtOperation.setText("-" + nvInput);
                    input = d +"";
                }
                else {
                    double d =
                            Double.parseDouble(numbers[0]) -
                                    Double.parseDouble(numbers[1]);
                    output = Double.toString(d);
                    nvInput = RemoveDec(output);
                    edtOperation.setText(nvInput);
                    input = d + "";
                }
            }catch (Exception e){
                edtOperation.setText(e.getMessage().toString());
            }
        }
    }
    private String RemoveDec(String number){
        String n [] = number.split("\\.");
        if (n.length >1){
            if (n[1].equals("0")){
                number = n[0];
            }
        }
        return number;
    }


}