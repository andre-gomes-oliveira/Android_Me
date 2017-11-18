package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

public class MasterListFragment extends Fragment {

    // Tag for logging
    private static final String TAG = "MasterListFragment";
    public static final String IMAGE_ID_LIST = "image_ids";

    private List<Integer> mImageIds;
    private MasterListAdapter mListAdapter;
    private GridView mGridView;

    public void setImageIds(List<Integer> imageIds) {
        this.mImageIds = imageIds;
        mListAdapter = new MasterListAdapter(this.getContext(), mImageIds);
    }

    public MasterListFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        setImageIds(AndroidImageAssets.getAll());

        View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);

        mGridView = (GridView) rootView.findViewById(R.id.master_list_fragment);
        mGridView.setAdapter(mListAdapter);

        return rootView;
    }
}
