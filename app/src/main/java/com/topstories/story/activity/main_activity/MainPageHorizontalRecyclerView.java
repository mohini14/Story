package com.topstories.story.activity.main_activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.topstories.story.R;
import com.topstories.story.model.MainPageData;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainPageHorizontalRecyclerView extends RecyclerView.Adapter<MainPageHorizontalRecyclerView.RecyclerviewHolder> {

    private MainPageData mData;
    private Context mContext;

    MainPageHorizontalRecyclerView(MainPageData data, Context con) {
        mData = data;
        mContext = con;
    }

    @NonNull
    @Override
    public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_recyclerview_cell, parent, false);
        return new MainPageHorizontalRecyclerView.RecyclerviewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, int position) {
        Picasso.with(mContext)
                .load(mData.getImageURLList().get(position)).placeholder(R.drawable.loading)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mData.getImageURLList().size();
    }

    public class RecyclerviewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.horizontal_cell_image_view_id)
        ImageView imageView;

        RecyclerviewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

