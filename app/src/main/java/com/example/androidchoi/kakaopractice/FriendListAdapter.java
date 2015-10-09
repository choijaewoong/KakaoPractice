package com.example.androidchoi.kakaopractice;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Choi on 2015-10-09.
 */
public class FriendListAdapter extends BaseAdapter{

    List<Profile> mProfiles = new ArrayList<Profile>();

//    public void add(Profile profile){
//        mProfiles.add(profile);
//        notifyDataSetChanged(); //데이터 변경을 알림
//    }

    public FriendListAdapter(List<Profile> profiles) {
        mProfiles = profiles;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mProfiles.size();
    }

    @Override
    public Object getItem(int position) {
        return mProfiles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ProfileView view;

        if(convertView == null){
            view = new ProfileView(parent.getContext());
        }else{
            view = (ProfileView)convertView;
        }
        view.setProfileData(mProfiles.get(position));
        return view;
    }
}
