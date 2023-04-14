package com.example.sit70831;

import android.content.Intent;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;

import androidx.appcompat.app.AppCompatActivity;



public class QuizActivity extends AppCompatActivity {


    TextView quizQuestion, quizQuestionDetails,title, currentQuestionNumber;
    Button opt1, opt2, opt3, opt4, submitButton;

    ProgressBar progressBar;

    String playerName;
    Boolean optSelected = false;
    Integer currentQuestion=0, score = 0;
    Integer totalQuestions = 5;
    private ArrayList<QuizApp> quizzes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        Intent intent = getIntent();
        playerName = intent.getStringExtra("name");
        opt1 = findViewById(R.id.option1Button);
        opt2 = findViewById(R.id.option2Button);
        opt3 = findViewById(R.id.option3Button);
        opt4 = findViewById(R.id.option4Button);
        title = findViewById(R.id.welcomeTitle);
        currentQuestionNumber = findViewById(R.id.currentQuestionNumber);

        quizQuestionDetails = findViewById(R.id.quizQuestionDetails);
        progressBar = findViewById(R.id.QuizProgressBar);
        quizQuestion = findViewById(R.id.quizQuestion);

        submitButton = findViewById(R.id.submitButton);
        title.setText("Taking Quiz: "+ playerName);
        quizQuestions();
        getQuizQuestions();
        restartProgress();
    }

    private void quizQuestions() {
        QuizApp question1 = new QuizApp("Which language is used to develop Android apps?",
                "Please select one",
                "Java", "C#", "Python", "Ruby", "Java");
        QuizApp question2 = new QuizApp("Which method is used to start a new activity in Android?",
                "Please select one",
                "startActivity()", "startActivity()", "onPause()", "onDestroy()", "startApplication()");
        QuizApp question3 = new QuizApp("Which method is used to get a reference to a view in an Android app?",
                "Please select one",
                "findViewById()", "onCreate()", "onPause()", "onDestroy()", "findViewById()");
        QuizApp question4 = new QuizApp("Which layout allows you to position child views in a specific order or relative to each other?",
                "Please select one",
                "RelativeLayout", "RelativeLayout", "FrameLayout", "ConstraintLayout", "LinearLayour");
        QuizApp question5 = new QuizApp("Which of the following is NOT a core component of Android?",
                "Please select one",
                "Blockchain", "Service", "Intent", "Blockchain", "Activity");
        quizzes = new ArrayList<>(Arrays.asList(question1, question2, question3, question4, question5));
    }

    private void getQuizQuestions() {
        QuizApp quiz = quizzes.get(currentQuestion);
        quizQuestion.setText(quiz.getQuestion());
        quizQuestionDetails.setText(quiz.getQuestionDetails());
        opt1.setText(quiz.getOpt1());
        opt2.setText(quiz.getOpt2());
        opt3.setText(quiz.getOpt3());
        opt4.setText(quiz.getOpt4());
    }


    private void restartProgress() {
        currentQuestionNumber.setText(currentQuestion+1+"/"+totalQuestions);
        progressBar.setProgress(currentQuestion+1);

    }
    private void correctAnswer(QuizApp quiz) {
        if (quiz.getCorrectAnswer() == opt1.getText().toString()) {
            opt1.setBackgroundColor(getResources().getColor(R.color.Green)
            );
        } else if (quiz.getCorrectAnswer() == opt2.getText().toString()) {
            opt2.setBackgroundColor(getResources().getColor(R.color.Green)
            );
        } else if (quiz.getCorrectAnswer() == opt3.getText().toString()) {
            opt3.setBackgroundColor(getResources().getColor(R.color.Green)
            );
        } else if (quiz.getCorrectAnswer() == opt4.getText().toString()) {
            opt4.setBackgroundColor(getResources().getColor(R.color.Green)
            );
        }
    }
    public void opt1Selected(View view) {

        QuizApp quiz = quizzes.get(currentQuestion);
        optSelected = true;
        if (quiz.getCorrectAnswer() != opt1.getText().toString()) {
            opt1.setBackgroundColor(getResources().getColor(R.color.Red));
        } else score++;

        correctAnswer(quiz);
    }
    public void opt2Selected(View view) {

        QuizApp quiz = quizzes.get(currentQuestion);
        if (quiz.getCorrectAnswer() != opt2.getText().toString()) {
            opt2.setBackgroundColor(getResources().getColor(R.color.Red));
        } else score++;

        optSelected = true;
        correctAnswer(quiz);
    }
    public void opt3Selected(View view) {

        QuizApp quiz = quizzes.get(currentQuestion);
        if (quiz.getCorrectAnswer() != opt3.getText().toString()) {
            opt3.setBackgroundColor(getResources().getColor(R.color.Red));
        } else score++;

        optSelected = true;
        correctAnswer(quiz);
    }
    public void opt4Selected(View view) {

        QuizApp quiz = quizzes.get(currentQuestion);
        if (quiz.getCorrectAnswer() != opt4.getText().toString()) {
            opt4.setBackgroundColor(getResources().getColor(R.color.Red));
        } else score++;

        optSelected = true;
        correctAnswer(quiz);
    }
    public void submitBtn(View view) {
        if (!optSelected) {
            showToast("Please select an answer first");
            return;
        }
        if (currentQuestion == 4) {
            Intent resultIntent = new Intent(QuizActivity.this, ResultActivity.class);
            resultIntent.putExtra("name", playerName);
            resultIntent.putExtra("correctAnswer", score);
            resultIntent.putExtra("totalQuestions", totalQuestions);
            QuizActivity.this.startActivity(resultIntent);
            return;
        }
        currentQuestion++;
        optSelected = false;
        getQuizQuestions();
        restartProgress();
        resetButtonsColor();
    }

    private void resetButtonsColor() {
        opt1.setBackgroundColor(getResources().getColor(R.color.Gray));
        opt2.setBackgroundColor(getResources().getColor(R.color.Gray));
        opt3.setBackgroundColor(getResources().getColor(R.color.Gray));
        opt4.setBackgroundColor(getResources().getColor(R.color.Gray));
    }
    @Override
    public void onRestart() {
        super.onRestart();
        currentQuestion = 0;
        score = 0;
        totalQuestions = 5;
        optSelected = false;
        restartProgress();
        resetButtonsColor();
        getQuizQuestions();

    }
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}