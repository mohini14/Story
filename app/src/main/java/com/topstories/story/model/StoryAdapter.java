package com.topstories.story.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.topstories.story.MyApplication;
import com.topstories.story.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StoryAdapter extends ArrayAdapter<Story> {

    public StoryAdapter(Context context) {
        super(context, 0);
    }

    @Override
    public View getView(int position, View contentView, ViewGroup parent) {
        ViewHolder holder;

        if (contentView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            contentView = inflater.inflate(R.layout.activity_story_description, parent, false);
            holder = new ViewHolder(contentView);
            contentView.setTag(holder);
        } else {
            holder = (ViewHolder) contentView.getTag();
        }

        Story currentStory = getItem(position);

        Picasso.with(getContext())
                .load(currentStory.getMainImageUrl())
                .error(R.drawable.loading)
                .placeholder(R.drawable.loading)
                .into(holder.imageView);

        holder.titleTextView.setText(currentStory.getTitle());
        holder.descriptionTextView.setText(currentStory.getDescription());
        holder.descriptionTextView.setLineSpacing(20, 1);
//        descriptionTextView.setLetterSpacing(0.05f);
        holder.generesView.setText(currentStory.getGeneresText());
        holder.authorView.setText(currentStory.getAuthorBioText());
        holder.likesCountTextView.setText(currentStory.likesCountText());
        holder.dislikesCountTextView.setText(currentStory.dislikesCountText());
        holder.whatsappCountTextView.setText(currentStory.lovedCountText());
        holder.shareCountTextView.setText(currentStory.lovedCountText());
        holder.viewsCountTextView.setText(currentStory.viewsCountText());

        // setting language spinner
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item,  currentStory.getLanguages());
        holder.languageSpinner.setAdapter(arrayAdapter);

        return contentView;
    }

    public static class ViewHolder {
        public Story story;

        @BindView(R.id.story_description_image_view_id)
        public ImageView imageView;
        @BindView(R.id.story_description_title_id)
        public TextView titleTextView;
        @BindView(R.id.story_description_description_id)
        public TextView descriptionTextView;
        @BindView(R.id.story_description_generes_view_id)
        public TextView generesView;
        @BindView(R.id.story_description_author_view_id)
        public TextView authorView;
        @BindView(R.id.story_description_likes_count_id)
        public TextView likesCountTextView;
        @BindView(R.id.story_description_dislikes_count_id)
        public TextView dislikesCountTextView;
        @BindView(R.id.story_description_whatsapp_count_id)
        public TextView whatsappCountTextView;
        @BindView(R.id.story_description_share_count_id)
        public TextView shareCountTextView;
        @BindView(R.id.story_description_views_count_id)
        public TextView viewsCountTextView;
        @BindView(R.id.story_description_share_count_image_id)
        public ImageView shareCountImageView;
        @BindView(R.id.story_description_whatsapp_count_image_id)
        public ImageView whatsappCountImageView;
        @BindView(R.id.story_description_language_spinner_id)
        public Spinner languageSpinner;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}

