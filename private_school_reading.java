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

public class private_school_reading extends AppCompatActivity {

    int tax;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_school_reading);
        Button b1 = findViewById(R.id.generate);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                find();
            }
        });
        EditText in2 = findViewById(R.id.input2);
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

    public void find(){
        EditText in1=findViewById(R.id.unit);
        EditText in2=findViewById(R.id.input2);
        EditText in3=findViewById(R.id.tax);
        TextView tot=findViewById(R.id.units);
        TextView out=findViewById(R.id.amount);
        if (in1.getText().toString().isEmpty() || in2.getText().toString().isEmpty() || in3.getText().toString().isEmpty()) {
            // Show toast message
            Toast.makeText(getApplicationContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
        } else {
            int a=Integer.parseInt(in1.getText().toString());
            int b=Integer.parseInt(in2.getText().toString());
            int c=Integer.parseInt(in3.getText().toString());
            int i=b-a;
            tax = c * 5 / 100;
            tot.setText(String.valueOf(i));
            double amt=amounts(i);
            double amt1=Math.round(amt);
            int amt2=(int)amt1;
            out.setText(String.valueOf(amt2));
        }}

    // Moved amounts method outside of find method
    public double amounts(int i){
        double amt;
        amt=i*8.5+(tax+200);
        return amt;
    }
}
