package com.example.androidchoi.kakaopractice;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    public static final String TAG_INDEX = "tagIndex";
    TabHost mTabHost;
    ViewPager mPager;
    TabsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabHost = (TabHost)findViewById(R.id.tabHost);
        mTabHost.setup(); //등록
        mPager = (ViewPager)findViewById(R.id.pager);
        mAdapter = new TabsAdapter(this, getSupportFragmentManager(), mTabHost, mPager);

        mAdapter.addTab(mTabHost.newTabSpec("tab1").setIndicator("친구"), FriendListFragment.class, null);
        mAdapter.addTab(mTabHost.newTabSpec("tab2").setIndicator("채팅"), ChatListFragment.class, null);
        mAdapter.addTab(mTabHost.newTabSpec("tab3").setIndicator("채널"), NewsFragment.class, null);
        mAdapter.addTab(mTabHost.newTabSpec("tab4").setIndicator("더보기"), MoreFragment.class, null);

        if(savedInstanceState != null){
            mTabHost.setCurrentTab(savedInstanceState.getInt(TAG_INDEX));
            mAdapter.onRestoreInstanceState(savedInstanceState);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt(TAG_INDEX, mTabHost.getCurrentTab());
        mAdapter.onSaveInstanceState(outState);
    }
}
