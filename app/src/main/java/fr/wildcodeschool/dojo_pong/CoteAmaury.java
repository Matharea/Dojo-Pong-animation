//package fr.wildcodeschool.dojo_pong;
//
//import android.animation.ObjectAnimator;
//import android.graphics.Point;
//import android.os.Bundle;
//import android.view.Display;
//import android.view.animation.Animation;
//import android.view.animation.TranslateAnimation;
//import android.widget.ImageView;
//
//public class CoteAmaury {
//
//    ImageView southRacket;
//    ImageView northRacket;
//    ImageView ball;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        Display display = getWindowManager().getDefaultDisplay();
//        Point size = new Point();
//        display.getSize(size);
//
//        float centerX = size.x / 2;
//
//
//        southRacket = findViewById(R.id.bottomBar);
//        southRacket.setX(-centerX);
//        northRacket = findViewById(R.id.topBar);
//        northRacket.setX(-centerX);
//        ball = findViewById(R.id.ball);
//
//        final float southRacketLeftEnd = southRacket.getX() - southRacket.getWidth() / 2;
//        final float southRacketRightEnd = southRacket.getX() + southRacket.getWidth() / 2;
//        final float northRacketLeftEnd = southRacket.getX() - southRacket.getWidth() / 2;
//        final float northRacketRightEnd = northRacket.getX() + northRacket.getWidth() / 2;
//
//
//        ObjectAnimator moveSouthRacketCenter = ObjectAnimator.ofFloat(southRacket, "x", centerX / 2);
//        moveSouthRacketCenter.setDuration(5000);
//        moveSouthRacketCenter.start();
//
//        ObjectAnimator moveNorthRacketCenter = ObjectAnimator.ofFloat(northRacket, "x", centerX / 2);
//        moveNorthRacketCenter.setDuration(5000);
//        moveNorthRacketCenter.start();
//
//        final Animation ballAnimationUp = new TranslateAnimation(0, 0, southRacket.getY(), northRacket.getY());
//        ballAnimationUp.setDuration(1000);
//        final Animation ballAnimationDown = new TranslateAnimation(0, 0, northRacket.getY(), southRacket.getY());
//        ballAnimationDown.setDuration(1000);
//
//        ballAnimationDown.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                ball.startAnimation(ballAnimationUp);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//
//        ballAnimationUp.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                ball.startAnimation(ballAnimationDown);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//
//        ball.startAnimation(ballAnimationDown);
//    }
//}