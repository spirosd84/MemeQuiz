package com.example.android.memequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by SpirosDrivas on 2017.03.03
 * <p>
 * Simple quiz app to test how well you know memes
 */

public class memeSelect extends AppCompatActivity {
    // stores the state of the RadioButton with the correct answer
    boolean[] answer = new boolean[5];
    // stores the RadioGroup objects to know if at least one is checked
    RadioGroup question[] = new RadioGroup[5];
    // stores the RadioButton objects to get the RadioButton that is checked
    RadioButton buttons[] = new RadioButton[5];
    // stores the total results
    TextView results[] = new TextView[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meme_select);

        question[0] = (RadioGroup) findViewById(R.id.question1_radio);
        question[1] = (RadioGroup) findViewById(R.id.question2_radio);
        question[2] = (RadioGroup) findViewById(R.id.question3_radio);
        question[3] = (RadioGroup) findViewById(R.id.question4_radio);
        question[4] = (RadioGroup) findViewById(R.id.question5_radio);

        buttons[0] = (RadioButton) findViewById(R.id.question1_answer);
        buttons[1] = (RadioButton) findViewById(R.id.question2_answer);
        buttons[2] = (RadioButton) findViewById(R.id.question3_answer);
        buttons[3] = (RadioButton) findViewById(R.id.question4_answer);
        buttons[4] = (RadioButton) findViewById(R.id.question5_answer);


        results[0] = (TextView) findViewById(R.id.question1_result);
        results[1] = (TextView) findViewById(R.id.question2_result);
        results[2] = (TextView) findViewById(R.id.question3_result);
        results[3] = (TextView) findViewById(R.id.question4_result);
        results[4] = (TextView) findViewById(R.id.question5_result);

        // reset to the main view
        Button reset = (Button) findViewById(R.id.reset_button);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent selectIntent = new Intent(memeSelect.this, MainActivity.class);
                startActivity(selectIntent);
            }
        });

    }

    /**
     * this method checks on submit if every question RadioButton is checked and stores the results for display
     */

    public void submit(View view) {
        for (int i = 0; i < 5; i++) {
            if (question[i].getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, getString(R.string.toast1) + (i + 1), Toast.LENGTH_SHORT).show();
                return;
            } else {
                answer[i] = buttons[i].isChecked();
            }

        }

        // counter for the correctly answered questions
        int count = 0;

        // display the results on screen
        for (int i = 0; i < 5; i++) {
            if (answer[i]) {
                count++;
                results[i].setText(getString(R.string.result) + (i + 1) + getString(R.string.trueAnswer));
            } else {
                results[i].setText(getString(R.string.result) + (i + 1) + getString(R.string.falseAnswer));
            }
        }

        // make the results view visible
        ScrollView questions = (ScrollView) findViewById(R.id.questions);
        questions.setVisibility(View.GONE);
        RelativeLayout results = (RelativeLayout) findViewById(R.id.results);
        results.setVisibility(View.VISIBLE);

        // display toast message for the summary of answered questions
        if (count == 5) {
            Toast.makeText(this, getString(R.string.well_done), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, getString(R.string.answer) + count + getString(R.string.answers), Toast.LENGTH_LONG).show();
        }
    }

}
