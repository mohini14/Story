package com.topstories.story.activities.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.topstories.story.R;
import com.topstories.story.activities.download.DownloadFragment;
import com.topstories.story.activities.search.SearchFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener,
        HomeFragment.SendCategorySelected {


    @Nullable
    @BindView(R.id.my_toolbar)
    Toolbar mToolbar;


    @BindView(R.id.bottom_navigation_view)
    BottomNavigationView mBottomNavigationView;

    private Unbinder mUnBinder;
    public static int SEARCH_FRAGMENT_TAG = 10000;
    public static int DOWNLOAD_FRAGMENT_TAG = 2000;
    public static int HOME_FRAGMENT_TAG = 30000;
    public static int STORY_LISTING_FRAGMENT_TAG = 40000;

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

    private void setUpLauyout() {
        mUnBinder = ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);

        // add Home frag activity by default
        addFragmentOnHomeActivity(new HomeFragment(), HOME_FRAGMENT_TAG);
    }

    /**
     * Method to add fragment on home view container
     *
     * @param fragment : frag class
     * @param tag      : tag of frag defined in Home class
     */
    private void addFragmentOnHomeActivity(Fragment fragment, int tag) {
        android.support.v4.app.Fragment fragExists = getSupportFragmentManager().findFragmentByTag(String.valueOf(tag));
        if (fragExists == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//            transaction.addToBackStack(String.valueOf(tag));
            transaction.replace(R.id.home_frag_container, fragment, String.valueOf(tag));
            transaction.commit();
        }
    }

    /**
     * Method to remove all fragments from container
     */
    private void removeAllFragFromActivity() {
        FragmentManager fm = getSupportFragmentManager();

        for (int i = 0; i < fm.getBackStackEntryCount(); i++) {
            fm.popBackStack();
        }

    }

    /**
     * Method invoked as item listener for bottom navigation view items
     *
     * @param item : item clecked
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                addFragmentOnHomeActivity(new HomeFragment(), HOME_FRAGMENT_TAG);
                break;
            case R.id.navigation_search:
                addFragmentOnHomeActivity(new SearchFragment(), SEARCH_FRAGMENT_TAG);
                break;
            case R.id.navigation_downloads:
                addFragmentOnHomeActivity(new DownloadFragment(), DOWNLOAD_FRAGMENT_TAG);
                break;
            default:
                break;
        }
        return false;
    }

    @Override
    public void sendCategorySelected(String category) {
        addFragmentOnHomeActivity(new StoryListFragment(), STORY_LISTING_FRAGMENT_TAG);
        ((TextView)findViewById(R.id.custom_toolbar_text_view_id)).setText(category);
    }
}
