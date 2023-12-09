package com.example.shouflihaldocteurv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Rendez_vous extends AppCompatActivity {
    FirebaseAuth auth;
    Button button, btn_Home, rdv_2;

    TextView textView;
    FirebaseUser User;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rendez_vous);
        auth = FirebaseAuth.getInstance();
        button = findViewById(R.id.logout);
        User = auth.getCurrentUser();
        rdv_2 = ( Button) findViewById(R.id.rdv_2);
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
        rdv_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRdv_2();
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
    public void openRdv_2(){
        Intent intent = new Intent(this,Rendez_vous2.class);
        startActivity(intent);
        finish();
    }
}