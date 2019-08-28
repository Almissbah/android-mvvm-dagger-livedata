package com.almissbah.wasit.ui.main.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.almissbah.wasit.R;
import com.almissbah.wasit.data.local.pref.User;
import com.almissbah.wasit.data.repo.DemoRepo;
import com.almissbah.wasit.databinding.ProfileFragmentBinding;
import com.almissbah.wasit.ui.main.viewmodel.ProfileViewModel;
import com.squareup.picasso.Picasso;
import dagger.android.support.DaggerFragment;

import javax.inject.Inject;

public class ProfileFragment extends DaggerFragment {
    private ProfileFragmentBinding mBinding;
    private ProfileViewModel mViewModel;
    @Inject
    DemoRepo repository;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.profile_fragment, container, false);
        Picasso.get().load(R.drawable.offer_image_3).into(mBinding.userImage);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ProfileViewModel.class);
        mViewModel.setRepository(repository);
        mViewModel.getAppUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                mBinding.tvName.setText(user.getName());
            }
        });
        // TODO: Use the ViewModel
    }

}
