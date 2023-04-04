package com.example.marxoulabible;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.yalantis.library.Koloda;



public class GameActivity extends AppCompatActivity {


    private TextView textView;
    private StringManagement stringManagement;
    Koloda koloda;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);

        // get the number of quotes to display
        Intent intent = getIntent();
        int numQuotes = Integer.parseInt(intent.getStringExtra("numQuotes"));

        koloda = findViewById(R.id.koloda);

        StringManagement stringManager = new StringManagement(this);
        SwipeAdapter adapter = new SwipeAdapter(this, numQuotes,stringManager);
        koloda.setAdapter(adapter);
        koloda.setKolodaListener(new SwipeListener(this, stringManager));

    }

}


