package cc.httpsdesignstudio.aparna;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import cc.httpsdesignstudio.aparna.Utils.BottomNavigation;

/**
 * Created by Saumia Singhal on 3/11/2018.
 */

public class SearchActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        setupBottomNavigationViewBar();
    }

    void setupBottomNavigationViewBar() {
        BottomNavigationViewEx bottomNavigationViewEx = new BottomNavigationViewEx(getBaseContext());
        BottomNavigation.setupBottomNavigationView(bottomNavigationViewEx);
    }
}
