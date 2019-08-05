package com.almissbah.wasit.ui.main.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.almissbah.wasit.R;
import com.almissbah.wasit.data.local.entity.OfferEntity;
import com.almissbah.wasit.ui.main.viewmodel.LikedOffersViewModel;

import java.util.List;

public class LikedOffersFragment extends Fragment {

    private LikedOffersViewModel mViewModel;

    public static LikedOffersFragment newInstance() {
        return new LikedOffersFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.liked_offers_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(LikedOffersViewModel.class);

        mViewModel.getLikedOffers().observe(this, new Observer<List<OfferEntity>>() {
            @Override
            public void onChanged(@Nullable List<OfferEntity> offerEntities) {


                updateRecyclerView(offerEntities);
            }
        });


    }

    private void updateRecyclerView(List<OfferEntity> offerEntities) {
        // TODO: Complete updateRecyclerView function
    }

}
