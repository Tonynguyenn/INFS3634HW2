package com.example.borgerkong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static ArrayList<MenuItem> OrderArray = new ArrayList<MenuItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = findViewById(R.id.rv_menu);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MenuAdapter menuAdapter = new MenuAdapter();
        menuAdapter.setData(itemDatabase.getAllMenuItems());
        recyclerView.setAdapter(menuAdapter);

        Intent intent1 = getIntent();
        int returnFromOrders = intent1.getIntExtra("returnFromOrders", 0);
        if (returnFromOrders == 1) {
            OrderArray.clear();
        } else if (returnFromOrders == 2) {
            OrderArray = (ArrayList<MenuItem>) getIntent().getSerializableExtra("OrderArray");
        }

        int itemID = intent1.getIntExtra("itemID", 0);
        if (itemID != 0) {
            MenuItem MenuItemObject = new MenuItem(itemID);
            int Quantity = intent1.getIntExtra("quantity", 0);
            MenuItemObject.setOrderQuantity(Quantity);
            OrderArray.add(MenuItemObject);
        }

        Button viewOrderButton = findViewById(R.id.viewOrderButton);
        viewOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), OrderActivity.class);
                intent2.putExtra("OrderArray", OrderArray);
                startActivity(intent2);
            }
        });
    }
}
