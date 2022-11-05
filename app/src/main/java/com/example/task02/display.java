package com.example.task02;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class display extends AppCompatActivity{
    private VideoView videoView;
    private TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        videoView = findViewById(R.id.videoViewID);
        txtView = findViewById(R.id.txtViewId);

        Bundle bundle;
        bundle = getIntent().getExtras();
        if(bundle!=null){
            String provinceName = bundle.getString("name");
            showDetails(provinceName);
        }
    }

    void showDetails(String provName) {
        if (provName.equals("nwt")){
            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.nwt);
            videoView.setVideoURI(uri);
            txtView.setText(R.string.nwt_disp);
        }
        if (provName.equals("ns")){
            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ns);
            videoView.setVideoURI(uri);
            txtView.setText(R.string.ns_disp);
        }
        if (provName.equals("pei")){
            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.pei);
            videoView.setVideoURI(uri);
            txtView.setText(R.string.pei_disp);
        }
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
    }
}
