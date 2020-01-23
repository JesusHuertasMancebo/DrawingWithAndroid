package es.b.drawingwithandroid;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class MyCanvasActivity extends MainMenu {

    //Nova classe que exten de View
    CanvasExampleView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_my_canvas);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawView = new CanvasExampleView(this);
        //La nova vista
        drawView.setBackgroundColor(Color.WHITE);
        setContentView(drawView);
    }

}
