package com.example.midterm_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView gameView;
    private int numArr[];
    private ArrayList<String> results; // Create an ArrayList object
    private EditText numInput;
    private TextView moneyInput;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.gameView = findViewById(R.id.gameView);
        this.results = new ArrayList<String>();
        this.results.add("W");
        this.results.add("L");
        this.results.add("N");
        this.numArr = new int[9];
        this.numInput = findViewById(R.id.numInput);
        this.moneyInput = findViewById(R.id.moneyDisplay);
        this.moneyInput.setText("Money - " + 100);
        this.button = findViewById(R.id.button);

        for (int i = 0; i < 9; i++) {
            String str = "(" + (i + 1) + ") ";
            if(i == 2 || i == 5 || i == 8){
                str+="\n";
            }
            this.gameView.append(str);
            this.numArr[i] = i;
        }

        button.setOnClickListener( v-> {
            int input;
            try {
                input = Integer.parseInt(this.numInput.getText().toString());
                if (input < 1 && input > 9){
                    return;
                }
                this.gameView.setText("");
                for (int i = 0; i < 9; i++) {
                    String str = "(" + this.results.get(getRandomNumberInRange(0, 2)) + ") ";
                    if(i == 2 || i == 5 || i == 8){
                        str+="\n";
                    }
                    this.gameView.append(str);
                }

            }
            catch (NumberFormatException e)
            {
                System.out.println(e);
            }
        });

//        this.gameView.setText("num is - " + this.numArr[7]);

    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
