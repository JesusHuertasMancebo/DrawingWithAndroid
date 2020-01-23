package es.b.drawingwithandroid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class BallAndPaletteView extends View {

    //Painting a ball
    Paint ball = new Paint();
    //The center of the ball
    private int x, y;
    //El radio
    private static int radius = 40;
    //Painting the palette
    Paint paleta = new Paint();
    //The background
    Paint background = new Paint();

    private float xPaleta = 100, yPaleta;
    private float ample = 200;
    private float alt = 30;
    private float ultimaXpaleta, ultimaYpaleta;
    private int width, height;
    //The speed of the ball
    private int xDirection = 10, yDirection = 10;
    private float ultimaXPaleta, ultimaYPaleta;


    //Constructores
    public BallAndPaletteView(Context context) {
        super(context);
    }

    public BallAndPaletteView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BallAndPaletteView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BallAndPaletteView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void motion(){
        //Controlling the bounds
        if ((x > width) || (x < 0)) {
            xDirection = -xDirection;
        }
        if ((y > height) || (y < 0)) {
            yDirection = -yDirection;
        }

        //Controlling the palette
        if (y + radius > yPaleta) {
            if ((x + radius > xPaleta) && (x - radius < xPaleta + ample)) {
                yDirection = -yDirection;
            }
        }

        //New movement
        x += xDirection;
        y += yDirection;

        // Call to onDraw to repaint the canvas
        invalidate();
    }

    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        width = canvas.getWidth();
        height = canvas.getHeight();
        // Near of the bottom of the screen
        yPaleta = height - radius;

        //The background of the canvas
        background.setColor(Color.WHITE);
        //The ball
        ball.setColor(Color.RED);
        //The palette
        paleta.setColor(Color.BLUE);

        canvas.drawRect(0,0,getWidth(), getHeight(), background);
        canvas.drawCircle(x,y, radius,ball);
        canvas.drawRect(xPaleta, yPaleta, xPaleta + ample, yPaleta + alt, paleta);

        motion();
    }


    @Override
    public boolean onTouchEvent (MotionEvent ev) { // Only moving the palette
        final int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                ultimaXPaleta = ev.getX(); ultimaYPaleta = ev.getY(); break;
            }
            case MotionEvent.ACTION_MOVE: {
// Calculate the distance moved
                final float dx = ev.getX() - ultimaXPaleta;
                final float dy = ev.getY() - ultimaYPaleta;
                xPaleta += dx; // Move the palette. Only in horizontal!
// Remember this touch position for the next move event
                ultimaXPaleta = ev.getX(); ultimaYPaleta = ev.getY();
// Invalidate to request a redraw
                invalidate(); break;
            }
        }
        return true;
    } // End of onTouchEvent





}
