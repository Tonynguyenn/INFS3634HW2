package com.example.borgerkong;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private ArrayList<MenuItem> OrderArray;

    public static void setOrderTotal(double orderTotal) {
        OrderAdapter.orderTotal = orderTotal;
    }

    public static double orderTotal = 0;

    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, parent, false);
        OrderViewHolder orderViewHolder = new OrderViewHolder(view);
        return orderViewHolder;
    }

    public void onBindViewHolder(@NonNull final OrderViewHolder holder, final int position) {
        MenuItem itemMenuObject = OrderArray.get(position);
        final Context context = holder.itemMenuName3.getContext();
        holder.itemMenuImage3.setImageResource(itemMenuObject.getImage());
        holder.itemMenuName3.setText(itemMenuObject.getName());
        String itemMenuOrderQuantityString = "x" + Integer.toString(itemMenuObject.getOrderQuantity());
        holder.itemMenuQuantity2.setText(itemMenuOrderQuantityString);
        holder.removeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1;
                OrderArray.remove(position);
                if (getItemCount() == 0) {
                    intent1 = new Intent(context, MainActivity.class);
                    intent1.putExtra("returnFromOrders", 1);
                } else {
                    intent1 = new Intent(context, OrderActivity.class);
                    intent1.putExtra("OrderArray", OrderArray);
                }
                orderTotal = 0;
                context.startActivity(intent1);
            }
        });
    }

    public int getItemCount() {
        return OrderArray.size();
    }

    public void setData(ArrayList<MenuItem> data) {
        this.OrderArray = data;
    }

    public double getOrderTotal() {
        for (int i = 0; i < OrderArray.size(); i++) {
            MenuItem menuItemObject = OrderArray.get(i);
            orderTotal += (menuItemObject.getOrderQuantity() * menuItemObject.getPrice());
        }
        return orderTotal;
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ImageView itemMenuImage3;
        public TextView itemMenuName3;
        public TextView itemMenuQuantity2;
        public Button removeOrderButton;

        public OrderViewHolder(View v) {
            super(v);
            view = v;
            itemMenuImage3 = v.findViewById(R.id.image3);
            itemMenuName3 = v.findViewById(R.id.name3);
            itemMenuQuantity2 = v.findViewById(R.id.quantity2);
            removeOrderButton = v.findViewById(R.id.removeOrderButton);
        }
    }


}
