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
import android.content.Context;
import android.view.inputmethod.InputMethodManager;

public class domestic_units extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domestic_units);

        Button gen = findViewById(R.id.generate);
        gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                find();
            }
        });

        EditText inputUnit = findViewById(R.id.unit);
        inputUnit.setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    // Hide the soft keyboard
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                    // Consume the event to prevent further action
                    return true;
                }
                return false;
            }
        });
    }

    public void find() {
        EditText input = findViewById(R.id.unit);
        TextView output = findViewById(R.id.amount);

        if (input.getText().toString().isEmpty()) {
            // Show toast message
            Toast.makeText(getApplicationContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
        } else {
            // Both fields are filled, proceed with your logic
            // You can add your calculation logic here

            int inputValue = Integer.parseInt(input.getText().toString());
            double amount = amounts(inputValue);
            double roundedAmount = Math.round(amount);
            int roundedAmountInt = (int) roundedAmount;
            output.setText(String.valueOf(roundedAmountInt));
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
