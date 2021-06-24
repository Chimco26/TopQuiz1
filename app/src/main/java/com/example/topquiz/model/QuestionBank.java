package com.example.topquiz.model;

import java.util.Collections;
import java.util.List;

public class QuestionBank {
    private List<Question> mQuestionList;
    private int mNextQuestionIndex;

    public QuestionBank(List<Question> questionList) {
        mQuestionList = questionList;
        Collections.shuffle(mQuestionList);
        mNextQuestionIndex = 0;
    }

    public Question getQuestion(){
        if(mQuestionList.size() == mNextQuestionIndex){
            mNextQuestionIndex = 0;
        }
        return mQuestionList.get(mNextQuestionIndex++);
    }

    @Override
    public String toString() {
        return "QuestionBank{" +
                "mQuestionList=" + mQuestionList +
                ", mNextQuestionIndex=" + mNextQuestionIndex +
                '}';
    }
}
