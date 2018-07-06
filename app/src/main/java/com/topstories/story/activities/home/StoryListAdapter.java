package com.topstories.story.activities.home;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.topstories.story.MyApplication;
import com.topstories.story.R;
import com.topstories.story.model.Story;
import com.topstories.story.utils.Gen;
import com.topstories.story.utils.SavedInstance;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StoryListAdapter extends  RecyclerView.Adapter<StoryListAdapter.StoryListViewHolder> {

    public List<Story> stories;
    public Context context;

    @NonNull
    @Override
    public StoryListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.story_list_recycler_view_cell, parent, false);
        return new StoryListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final StoryListViewHolder holder, int position) {
        holder.story = stories.get(position);

        Picasso.with(context)
                .load(holder.story.getThumbNailUrl())
                .error(R.drawable.loading)
                .placeholder(R.drawable.loading)
                .into(holder.imageView);
        holder.titleTextView.setText(holder.story.getTitle());
        holder.descriptionTextView.setText(holder.story.getShortDescription());
        holder.authorTextView.setText(holder.story.getAuthor());
        holder.viewCountTextView.setText(holder.story.viewsCountText());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SavedInstance.getInstance().selectedStory = holder.story;
                Gen.startActivity((Activity) context, false, StoryDescriptionActivity.class);
            }
        });



    }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    public StoryListAdapter(List<Story> stories, Context context){
        this.stories = stories;
        this.context = context;
    }

    public class StoryListViewHolder extends RecyclerView.ViewHolder {

        public Story story;

        @BindView(R.id.story_list_cell_image_view_id) public ImageView imageView;
        @BindView(R.id.story_list_cell_title_view_id)public TextView titleTextView;
        @BindView(R.id.story_list_cell_description_view_id)public TextView descriptionTextView;
        @BindView(R.id.story_list_cell_author_view_id)public TextView authorTextView;
        @BindView(R.id.story_list_cell_layout_id)public ConstraintLayout layout;
        @BindView(R.id.story_list_cell_view_count_view_id) public TextView viewCountTextView;
        public StoryListViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
