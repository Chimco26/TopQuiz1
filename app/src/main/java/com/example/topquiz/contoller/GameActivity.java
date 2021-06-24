package com.example.topquiz.contoller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.topquiz.R;
import com.example.topquiz.model.Question;
import com.example.topquiz.model.QuestionBank;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mQuestionText;
    private Button mAnswerButton1;
    private Button mAnswerButton2;
    private Button mAnswerButton3;
    private Button mAnswerButton4;

    private Question mCurrentQuestion;
    private QuestionBank mQuestionBank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mQuestionBank = this.generateQuestion();
        System.out.println("my question banq is: " + mQuestionBank);


        mQuestionText = (TextView) findViewById(R.id.activity_game_text_question);
        mAnswerButton1 = (Button) findViewById(R.id.activity_game_button_answer1);
        mAnswerButton2 = (Button) findViewById(R.id.activity_game_button_answer2);
        mAnswerButton3 = (Button) findViewById(R.id.activity_game_button_answer3);
        mAnswerButton4 = (Button) findViewById(R.id.activity_game_button_answer4);

        mAnswerButton1.setTag(0);
        mAnswerButton2.setTag(1);
        mAnswerButton3.setTag(2);
        mAnswerButton4.setTag(3);

        mAnswerButton1.setOnClickListener(this);
        mAnswerButton2.setOnClickListener(this);
        mAnswerButton3.setOnClickListener(this);
        mAnswerButton4.setOnClickListener(this);


        mCurrentQuestion = mQuestionBank.getQuestion();
        this.DisplayQuestion(mCurrentQuestion);

    }

    @Override
    public void onClick(View v) {
        int resonseIndex = (int) v.getTag();

        if (resonseIndex == mCurrentQuestion.getAnswerIndex()){
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT);
        } else {
            Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT);
        }
    }

    private void DisplayQuestion(final Question question){
        System.out.println("my question is: " + question);
        mQuestionText.setText(question.getQuestion());
        mAnswerButton1.setText(question.getChoiceList().get(0));
        mAnswerButton2.setText(question.getChoiceList().get(1));
        mAnswerButton3.setText(question.getChoiceList().get(2));
        mAnswerButton4.setText(question.getChoiceList().get(3));
    }

    private QuestionBank generateQuestion(){
        Question q1 = new Question("Who is the creator of Android?",
                Arrays.asList("Andy Rubin", "Steve Wozniak", "Jake Wharton", "Paul Smith"),
                0);

        Question q2 = new Question("When did the first man land on the moon?",
                Arrays.asList("1958", "1962", "1967", "1969"),
                3);

        Question q3 = new Question("What is the house number of the Simpsons?",
                Arrays.asList("42", "101", "666", "742"),
                3);
        System.out.println("q3 is: " + q3);
        QuestionBank allQuestions = new QuestionBank(Arrays.asList(q1, q2, q3));
        System.out.println("my bank questions is: " + allQuestions);

        return allQuestions;
    }
}