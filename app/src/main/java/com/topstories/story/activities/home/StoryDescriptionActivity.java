package com.topstories.story.activities.home;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.topstories.story.R;
import com.topstories.story.model.Story;
import com.topstories.story.utils.SavedInstance;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StoryDescriptionActivity extends AppCompatActivity {

    public Story currentStory;

    @BindView(R.id.story_description_image_view_id) public ImageView imageView;
    @BindView(R.id.story_description_title_id) public TextView titleTextView;
    @BindView(R.id.story_description_description_id) public TextView descriptionTextView;
    @BindView(R.id.story_description_generes_view_id) public TextView generesView;
    @BindView(R.id.story_description_author_view_id) public TextView authorView;
    @BindView(R.id.story_description_likes_count_id) public TextView likesCountTextView;
    @BindView(R.id.story_description_dislikes_count_id) public TextView dislikesCountTextView;
    @BindView(R.id.story_description_loves_count_id) public TextView lovedCountTextView;
    @BindView(R.id.story_description_views_count_id) public TextView viewsCountTextView;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_description);
        ButterKnife.bind(this);
        currentStory = SavedInstance.getInstance().selectedStory;

        Picasso.with(this)
                .load(currentStory.getMainImageUrl())
                .error(R.drawable.loading)
                .placeholder(R.drawable.loading)
                .into(imageView);

        titleTextView.setText(currentStory.getTitle());
        descriptionTextView.setText(currentStory.getDescription());
        descriptionTextView.setLineSpacing(20,1);
//        descriptionTextView.setLetterSpacing(0.05f);
        generesView.setText(currentStory.getGeneresText());
        authorView.setText(currentStory.getAuthorBioText());
        likesCountTextView.setText(currentStory.likesCountText());
        dislikesCountTextView.setText(currentStory.dislikesCountText());
        lovedCountTextView.setText(currentStory.lovedCountText());
        viewsCountTextView.setText(currentStory.viewsCountText());
    }

}
