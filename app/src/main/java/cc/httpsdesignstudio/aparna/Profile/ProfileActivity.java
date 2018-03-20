package cc.httpsdesignstudio.aparna.Profile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import cc.httpsdesignstudio.aparna.Alert.LikesActivity;
import cc.httpsdesignstudio.aparna.Feed.FeedActivity;
import cc.httpsdesignstudio.aparna.R;
import cc.httpsdesignstudio.aparna.Utils.BottomNavigation;

//includes Bottom Navigation bar

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";
    public static final int ACTIVITY_NUM = 2;
    ImageView ivFeed, ivProfile, ivAlert, ivMessage;
    ImageView ivSignOut;
    Button btnSignOut;
    private Button btnEditProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        ivSignOut = findViewById(R.id.ivSignOut);
        btnSignOut = findViewById(R.id.btnSignOut);
        btnEditProfile = findViewById(R.id.btnEditProfile);

        //Bottom Navigation View
 /*       ivFeed = findViewById(R.id.ivFeed);
        ivProfile = findViewById(R.id.ivProfile);
        ivAlert = findViewById(R.id.ivAlert);
        ivMessage = findViewById(R.id.ivMessaage);
        btnEditProfile = findViewById(R.id.btnEditProfile);

        //setting up buttons
        ivFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, FeedActivity.class);
                startActivity(intent);
            }
        });
        ivAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, LikesActivity.class);
                startActivity(intent);
            }
        });
        ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start messaging activity
                *//*Intent intent = new Intent(FeedActivity.this, ProfileActivity.class);
                startActivity(intent);*//*
            }
        });
*/
        ivSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                if(btnSignOut.getVisibility() == View.GONE) {
                    btnSignOut.setVisibility(View.VISIBLE);
//                }
                /*else if(btnSignOut.getVisibility() == View.VISIBLE) {
                    btnSignOut.setVisibility(View.GONE);
                }
*/
            }
        });

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Signing out user...

            }
        });

        btnEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent (ProfileActivity.this, BuildYourProfile.class);
                startActivity(intent);
            }
        });

        Log.e(TAG, "OnCreate : called");

        setupBottomNavigationViewBar();

    }
    void setupBottomNavigationViewBar() {

        Log.e(TAG, "setupBottomNavigationViewBar called");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavigation);
        BottomNavigation.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigation.enableNavigation(ProfileActivity.this,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);


}
}