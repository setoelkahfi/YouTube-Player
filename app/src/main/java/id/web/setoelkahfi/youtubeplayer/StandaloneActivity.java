package id.web.setoelkahfi.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener {
    private String GOOGLE_API_KEY = "AIzaSyDmmiYY2RvWvK6WBULUuD6YR8igW86GyJA";
    private String YOUTUBE_VIDEO_ID = "mcdPDVRwYlo";
    private String YOUTUBE_PLAYLIST = "PLTHOlLMWEwVy2ZNmdrwRlRlVfZ8fiR_ms";

    private Button buttonPlayVideo;
    private Button buttonPlayPlaylist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttonPlayVideo = (Button) findViewById(R.id.buttonPlayVideo);
        buttonPlayPlaylist = (Button) findViewById(R.id.buttonPlaylist);

        buttonPlayVideo.setOnClickListener(this);
        buttonPlayPlaylist.setOnClickListener(this);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.buttonPlayVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, GOOGLE_API_KEY, YOUTUBE_VIDEO_ID);
                break;
            case R.id.buttonPlaylist:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, GOOGLE_API_KEY, YOUTUBE_PLAYLIST);
                break;
            default:
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
