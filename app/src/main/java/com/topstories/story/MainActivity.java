package com.topstories.story;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import model.MainPageData;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.parent_recycler_view)
    RecyclerView mMainPageRecyclerView;

    private Unbinder mUnBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpLauyout();
    }

    @Override
    protected void onDestroy() {
        mUnBinder.unbind();
        super.onDestroy();
    }

    private void setUpLauyout(){

        mUnBinder = ButterKnife.bind(this);
        mMainPageRecyclerView.setHasFixedSize(true);
        mMainPageRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mMainPageRecyclerView.setAdapter(new MainActivityRecyclerView(new MainPageData().getData(), this));
    }
}
