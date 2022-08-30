package vn.edu.csc.bt_advanceui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity5 extends AppCompatActivity {
    ViewPager2 vpWeather;
    WeatherAdapter weatherAdapter;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);


        vpWeather = findViewById(R.id.vpWeather);
        weatherAdapter = new WeatherAdapter(MainActivity5.this);
        vpWeather.setAdapter(weatherAdapter);

        tabLayout = findViewById(R.id.tabLayout);

        new TabLayoutMediator(tabLayout, vpWeather, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0 :
                        tab.setText("1");
                        tab.setIcon(R.drawable.ic_baseline_add_24);
                        break;
                    case 1:
                        tab.setText("2");
                        tab.setIcon(R.drawable.ic_baseline_announcement_24);
                        break;
                    case 2:
                        tab.setText("3");
                        tab.setIcon(R.drawable.ic_baseline_phone_24);
                        break;
                    case 3:
                        tab.setText("4");
                        tab.setIcon(R.drawable.ic_baseline_announcement_24);
                        break;
                    case 4:
                        tab.setText("5");
                        tab.setIcon(R.drawable.ic_baseline_phone_24);
                        break;


                }
            }
        }).attach();

    }
}