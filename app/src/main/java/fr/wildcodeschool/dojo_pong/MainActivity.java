package fr.wildcodeschool.dojo_pong;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    View lMain;
    ImageView topBar ;
    ImageView bottomBar;
    ImageView ball;

    Animation ballAnimationUp;
    Animation ballAnimationDown;
    Point size;

    private  float coord_x = 0;
    private  float coord_y = 0;
    private float topBall;
    private float bottomBall;
    private  boolean firstTime = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lMain = findViewById(R.id.mainLayout);
        topBar = findViewById(R.id.topBar);
        bottomBar = findViewById(R.id.bottomBar);
        ball = findViewById(R.id.ball);

        topBall = -300.0f;
        bottomBall = 300.0f;

        ballAnimationDown = new TranslateAnimation(0, 0, 0, 0);
        ballAnimationUp = new TranslateAnimation(0, 0, 0, 0);

        //Get the screen size
        Display display = getWindowManager().getDefaultDisplay();
        size = new Point();
        display.getSize(size);

//        final AnimatorSet set = new AnimatorSet();

        //When you touch the screen
        lMain.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    // Get X & Y clic position
                    if(firstTime){
//                        moveBall(set, ball, bottomBar, 3000);
                        firstTime = false;
                    }
                    coord_x = event.getX() - (size.x/2);
                    coord_y = event.getY();
                    if (coord_y > (size.y / 2))
                        moveBar(bottomBar);
                    else
                        moveBar(topBar);
                }
                return true;
            }
        });




//        set.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                if (ball.getX() > size.y/2)
//                    moveBall(set, ball, bottomBar, (int) (animation.getDuration()/2));
//                else
//                    moveBall(set, ball, topBar, (int) (animation.getDuration()/2));
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//
//            }
//        });

        moveBallDown(0,0);
    }

    public void moveBallUp (float posXTop, float posXBottom){

        ballAnimationUp = new TranslateAnimation(ball.getX() - size.x/2, ball.getX() - size.x/2, size.y/2 - 100, -size.y/2 + 100);
        ballAnimationUp.setDuration(1000);
        attachUpListener();
        ball.startAnimation(ballAnimationUp);

    }
    public void moveBallDown (float posXTop, float posXBottom){

        ballAnimationDown = new TranslateAnimation(ball.getX() - size.x/2, posXBottom, - size.y/2 + 100, size.y/2 - 100);
        ballAnimationDown.setDuration(1000);
        attachDownListener();
        ball.startAnimation(ballAnimationDown);

    }

    public void moveBar(ImageView bar){
        ObjectAnimator move = ObjectAnimator.ofFloat(bar, "translationX", coord_x);
        move.setDuration(1000);
        move.start();
    }

//    public float setBottomBall

//    public void moveBall(AnimatorSet animator, ImageView ball, ImageView bar, Integer duration){
//        animator.playTogether(
//                ObjectAnimator.ofFloat(ball, "y", bar.getY() - 50),
//                ObjectAnimator.ofFloat(ball, "x", bar.getX())
//        );
//        animator.setDuration(duration).start();
//    }

    public void attachUpListener(){
        ballAnimationUp.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                moveBallDown(topBar.getX() - topBar.getWidth()/2, bottomBar.getX() - topBar.getWidth()/2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void attachDownListener(){
        ballAnimationDown.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                moveBallUp(topBar.getX() - topBar.getWidth()/2, bottomBar.getX() - topBar.getWidth()/2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}