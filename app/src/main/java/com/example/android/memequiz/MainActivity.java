package com.example.android.memequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by SpirosDrivas on 2017.03.03
 * <p>
 * Simple quiz app to test how well you know memes
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // intent to the memeSelect view
        Button start = (Button) findViewById(R.id.start_button);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent selectIntent = new Intent(MainActivity.this, memeSelect.class);
                startActivity(selectIntent);
            }
        });

    }

}
