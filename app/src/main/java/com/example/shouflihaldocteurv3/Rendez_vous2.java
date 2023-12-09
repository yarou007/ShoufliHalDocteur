package com.example.shouflihaldocteurv3;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Rendez_vous2 extends AppCompatActivity {

    FirebaseAuth auth;
    Button button, btn_Home;
    Button rdv22;

    TextView textView;
    FirebaseUser User;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rendez_vous);


        auth = FirebaseAuth.getInstance();
        button = findViewById(R.id.logout);
        User = auth.getCurrentUser();
        rdv22 = ( Button) findViewById(R.id.Rdv);
        rdv22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRdv1();
            }
        });

        btn_Home = ( Button ) findViewById(R.id.Home);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), MainActivity4.class);
                startActivity(intent);
                finish();
            }
        });

        btn_Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });
    }
    public void openHome(){
        Intent intent = new Intent(this,WelcomingPage.class);
        startActivity(intent);
        finish();
    }
    public void openRdv1(){
        Intent intent = new Intent(this,Rendez_vous.class);
        startActivity(intent);
        finish();
    }
}