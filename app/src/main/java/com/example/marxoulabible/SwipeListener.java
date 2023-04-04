package com.example.marxoulabible;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;

import com.yalantis.library.KolodaListener;

public class SwipeListener implements KolodaListener {
    Context context;
    private StringManagement stringManager;

    public SwipeListener(Context context, StringManagement stringManager) {
        super();
        this.context = context;
        this.stringManager = stringManager;
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
        if(stringManager.isOver()){
            endActivity();
        }
    }

    @Override
    public void onCardSwipedRight(int i) {
        stringManager.addReponseUser(0);
        System.out.println(stringManager.getReponses());
        System.out.println(stringManager.getReponsesUser());
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
}
