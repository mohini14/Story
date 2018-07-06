package com.topstories.story.activities.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.topstories.story.R;
import com.topstories.story.model.Story;
import com.topstories.story.utils.SavedInstance;

import java.text.MessageFormat;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StoryDescriptionActivity extends AppCompatActivity {

    public static Story currentStory;


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
        descriptionTextView.setLineSpacing(20, 1);
//        descriptionTextView.setLetterSpacing(0.05f);
        generesView.setText(currentStory.getGeneresText());
        authorView.setText(currentStory.getAuthorBioText());
        likesCountTextView.setText(currentStory.likesCountText());
        dislikesCountTextView.setText(currentStory.dislikesCountText());
        whatsappCountTextView.setText(currentStory.lovedCountText());
        shareCountTextView.setText(currentStory.lovedCountText());
        viewsCountTextView.setText(currentStory.viewsCountText());

        // setting language spinner
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,  currentStory.getLanguages());
        languageSpinner.setAdapter(arrayAdapter);


        final StoryDescriptionActivity activity = this;

        whatsappCountImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.shareMessageOnWhatsapp(currentStory.getDescription().substring(0, 250));
            }
        });

        shareCountImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.shareIt(currentStory.getDescription().substring(0, 250));
            }
        });
    }

    private void shareIt(String message) {
        message = MessageFormat.format("{0}........\n\nRead more at: https://lolmenow.com", message);
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Real Short Tales: " + currentStory.getTitle());
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
        startActivity(Intent.createChooser(sharingIntent, "Tell your friends about this tale via.."));
    }

    private void shareMessageOnWhatsapp(String message) {
        String url = MessageFormat.format("whatsapp://send?text={0}.......\n\nRead more at: https://lolmenow.com", message);
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }



}
