package com.example.projectfood1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Act4 extends AppCompatActivity {

    public Button button10;
public EditText et5;
public EditText et1,et2,et3,et4;
public RadioButton r1,r2;
//String user_name,user_pass,user_con;
//Context ctx=this;
//TextInputLayout etname,etemail,etpassword,etconfirm,etusername;
/*public DatabaseReference databaseReference;*/
   public String gender=null;
   // FirebaseAuth firebaseAuth;
   // SQLiteDatabase sqLiteDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act4);
        getSupportActionBar().setTitle("SignUp ");
       /* sqLiteDatabase=openOrCreateDatabase("Student", Context.MODE_PRIVATE,null);
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS studentable(fullname VARCHAR(56) ,username VARCHAR(56),email VARCHAR(56),password VARCHAR(56),cpassword VARCHAR(56));");
*/
        et5=(EditText)findViewById(R.id.etfullname);
        et1=(EditText)findViewById(R.id.etemail);
        et2=(EditText)findViewById(R.id.etpassword);
        et3=(EditText)findViewById(R.id.etconfirm);
        et4=(EditText)findViewById(R.id.etusername);
        r1=(RadioButton)findViewById(R.id.rbtmale);
        r2=(RadioButton)findViewById(R.id.rbtfemale);
        button10=(Button)findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(et1.getText().toString())){
                    Toast.makeText(Act4.this, "Please Enter Email Address", Toast.LENGTH_SHORT).show();
                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(et1.getText().toString()).matches()){
                    Toast.makeText(Act4.this, "Please Enter Valid Email Address", Toast.LENGTH_SHORT).show();
                }
                else  if(TextUtils.isEmpty(et2.getText().toString())){
                    Toast.makeText(Act4.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                }
                else if(et2.getText().toString().length()<6){
                    Toast.makeText(Act4.this, "Please Enter 6 or more than 6 digit Password", Toast.LENGTH_SHORT).show();
                }
                else  if(TextUtils.isEmpty(et5.getText().toString())){
                    Toast.makeText(Act4.this, "Please Enter Name", Toast.LENGTH_SHORT).show();
                }
                else{
                    registration();
                }
            }
        });

    /*    button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_name= et4.getText().toString();
                user_pass=et2.getText().toString();
                user_con=et3.getText().toString();

                if(!(user_pass.equalsIgnoreCase(user_con))){
                    Toast.makeText(getBaseContext(),"Password not matching",Toast.LENGTH_SHORT).show();
                    et4.setText("");
                    et2.setText("");
                    et3.setText("");

                }
                else
                {
                    DatabaseOperations DB=new DatabaseOperations(ctx);
                    DB.putInformation(DB,user_name,user_pass);
Act4.this.onClick(view);
                    Toast.makeText(getBaseContext(), "login success",Toast.LENGTH_SHORT).show();
                    finish();

                }



            }
        });
      // databaseReference=FirebaseDatabase.getInstance().getReference("FoodApp");
        //firebaseAuth=FirebaseAuth.getInstance();

//button10.setOnClickListener(this);

     *//*   button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String filename = et5.getText().toString();
                final String username = et4.getText().toString();
                final String email = et1.getText().toString();
                final String confirm = et3.getText().toString();
                final String password = et2.getText().toString();
                if (r1.isChecked()) {
                    gender = "Male";
                }
                if (r2.isChecked()) {
                    gender = "Female";
                }
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Act4.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Act4.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                }

                if (TextUtils.isEmpty(filename)) {
                    Toast.makeText(Act4.this, "Please Enter Name", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(Act4.this, "Please Enter Username", Toast.LENGTH_SHORT).show();
                }

               *//**//* firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Act4.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    Model info = new Model(filename, username, email, gender);
                                    FirebaseDatabase.getInstance().getReference("FoodApp").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(info).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            Toast.makeText(Act4.this, "Registration Completed", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(Act4.this, LoginUser.class));

                                        }
                                    });


                                }


                            }
                        });
*//**//**//**//*
                if (password.equals(confirm)) {
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Act4.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {

                                        startActivity(new Intent(Act4.this, LoginUser.class));

                                    } else {

                                    }

                                    // ...
                                }
                            });


                }
            }
    });*//**//*
            }
        });*//*
}

    public void onClick(View view) {
        if(view.getId()==R.id.button10){
            final String filename = et5.getText().toString();
            final String username = et4.getText().toString();
            final String email = et1.getText().toString();
            final String confirm = et3.getText().toString();
            final String password = et2.getText().toString();
            if(filename.equals("")||email.equals("")||username.equals("")||confirm.equals("")||password.equals("")){
                Toast.makeText(Act4.this, "Please Enter Proper Details", Toast.LENGTH_SHORT).show();
return;
            }
            else{
                sqLiteDatabase.execSQL("Insert Into studentable(fullname,username,email,password,cpassword)VALUES('"+filename+"','"+username+"','"+email+"','"+password+"','"+confirm+"'); ");
                Toast.makeText(Act4.this, "Record saved", Toast.LENGTH_SHORT).show();
                Cursor c=sqLiteDatabase.rawQuery(
                        "SELECT *FROM studentable",null);
                StringBuffer buffer=new StringBuffer();
                while (c.moveToNext()){
                    buffer.append(" name"+c.getString(1));
                    buffer.append("username"+c.getString(2));
                    buffer.append("email"+c.getString(3));
                }
            }
}*/
        }

    private void registration() {

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(et1.getText().toString(), et2.getText().toString())
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("email",et1.getText().toString());
                        map.put("password",et2.getText().toString());
                        map.put("name",et5.getText().toString());
                        map.put("male",r1.getText().toString());
                        map.put("female",r2.getText().toString());
                        FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getUid()).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(Act4.this, "Registration Successfull..", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Act4.this, LoginUser.class));
                                finish();
                            }
                        });


                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Act4.this, "Failed..", Toast.LENGTH_SHORT).show();
                    }
                });
    }


}