package com.example.ebbill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class choice extends AppCompatActivity {

    private Button but;
    private Context con;
    private Button but1;
    private Context con1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        con=this;
        but=findViewById(R.id.reading);
        but.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       Intent intent=new Intent(con, reading.class);
                                       startActivity(intent);


                                   }
                               }
        );
        con1=this;
        but1=findViewById(R.id.amount);
        but1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent=new Intent(con1,unit.class);
                                        startActivity(intent);


                                    }
                                }
        );

        // Retrieve the value from the Intent
        Intent intent = getIntent();
        String inputText = intent.getStringExtra("inputText");

        // Append a comma after the name
        inputText += ",";

        // Use the modified value, set it to a TextView
        TextView textView = findViewById(R.id.show); // Replace textView with your TextView ID
        textView.setText(inputText);
    }

}
