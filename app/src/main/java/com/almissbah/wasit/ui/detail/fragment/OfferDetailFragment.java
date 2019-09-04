package com.almissbah.wasit.ui.detail.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.almissbah.wasit.R;
import com.almissbah.wasit.data.local.db.entity.OfferEntity;
import com.almissbah.wasit.data.repo.BazarRepository;
import com.almissbah.wasit.databinding.FragmentOfferDetailBinding;
import com.almissbah.wasit.ui.base.BaseFragment;
import com.almissbah.wasit.ui.detail.viewmodel.OfferDetailViewModel;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import static com.almissbah.wasit.ui.detail.DetailsActivity.OBJECT_ID;


public class OfferDetailFragment extends BaseFragment {
    private int offer_id;
    private FragmentOfferDetailBinding mBinding;
    OfferDetailViewModel offerDetailViewModel;
    @Inject
    BazarRepository repository;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_offer_detail, container, false);

        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViewModel();
    }

    void initViewModel() {
        offerDetailViewModel = ViewModelProviders.of(this).get(OfferDetailViewModel.class);
        offer_id = getArguments().getInt(OBJECT_ID);
        offerDetailViewModel.setRepository(repository);

        offerDetailViewModel.getOfferById(offer_id).observe(this, offerEntity -> {
            initOfferView(offerEntity);
        });
    }

    void initOfferView(OfferEntity offerEntity) {
        mBinding.setOffer(offerEntity);
        Picasso.get().load(R.drawable.offer_image_3).into(mBinding.ivOfferImage);
        if (offerEntity.isLiked()) mBinding.btnLike.setVisibility(View.INVISIBLE);
        mBinding.markdownView.loadMarkdown(offerEntity.getContent());
        mBinding.btnLike.setOnClickListener(view -> offerDetailViewModel.likeOffer(offerEntity));
    }

}
