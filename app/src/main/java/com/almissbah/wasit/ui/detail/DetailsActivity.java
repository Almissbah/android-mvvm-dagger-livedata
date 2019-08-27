package com.almissbah.wasit.ui.detail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.almissbah.wasit.R;
import com.almissbah.wasit.databinding.ActivityDetailsBinding;
import com.almissbah.wasit.ui.detail.fragment.OfferDetailFragment;
import dagger.android.support.DaggerAppCompatActivity;

import static com.almissbah.wasit.ui.detail.fragment.OfferDetailFragment.OFFER_ID;

public class DetailsActivity extends DaggerAppCompatActivity {

    ActivityDetailsBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_details);

        setSupportActionBar(mBinding.toolbar);


        Bundle bundle = new Bundle();
        bundle.putInt(OFFER_ID, 1);

        OfferDetailFragment offerDetailFragment = new OfferDetailFragment();
        offerDetailFragment.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, offerDetailFragment);
        transaction.commit();
    }

}
