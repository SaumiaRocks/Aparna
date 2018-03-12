package cc.httpsdesignstudio.aparna.Feed;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import cc.httpsdesignstudio.aparna.R;

/**
 * Created by Saumia Singhal on 3/8/2018.
 */

public class FeedHolder  extends RecyclerView.ViewHolder {

        View fView;
        TextView postTitle;
        TextView postDescription;
        ImageView postImage;


        public FeedHolder (View feedView) {
            super(feedView);
            fView = feedView;
        }

        public void setTitle(String title) {
            postTitle = fView.findViewById(R.id.etPostTitle);
            postTitle.setText(title);
        }

        public void setDescription(String description) {
            postDescription = fView.findViewById(R.id.etPostDescription);
            postDescription.setText(description);
        }

        public void setImage(String image) {
            postImage = fView.findViewById(R.id.ivPostUploadedImage);
            if (TextUtils.isEmpty(image)) {
                postImage.setVisibility(View.GONE);
            }
            else {
                Picasso.with(postImage.getContext())
                        .load(image)
                        .resize(50, 50)
                        .centerCrop()
                        .into(postImage);

            }
        }
    }

