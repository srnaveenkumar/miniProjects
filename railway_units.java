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


public class railway_units extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_railway_units);
        Button b1 = findViewById(R.id.generate);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                find();
            }
        });
        EditText in2 = findViewById(R.id.unit);
        in2.setOnEditorActionListener(new OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    find();
                    return true;
                }
                return false;
            }
        });
    }

    public void find() {
        EditText in1 = findViewById(R.id.unit);
        EditText in3 = findViewById(R.id.tax);
        TextView out = findViewById(R.id.amount);

        if (in1.getText().toString().isEmpty() || in3.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
        } else {
            int a = Integer.parseInt(in1.getText().toString());
            int c = Integer.parseInt(in3.getText().toString());
            double tax = c * 5 / 100;
            double amt = amounts(a, tax);
            double amt1 = Math.round(amt);
            int amt2 = (int) amt1;
            out.setText(String.valueOf(amt2));
        }
    }

    public double amounts(int i, double tax) {
        double amt;
        amt = i * 8 + (200 + tax);
        return amt;
    }
}
