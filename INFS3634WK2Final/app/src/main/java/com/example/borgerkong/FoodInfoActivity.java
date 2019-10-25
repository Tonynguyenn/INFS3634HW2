package com.example.borgerkong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class FoodInfoActivity extends AppCompatActivity {

    private int quantity = 0;
    private String quantityDisplay = "";
    private int itemID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Intent intent1 = getIntent();
        itemID = intent1.getIntExtra("itemID", 0);

        MenuItem itemMenuObject = itemDatabase.getMenuItemByID(itemID);

        ConstraintLayout activity_detail = findViewById(R.id.activity_detail);

        TextView name = activity_detail.findViewById(R.id.name2);
        name.setText(itemMenuObject.getName());

        ImageView image = activity_detail.findViewById(R.id.image2);
        image.setImageResource(itemMenuObject.getImage());

        TextView price = activity_detail.findViewById(R.id.price);
        String itemMenuPriceString = "$" + Double.toString(itemMenuObject.getPrice()) + "0";
        price.setText(itemMenuPriceString);


        TextView description = activity_detail.findViewById(R.id.description);
        description.setText(itemMenuObject.getDescription());

        final TextView itemQuantity = activity_detail.findViewById(R.id.quantity);
        Button plusButton = activity_detail.findViewById(R.id.plusB);
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++quantity;
                quantityDisplay = Integer.toString(quantity);
                itemQuantity.setText(quantityDisplay);
            }
        });
        Button minusButton = activity_detail.findViewById(R.id.minusB);
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity == 0) {
                    return;
                } else {
                    --quantity;
                    quantityDisplay = Integer.toString(quantity);
                    itemQuantity.setText(quantityDisplay);
                }
            }
        });
        Button addButton = activity_detail.findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity == 0) {
                    return;
                } else {
                    Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                    intent1.putExtra("itemID", itemID);
                    intent1.putExtra("quantity", quantity);
                    startActivity(intent1);
                }
            }
        });

        ConstraintLayout detailHeader = findViewById(R.id.detailHeader);
        ImageView returnToMenuButton2 = detailHeader.findViewById(R.id.returnToMenuButton2);
        returnToMenuButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}
