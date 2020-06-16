package com.example.projectfood1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminNext extends AppCompatActivity {
DatabaseReference databaseReference;
ListView listViewData;
ImageView imageView,imageView2;
List<UserData> userDatalist;
private FirebaseStorage firebaseDatabase ;
private  StorageReference databaseReference1;
private  DatabaseReference first;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);int count = 0;
        setContentView(R.layout.activity_admin_next);
    databaseReference = FirebaseDatabase.getInstance().getReference("food");
        firebaseDatabase = FirebaseStorage.getInstance();
        databaseReference1 = firebaseDatabase.getReferenceFromUrl("gs://projectfood1-92867.appspot.com/images").child("food.jpg");

        imageView = findViewById(R.id.imageViewData);

    listViewData = findViewById(R.id.listViewData);
    try{
        final File file = File.createTempFile("image","jpg");
        databaseReference1.getFile(file).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                imageView.setImageBitmap(bitmap);
                imageView2.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AdminNext.this, "Image failed to load", Toast.LENGTH_SHORT).show();
            }
        });
    } catch (IOException e) {
        e.printStackTrace();
    }
        userDatalist = new ArrayList<>();
    }



    @Override
    protected void onStart() {
        super.onStart();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userDatalist.clear();

                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()){
                    UserData userdata = userSnapshot.getValue(UserData.class);
                    userDatalist.add(userdata);
                }

                Adapter adapte = new Adapter(AdminNext.this, userDatalist);
                listViewData.setAdapter(adapte);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }



}
