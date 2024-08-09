package com.example.ebbill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView.OnEditorActionListener;
import android.view.inputmethod.InputMethodManager;

public class MainActivity extends AppCompatActivity {


    private Context con;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        con = this;
        Button but;
        editText = findViewById(R.id.name);

        but = findViewById(R.id.start);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editText.getText().toString().trim();

                if (inputText.isEmpty()) {
                    Toast.makeText(con, "Please fill in the required field", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(con, choice.class);
                    intent.putExtra("inputText", inputText);
                    startActivity(intent);
                }
            }
        });
        EditText in2 = findViewById(R.id.name);
        in2.setOnEditorActionListener(new OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(in2.getWindowToken(), 0);
                    return true;
                }
                return false;
            }
        });
    }
}

