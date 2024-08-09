package com.example.ebbill;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView.OnEditorActionListener;

public class domestic_reading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domestic_reading);

        Button gen = findViewById(R.id.generate);
        gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                find();
            }
        });

        EditText in2 = findViewById(R.id.input1);
        in2.setOnEditorActionListener(new OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    // Hide the soft keyboard
                    // Perform the action
                    find();
                    return true;
                }
                return false;
            }
        });
    }

    public void find() {
        EditText in1 = findViewById(R.id.input1);
        EditText in2 = findViewById(R.id.input2);
        TextView tot = findViewById(R.id.units);
        TextView out = findViewById(R.id.amount);

        if (in1.getText().toString().isEmpty() || in2.getText().toString().isEmpty()) {
            // Show toast message
            Toast.makeText(getApplicationContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
        } else {
            // Both fields are filled, proceed with your logic
            // You can add your calculation logic here

            int a = Integer.parseInt(in1.getText().toString());
            int b = Integer.parseInt(in2.getText().toString());
            int i = b - a;

            tot.setText(String.valueOf(i));
            double amt = amounts(i);
            double amt1 = Math.round(amt);
            int amt2 = (int) amt1;
            out.setText(String.valueOf(amt2));
        }
    }

    public double amounts(int i) {
        if (i > 500) {
            i = i - 100;
            if (i > 400 && i <= 500) {
                double amt = (300 * 4.5);
                i = i - 300;
                amt = amt + (100 * 6);
                i = i - 100;
                amt = amt + (i * 8);
                return amt;
            }
            if (i > 500 && i <= 700) {
                double amt = (300 * 4.5);
                i = i - 300;
                amt = amt + (100 * 6);
                i = i - 100;
                amt = amt + (100 * 8);
                i = i - 100;
                amt = amt + (i * 9);
                return amt;
            }
            if (i > 700 && i <= 900) {
                double amt = (300 * 4.5);
                i = i - 300;
                amt = amt + (100 * 6);
                i = i - 100;
                amt = amt + (100 * 8);
                i = i - 100;
                amt = amt + (200 * 9);
                i = i - 200;
                amt = amt + (i * 10);
                return amt;
            }
            if (i > 900) {
                double amt = (300 * 4.5);
                i = i - 300;
                amt = amt + (100 * 6);
                i = i - 100;
                amt = amt + (100 * 8);
                i = i - 100;
                amt = amt + (200 * 9);
                i = i - 200;
                amt = amt + (200 * 10);
                i = i - 200;
                amt = amt + (i * 11);
                return amt;
            }
        }
        if (i <= 500) {
            if (i < 100) {
                return 0;
            }
            i = i - 100;
            if (i <= 100) {
                double amt = (i * 2.25);
                return amt;
            }
            if (i <= 300) {
                double amt = (100 * 2.25);
                i = i - 100;
                amt = amt + (i * 4.5);
                return amt;
            }
            if (i <= 400) {
                double amt = (100 * 2.25);
                i = i - 100;
                amt = amt + (200 * 4.5);
                i = i - 200;
                amt = amt + (i * 6);
                return amt;
            }
        }
        return 0; // Default return value if none of the conditions are met
    }


}
