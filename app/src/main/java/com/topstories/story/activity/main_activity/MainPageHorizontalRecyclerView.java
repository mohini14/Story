package com.topstories.story.activity.main_activity;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.topstories.story.R;
import com.topstories.story.model.MainPageData;
import com.topstories.story.model.Story;
import com.topstories.story.utils.Gen;
import com.topstories.story.utils.SavedInstance;

import java.util.List;

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
        holder.story = mData.getStories().get(position);
        final Story story = holder.story;
        Picasso.with(mContext)
                .load(holder.story.getThumbNailUrl())
                .error(R.drawable.loading)
                .placeholder(R.drawable.loading)
                .into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gen.makeShortToast(mContext, "Story clicked is " + story.getTitle());
                SavedInstance.getInstance().selectedStory = story;
                Gen.startActivity((Activity) mContext, false, StoryDescriptionActivity.class);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.getStories().size();
    }

    public class RecyclerviewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.horizontal_cell_image_view_id)
        ImageView imageView;

        private Story story;

        RecyclerviewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
