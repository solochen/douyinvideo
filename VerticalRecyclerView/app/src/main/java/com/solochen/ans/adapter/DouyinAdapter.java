package com.solochen.ans.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.VideoView;

import com.solochen.ans.R;

/**
 * Created by chenshaolong on 2018/8/7.
 */

public class DouyinAdapter extends RecyclerView.Adapter<DouyinAdapter.ViewHolder> {

    private int[] imgs = {R.mipmap.img_video_1,R.mipmap.img_video_2};
    private int[] videos = {R.raw.video_1, R.raw.video_2};
    Context mContext;

    public DouyinAdapter(Context context){
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_pager, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.img_thumb.setImageResource(imgs[position%2]);
        holder.videoView.setVideoURI(Uri.parse("android.resource://" + mContext.getPackageName() + "/" + videos[position % 2]));
    }

    @Override
    public int getItemCount() {
        return 20;
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        VideoView videoView;
        ImageView img_thumb;

        public ViewHolder(View itemView) {
            super(itemView);
            img_thumb = itemView.findViewById(R.id.img_thumb);
            videoView = itemView.findViewById(R.id.video_view);
        }
    }

}
