package org.androidtown.megacody;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.androidtown.megacody.CameraActivity;

public class CodyActivity extends AppCompatActivity {
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;

    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cody);

        loadWithGlide();

    }

    public void loadWithGlide(){
        imageView1 = (ImageView)findViewById(R.id.imageView1);
        imageView2 = (ImageView)findViewById(R.id.imageView2);
        imageView3 = (ImageView)findViewById(R.id.imageView3);
        imageView4 = (ImageView)findViewById(R.id.imageView4);
        imageView5 = (ImageView)findViewById(R.id.imageView5);
        imageView6 = (ImageView)findViewById(R.id.imageView6);


        // Reference to an image file in Cloud Storage



        for(i=1; i<4; i++){
            StorageReference storageReference = FirebaseStorage.getInstance().getReference();
            StorageReference imageRef = storageReference.child("codylist/T3W01M_"+ i +".jpg");
            // Log.d(this.getClass().getName(), imageRef.toString());
            switch (i){
                case 1:
                    imageRef.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                        @Override
                        public void onComplete(@NonNull Task<Uri> task) {
                            if(task.isSuccessful()){
                                Glide.with(CodyActivity.this).load(task.getResult()).into(imageView1);
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
                                Glide.with(CodyActivity.this).load(task.getResult()).into(imageView2);
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
                                Glide.with(CodyActivity.this).load(task.getResult()).into(imageView3);
                            }else{
                            }
                        }
                    });
                    break;
            }

        }

        for(i=1; i<4; i++){
            StorageReference storageReference = FirebaseStorage.getInstance().getReference();
            StorageReference imageRef = storageReference.child("codylist/T3W01W_"+ i +".jpg");
            // Log.d(this.getClass().getName(), imageRef.toString());
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

        //StorageReference image = storageReference.child("images/test.jpg");

        // Download directly from StorageReference using Glide
        // (See MyAppGlideModule for Loader registration)

        //Glide.with(CodyActivity.this).load(image).into(imageView);
       // Log.d(this.getClass().getName(), "my url2 : " + image.toString());


}

