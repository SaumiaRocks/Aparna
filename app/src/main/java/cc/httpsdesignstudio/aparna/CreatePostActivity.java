package cc.httpsdesignstudio.aparna;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class CreatePostActivity extends AppCompatActivity {

    final int GALLERY_REQUEST_CODE = 1;
    TextView etName;
    EditText etTitle, etDescription;
    ImageView ivProfilePicture, ivUploadImage, ivUploadedImage;
    Button btnShare;
    FirebaseStorage storage;
    StorageReference storageReference;
    Uri uri;
    FirebaseDatabase database;
    DatabaseReference databaseReference;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_post_activity);

        etName = findViewById(R.id.etName);
        etTitle = findViewById(R.id.etEnterTitle);
        etDescription = findViewById(R.id.etEnterDescription);
        ivProfilePicture = findViewById(R.id.ivProfilePicture);
        ivUploadImage = findViewById(R.id.ivUploadImage);
        ivUploadedImage = findViewById(R.id.ivUploadedImage);
        btnShare = findViewById(R.id.btnShare);
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();

        ivUploadedImage.setVisibility(View.GONE);

        ivUploadImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view == ivUploadImage) {
                    Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                    galleryIntent.setType("image/*");
                    startActivityForResult(galleryIntent, GALLERY_REQUEST_CODE);
                }

            }
        });
        btnShare.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("Tag","Share clicked");
                Toast.makeText(CreatePostActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                String title = etTitle.getText().toString().trim();
                String description = etDescription.getText().toString().trim();


                if(!TextUtils.isEmpty(title) && !TextUtils.isEmpty(description)) {
                    System.out.print(uri.toString());
                    StorageReference filePath = storageReference.child("PostImage").child(uri.getLastPathSegment());
                    filePath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                                                   @Override
                                                                   public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                                                       String title = etTitle.getText().toString().trim();
                                                                       String description = etDescription.getText().toString().trim();

                                                                       Uri downloadurl = taskSnapshot.getDownloadUrl();
                                                                       Toast.makeText(CreatePostActivity.this, "Image uploaded successfully", Toast.LENGTH_LONG).show();
                                                                       DatabaseReference newPost = databaseReference.push();
                                                                       newPost.child("title").setValue(title);
                                                                       newPost.child("description").setValue(description);
                                                                       newPost.child("image").setValue(downloadurl.toString());
                                                                   }
                                                               }
                    );
                    Intent intent = new Intent(CreatePostActivity.this,FeedActivity.class);
                    startActivity(intent);
                }


            }
        });


    }

   /* @Override
    public void onClick(View view) {
        if(view == ivUploadImage) {
            Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
            galleryIntent.setType("image*//*");
            startActivityForResult(galleryIntent, GALLERY_REQUEST_CODE);
        }

    }
*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_REQUEST_CODE && resultCode == RESULT_OK) {
            ivUploadedImage.setVisibility(View.VISIBLE);
            uri = data.getData();
            ivUploadedImage.setImageURI(uri);
        }
    }


    public void btnShareClicked(View view) {
            }
}
