package com.almissbah.wasit.ui.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.almissbah.wasit.R;
import com.almissbah.wasit.data.local.entity.OfferEntity;

import java.util.List;

public class AllOffersAdapter extends RecyclerView.Adapter<AllOffersAdapter.ViewHolder> {
    List<OfferEntity> offerEntities;

    public AllOffersAdapter(List<OfferEntity> offerEntities) {
        this.offerEntities = offerEntities;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.offer_item, viewGroup, false);
        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        // Get the data model based on position
        OfferEntity offerEntity = offerEntities.get(position);
        // Set item views based on your views and data model
        viewHolder.offerTitle.setText(offerEntity.getTitle());
        viewHolder.offerInfo.setText(offerEntity.getContent());
        viewHolder.offerOwner.setText(offerEntity.getOfferOwner().toString());
    }

    @Override
    public int getItemCount() {
        return offerEntities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView offerTitle;
        public TextView offerInfo;
        public TextView offerOwner;
        public ImageView offerImage;

        public ViewHolder(View itemView) {
            super(itemView);

            offerTitle = (TextView) itemView.findViewById(R.id.tv_title);
            offerInfo = (TextView) itemView.findViewById(R.id.tv_info);
            offerOwner = (TextView) itemView.findViewById(R.id.tv_owner);

            offerImage = (ImageView) itemView.findViewById(R.id.iv_offer_image);
        }
    }
}
