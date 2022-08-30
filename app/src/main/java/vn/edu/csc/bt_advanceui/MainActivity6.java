package vn.edu.csc.bt_advanceui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Switch;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity6 extends AppCompatActivity {
    BottomNavigationView btv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        btv = findViewById(R.id.btv);
        // them su kien, nếu bị gạch ngang, cái bộ lậptình không hỗ trợchươngtrình này, nhưng vẫn hỗ trợ cho dòng thâp hơn
        btv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                init(item.getItemId());
                return true;
            }
        });
        init(R.id.mnu_home);
    }

    private void init(int id) {
        Fragment fragment = null;
        switch(id){
            case R.id.mnu_home:
                fragment = new HomeFragment();
                break;
            case R.id.mnu_order:
                fragment = new OrderFragment();
                break;
            case R.id.mnu_profile:
                fragment = new ProfileFragment();
                break;
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content,fragment);
        ft.commit();
    }
}