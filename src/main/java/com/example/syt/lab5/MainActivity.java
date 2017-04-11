package com.example.syt.lab5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int SECOND_ACTIVITY_RESULT_CODE = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Button convertButton = (Button) findViewById(R.id.convertButton);
        convertButton.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                converter(view);
            }
        });*/

    }

    public void converter(View view) {

        Intent myIntent = new Intent(getApplicationContext(), Choose.class);
        startActivityForResult(myIntent, SECOND_ACTIVITY_RESULT_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        //check that it is the Choose with an OK result
        if (requestCode == SECOND_ACTIVITY_RESULT_CODE) {
            if(resultCode == RESULT_OK){
                //get String data from Intent
                String returningString = data.getStringExtra("result");
                Double returningNumber = Double.parseDouble(returningString);

                EditText amountMoney = (EditText) findViewById(R.id.amountMoney);
                Double euroAmount = Double.parseDouble(amountMoney.getText() .toString());
                Double convetedAmount = euroAmount * returningNumber;
                String finalresult = Double.toString(convetedAmount);

                //set TextView with String
                if ((euroAmount*1.06) == convetedAmount){
                    TextView result = (TextView) findViewById(R.id.result);
                    result.setText(finalresult + " Dollars");
                }
                if ((euroAmount *117.54) == convetedAmount){
                    TextView result = (TextView) findViewById(R.id.result);
                    result.setText(finalresult + " Yens");
                }
            }
        }
    }

}
