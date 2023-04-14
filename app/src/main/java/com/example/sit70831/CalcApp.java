package com.example.sit70831;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

public class CalcApp extends AppCompatActivity {

    TextView result;
    Button revertBack,addButton,subtractButton;
    EditText firstNumber, secondNumber;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        addButton = findViewById(R.id.addButton);
        subtractButton = findViewById(R.id.subtractButton);
        firstNumber = findViewById(R.id.firstNum);
        secondNumber = findViewById(R.id.secndNum);
        result = findViewById(R.id.resultTextView);
    }

    public void onAdd(View view) {

        String firstNumberString = firstNumber.getText().toString();
        if (firstNumberString.matches("")) {
            showToast("Please enter 1st number");
            return;
        }
        String secondNumberString = secondNumber.getText().toString();
        if (secondNumberString.matches("")) {
            showToast("Please enter 2nd number");
            return;
        }

        Double sum = Double.valueOf(firstNumberString)+Double.valueOf(secondNumberString);
        result.setText("Result = "+sum);
    }

    public void onSubtract(View view) {

        String firstNumberString = firstNumber.getText().toString();
        if (firstNumberString.matches("")) {
            showToast("Please enter 1st number");
            return;
        }
        String secondNumberString = secondNumber.getText().toString();
        if (secondNumberString.matches("")) {

            return;
        }
        Double difference = Double.valueOf(firstNumberString)-Double.valueOf(secondNumberString);
        result.setText("Result = " + difference);
    }
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}