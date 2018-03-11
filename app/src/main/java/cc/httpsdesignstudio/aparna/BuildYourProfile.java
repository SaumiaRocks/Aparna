package cc.httpsdesignstudio.aparna;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class BuildYourProfile extends AppCompatActivity {

    EditText etName, etEducationQualification, etSkills, etInterest, etWantToLearn;
    TextView tvBirthDate;
    Button btnNext;
    Button btnNext2;
    Button btnNext3;
    ProgressBar progressBar;
    FirebaseAuth firebaseAuth;
    FirebaseStorage storage;
    StorageReference storageReference;
    Uri uri;
    FirebaseDatabase database;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.build_your_profile_activity);

        Log.e("Start", "OnCreate called");

        etName = findViewById(R.id.etYourName);
        etEducationQualification = findViewById(R.id.etEducationQualification);
        etSkills = findViewById(R.id.etSkills);
        etInterest = findViewById(R.id.etInterest);
        etWantToLearn = findViewById(R.id.etWantToLearn);
        tvBirthDate = findViewById(R.id.picDate);
        btnNext = findViewById(R.id.btnNext);
        btnNext2 = findViewById(R.id.btnNext2);
        btnNext3 = findViewById(R.id.btnNext3);
        progressBar = findViewById(R.id.progressBar);
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();
        firebaseAuth = FirebaseAuth.getInstance();


        progressBar.setProgress(33);
        etSkills.setText(null);


        Log.e("etname in oncreate", "inside etName if , etNAme = " + etName.getText().toString());


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             /*   String sample;
                sample = etInterest.getText().toString();*/
                Log.e("etname", "inside etName if , etNAme = " + etName.getText().toString());

                Log.e("etInterest", "etInterest = " + etInterest.getText().toString());





                if(etName.getText().toString()!= null) {

                    Log.e("etname", "inside etName if , etNAme = " + etName.getText().toString());
                    Log.e("Status", "changing birthday to edu");

                    String name = etName.getText().toString().trim();
                    String email = firebaseAuth.getCurrentUser().getEmail().trim();

                    // Storing data on firebase

                    databaseReference.child("Users").child("Name").setValue(name);


//                    String birthDate = tvBirthDate.getText().toString();
                    ProfilePic profilePicFragment;
                    profilePicFragment = new ProfilePic();
                    EducationQualification educationQualificationfragment;
                    educationQualificationfragment = new EducationQualification();
                    BirthdateFragment birthdateFragment;
                    birthdateFragment = new BirthdateFragment();

                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.UpperFragment, profilePicFragment);
                    fragmentTransaction.replace(R.id.LowerFragment, educationQualificationfragment);
                    fragmentTransaction.replace(R.id.firstFragment, birthdateFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                    progressBar.setProgress(66);

                    btnNext.setVisibility(View.GONE);
                    btnNext2.setVisibility(View.VISIBLE);
                }




            }
        });

        btnNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etSkills.getText().toString().trim()!= null && etEducationQualification.getText().toString().trim() != null) {
                    Log.e("Status", "changing edu to interest");
                    String educationQualification = etEducationQualification.getText().toString().trim();
                    String skills= etSkills.getText().toString();
                    String email = firebaseAuth.getCurrentUser().getEmail().trim();

                    //storing data pn firebase
                    databaseReference.child("Users").child(email).child("Education Qualification").setValue(educationQualification);

                    Interest interestFragment;
                    interestFragment = new Interest();
                    EducationQualification educationQualificationfragment;
                    educationQualificationfragment = new EducationQualification();

                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.LowerFragment, interestFragment);
                    fragmentTransaction.replace(R.id.secondFragment, educationQualificationfragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                    progressBar.setProgress(100);
                    btnNext2.setVisibility(View.GONE);
                    btnNext3.setVisibility(View.VISIBLE);
                }
            }
        });

        btnNext3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etInterest.getText().toString()!= null && etWantToLearn.getText().toString() != null) {
                    Log.e("Status", "final");

                    String interest = etInterest.getText().toString();
                    String wantToLearn = etWantToLearn.getText().toString();

                    // start Profile Activity
                    Intent intent = new Intent(BuildYourProfile.this, FeedActivity.class);
                    startActivity(intent);

                    progressBar.setProgress(100);
                }

            }
        });

    }
}
