package com.almissbah.wasit.ui.main.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.almissbah.wasit.BuildConfig;
import com.almissbah.wasit.R;
import com.almissbah.wasit.data.local.entity.OfferEntity;
import com.almissbah.wasit.databinding.AllOffersFragmentBinding;
import com.almissbah.wasit.ui.main.adapter.AllOffersAdapter;
import com.almissbah.wasit.ui.main.viewmodel.AllOffersViewModel;
import dagger.android.support.DaggerFragment;

public class AllOffersFragment extends DaggerFragment {
    private AllOffersFragmentBinding mBinding;
    private AllOffersViewModel mViewModel;
    private AllOfferFragmentListener listener;
    public static AllOffersFragment newInstance() {
        return new AllOffersFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(
                inflater, R.layout.all_offers_fragment, container, false);

        return mBinding.getRoot();
    }

    public void setListener(AllOfferFragmentListener listener
    ) {
        this.listener = listener;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(AllOffersViewModel.class);

        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        mViewModel.getAllOffers().observe(this, offerEntities -> {
            AllOffersAdapter allOffersAdapter = new AllOffersAdapter(offerEntities, new AllOffersAdapter.AllOffersAdapterListener() {
                @Override
                public void onOfferClicked(View view, OfferEntity offerEntity) {
                    if (listener != null) {
                        listener.onOfferClick(offerEntity);
                    }
                }
            });
            mBinding.recyclerView.setAdapter(allOffersAdapter);

        });
        // TODO: Use the ViewModel


        if (BuildConfig.FLAVOR.equals("whitneyhoustonFull")) {

        } else if (BuildConfig.FLAVOR.equals("elvispresleyDemo")) {

        }
    }

    public interface AllOfferFragmentListener {
        void onOfferClick(OfferEntity offerEntity);
    }
}
