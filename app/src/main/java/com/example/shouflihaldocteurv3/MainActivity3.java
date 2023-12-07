package com.example.shouflihaldocteurv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity {

    private Button ignorer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ignorer = (Button) findViewById(R.id.ignorer2);
        ignorer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoingBackActivity1();
            }
        });
    }
    public void GoingBackActivity1(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_in_right);

    }
}