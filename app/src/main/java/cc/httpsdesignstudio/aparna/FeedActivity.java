package cc.httpsdesignstudio.aparna;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class FeedActivity extends AppCompatActivity {

    FloatingActionButton addPost;
    RecyclerView feedList;
    FirebaseDatabase database;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        addPost = findViewById(R.id.addPost);
        feedList = findViewById(R.id.feedList);
        feedList.setHasFixedSize(true);
        feedList.setLayoutManager(new LinearLayoutManager(this));
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();

        Query query = databaseReference;


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


    @Override
    protected void onStart() {
        super.onStart();

    }




}
