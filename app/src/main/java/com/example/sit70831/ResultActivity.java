package com.example.sit70831;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView yourScoreTextView, scoreTextView, resultTitleTextView;
    Button retryButton, finishButton;
    Integer totalScore;
    String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        totalScore = intent.getIntExtra("correctAnswer", 0);

        resultTitleTextView = findViewById(R.id.resultTitleTextView);
        yourScoreTextView = findViewById(R.id.yourScoreTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        retryButton = findViewById(R.id.retakeButton);
        finishButton = findViewById(R.id.finishButton);

        if (totalScore == 0) {
            resultTitleTextView.setText("Fail! Try again, "+name+"!");
        } else if (totalScore == 5) {
            resultTitleTextView.setText("Perfect! "+name+"!");
        } else {
            resultTitleTextView.setText("Well done! " + name + "!");
        }
        scoreTextView.setText(totalScore +"");
    }
    public void onRetakeQuiz(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("name", name);
        startActivity(intent);
    }
    public void onFinishQuiz(View view) {
        finish();
    }


}