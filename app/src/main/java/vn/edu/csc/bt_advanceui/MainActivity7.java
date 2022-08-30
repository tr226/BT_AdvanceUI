package vn.edu.csc.bt_advanceui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity7 extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView nav;
    ActionBarDrawerToggle hamburger;
    TextView tvEmail;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerLayout);

        hamburger = new ActionBarDrawerToggle(MainActivity7.this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.setDrawerListener(hamburger);

        // nav
        nav = findViewById(R.id.nav);

        // cach set nav nay la cach cu
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                init(item.getItemId());

                item.setCheckable(true);// highlight menu chon
                return true;
            }
        });
        init(R.id.mnu_home);


        View view = nav.getHeaderView(0); // link tk gmail cua header , phai co dong nay moi findviewbyid dc
        tvEmail = view.findViewById(R.id.tvEmail);
        tvEmail.setText("nmdye@gmail.com");





    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        hamburger.syncState();
    }
    private void init(int id) {
        Fragment fragment = null;
        String title = " ";
        switch(id){
            case R.id.mnu_home:
                fragment = new HomeFragment();
                title = "Home";
                break;
            case R.id.mnu_order:
                fragment = new OrderFragment();
                title = "Order";
                break;
            case R.id.mnu_profile:
                fragment = new ProfileFragment();
                title=  "Profile";
                break;
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content,fragment);
        ft.commit();

        toolbar.setTitle(title);

        drawerLayout.closeDrawers();// dong sau khi chon xong
    }
}