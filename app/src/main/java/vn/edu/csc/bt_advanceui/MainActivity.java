package vn.edu.csc.bt_advanceui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toolbar toolbar;
        TextView tvTitle;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
       // toolbar.setTitle("FoodNow");

        //
        tvTitle = findViewById(R.id.tvTitle);
        tvTitle = toolbar.findViewById(R.id.tvTitle);
        tvTitle.setText("FoodNow");

    }
}