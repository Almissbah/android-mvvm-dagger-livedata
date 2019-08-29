package com.almissbah.wasit.ui.detail.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.almissbah.wasit.R;
import com.almissbah.wasit.ui.detail.viewmodel.OwnerDetailViewModel;

public class OwnerDetailFragment extends Fragment {

    private OwnerDetailViewModel mViewModel;

    public static OwnerDetailFragment newInstance() {
        return new OwnerDetailFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.owner_detail_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(OwnerDetailViewModel.class);
        // TODO: Use the ViewModel
    }

}
