package org.androidtown.megacody;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;

public class CodyActivity extends AppCompatActivity {
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;

    private ImageButton backbutton;
    int i;
    int j = 0;
    private String[] strings = new String[30];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cody);

        // 데이터베이스 읽기 #1. ValueEventListener
        FirebaseDatabase.getInstance().getReference().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    strings[j] = (String) snapshot.getValue();
                    Log.d("MainActivity", strings[j]);
                    j++;


                }

                imageView4 = (ImageView)findViewById(R.id.imageView4);
                imageView5 = (ImageView)findViewById(R.id.imageView5);
                imageView6 = (ImageView)findViewById(R.id.imageView6);
                // imageView4 = (ImageView)findViewById(R.id.imageView4);
                // imageView5 = (ImageView)findViewById(R.id.imageView5);
                // imageView6 = (ImageView)findViewById(R.id.imageView6);


                // Reference to an image file in Cloud Storage



                for(i=1; i<4; i++){
                    StorageReference storageReference = FirebaseStorage.getInstance().getReference();
                    StorageReference imageRef = storageReference.child(strings[i]);
                    Log.d(this.getClass().getName(), imageRef.toString());
                    switch (i){
                        case 1:
                            imageRef.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    if(task.isSuccessful()){
                                        Glide.with(CodyActivity.this).load(task.getResult()).into(imageView4);
                                    }else{
                                    }
                                }
                            });
                            break;
                        case 2:
                            imageRef.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    if(task.isSuccessful()){
                                        Glide.with(CodyActivity.this).load(task.getResult()).into(imageView5);
                                    }else{
                                    }
                                }
                            });
                            break;
                        case 3:
                            imageRef.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    if(task.isSuccessful()){
                                        Glide.with(CodyActivity.this).load(task.getResult()).into(imageView6);
                                    }else{
                                    }
                                }
                            });
                            break;
                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //Log.d("MainActivity", strings[0]);
        //loadWithGlide();

        backbutton = findViewById(R.id.back_btn);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CodyActivity.this, CameraActivity.class));
                finish();
            }
        });

    }
}