package com.example.sit70831;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;


public class MainActivity extends AppCompatActivity {

    Button startButton, calculatorButton;
    TextInputLayout nameTextInput;
    String name;

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
    public void onCalc(View view) {
        Intent calculatorIntent = new Intent(MainActivity.this, CalcApp.class);
        MainActivity.this.startActivity(calculatorIntent);
    }
    public void onStartQuizBtn(View view) {
        String uname = nameTextInput.getEditText().getText().toString();

        name = uname;

        Intent quizIntent = new Intent(MainActivity.this, QuizActivity.class);
        quizIntent.putExtra("name", name);
        MainActivity.this.startActivity(quizIntent);
    }

}