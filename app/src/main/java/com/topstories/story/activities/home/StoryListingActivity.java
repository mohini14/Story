package com.topstories.story.activities.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.topstories.story.R;
import com.topstories.story.model.Story;

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
        prepareData();

    }

    public void prepareData(){
        for (int i = 0 ; i < 100 ; i++){
            stories.add(new Story());
        }

        adapter.notifyDataSetChanged();
    }


}
