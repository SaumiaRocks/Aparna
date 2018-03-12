package cc.httpsdesignstudio.aparna.Utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import cc.httpsdesignstudio.aparna.Feed.FeedActivity;
import cc.httpsdesignstudio.aparna.Alert.LikesActivity;
import cc.httpsdesignstudio.aparna.Profile.ProfileActivity;
import cc.httpsdesignstudio.aparna.R;

/**
 * Created by Saumia Singhal on 3/11/2018.
 */

public class BottomNavigation extends AppCompatActivity{

    ImageView ivFeed, ivProfile, ivAlert, ivMessage;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ivFeed = findViewById(R.id.ivFeed);
        ivProfile = findViewById(R.id.ivProfile);
        ivAlert = findViewById(R.id.ivAlert);
        ivMessage = findViewById(R.id.ivMessaage);    }

  /*  public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx) {

      *//* bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);*//*
    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx viewEx) {
        viewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()) {

                    case R.id.icFeed :
                        Log.e("Feed", "inside case Feed");
                        Intent intent1 = new Intent(context, FeedActivity.class);
                        context.startActivity(intent1);
                        break;
                    case R.id.icProfile:
                        Log.e("Profile", "inside case Profile");
                        Intent intent2 = new Intent(context, ProfileActivity.class);
                        context.startActivity(intent2);
                        break;
                    case R.id.icAlert:
                        Log.e("Alert", "inside case Alert");
                        Intent intent3 = new Intent(context, LikesActivity.class);
                        context.startActivity(intent3);
                        break;
                    case R.id.icMessage:
                        Log.e("Message", "inside case Message");
                        //start messaging activity
                        break;


                }

                return false;
            }
        });
    }*/


}
