package com.example.marxoulabible;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class EndActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_screen);
        int bonneReponses = getIntent().getIntExtra("bonneReponses", 0);
        View view = findViewById(android.R.id.content);

        TextView textView_fin = view.findViewById(R.id.textView);
        String MessageFin = "Vous avez eu " + bonneReponses + " bonnes réponses";
        textView_fin.setText(MessageFin);

        /* Initialisation du bouton menu */
        Button menuButton = findViewById(R.id.btn_menu);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* Lancement de l'activité GameActivity */
                Intent intent = new Intent(EndActivity.this, MainMenuActivity.class);
                startActivity(intent);
            }
        });
    }

}
