package com.example.sit70831;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;


public class MainActivity extends AppCompatActivity {

    Button startButton;
    TextInputLayout nameTextInput;
    String name;
    Button calculatorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        startButton = findViewById(R.id.startButton);
        calculatorButton = findViewById(R.id.calculatorButton);
        nameTextInput = findViewById(R.id.nameInputLayout);
        nameTextInput.getEditText().setText(name);

    }

    public void onStartButtonPressed(View view) {
        System.out.println("Start Button Pressed!");
        String uname = nameTextInput.getEditText().getText().toString();

        name = uname;
        Intent quizIntent = new Intent(MainActivity.this, QuizActivity.class);
        quizIntent.putExtra("name", name);
        MainActivity.this.startActivity(quizIntent);
    }
    public void onCalculatorButtonPressed(View view) {
        System.out.println("Calculator Button Pressed!");
        Intent calculatorIntent = new Intent(MainActivity.this, CalcApp.class);
        MainActivity.this.startActivity(calculatorIntent);
    }
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}