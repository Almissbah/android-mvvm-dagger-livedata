package com.almissbah.wasit.ui.main.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.almissbah.wasit.R;
import com.almissbah.wasit.data.local.db.entity.OfferEntity;
import com.almissbah.wasit.databinding.OfferItemBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.MyViewHolder> {
    List<OfferEntity> offerEntities = new ArrayList<>();
    ItemClickListener clickListener;
    ItemClickListener likedListener;

    public OffersAdapter() {

    }

    public void setOfferEntities(List<OfferEntity> offerEntities) {
        this.offerEntities = offerEntities;
    }

    public void setClickListener(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setLikedListener(ItemClickListener likedListener) {
        this.likedListener = likedListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        Context context = viewGroup.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        OfferItemBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.offer_item, viewGroup, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {
        OfferEntity offerEntity = offerEntities.get(position);
        viewHolder.binding.setOffer(offerEntity);
        Picasso.get().load(R.drawable.offer_image_3).into(viewHolder.binding.ivOfferImage);
        if (offerEntity.isLiked()) viewHolder.binding.btnLike.setVisibility(View.INVISIBLE);
        viewHolder.binding.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (likedListener != null)
                    likedListener.onClicked(view, offerEntity);
            }
        });
        viewHolder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(OffersAdapter.class.getSimpleName(), "Offer with title " + offerEntity.getTitle() + " Clicked ");
                if (clickListener != null)
                    clickListener.onClicked(view, offerEntity);
            }
        });
    }

    @Override
    public int getItemCount() {

        return offerEntities.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final OfferItemBinding binding;

        public MyViewHolder(final OfferItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }

    public interface ItemClickListener {
        void onClicked(View view, OfferEntity offerEntity);
    }
}
