package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MultiplicationActivity extends AppCompatActivity {
    EditText num1_editText;
    EditText num2_editText;
    TextView result_text;
    Button multiply_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplication);
        num1_editText=findViewById(R.id.num1_editText);
        num2_editText=findViewById(R.id.num2_editText);
        result_text=findViewById(R.id.result_text);
        multiply_button=findViewById(R.id.multiply_button);

    }

    public void click_multiply_button(View view) {
        String number1String=num1_editText.getText().toString();
        String number2String=num2_editText.getText().toString();
        if (number1String.isEmpty() || number2String.isEmpty()){
            Toast.makeText(MultiplicationActivity.this, "Please enter the number.", Toast.LENGTH_SHORT).show();
        }
        else {
            int number1=Integer.parseInt(number1String);
            int number2=Integer.parseInt(number2String);
            int result=number1*number2;
            result_text.setText(String.valueOf(result));
        }
    }
}