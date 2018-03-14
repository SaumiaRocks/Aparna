package cc.httpsdesignstudio.aparna.Alert;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import cc.httpsdesignstudio.aparna.R;
import cc.httpsdesignstudio.aparna.Utils.BottomNavigation;

/**
 * Created by Design Studio IITR on 11-03-2018.
 */
//includes Bottom Navigation bar



public class LikesActivity extends AppCompatActivity{

    public static final int ACTIVITY_NUM = 3 ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

//        setupBottomNavigationViewBar();
    }

 /*   void setupBottomNavigationViewBar() {
        BottomNavigationViewEx bottomNavigationViewEx = new BottomNavigationViewEx(getBaseContext());
        BottomNavigation.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigation.enableNavigation(LikesActivity.this, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }*/
}
