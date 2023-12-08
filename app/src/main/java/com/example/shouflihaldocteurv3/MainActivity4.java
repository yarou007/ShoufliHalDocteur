package com.example.shouflihaldocteurv3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity4 extends AppCompatActivity {

    private Button inscription,connexion;
    TextInputEditText editTextEmail,editTextPassword;
    FirebaseAuth mAuth; // Instance de l'authentification Firebase
    ProgressBar progressBar; // Barre de progression pour la connexion
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        mAuth = FirebaseAuth.getInstance(); // instantiation mtaa l Auth FireBase
        editTextEmail = findViewById(R.id.email); // Champs de texte pour l'email et le mot de passe
        editTextPassword = findViewById(R.id.password);// Champs de texte pour password et le mot de passe
        connexion= findViewById(R.id.connexion);
        progressBar = findViewById(R.id.progressbar);
        textView = findViewById(R.id.inscription);
        inscription = ( Button) findViewById(R.id.inscription);

        // Écouteur d'événement pour le bouton de connexion

        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String email,password;
                // wala String.valueof();

                // Récupération des valeurs des champs de texte
                email= editTextEmail.getText().toString();
                password= editTextPassword.getText().toString();

                // Validation des champs de texte
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(MainActivity4.this,"Enter Email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(MainActivity4.this,"Enter password",Toast.LENGTH_SHORT).show();
                    return;
                }

                // Tentative de connexion avec Firebase
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    progressBar.setVisibility(View.GONE);
                                    // Sign in success, update UI with the signed-in user's information
                                    //  FirebaseUser user = mAuth.getCurrentUser();
                                    //  updateUI(user);
                                    Toast.makeText(MainActivity4.this, "Login Successful.",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(),WelcomingPage.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(MainActivity4.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
        //l'ecouteur event listner
        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInscription();
            }
            // Ouvre la deuxième activité2
        });
    }
    public void openInscription(){
        // Création d'une intention pour ouvrir la deuxième activité
        // intent -> intention ( neya behs nhel )
        Intent intent   = new Intent(this, Registration.class);
        startActivity(intent); // Lancement de la deuxième activité
        // animation pour slide droit vers gauche
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_in_left);
    }

}