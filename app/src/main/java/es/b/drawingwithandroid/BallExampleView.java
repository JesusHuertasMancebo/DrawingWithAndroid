package es.b.drawingwithandroid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class BallExampleView extends View {

    private Drawable mIcon;
    private int xDirection = 5, yDirection = 5;
    private float width = 1000;
    private float height = 600;
    private float mPosX;
    private float mPosY;

    public BallExampleView(Context context) {
        super(context);
        init(context);
    }

    public BallExampleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BallExampleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public BallExampleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }


    public void init(Context context) {
        mIcon = context.getDrawable(R.drawable.ic_ball);
        mIcon.setBounds(0,0, mIcon.getIntrinsicWidth(), mIcon.getIntrinsicHeight());
    }

    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(mPosX,mPosY);
        mIcon.draw(canvas);
        canvas.restore();
        motion();
    }

    public void motion(){
        //New position
        mPosX += xDirection;
        mPosY += yDirection;

        if ((mPosX > width) || (mPosX < 0)){
            xDirection = -xDirection;
        }

        if ((mPosY > height) || (mPosY < 0)){
            yDirection = -yDirection;
        }
        //To redraw the ball
        invalidate();
    }
}
