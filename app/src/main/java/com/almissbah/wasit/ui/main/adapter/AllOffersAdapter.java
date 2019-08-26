package com.almissbah.wasit.ui.main.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.almissbah.wasit.R;
import com.almissbah.wasit.data.local.entity.OfferEntity;
import com.almissbah.wasit.databinding.OfferItemBinding;

import java.util.List;

public class AllOffersAdapter extends RecyclerView.Adapter<AllOffersAdapter.MyViewHolder> {
    List<OfferEntity> offerEntities;
    AllOffersAdapterListener listener;

    public AllOffersAdapter(List<OfferEntity> offerEntities, AllOffersAdapterListener listener) {
        this.offerEntities = offerEntities;
        this.listener = listener;
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

        // Get the data model based on position
        OfferEntity offerEntity = offerEntities.get(position);
        viewHolder.binding.setOffer(offerEntity);
        viewHolder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null)
                    listener.onOfferClicked(view, offerEntity);
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

    public interface AllOffersAdapterListener {
        void onOfferClicked(View view, OfferEntity offerEntity);
    }
}
