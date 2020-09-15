package com.example.digitalscoreboardapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnScoreReal, btnScoreBarselona, btnReal, btnBarselona;
    private int mCount = 0;
    private int total = 10;
    private int mCountGoal = 0;

    private int mCount1 = 0;
    private int total1 = 10;
    private int mCountGoal1 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnScoreReal = (Button) findViewById(R.id.btnReal);
        btnReal = (Button) findViewById(R.id.btnGoal1);
        btnScoreBarselona = (Button) findViewById(R.id.btnBarselona);
        btnBarselona = (Button) findViewById(R.id.btnGoal2);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.switch1:
                int orientation = this.getResources().getConfiguration().orientation;
                if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                } else {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
                return true;

            case R.id.reset:
                btnScoreBarselona.setText(Integer.toString(0));
                btnScoreReal.setText(Integer.toString(0));
                btnBarselona.setText(Integer.toString(0));
                btnReal.setText(Integer.toString(0));
                mCount = 0;
                total = 10;
                mCountGoal = 0;

                mCount1 = 0;
                total1 = 10;
                mCountGoal1 = 0;
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    public void countUp(View view) {
        int a = Integer.parseInt((String) btnScoreReal.getText());

            while (mCount < total) {
                mCount += 1;
                if (btnScoreReal != null)
                    btnScoreReal.setText(Integer.toString(mCount));
                break;
            }
            if (a == 9) {
                mCountGoal += 1;
                if (btnReal != null) ;
                btnReal.setText(Integer.toString(mCountGoal));
                if (btnScoreReal != null)
                    btnScoreReal.setText(Integer.toString(0));
                mCount = 0;
            }



    }

    public void countUpTwo(View view) {
        int a = Integer.parseInt((String) btnScoreBarselona.getText());

        while (mCount1 < total1) {
            mCount1 += 1;
            if (btnScoreBarselona != null)
                btnScoreBarselona.setText(Integer.toString(mCount1));
            break;
        }
        if (a == 9) {
            mCountGoal1 += 1;
            if (btnBarselona != null) ;
            btnBarselona.setText(Integer.toString(mCountGoal1));
            if (btnScoreBarselona != null)
                btnScoreBarselona.setText(Integer.toString(0));
            mCount1 = 0;
        }



    }
}

