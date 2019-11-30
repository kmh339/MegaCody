package org.androidtown.megacody;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class CodyActivity extends AppCompatActivity {
    ImageView imageView;
    CameraActivity cameraActivity = new CameraActivity();

    String url = cameraActivity.getDownloadURL();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cody);
        Toast.makeText(this, "my" + url, Toast.LENGTH_SHORT).show();
        loadWithGlide();



    }

    public void loadWithGlide(){
        imageView = findViewById(R.id.codyImageView);
        // Reference to an image file in Cloud Storage
        StorageReference storageReference = FirebaseStorage.getInstance().getReference();


        // Download directly from StorageReference using Glide
        // (See MyAppGlideModule for Loader registration)
        Glide.with(CodyActivity.this).load("https://firebasestorage.googleapis.com/v0/b/megacody-578e9.appspot.com/o/images%2Ftest.jpg?alt=media&token=826b0b9b-4400-48f8-bfad-79e404b61976").into(imageView);
        //Glide.with(CodyActivity.this).load(url).into(imageView);


    }
}
