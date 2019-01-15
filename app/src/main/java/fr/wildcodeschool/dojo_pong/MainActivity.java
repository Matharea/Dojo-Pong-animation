package fr.wildcodeschool.dojo_pong;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static float COORD_X = 0;
    private static float COORD_Y = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View lMain = findViewById(R.id.mainLayout);
        Display display = getWindowManager().getDefaultDisplay();
        final Point size = new Point();
        display.getSize(size);

        lMain.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    COORD_X = event.getX();
                    COORD_Y = event.getY();
                    if (COORD_Y > (size.y / 2))
                        Toast.makeText(getApplicationContext(), "Bonjour vous avez cliqué en bas !", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getApplicationContext(), "Bonjour vous avez cliqué en haut", Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });
    }
}
