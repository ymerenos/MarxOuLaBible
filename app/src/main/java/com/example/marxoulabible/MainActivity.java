package com.example.marxoulabible;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.cardview.widget.CardView;


public class MainActivity extends AppCompatActivity {

    filters_container=(RelativeLayout)root.findViewById(R.id.filters_container);
    new SwipeDetector(filters_container).setOnSwipeListener(new SwipeDetector.onSwipeEvent() {
        @Override
        public void SwipeEventDetected(View v, SwipeDetector.SwipeTypeEnum swipeType) {
            if(swipeType==SwipeDetector.SwipeTypeEnum.LEFT_TO_RIGHT)
                getActivity().onBackPressed();
        }
    });
}


