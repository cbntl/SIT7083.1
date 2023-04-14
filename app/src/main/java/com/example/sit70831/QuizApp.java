package com.example.sit70831;

public class QuizApp {
    private String question, questionDetails, correctAnswer, opt1, opt2, opt3, opt4;

    public QuizApp(String question, String questionDetails,  String correctAnswer, String option1, String option2, String option3, String option4) {

        this.question = question;
        this.questionDetails = questionDetails;
        this.correctAnswer = correctAnswer;
        this.opt1 = option1;
        this.opt2 = option2;
        this.opt3 = option3;
        this.opt4 = option4;

    }

    public String getQuestion() {
        return question;
    }
    public String getQuestionDetails() {
        return questionDetails;
    }
    public String getCorrectAnswer() {
        return correctAnswer;
    }
    public String getOpt1() {
        return opt1;
    }
    public String getOpt2() {
        return opt2;
    }
    public String getOpt3() {
        return opt3;
    }
    public String getOpt4() {
        return opt4;
    }

}
