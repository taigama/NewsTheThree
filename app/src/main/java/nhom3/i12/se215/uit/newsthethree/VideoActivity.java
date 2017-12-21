package nhom3.i12.se215.uit.newsthethree;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {


    VideoView mVideoView;
    MediaController mMediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        mVideoView = (VideoView)findViewById(R.id.view_video);


        mMediaController = new MediaController(this);

        setTitle("");

        playVideo();
    }


    public void playVideo(){
        String videoPath = "android.resource://nhom3.i12.se215.uit.newsthethree/" + R.raw.ngontay;
        Uri uri = Uri.parse(videoPath);
        mVideoView.setVideoURI(uri);
        mVideoView.setMediaController(mMediaController);
        mMediaController.setAnchorView(mVideoView);
        mVideoView.start();
    }
}
