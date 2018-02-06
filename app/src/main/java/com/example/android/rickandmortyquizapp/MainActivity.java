package com.example.android.rickandmortyquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.rickandmortyquizapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /*//
    CHECKS THE RESULTS OF THE QUIZ
     */
    public void checkResults(View view) {
        RadioButton questionOneRightAnswer =  findViewById(R.id.q1ra);
        boolean rightAnswerToQuestionOne = questionOneRightAnswer.isChecked();

        RadioButton questionTwoRightAnswer =  findViewById(R.id.q2ra);
        boolean rightAnswerToQuestionTwo = questionTwoRightAnswer.isChecked();

        RadioButton questionThreeRightAnswer =  findViewById(R.id.q3ra);
        boolean rightAnswerToQuestionThree = questionThreeRightAnswer.isChecked();

        RadioButton questionFourRightAnswer =  findViewById(R.id.q4ra);
        boolean rightAnswerToQuestionFour = questionFourRightAnswer.isChecked();

        RadioButton questionFiveRightAnswer = findViewById(R.id.q5ra);
        boolean rightAnswerToQuestionFive = questionFiveRightAnswer.isChecked();

        int score = countScore (rightAnswerToQuestionOne, rightAnswerToQuestionTwo,
                rightAnswerToQuestionThree, rightAnswerToQuestionFour, rightAnswerToQuestionFive);

        displayResult(finalQuizResult(rightAnswerToQuestionOne,
                rightAnswerToQuestionTwo,
                rightAnswerToQuestionThree,
                rightAnswerToQuestionFour, rightAnswerToQuestionFive, score));

    }
    private int countScore (boolean qq1, boolean qq2, boolean qq3, boolean qq4, boolean qq5){
        int startScore = 0;

        if (qq1){
            startScore = startScore +1;
        }
        if (qq2){
            startScore = startScore +1;
        }
        if (qq3){
            startScore = startScore +1;
        }
        if (qq4){
            startScore = startScore +1;
        }
        if (qq5){
            startScore = startScore +1;
        }
        if (startScore <= 3){
            Toast.makeText(this, "You are not a real Rick and Morty fan, are you?", Toast.LENGTH_SHORT).show();;

        }
        if (startScore > 3){
            Toast.makeText(this, "Now you are a certified Rick and Morty Fan. PICKLE RIIICK!", Toast.LENGTH_LONG).show();;

        }
        return startScore;
    }


    /** DISPLAYS THE RESULT OF THE QUIZ
     *
     * @param rightAnswerToQuestionOne is right answer the question 1
     * @param rightAnswerToQuestionTwo is right answer the question  2
     * @param rightAnswerToQuestionThree is right answer the question  3
     * @param rightAnswerToQuestionFour is right answer the question  4
     * @param rightAnswerToQuestionFive is right answer the question  5
     * @return is the message to be displayed on the screen
     */
    private String finalQuizResult (boolean rightAnswerToQuestionOne,
                                    boolean rightAnswerToQuestionTwo,
                                    boolean rightAnswerToQuestionThree,
                                    boolean rightAnswerToQuestionFour,
                                    boolean rightAnswerToQuestionFive, int score){
        String resultMessage = "\nYour total score is " + score + " out of 5";
        resultMessage += "\nYour answer to first question is " + rightAnswerToQuestionOne;
        resultMessage += "\nYour answer to second question is " + rightAnswerToQuestionTwo;
        resultMessage += "\nYour answer to third question is " + rightAnswerToQuestionThree;
        resultMessage += "\nYour answer to fourth question is " + rightAnswerToQuestionFour;
        resultMessage += "\nYour answer to fifth question is " + rightAnswerToQuestionFive;
        return resultMessage;
    }



    /*/
    method for displaying the result
     */
    private void displayResult(String message) {
        TextView resultSummaryTextView = (TextView) findViewById(R.id.quiz_results);
        resultSummaryTextView.setText(message);
    }

}
