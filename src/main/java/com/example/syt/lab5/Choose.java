package com.example.syt.lab5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Button;

public class Choose extends AppCompatActivity {

    CheckBox dollarCheckBox;
    CheckBox yenCheckBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        dollarCheckBox = (CheckBox) findViewById(R.id.checkBoxUSDollar);
        yenCheckBox = (CheckBox) findViewById(R.id.checkBoxJapaneseYen);
    }

    public void chooseClicked(View v) {

        if(dollarCheckBox.isChecked()){
            yenCheckBox.setChecked(false);
            Double numberToPassBack = 1.06;
            String stringToPassBack = Double.toString(numberToPassBack);

            Intent newIntent = new Intent();
            newIntent.putExtra("result", stringToPassBack);
            setResult(RESULT_OK, newIntent);
            finish();

        }
        if(yenCheckBox.isChecked()){
            dollarCheckBox.setChecked(false);
            Double numberToPassBack = 117.54;
            String stringToPassBack = Double.toString(numberToPassBack);

            Intent newIntent = new Intent();
            newIntent.putExtra("result", stringToPassBack);
            setResult(RESULT_OK, newIntent);
            finish();

        }
    }

}
