package com.example.shouflihaldocteurv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button suivant;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         //Recuperation button avec ID suivant ( page 1 )
        suivant = ( Button) findViewById(R.id.suivant1);

        //l'ecouteur event listner
        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
            // Ouvre la deuxième activité2
        });
    }
    public void openActivity2(){
       // Création d'une intention pour ouvrir la deuxième activité
        // intent -> intention ( neya behs nhel )
        Intent intent   = new Intent(this, MainActivity2.class);
        startActivity(intent); // Lancement de la deuxième activité
        // animation pour slide droit vers gauche
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_in_left);
    }
}