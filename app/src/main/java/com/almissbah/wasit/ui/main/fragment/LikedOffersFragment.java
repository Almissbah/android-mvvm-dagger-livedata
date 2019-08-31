package com.almissbah.wasit.ui.main.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.almissbah.wasit.R;
import com.almissbah.wasit.data.local.db.entity.OfferEntity;
import com.almissbah.wasit.data.repo.AppRepo;
import com.almissbah.wasit.data.repo.DemoRepo;
import com.almissbah.wasit.databinding.LikedOffersFragmentBinding;
import com.almissbah.wasit.ui.base.BaseFragment;
import com.almissbah.wasit.ui.main.adapter.OffersAdapter;
import com.almissbah.wasit.ui.main.viewmodel.LikedOffersViewModel;
import dagger.android.support.DaggerFragment;

import javax.inject.Inject;
import java.util.List;

public class LikedOffersFragment extends BaseFragment {
    private LikedOffersFragmentBinding mBinding;
    private LikedOffersViewModel mViewModel;
    @Inject
    AppRepo repository;
    public static LikedOffersFragment newInstance() {
        return new LikedOffersFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(
                inflater, R.layout.liked_offers_fragment, container, false);

        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(LikedOffersViewModel.class);
        mViewModel.setRepository(repository);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        OffersAdapter offersAdapter = new OffersAdapter();
        mBinding.recyclerView.setAdapter(offersAdapter);
        mViewModel.getLikedOffers().observe(this, new Observer<List<OfferEntity>>() {
            @Override
            public void onChanged(@Nullable List<OfferEntity> offerEntities) {

                offersAdapter.setOfferEntities(offerEntities);
                offersAdapter.notifyDataSetChanged();
            }
        });
    }


}
