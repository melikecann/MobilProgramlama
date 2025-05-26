package com.example.bluetoothwifikamerabalama;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Camera extends AppCompatActivity {
    private static final int VIDEO_ACTION_CODE = 101;
    private static final int IMAGE_ACTION_CODE = 102;
    private static final int CAMERA_PERMISSION_CODE = 100;

    private Button b5, b6;
    private ImageView imageView;
    private VideoView videoView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_camera);

        b5 = findViewById(R.id.btn_resimCek);
        b6 = findViewById(R.id.btn_videoCek);
        imageView = findViewById(R.id.imageView);
        videoView = findViewById(R.id.videoView);

        b5.setOnClickListener(v -> {
            if (checkCameraPermission()) {
                captureImage();
            }
        });

        b6.setOnClickListener(v -> {
            if (checkCameraPermission()) {
                captureVideo();
            }
        });
    }

    private boolean checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA},
                    CAMERA_PERMISSION_CODE);
            return false;
        }
        return true;
    }

    private void captureImage() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, IMAGE_ACTION_CODE);
        }
    }

    private void captureVideo() {
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takeVideoIntent, VIDEO_ACTION_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK || data == null) return;

        if (requestCode == IMAGE_ACTION_CODE) {
            Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(imageBitmap);
        } else if (requestCode == VIDEO_ACTION_CODE) {
            Uri videoUri = data.getData();
            videoView.setVideoURI(videoUri);
            videoView.setMediaController(new MediaController(this));
            videoView.requestFocus();
            videoView.start();
        }
    }

    // Kullanıcı izin verirse işlem devam etsin
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Kamera izni verildi", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Kamera izni reddedildi", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
