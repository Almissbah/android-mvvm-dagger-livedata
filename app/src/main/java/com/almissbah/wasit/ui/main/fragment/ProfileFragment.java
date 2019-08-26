package com.almissbah.wasit.ui.main.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.almissbah.wasit.R;
import com.almissbah.wasit.data.local.entity.OfferEntity;
import com.almissbah.wasit.databinding.ProfileFragmentBinding;
import com.almissbah.wasit.ui.main.viewmodel.ProfileViewModel;
import dagger.android.support.DaggerFragment;

import javax.inject.Inject;

public class ProfileFragment extends DaggerFragment {
    private ProfileFragmentBinding mBinding;
    private ProfileViewModel mViewModel;
    @Inject
    public String offerEntity;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.profile_fragment, container, false);
        mBinding.tvName.setText(offerEntity);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ProfileViewModel.class);
        // TODO: Use the ViewModel
    }

}
