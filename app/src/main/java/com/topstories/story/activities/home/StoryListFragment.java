package com.topstories.story.activities.home;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arasthel.asyncjob.AsyncJob;
import com.topstories.story.R;
import com.topstories.story.model.Story;
import com.topstories.story.utils.Gen;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StoryListFragment extends Fragment {

    @BindView(R.id.story_listing_recycler_view_id)
    public RecyclerView recyclerView;
    public StoryListAdapter adapter;
    public List<Story> stories = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_story_listing, container, false);
        ButterKnife.bind(this, view);
        adapter = new StoryListAdapter(stories, getActivity());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        Gen.showLoader(getActivity());
        prepareDataAsync();

        return view;
    }

    public void prepareDataAsync() {
        AsyncJob.doInBackground(new AsyncJob.OnBackgroundJob() {
            @Override
            public void doOnBackground() {
                prepareData();
                AsyncJob.doOnMainThread(new AsyncJob.OnMainThreadJob() {
                    @Override
                    public void doInUIThread() {
                        adapter.notifyDataSetChanged();
                        Gen.hideLoader(getActivity());
                    }
                });
            }
        });
    }

    public void prepareData() {
        for (int i = 0; i < 100; i++) {
            stories.add(new Story());
        }
    }
}
