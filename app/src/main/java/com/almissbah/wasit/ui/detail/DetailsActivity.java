package com.almissbah.wasit.ui.detail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import com.almissbah.wasit.R;
import com.almissbah.wasit.databinding.ActivityDetailsBinding;
import com.almissbah.wasit.ui.base.BaseActivity;
import com.almissbah.wasit.ui.detail.fragment.OfferDetailFragment;
import com.almissbah.wasit.ui.detail.fragment.OwnerDetailFragment;
import dagger.android.support.DaggerAppCompatActivity;


public class DetailsActivity extends BaseActivity {

    ActivityDetailsBinding mBinding;
    public static String EXT_DATA = DetailsActivity.class.getSimpleName();
    public static String OBJECT_ID = "oid";
    public static int FRAG_OFFER_DETAIL_INDEX = 1;
    public static int FRAG_OWNER_DETAIL_INDEX = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_details);
        setSupportActionBar(mBinding.toolbar);
        initFragmnet();
    }

    void initFragmnet() {
        int index = getIntent().getIntExtra(EXT_DATA, 0);
        if (index == FRAG_OFFER_DETAIL_INDEX)
            loadOfferDetails();
        else if (index == FRAG_OWNER_DETAIL_INDEX)
            loadOwnerDetails();
    }

    void loadOfferDetails() {
        showFragment(new OfferDetailFragment());
    }

    void loadOwnerDetails() {
        showFragment(new OwnerDetailFragment());
    }

    void showFragment(Fragment fragment) {
        Bundle bundle = new Bundle();
        bundle.putInt(OBJECT_ID, getIntent().getIntExtra(OBJECT_ID, 0));
        fragment.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.commit();
    }

}
