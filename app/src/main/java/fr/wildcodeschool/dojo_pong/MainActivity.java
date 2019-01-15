package fr.wildcodeschool.dojo_pong;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.support.animation.DynamicAnimation;
import android.support.animation.SpringAnimation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private  float coord_x = 0;
    private  float coord_y = 0;
    private  boolean firstTime = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View lMain = findViewById(R.id.mainLayout);
        final ImageView topBar = findViewById(R.id.topBar);
        final ImageView bottomBar = findViewById(R.id.bottomBar);
        final ImageView ball = findViewById(R.id.ball);


        //Get the screen size
        Display display = getWindowManager().getDefaultDisplay();
        final Point size = new Point();
        display.getSize(size);

        final AnimatorSet set = new AnimatorSet();

        //When you touch the screen
        lMain.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    // Get X & Y clic position
                    if(firstTime){
                        moveBall(set, ball, bottomBar, 3000);
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
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (ball.getX() > size.y/2)
                    moveBall(animation, ball, bottomBar, (int) (animation.getDuration()/2));
                else
                    moveBall(animation, ball, topBar, (int) (animation.getDuration()/2));
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    public void moveBar(ImageView bar){
        ObjectAnimator move = ObjectAnimator.ofFloat(bar, "translationX", coord_x);
        move.setDuration(1000);
        move.start();
    }

    public void moveBall(Animator animator, ImageView ball, ImageView bar, Integer duration){
        animator.playTogether(
                ObjectAnimator.ofFloat(ball, "y", bar.getY() - 50),
                ObjectAnimator.ofFloat(ball, "x", bar.getX())
        );
        animator.setDuration(duration).start();
    }
}
