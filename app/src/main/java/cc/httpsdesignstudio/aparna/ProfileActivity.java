package cc.httpsdesignstudio.aparna;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import cc.httpsdesignstudio.aparna.Utils.BottomNavigation;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        Log.e(TAG, "OnCreate : called");

        setupBottomNavigationViewBar();

    }

    void setupBottomNavigationViewBar() {
        BottomNavigationViewEx bottomNavigationViewEx = new BottomNavigationViewEx(ProfileActivity.this);
        BottomNavigation.setupBottomNavigationView(bottomNavigationViewEx);
    }
}
