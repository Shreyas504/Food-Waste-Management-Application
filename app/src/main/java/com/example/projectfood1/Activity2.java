package com.example.projectfood1;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class Activity2 extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 234;

    EditText editTextAdd, editTextArea, editTextMobile, editTextPincode;
    Button buttonAdd, buttonUpload, buttonImage, buttonBack;
    Spinner spinnertype;
    private Uri mImageUri;

    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        getSupportActionBar().setTitle("Notify");
buttonBack = findViewById(R.id.btnHome);
        editTextAdd = findViewById(R.id.editTextAdd);
        editTextArea = findViewById(R.id.editTextArea);
        editTextMobile = findViewById(R.id.editTextMobile);
        editTextPincode = findViewById(R.id.editTextPincode);
        buttonImage = findViewById(R.id.buttonImage);
        mStorageRef = FirebaseStorage.getInstance().getReference("uploads/");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("uploads");
        buttonAdd = findViewById(R.id.button);
        spinnertype = findViewById(R.id.spinnertype);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity2.this, Dashboard.class));
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addArtist();
            }
        });
        buttonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(Activity2.this, Upload.class));
            }
        });

    }


    private void addArtist() {
        DatabaseReference databaseArtist;
        databaseArtist = FirebaseDatabase.getInstance().getReference("food");

        //  String uadd = editTextAdd.getText().toString().trim();
        //String uarea = editTextArea.getText().toString().trim();
        String umobile = editTextMobile.getText().toString().trim();
        String upincode = editTextPincode.getText().toString().trim();
        String address = String.valueOf(editTextAdd.getText());
        String area = String.valueOf(editTextArea.getText());
        String mobile = String.valueOf(editTextMobile.getText());
        String pincode = String.valueOf(editTextPincode.getText());
        String type = String.valueOf(spinnertype.getSelectedItem());
        if (!TextUtils.isEmpty(address)) {
            String id = databaseArtist.push().getKey();

            UserData userData = new UserData(address, area, mobile, pincode, type);

            databaseArtist.child(id).setValue(userData);

            Toast.makeText(this, "Thank You for helping", Toast.LENGTH_LONG).show();
            startActivity(new Intent(Activity2.this, Dashboard.class));

        } else {
            Toast.makeText(this, "You should enter name", Toast.LENGTH_SHORT).show();

        }
    }




}