package com.example.marxoulabible;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import com.example.marxoulabible.SwipeDetector.onSwipeEvent;
import com.example.marxoulabible.StringManagement;
import android.content.Context;
import android.content.res.Resources;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<String> myDataset;
    private Button button;
    private TextView textView;
    private CardView cardView;
    private SwipeDetector swipeDetector;
    private StringManagement stringManagement;
    private String quote;
    /*
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the context of the app
        stringManagement = new StringManagement(this);

        //Get the recycler view
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        myDataset = new ArrayList<String>();
        mAdapter = new MyAdapter(myDataset);
        recyclerView.setAdapter(mAdapter);

        //Get the button
        button = (Button) findViewById(R.id.button);

        //Get the text view
        textView = (TextView) findViewById(R.id.textView);

        //Get the card view
        cardView = (CardView) findViewById(R.id.cardView);

        //Get the swipe detector
        swipeDetector = new SwipeDetector(cardView);

        //Set the swipe detector listener
        swipeDetector.setOnSwipeListener(new SwipeDetector.onSwipeEvent() {
            @Override
            public void SwipeEventDetected(View v, SwipeDetector.SwipeTypeEnum SwipeType) {
                switch (SwipeType) {
                    case LEFT_TO_RIGHT:
                        //We get a random quote from the marx quotes and we add a 0 in front of it to indicate that it is a marx quote
                        quote = stringManagement.getRandomQuote(0);
                        myDataset.add(quote);
                        mAdapter.notifyDataSetChanged();
                        break;
                    case RIGHT_TO_LEFT:
                        //We get a random quote from the bible quotes and we add a 1 in front of it to indicate that it is a bible quote
                        quote = stringManagement.getRandomQuote(1);
                        myDataset.add(quote);
                        mAdapter.notifyDataSetChanged();
                        break;
                    case TOP_TO_BOTTOM:
                        //We get a random quote from the bible quotes and we add a 1 in front of it to indicate that it

                }
            }
        }
        );
    }
    */
}


