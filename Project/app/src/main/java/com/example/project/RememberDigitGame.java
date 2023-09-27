package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class RememberDigitGame extends AppCompatActivity {
    Random random=new Random();
    int random_digits[]=new int[10];
    private TextView random_digit_text;
    private EditText user_input;
    private Button next_button;
    private Button check_button;
    private TextView description_text;
    private TextView description2_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remember_digit_game);
        random_digit_text=findViewById(R.id.random_digits);
        user_input=findViewById(R.id.user_digit);
        next_button=findViewById(R.id.next_button);
        check_button=findViewById(R.id.check_button);
        description_text=findViewById(R.id.description_text);
        description2_text=findViewById(R.id.description2_text);
        for (int i=0;i<10;i++){
            random_digits[i]= random.nextInt(10);
        }
        StringBuilder sb= new StringBuilder();
        for (int digit:random_digits){
            sb.append(digit).append(" ");
        }
        random_digit_text.setText(sb.toString());

    }


    public void next_click(View view) {
        random_digit_text.setVisibility(View.INVISIBLE);
        next_button.setVisibility(View.INVISIBLE);
        user_input.setVisibility(View.VISIBLE);
        check_button.setVisibility(View.VISIBLE);
        description_text.setVisibility(View.INVISIBLE);
        description2_text.setVisibility(View.VISIBLE);

    }

    public void check_click(View view) {
        String inputText = user_input.getText().toString();
        if (inputText.length() != 10) {
            Toast.makeText(RememberDigitGame.this, "Please enter 10 digits.", Toast.LENGTH_SHORT).show();
            return;
        }

        int[] user_digits = new int[10];
        for (int i = 0; i < 10; i++) {
            char digitChar = inputText.charAt(i);
            if (!Character.isDigit(digitChar)) {
                Toast.makeText(RememberDigitGame.this, "Invalid digit: " + digitChar, Toast.LENGTH_SHORT).show();
                return;
            }
            user_digits[i] = Character.getNumericValue(digitChar);
        }

        boolean isSuccess = true;
        for (int i = 0; i < 10; i++) {
            if (user_digits[i] != random_digits[i]) {
                isSuccess = false;
                break;
            }
        }

        if (isSuccess) {
            Toast.makeText(RememberDigitGame.this, "Congratulations! The numbers you entered are correct.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(RememberDigitGame.this, "Sorry, the numbers you entered are incorrect.", Toast.LENGTH_SHORT).show();
        }
    }
}