package com.delivery.chaze.chazedelivery.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.delivery.chaze.chazedelivery.R;
import com.delivery.chaze.chazedelivery.models.Shops;

import java.util.ArrayList;

public class ShopsAdapter extends RecyclerView.Adapter<ShopsAdapter.ShopsViewHolder> {
    Context context;
    ArrayList<Shops> shopList;

    public ShopsAdapter(Context context, ArrayList<Shops> shopList) {
        this.context = context;
        this.shopList = shopList;
    }

    @NonNull
    @Override
    public ShopsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ShopsViewHolder holder =
                new ShopsViewHolder(LayoutInflater.from(context).inflate(R.layout.shop_card, viewGroup, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShopsViewHolder shopsViewHolder, int i) {
        Shops shop=shopList.get(i);
        shopsViewHolder.shopName.setText(shop.getShopName());
        shopsViewHolder.shopAddress.setText(shop.getAddress());
    }

    @Override
    public int getItemCount() {
        return shopList.size();
    }

    public class ShopsViewHolder extends RecyclerView.ViewHolder{
        TextView shopName, shopAddress;
        public ShopsViewHolder(@NonNull View itemView) {
            super(itemView);
            shopName=itemView.findViewById(R.id.ShopName);
            shopAddress=itemView.findViewById(R.id.ShopAddress);
        }
    }
}
