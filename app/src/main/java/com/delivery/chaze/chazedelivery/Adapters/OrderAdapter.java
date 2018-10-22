package com.delivery.chaze.chazedelivery.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.delivery.chaze.chazedelivery.OrderActivity;
import com.delivery.chaze.chazedelivery.R;
import com.delivery.chaze.chazedelivery.models.Orders;
import com.delivery.chaze.chazedelivery.models.Shops;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    Context context;
    ArrayList<Orders> ordersList;

    public OrderAdapter(Context context, ArrayList<Orders> ordersList) {
        this.context = context;
        this.ordersList = ordersList;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        OrderViewHolder holder =
                new OrderViewHolder(LayoutInflater.from(context).inflate(R.layout.order_card, viewGroup, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final OrderViewHolder orderViewHolder, int i) {
        Orders order=ordersList.get(i);
        orderViewHolder.button.setText("Take Order");
        orderViewHolder.customerName.setText(order.getName());
        orderViewHolder.customerAddress.setText(order.getAddress());
        ShopsAdapter adapter=new ShopsAdapter(context,order.getShopList());
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        orderViewHolder.recyclerView.setAdapter(adapter);
        orderViewHolder.recyclerView.setLayoutManager(linearLayoutManager);
        orderViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, OrderActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ordersList.size();
    }

    public void addItems() {
        for(int i=0;i<4;i++){
            ArrayList<Shops> items=new ArrayList<>();
            for (int j=0;j<25;j++){
                items.add(new Shops("shop name","shop address"));
            }
            ordersList.add(new Orders("cust name","cust address","cust add.",items));
        }
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView;
        TextView button,customerName,customerAddress;
        CardView cardView;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView=itemView.findViewById(R.id.shopNameRecycler);
            button=itemView.findViewById(R.id.takeOrder);
            cardView=itemView.findViewById(R.id.ordersCard);
            customerAddress=itemView.findViewById(R.id.customerAddress);
            customerName=itemView.findViewById(R.id.customerName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context, OrderActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }
}
