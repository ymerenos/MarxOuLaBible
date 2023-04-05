package com.example.marxoulabible;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.yalantis.library.KolodaListener;

public class SwipeListener implements KolodaListener {
    Context context;
    private StringManagement stringManager;
    private ViewGroup rootLayout;

    private Bitmap marxHead;
    private Bitmap jesusHead;

    public SwipeListener(Context context, StringManagement stringManager, ViewGroup rootLayout) {
        super();
        this.context = context;
        this.stringManager = stringManager;
        this.rootLayout = rootLayout;

        this.marxHead = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.marx_head);
        ImageView imageViewMarx = new ImageView(context);
        imageViewMarx.setImageBitmap(this.marxHead);

        this.jesusHead = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.jesus_head);
        ImageView imageViewJesus = new ImageView(context);
        imageViewJesus.setImageBitmap(this.jesusHead);
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
        stringManager.addReponseUser(0);
        // Déclenche l'animation de changement de couleur
        showColorEffect(0xBFCF1922);
        animateImage(rootLayout, R.drawable.marx_head, 0); // Animate an image falling from the left side


        if(stringManager.isOver()){
            endActivity();
        }
    }

    @Override
    public void onCardSwipedRight(int i) {
        stringManager.addReponseUser(1);
        // Déclenche l'animation de changement de couleur
        showColorEffect(0xBF12067D);
        animateImage(rootLayout, R.drawable.jesus_head, 1); // Animate an image falling from the left side


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

    public void animateImage(ViewGroup rootLayout, int drawableResId, int side) {
        // Create an ImageView to hold the image
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(drawableResId);

        // Add the ImageView to the root layout
        rootLayout.addView(imageView);

        // Set the initial position of the ImageView
        int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
        int x = (side == 0) ? -imageView.getWidth() : screenWidth;
        int y = (int) (Math.random() * screenHeight - imageView.getHeight());
        imageView.setX(x);
        imageView.setY(y);

        // Create an ObjectAnimator to animate the ImageView's X position
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "x", x, screenWidth / 2f);
        animator.setDuration(2500);
        animator.setInterpolator(new AccelerateInterpolator());

        // Set a listener to remove the ImageView when the animation is finished
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                rootLayout.removeView(imageView);
            }
        });

        // Start the animation
        animator.start();
    }

}
