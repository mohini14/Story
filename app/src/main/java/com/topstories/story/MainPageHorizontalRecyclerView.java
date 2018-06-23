package com.topstories.story;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.topstories.story.utils.DownloadImage;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainPageHorizontalRecyclerView extends RecyclerView.Adapter<MainPageHorizontalRecyclerView.RecyclerviewHolder> {

    List<String> mListData;
    Context mContext;

    MainPageHorizontalRecyclerView(List<String> data, Context con) {
        mListData = data;
        mContext = con;
    }

    @NonNull
    @Override
    public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_rtecyclerview_cell, parent, false);
        return new MainPageHorizontalRecyclerView.RecyclerviewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, int position) {
        Picasso.with(mContext)
                .load(mListData.get(position)).placeholder(R.drawable.loading_mark)
                //.memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)

                .into(holder.imageView);

//        holder.imageView.setTag(mListData.get(position));
//        new DownloadImage().execute(holder.imageView);
    }
//    holder.imageView.setBackground(ContextCompat.getDrawable(mContext, R.drawable.my_image));

    @Override
    public int getItemCount() {
        return mListData.size();
    }

    public class RecyclerviewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image_view)
        ImageView imageView;

        public RecyclerviewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
