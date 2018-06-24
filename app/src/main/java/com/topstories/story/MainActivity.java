package com.topstories.story;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.topstories.story.model.MainPageData;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.parent_recycler_view)
    RecyclerView mMainPageRecyclerView;

    @Nullable
    @BindView(R.id.my_toolbar)
    Toolbar mToolbar;

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

        setSupportActionBar(mToolbar);
        mMainPageRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mMainPageRecyclerView.setAdapter(new MainActivityRecyclerView(new MainPageData().getData(), this));
    }
}
