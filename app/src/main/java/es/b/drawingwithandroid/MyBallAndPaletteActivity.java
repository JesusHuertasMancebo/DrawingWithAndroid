package es.b.drawingwithandroid;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class MyBallAndPaletteActivity extends MainMenu {

    BallAndPaletteView ballAndPaletteView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_my_ball_and_palette);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ballAndPaletteView = new BallAndPaletteView(this);
        ballAndPaletteView.setBackgroundColor(Color.WHITE);
        setContentView(ballAndPaletteView);

    }

}
