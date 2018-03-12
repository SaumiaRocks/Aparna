package cc.httpsdesignstudio.aparna.Feed;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import cc.httpsdesignstudio.aparna.Alert.LikesActivity;
import cc.httpsdesignstudio.aparna.Profile.ProfileActivity;
import cc.httpsdesignstudio.aparna.R;
import cc.httpsdesignstudio.aparna.Utils.BottomNavigation;

//includes Bottom Navigation bar

public class FeedActivity extends AppCompatActivity {

    private static final String TAG = "FeedActivity";

    ImageView ivFeed, ivProfile, ivAlert, ivMessage;
    FloatingActionButton addPost;
    RecyclerView feedList;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    public static final int ACTIVITY_NUM = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed_activity);

        addPost = findViewById(R.id.flaAddPost);
        feedList = findViewById(R.id.feedList);
        feedList.setHasFixedSize(true);
        feedList.setLayoutManager(new LinearLayoutManager(this));
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();

        //Bottom Navigation View
        ivFeed = findViewById(R.id.ivFeed);
        ivProfile = findViewById(R.id.ivProfile);
        ivAlert = findViewById(R.id.ivAlert);
        ivMessage = findViewById(R.id.ivMessaage);

        //setting up buttons
        ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FeedActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
        ivAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //start likes activity
               /* Intent intent = new Intent(FeedActivity.this, LikesActivity.class);
                startActivity(intent);*/
            }
        });
        ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start messaging activity
                /*Intent intent = new Intent(FeedActivity.this, ProfileActivity.class);
                startActivity(intent);*/
            }
        });



        Query query = databaseReference;
        Log.e(TAG, "Starting feed activity");
//        setupBottomNavigationViewBar();

        //for switching between search tab and home tab
        setupViewPager();

        FirebaseRecyclerAdapter adapter = new FirebaseRecyclerAdapter<Post, FeedHolder>(Post.class,
                R.layout.card_layout,
                FeedHolder.class,
                query) {

            @Override
            protected void populateViewHolder(FeedHolder viewHolder, Post model, int position) {
                viewHolder.setTitle(model.getTitle());
                viewHolder.setDescription(model.getDescription());
                viewHolder.setImage(model.getImage());
                Log.v("FeedActivity","Populate called");
                Log.e("Testing",model.getTitle()+" "+model.getDescription()+" "+ model.getImage());

            }
        };
        feedList.setAdapter(adapter);

        addPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view == addPost) {
                    Intent intent = new Intent(FeedActivity.this, CreatePostActivity.class);
                    startActivity(intent);
                }

            }
        });
    }

    // setting up top tabs
    void setupViewPager() {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FeedFragment());        // index 0
        adapter.addFragment(new SearchFragment());      // index 1

        ViewPager viewPager = findViewById(R.id.vpHomeImages);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.topTabs);
        tabLayout.setupWithViewPager(viewPager);

//        tabLayout.getTabAt(1).setIcon(R.drawable.ic_search);

    }


    // setting up bottom navigation bar
 /*   void setupBottomNavigationViewBar() {

        Log.e(TAG, "setupBottomNavigationViewBar called");
        BottomNavigationViewEx bottomNavigationViewEx = new BottomNavigationViewEx(getBaseContext());
        *//*BottomNavigation.setupBottomNavigationView(bottomNavigationViewEx);*//*
        BottomNavigation.enableNavigation(FeedActivity.this, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
*/


}
