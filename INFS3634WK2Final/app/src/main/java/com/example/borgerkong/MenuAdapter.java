package com.example.borgerkong;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private ArrayList<MenuItem> MenuItemArray;

    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        MenuViewHolder menuViewHolder = new MenuViewHolder(view);
        return menuViewHolder;
    }

    public void onBindViewHolder(@NonNull final MenuViewHolder holder, final int position) {
        MenuItem menuItemObject = MenuItemArray.get(position);
        final Context context = holder.name.getContext();
        holder.image.setImageResource(menuItemObject.getImage());
        holder.name.setText(menuItemObject.getName());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(context, DetailActivity.class);
                intent1.putExtra("itemID", position + 1);
                context.startActivity(intent1);
            }
        });
    }

    public int getItemCount() {
        return MenuItemArray.size();
    }

    public void setData(ArrayList<MenuItem> data) {
        this.MenuItemArray = data;
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ImageView image;
        public TextView name;

        public MenuViewHolder(View v) {
            super(v);
            view = v;
            image = v.findViewById(R.id.image);
            name = v.findViewById(R.id.name);
        }
    }

}