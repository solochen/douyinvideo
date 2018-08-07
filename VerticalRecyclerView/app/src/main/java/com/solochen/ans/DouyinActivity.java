package com.solochen.ans;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

import com.solochen.ans.adapter.DouyinAdapter;
import com.solochen.ans.listener.OnViewPagerListener;
import com.solochen.ans.widget.ViewPagerLayoutManager;

/**
 * Created by chenshaolong on 2018/8/7.
 */

public class DouyinActivity extends AppCompatActivity implements OnViewPagerListener {

    RecyclerView mRecyclerView;
    ViewPagerLayoutManager mLayoutManager;
    DouyinAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_douyin);

        initView();
        initListener();

    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mLayoutManager = new ViewPagerLayoutManager(this, OrientationHelper.VERTICAL);
        mAdapter = new DouyinAdapter(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initListener() {
        mLayoutManager.setOnViewPagerListener(this);
    }

    @Override
    public void onInitComplete() {
        playVideo(0);
    }

    @Override
    public void onPageRelease(boolean isNext, int position) {
        int index = 0;
        if (isNext) {
            index = 0;
        } else {
            index = 1;
        }
        releaseVideo(index);
    }

    @Override
    public void onPageSelected(int position, boolean isBottom) {
        playVideo(0);
    }


    private void playVideo(int position) {
        View itemView = mRecyclerView.getChildAt(0);
        final VideoView videoView = itemView.findViewById(R.id.video_view);
        final ImageView imgThumb = itemView.findViewById(R.id.img_thumb);
        final MediaPlayer[] mediaPlayer = new MediaPlayer[1];
        videoView.start();
        videoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {
                mediaPlayer[0] = mp;
                mp.setLooping(true);
                imgThumb.animate().alpha(0).setDuration(200).start();
                return false;
            }
        });
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

            }
        });
    }

    private void releaseVideo(int index) {
        View itemView = mRecyclerView.getChildAt(index);
        final VideoView videoView = itemView.findViewById(R.id.video_view);
        final ImageView imgThumb = itemView.findViewById(R.id.img_thumb);
        videoView.stopPlayback();
        imgThumb.animate().alpha(1).start();
    }

}
