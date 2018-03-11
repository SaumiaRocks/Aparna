package cc.httpsdesignstudio.aparna;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etUsername;
    EditText etEmail;
    EditText etPassword;
    Button btnRegister;
    TextView tvRegistered;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    FirebaseStorage storage;
    StorageReference storageReference;
    Uri uri;
    FirebaseDatabase database;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        tvRegistered = (TextView) findViewById(R.id.tvRegistered);
        progressDialog = new ProgressDialog(MainActivity.this);
        firebaseAuth = FirebaseAuth.getInstance();
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();

     /*   if(firebaseAuth.getCurrentUser()!=null) {
            // Start profile activity
            MainActivity.this.finish();
            startActivity(new Intent(MainActivity.this, FeedActivity.class));
        }*/

        btnRegister.setOnClickListener(MainActivity.this);
        tvRegistered.setOnClickListener(MainActivity.this);
    }

    void RegisterUser() {
        String username = etUsername.getText().toString().trim();
        final String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if(TextUtils.isEmpty(username)) {
            Toast.makeText(MainActivity.this, "Please enter username", Toast.LENGTH_SHORT).show();
        }

        if(TextUtils.isEmpty(email)) {
            Toast.makeText(MainActivity.this, "Please enter email", Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(password)) {
            Toast.makeText(MainActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
        }
        if(password.length() <= 5) {
            Toast.makeText(MainActivity.this, "Your password is too short", Toast.LENGTH_SHORT).show();
        }

        progressDialog.setMessage("Registering User...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        String username = etUsername.getText().toString().trim();

                        if (task.isSuccessful()) {
                            //Storing data on database
                            databaseReference.child("Users").child("Username").setValue(username);
                            databaseReference.child("Users").child("Email").setValue(FirebaseAuth.getInstance().getCurrentUser().getEmail());
                            Toast.makeText(MainActivity.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();


                            // open up the build profile page
                            Intent intent = new Intent(MainActivity.this, BuildYourProfile.class);
                            startActivity(intent);

                        } else {
                            Toast.makeText(MainActivity.this, "Could not register. Please try again.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if(view == btnRegister) {
            RegisterUser();
        }
        else if(view == tvRegistered) {
            // open sign-in page
            MainActivity.this.finish();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));

        }
    }



}
