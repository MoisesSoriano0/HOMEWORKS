package com.example.admin.scientificcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvDisplay;
    private Boolean pointed = false;
    private Double firstValue = 0.0;
    private Double secondValue = 0.0;
    private String operation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tvDisplay);

    }

    public void btnClick(View view) {


        switch (view.getId()) {
            case R.id.btnOne: tvDisplay.setText(tvDisplay.getText().toString() + "1");
                break;
            case R.id.btnTwo: tvDisplay.setText(tvDisplay.getText().toString() + "2");
                break;
            case R.id.btnThree: tvDisplay.setText(tvDisplay.getText().toString() + "3");
                break;
            case R.id.btnFour: tvDisplay.setText(tvDisplay.getText().toString() + "4");
                break;
            case R.id.btnFive: tvDisplay.setText(tvDisplay.getText().toString() + "5");
                break;
            case R.id.btnSix: tvDisplay.setText(tvDisplay.getText().toString() + "6");
                break;
            case R.id.btnSeven: tvDisplay.setText(tvDisplay.getText().toString() + "7");
                break;
            case R.id.btnEight: tvDisplay.setText(tvDisplay.getText().toString() + "8");
                break;
            case R.id.btnNine:  tvDisplay.setText(tvDisplay.getText().toString() + "9");
                break;
            case R.id.btnZero:  tvDisplay.setText(tvDisplay.getText().toString() + "0");
                break;
            case R.id.btnPoint:
//                String pointString = tvDisplay.getText().toString();
                if(!tvDisplay.getText().equals("")){
                    if(!tvDisplay.getText().toString().contains(".")){
                        tvDisplay.setText(tvDisplay.getText().toString() + ".");
                    }
                }

//                if(!pointed){
//                    tvDisplay.setText(tvDisplay.getText().toString() + ".");
//                    pointed = true;
//                }
                break;
            case R.id.btnDelete:
                tvDisplay.setText("");
                break;
            case R.id.btnMultiply:
                operation = "multiply";
                if (!tvDisplay.getText().equals("")) {
                    firstValue = Double.parseDouble(tvDisplay.getText().toString());
                    tvDisplay.setText("");
                }
                break;
            case R.id.btnPlus:
                operation = "add";
                if (!tvDisplay.getText().equals("")) {
                    firstValue = Double.parseDouble(tvDisplay.getText().toString());
                    tvDisplay.setText("");
                }
                break;
            case R.id.btnMinus:
                operation = "subtract";
                if (!tvDisplay.getText().equals("")) {
                    firstValue = Double.parseDouble(tvDisplay.getText().toString());
                    tvDisplay.setText("");
                }
                break;
            case R.id.btnDivide:
                operation = "divide";
                if (!tvDisplay.getText().equals("")) {
                    firstValue = Double.parseDouble(tvDisplay.getText().toString());
                    tvDisplay.setText("");
                }
                break;
            case R.id.btnCos:
                if (!tvDisplay.getText().equals("")) {
                    Double result = Math.cos(Double.parseDouble(tvDisplay.getText().toString()));
                    tvDisplay.setText(result.toString());
                }
                break;
            case R.id.btnSin:
                if (!tvDisplay.getText().equals("")) {
                    Double result = Math.sin(Double.parseDouble(tvDisplay.getText().toString()));
                    tvDisplay.setText(result.toString());
                }
                break;
            case R.id.btnTan:
                if (!tvDisplay.getText().equals("")) {
                    Double result = Math.tan(Double.parseDouble(tvDisplay.getText().toString()));
                    tvDisplay.setText(result.toString());
                }
                break;
            case R.id.btnSquareRoot:
                if (!tvDisplay.getText().equals("")) {
                    Double result = Math.sqrt(Double.parseDouble(tvDisplay.getText().toString()));
                    tvDisplay.setText(result.toString());
                }
                break;
            case R.id.btnEquals:
                if (!tvDisplay.getText().equals("")) {
                    secondValue = Double.parseDouble(tvDisplay.getText().toString());
                    tvDisplay.setText(basicOperations(firstValue, secondValue, operation));
                }
            default:
                System.out.println("Default");
                break;
        }

    }

    public String basicOperations(Double first, Double second, String operation){
        Double result= 0.0;

        switch (operation) {
            case "add":
                result = Double.valueOf(first + second);
                break;
            case "subtract":
                result = Double.valueOf(first - second);
                break;
            case "divide":
                result = Double.valueOf(first / second);
                break;
            case "multiply":
                result = Double.valueOf(first * second);
                break;
            default:
                break;
        }

        return result.toString();
    }
}
