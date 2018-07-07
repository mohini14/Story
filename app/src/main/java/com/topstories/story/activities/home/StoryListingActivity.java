package com.topstories.story.activities.home;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arasthel.asyncjob.AsyncJob;
import com.topstories.story.R;
import com.topstories.story.model.Story;
import com.topstories.story.utils.Gen;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StoryListingActivity extends AppCompatActivity {

    public List<Story> stories = new ArrayList<>();
    @BindView(R.id.story_listing_recycler_view_id) public RecyclerView recyclerView;
    public StoryListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_listing);
        ButterKnife.bind(this);

        adapter = new StoryListAdapter(stories, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        Gen.showLoader(this);
        prepareDataAsync();


    }

    public void prepareDataAsync() {
        final Activity activity = this;
        AsyncJob.doInBackground(new AsyncJob.OnBackgroundJob() {
            @Override
            public void doOnBackground() {
                prepareData();
                AsyncJob.doOnMainThread(new AsyncJob.OnMainThreadJob() {
                    @Override
                    public void doInUIThread() {
                        Gen.hideLoader(activity);
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    public void prepareData(){
        for (int i = 0 ; i < 100 ; i++){
            stories.add(new Story());
        }
    }


}
