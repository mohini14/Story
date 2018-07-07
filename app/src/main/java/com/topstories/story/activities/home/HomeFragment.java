package com.topstories.story.activities.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arasthel.asyncjob.AsyncJob;
import com.topstories.story.R;
import com.topstories.story.model.MainPageData;
import com.topstories.story.utils.Gen;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment {
    @BindView(R.id.parent_recycler_view)
    RecyclerView mMainPageRecyclerView;

    public List<MainPageData> mainPageDataList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        setUpLayout(root);
        return root;
    }

    private void setUpLayout(View v){
        ButterKnife.bind(this, v);
        mMainPageRecyclerView.setHasFixedSize(true);
        mMainPageRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Gen.showLoader(getActivity());
        AsyncJob.doInBackground(new AsyncJob.OnBackgroundJob() {
            @Override
            public void doOnBackground() {
                mainPageDataList = new MainPageData().getData();
                AsyncJob.doOnMainThread(new AsyncJob.OnMainThreadJob() {
                    @Override
                    public void doInUIThread() {
                        Gen.hideLoader(getActivity());
                        mMainPageRecyclerView.setAdapter(new MainActivityRecyclerView(mainPageDataList, getActivity()));
                    }
                });
            }
        });

    }

    interface SendCategorySelected{
        void sendCategorySelected(String category);
    }

}
