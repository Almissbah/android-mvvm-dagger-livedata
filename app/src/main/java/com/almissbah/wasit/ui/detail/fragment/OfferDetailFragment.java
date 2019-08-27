package com.almissbah.wasit.ui.detail.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.almissbah.wasit.R;
import com.almissbah.wasit.data.local.db.entity.OfferEntity;
import com.almissbah.wasit.data.repo.DemoRepo;
import com.almissbah.wasit.databinding.FragmentOfferDetailBinding;
import com.almissbah.wasit.ui.detail.viewmodel.OfferDetailViewModel;
import dagger.android.support.DaggerFragment;

import javax.inject.Inject;


public class OfferDetailFragment extends DaggerFragment {
    private int offer_id;
    public static String OFFER_ID = "offer_id";
    private FragmentOfferDetailBinding mBinding;
    private OfferDetailViewModel offerDetailViewModel;
    @Inject
    DemoRepo repository;
    public OfferDetailFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_offer_detail, container, false);
        offerDetailViewModel = ViewModelProviders.of(this).get(OfferDetailViewModel.class);
        offer_id = getArguments().getInt(OFFER_ID);
        offerDetailViewModel.setRepository(repository);
        offerDetailViewModel.getOfferById(offer_id).observe(this, new Observer<OfferEntity>() {
            @Override
            public void onChanged(@Nullable OfferEntity offerEntity) {
                mBinding.setOffer(offerEntity);
            }
        });
        return mBinding.getRoot();
    }


}
