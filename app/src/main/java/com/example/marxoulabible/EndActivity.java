package com.example.marxoulabible;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
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
    }
}
