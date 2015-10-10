package com.example.androidchoi.kakaopractice;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FriendListFragment extends Fragment {

    ListView mListView;
    FriendListAdapter mAdapter;
    List<Profile> mProfileList;

    public FriendListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_friends_list, container, false);
    }

    @Override
        public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();
        mAdapter = new FriendListAdapter(mProfileList);
        mListView = (ListView)getActivity().findViewById(R.id.listView);
        mListView.setAdapter(mAdapter);
    }

    private void initData() {

        String[] name = getResources().getStringArray(R.array.list_name);
        String[] message = getResources().getStringArray(R.array.list_message);
        TypedArray profileImage = getResources().obtainTypedArray(R.array.profile);

        mProfileList = new ArrayList<Profile>();
        for(int i=0; i<name.length; i++){
            Profile profile = new Profile();
            profile.name = name[i];
            profile.message = message[i];
            profile.profileImage = profileImage.getResourceId(i,-1);
            mProfileList.add(profile);
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            getActivity().setTitle("친구");
        }
    }
}
