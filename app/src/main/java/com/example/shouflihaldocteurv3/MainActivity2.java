package com.example.shouflihaldocteurv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    private Button button, ignorer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button = (Button) findViewById(R.id.suivant2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    OpenActivity3();
            }
        });
        ignorer = ( Button ) findViewById(R.id.ignorer1);
        ignorer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoingBackActivity1();
            }
        });
    }
    public void OpenActivity3(){
        Intent intent   = new Intent(this, MainActivity3.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_in_left);
    }
    public void GoingBackActivity1(){
        Intent intent   = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_in_right);
    }
    }
