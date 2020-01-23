package es.b.drawingwithandroid;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.io.IOError;
import java.io.IOException;

public class MyViewObjectActivity extends MainMenu {
    ImageView myImageView; View myBase;
    Integer maxHeight, maxWidth, offsetX, offsetY, step;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_my_view_object);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(150,200);
        myBase = findViewById(R.id.myBase);
        myImageView = myBase.findViewById(R.id.myImageView);
        myImageView.setLayoutParams(layoutParams);

        maxHeight = myBase.getLayoutParams().height;
        maxWidth = myBase.getLayoutParams().width;
        offsetX = 10;
        offsetY = 10; // To control the borders
        step = 100;
    }
    public void moveLeft(View view) {
        if (offsetX > 10) { offsetX = offsetX - step; myImageView.offsetLeftAndRight(-step);
        }
    }
    public void moveRight(View view) {
        if (offsetX < maxWidth -100){offsetX = offsetX + step; myImageView.offsetLeftAndRight(step);
        }
    }
    public void moveUp(View view) {
        if (offsetY > 10) { offsetY = offsetY - step; myImageView.offsetTopAndBottom(-step); }
    }
    public void moveDown(View view) {
        if (offsetY < maxHeight - 100) {offsetY = offsetY + step; myImageView.offsetTopAndBottom(step);
        }
    }
}
