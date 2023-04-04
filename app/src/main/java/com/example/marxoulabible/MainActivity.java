package com.example.marxoulabible;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import com.yalantis.library.Koloda;


public class MainActivity extends AppCompatActivity {


    private TextView textView;
    private StringManagement stringManagement;
    Koloda koloda;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        koloda = findViewById(R.id.koloda);


        SwipeAdapter adapter = new SwipeAdapter(this, 3);
        koloda.setAdapter(adapter);

    }

}


