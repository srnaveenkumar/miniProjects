package com.example.ebbill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class reading extends AppCompatActivity {

    private Button but;
    private Context con;
    private Button but1;
    private Context con1;
    private Button but2;
    private Context con2;
    private Button but3;
    private Context con3;
    private Button but4;
    private Context con4;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);
        con=this;
        but=findViewById(R.id.b1);
        but.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       Intent intent=new Intent(con, domestic_reading.class);
                                       startActivity(intent);


                                   }
                               }
        );
        con1=this;
        but1=findViewById(R.id.b2);
        but1.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       Intent intent=new Intent(con1, comm_reading.class);
                                       startActivity(intent);


                                   }
                               }
        );
        con2=this;
        but2=findViewById(R.id.b5);
        but2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent=new Intent(con2, railway_reading.class);
                                        startActivity(intent);


                                    }
                                }
        );
        con3=this;
        but3=findViewById(R.id.b3);
        but3.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent=new Intent(con3, govt_school.class);
                                        startActivity(intent);


                                    }
                                }
        );
        con4=this;
        but4=findViewById(R.id.b4);
        but4.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent=new Intent(con4, private_school_reading.class);
                                        startActivity(intent);


                                    }
                                }
        );
    }
}