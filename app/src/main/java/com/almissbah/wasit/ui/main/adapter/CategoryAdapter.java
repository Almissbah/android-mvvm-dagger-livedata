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
import com.almissbah.wasit.data.local.db.entity.CategoryEntity;
import com.almissbah.wasit.data.local.db.entity.OfferEntity;
import com.almissbah.wasit.databinding.CategoryItemBinding;
import com.almissbah.wasit.databinding.OfferItemBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    List<CategoryEntity> categoryEntities;
    CategoryAdapterListener clickListener;

    public CategoryAdapter(List<CategoryEntity> categoryEntities) {
        this.categoryEntities = categoryEntities;
    }

    public void setClickListener(CategoryAdapterListener clickListener) {
        this.clickListener = clickListener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        Context context = viewGroup.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        CategoryItemBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.category_item, viewGroup, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {
        CategoryEntity categoryEntity = categoryEntities.get(position);
        viewHolder.binding.setCategory(categoryEntity);
        Log.d(CategoryAdapter.class.getSimpleName(), "Category with title " + categoryEntity.getTitle() + " Clicked ");

        viewHolder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(CategoryAdapter.class.getSimpleName(), "Category with title " + categoryEntity.getTitle() + " Clicked ");
                if (clickListener != null)
                    clickListener.onClicked(view, categoryEntity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryEntities.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final CategoryItemBinding binding;

        public MyViewHolder(final CategoryItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }

    public interface CategoryAdapterListener {
        void onClicked(View view, CategoryEntity categoryEntity);
    }
}