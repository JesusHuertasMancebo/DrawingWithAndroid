package es.b.drawingwithandroid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;

public class CanvasExampleView extends View {

    private Drawable mIcon;
    private float mPosX;
    private float mPosY;
    private float mLastTouchX;
    private float mLastTouchY;

    public CanvasExampleView(Context context) {
        super(context);
        mIcon = context.getDrawable(R.drawable.ic_android);
        mIcon.setBounds(0,0,mIcon.getIntrinsicWidth(), mIcon.getIntrinsicHeight());
    }

    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(mPosX,mPosY);
        mIcon.draw(canvas);
        canvas.restore();
    }
    @Override
    public boolean onTouchEvent(MotionEvent ev){
        final int action = ev.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:{
                //Recordar por donde hemos empezado
                mLastTouchX = ev.getX();
                mLastTouchY = ev.getY();
                break;
            }
            case MotionEvent.ACTION_MOVE:{
                //Calcular la distancia movida
                final float dx = ev.getX() - mLastTouchX;
                final float dy = ev.getY() - mLastTouchY;
                //Remember this touch position for the next move event
                mLastTouchX = ev.getX();
                mLastTouchY = ev.getY();
                //New coordinates of the object
                mPosX += dx;
                mPosY += dy;
                //Invalidate to request a redraw
                invalidate();
                break;
            }
        }
        return true;
    }//End of onTouchEvent
}//End of the class
