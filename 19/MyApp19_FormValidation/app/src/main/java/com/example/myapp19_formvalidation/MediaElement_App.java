package com.example.myapp19_formvalidation;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MediaElement_App extends AppCompatActivity {
VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_element_app);
        videoView = findViewById(R.id.video);
        MediaController mediaController = new MediaController(MediaElement_App.this);
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.videoplayback);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.start();

    }
}