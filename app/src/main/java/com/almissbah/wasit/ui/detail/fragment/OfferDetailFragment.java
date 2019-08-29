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
import com.almissbah.wasit.data.repo.AppRepo;
import com.almissbah.wasit.data.repo.DemoRepo;
import com.almissbah.wasit.databinding.FragmentOfferDetailBinding;
import com.almissbah.wasit.ui.detail.viewmodel.OfferDetailViewModel;
import com.squareup.picasso.Picasso;
import dagger.android.support.DaggerFragment;

import javax.inject.Inject;

import static com.almissbah.wasit.ui.detail.DetailsActivity.OBJECT_ID;


public class OfferDetailFragment extends DaggerFragment {
    private int offer_id;
    private FragmentOfferDetailBinding mBinding;
    private OfferDetailViewModel offerDetailViewModel;
    @Inject
    AppRepo repository;
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

        offer_id = getArguments().getInt(OBJECT_ID);
        offerDetailViewModel.setRepository(repository);

        offerDetailViewModel.getOfferById(offer_id).observe(this, offerEntity -> {

            mBinding.setOffer(offerEntity);

            Picasso.get().load(R.drawable.offer_image_3).into(mBinding.ivOfferImage);

            if (offerEntity.isLiked()) mBinding.btnLike.setVisibility(View.INVISIBLE);

            mBinding.markdownView.loadMarkdown(offerEntity.getContent());

            mBinding.btnLike.setOnClickListener(view -> offerDetailViewModel.likeOffer(offerEntity));
        });
        return mBinding.getRoot();
    }


}
