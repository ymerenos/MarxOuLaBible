package com.example.marxoulabible;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Arrays;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        /* Initialisation du spinner */
        Spinner quoteSpinner = findViewById(R.id.spinner_mode);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.mode_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quoteSpinner.setAdapter(adapter);
        quoteSpinner.setSelection(0);

        /* Initialisation du bouton play */
        Button playButton = findViewById(R.id.btn_play);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedOption = quoteSpinner.getSelectedItem().toString();
                int nb_qts = 5;

                switch (selectedOption) {
                    case "Mode classique":
                        nb_qts = 7;
                        break;
                    case "Mode rapide":
                        nb_qts = 3;
                        break;
                    case "Mode libre":
                        nb_qts = 15;
                        break;
                    default:
                        break;
                }

                /* Lancement de l'activité GameActivity */
                Intent intent = new Intent(MainMenuActivity.this, GameActivity.class);
                intent.putExtra("numQuotes", Integer.toString(nb_qts));
                startActivity(intent);
            }
        });

        // Add quotes button
        Button addQuotesButton = findViewById(R.id.btn_addquote);
        addQuotesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and show the AddQuote dialog fragment
                DialogFragment addQuoteFragment = new AddQuote();
                addQuoteFragment.show(getSupportFragmentManager(), "add_quote");
            }
        });

    }
}

