package com.almissbah.wasit.ui.main.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.almissbah.wasit.BuildConfig;
import com.almissbah.wasit.R;
import com.almissbah.wasit.data.local.db.entity.CategoryEntity;
import com.almissbah.wasit.data.local.db.entity.OfferEntity;
import com.almissbah.wasit.data.repo.AppRepo;
import com.almissbah.wasit.data.repo.DemoRepo;
import com.almissbah.wasit.databinding.AllOffersFragmentBinding;
import com.almissbah.wasit.ui.main.MainActivity;
import com.almissbah.wasit.ui.main.adapter.OffersAdapter;
import com.almissbah.wasit.ui.main.viewmodel.OffersViewModel;
import dagger.android.support.DaggerFragment;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class OffersFragment extends DaggerFragment {
    private AllOffersFragmentBinding mBinding;
    private OffersViewModel mViewModel;
    private AllOfferFragmentListener listener;
    @Inject
    public AppRepo repository;

    public static OffersFragment newInstance() {
        return new OffersFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(
                inflater, R.layout.all_offers_fragment, container, false);


        ((MainActivity) getActivity()).setCategoryChangeListener(category -> mViewModel.getOffersByCategory(category.getTitle()));

        return mBinding.getRoot();
    }

    public void setListener(AllOfferFragmentListener listener
    ) {
        this.listener = listener;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(OffersViewModel.class);
        mViewModel.setRepository(repository);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        OffersAdapter offersAdapter = new OffersAdapter();
        offersAdapter.setClickListener(clickedOfferListener);
        offersAdapter.setLikedListener(likedOfferListener);
        mBinding.recyclerView.setAdapter(offersAdapter);


        mViewModel.getData().observe(this, offerEntities -> {
            offersAdapter.setOfferEntities(offerEntities);
            offersAdapter.notifyDataSetChanged();
            Log.d(OffersAdapter.class.getSimpleName(), "Data has changed no of items =" + offerEntities.size());
        });


        if (BuildConfig.FLAVOR.equals("whitneyhoustonFull")) {

        } else if (BuildConfig.FLAVOR.equals("elvispresleyDemo")) {

        }
    }


    OffersAdapter.OffersAdapterListener clickedOfferListener = new OffersAdapter.OffersAdapterListener() {
        @Override
        public void onClicked(View view, OfferEntity offerEntity) {
            if (listener != null) {
                listener.onOfferClick(offerEntity);
            }
        }
    };


    OffersAdapter.OffersAdapterListener likedOfferListener = new OffersAdapter.OffersAdapterListener() {
        @Override
        public void onClicked(View view, OfferEntity offerEntity) {
            Log.d(OffersFragment.class.getSimpleName(), "like Offer " + offerEntity.getTitle());
            mViewModel.likeOffer(offerEntity);
        }
    };


    public interface AllOfferFragmentListener {
        void onOfferClick(OfferEntity offerEntity);
    }
}
