package com.example.marxoulabible;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import androidx.annotation.NonNull;

import com.yalantis.library.KolodaListener;

public class SwipeListener implements KolodaListener {
    Context context;
    private StringManagement stringManager;
    private ViewGroup rootLayout;

    public SwipeListener(Context context, StringManagement stringManager, ViewGroup rootLayout) {
        super();
        this.context = context;
        this.stringManager = stringManager;
        this.rootLayout = rootLayout;
    }
    @Override
    public void onCardDoubleTap(int i) {

    }

    @Override
    public void onCardDrag(int i, @NonNull View view, float v) {

    }

    @Override
    public void onCardLongPress(int i) {

    }

    @Override
    public void onCardSingleTap(int i) {

    }


    @Override
    public void onCardSwipedLeft(int i) {
        stringManager.addReponseUser(1);
        System.out.println(stringManager.getReponses());
        System.out.println(stringManager.getReponsesUser());
        // Déclenche l'animation de changement de couleur
        showColorEffect(0xFFFF0000);
        
        if(stringManager.isOver()){
            endActivity();
        }
    }

    @Override
    public void onCardSwipedRight(int i) {
        stringManager.addReponseUser(0);
        System.out.println(stringManager.getReponses());
        System.out.println(stringManager.getReponsesUser());
        // Déclenche l'animation de changement de couleur
        showColorEffect(0xFF00FF00);


        if(stringManager.isOver()){
            endActivity();
        }
    }

    public void endActivity(){
        Intent intent = new Intent(context, EndActivity.class);
        intent.putExtra("bonneReponses", stringManager.bonneReponse());
        context.startActivity(intent);
    }

    @Override
    public void onClickLeft(int i) {
    }

    @Override
    public void onClickRight(int i) {
    }

    @Override
    public void onEmptyDeck() {
        //Ne prend pas en compte le dernier swipe, il faut donc utiliser onCardSwipedLeft et onCardSwipedRight
    }

    @Override
    public void onNewTopCard(int i) {

    }

    public void showColorEffect(int color) {
        // Create a new view that covers the entire screen
        View colorView = new View(context);

        colorView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        // Set the background color of the view
        colorView.setBackgroundColor(color);

        // Add the view to the root layout
        rootLayout.addView(colorView);

        // Create an animation to fade out the view
        AlphaAnimation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setDuration(500);

        // Set a listener to remove the view when the animation is finished
        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                rootLayout.removeView(colorView);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        // Start the animation
        colorView.startAnimation(fadeOut);
    }

}
