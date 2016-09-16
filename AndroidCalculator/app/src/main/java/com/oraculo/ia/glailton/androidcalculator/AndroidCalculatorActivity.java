package com.oraculo.ia.glailton.androidcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AndroidCalculatorActivity extends AppCompatActivity {

    private EditText edtNumber1;
    private EditText edtNumber2;
    private TextView txtResult;
    private Button btnMultiply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_calculator);

        edtNumber1 = (EditText) findViewById(R.id.editText01);
        edtNumber2 = (EditText) findViewById(R.id.editText02);
        txtResult = (TextView) findViewById(R.id.TextView01);
        btnMultiply = (Button) findViewById(R.id.Button01);

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showResult();
            }
        });
    }

    private void showResult() {
        float number1 = 0;
        float number2 = 0;
        if (!edtNumber1.getText().toString().equals("")) {
            number1 = Float.parseFloat(edtNumber1.getText().toString());
        }
        if (!edtNumber2.getText().toString().equals("")) {
            number2 = Float.parseFloat(edtNumber2.getText().toString());
        }
        float result = number1*number2;
        txtResult.setText(String.valueOf(result));
    }
}
