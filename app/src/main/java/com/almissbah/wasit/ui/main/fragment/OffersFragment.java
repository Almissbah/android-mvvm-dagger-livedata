package com.almissbah.wasit.ui.main.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.almissbah.wasit.BuildConfig;
import com.almissbah.wasit.R;
import com.almissbah.wasit.data.local.db.entity.CategoryEntity;
import com.almissbah.wasit.data.local.db.entity.OfferEntity;
import com.almissbah.wasit.data.repo.AppRepo;
import com.almissbah.wasit.databinding.AllOffersFragmentBinding;
import com.almissbah.wasit.ui.base.BaseFragment;
import com.almissbah.wasit.ui.main.MainActivity;
import com.almissbah.wasit.ui.main.adapter.CategoryAdapter;
import com.almissbah.wasit.ui.main.adapter.OffersAdapter;
import com.almissbah.wasit.ui.main.viewmodel.OffersViewModel;

import javax.inject.Inject;
import java.util.List;

public class OffersFragment extends BaseFragment {
    private AllOffersFragmentBinding mBinding;
    private OffersViewModel mViewModel;
    private AllOfferFragmentListener listener;
    OffersAdapter.ItemClickListener clickedOfferListener = new OffersAdapter.ItemClickListener() {
        @Override
        public void onClicked(View view, OfferEntity offerEntity) {
            if (listener != null) {
                listener.onOfferClick(offerEntity);
            }
        }
    };
    OffersAdapter.ItemClickListener likedOfferListener = new OffersAdapter.ItemClickListener() {
        @Override
        public void onClicked(View view, OfferEntity offerEntity) {
            Log.d(OffersFragment.class.getSimpleName(), "like Offer " + offerEntity.getTitle());
            mViewModel.likeOffer(offerEntity);
        }
    };
    @Inject
    public AppRepo repository;
    private CategoryAdapter categoryAdapter;

    public static OffersFragment newInstance() {
        return new OffersFragment();
    }

    private RecyclerView rvCategories;

    public void setListener(AllOfferFragmentListener listener
    ) {
        this.listener = listener;
    }

    private OffersAdapter offersAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(
                inflater, R.layout.all_offers_fragment, container, false);
        //   ((MainActivity) getActivity()).setCategoryChangeListener(category -> mViewModel.getOffersByCategory(category.getTitle()));
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initOfferView();
        initViewModel();
        initCategories();

        if (BuildConfig.FLAVOR.equals("whitneyhoustonFull")) {

        } else if (BuildConfig.FLAVOR.equals("elvispresleyDemo")) {

        }
    }

    private void initCategories() {
        rvCategories = mBinding.getRoot().findViewById(R.id.rv_categories);
        categoryAdapter = new CategoryAdapter();
        rvCategories.setAdapter(categoryAdapter);
        rvCategories.setLayoutManager(new StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL));
        categoryAdapter.setClickListener(new CategoryAdapter.ItemClickListener() {
            @Override
            public void onClicked(View view, CategoryEntity categoryEntity) {
                Log.d(
                        OffersAdapter.class.getSimpleName(),
                        "Activity CategoryEntity with title " + categoryEntity.getTitle() + " Clicked "
                );
                mViewModel.getOffersByCategory(categoryEntity.getTitle());

            }
        });

        mViewModel.getAllCategories().observe(this, categoryEntities -> {
            categoryAdapter.setCategoryEntities(categoryEntities);
            if (categoryEntities != null) {
                rvCategories.setItemViewCacheSize(categoryEntities.size());
            }
            categoryAdapter.notifyDataSetChanged();
        });
    }

    private void initOfferView() {
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        offersAdapter = new OffersAdapter();
        offersAdapter.setClickListener(clickedOfferListener);
        offersAdapter.setLikedListener(likedOfferListener);
        mBinding.recyclerView.setAdapter(offersAdapter);
    }

    private void initViewModel() {
        mViewModel = ViewModelProviders.of(this).get(OffersViewModel.class);
        mViewModel.setRepository(repository);
        mViewModel.getData().observe(this, offerEntities -> {
            offersAdapter.setOfferEntities(offerEntities);
            offersAdapter.notifyDataSetChanged();
            Log.d(OffersAdapter.class.getSimpleName(), "Data has changed no of items =" + offerEntities.size());
        });

    }


    public interface AllOfferFragmentListener {
        void onOfferClick(OfferEntity offerEntity);
    }
}
