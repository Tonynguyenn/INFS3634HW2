package com.example.borgerkong;

import android.view.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class itemDatabase {

    public static MenuItem getMenuItemByID(int itemID) {return MenuItems.get(itemID);
    }

    public static ArrayList<MenuItem> getAllMenuItems() {
        return new ArrayList<MenuItem>((List) Arrays.asList(MenuItems.values().toArray()));
    }

    private static final HashMap<Integer, MenuItem> MenuItems = new HashMap<>();

    static {

        MenuItems.put(1, new MenuItem(
                1,
                R.drawable.steak,
                "Steak",
                15.00,
                "350g rump steak cooked to your liking",
                0
        ));

        MenuItems.put(2, new MenuItem(
                2,
                R.drawable.lamb,
                "Garlic Roasted Lamb",
                12.50,
                "Slow roasted garlic lamb chops",
                0
        ));

        MenuItems.put(3, new MenuItem(
                3,
                R.drawable.burger,
                "Obama Burger",
                7.00,
                "Wagyu beef patty cooked to medium with 2 slices of American cheese between a potato roll",
                0
        ));

        MenuItems.put(4, new MenuItem(
                4,
                R.drawable.burger,
                "I gym burger",
                6.00,
                "A double grilled chicken breast burger with protein cheese and lettuce",
                0
        ));


        MenuItems.put(5, new MenuItem(
                5,
                R.drawable.sandwich,
                "BLT Sandwich",
                5.00,
                "Rasher bacon with fresh tomatoes and iceburg lettuce",
                0
        ));

        MenuItems.put(5, new MenuItem(
                5,
                R.drawable.sandwich,
                "BLT Sandwich",
                5.00,
                "Rasher bacon with fresh tomatoes and iceburg lettuce",
                0
        ));




        MenuItems.put(6, new MenuItem(
                6,
                R.drawable.wrap,
                "I gym wrap",
                5.00,
                "Grilled chicken breast wrap with cherry tomatoes and iceburg lettuce",
                0
        ));
        MenuItems.put(7, new MenuItem(
                7,
                R.drawable.wrap,
                "Bacon n egg wrap",
                5.00,
                "Rasher bacon with scrambled eggs in a wrap",
                0
        ));
        MenuItems.put(8, new MenuItem(
                8,
                R.drawable.chips,
                "Canadian poutine",
                5.00,
                "Fries topped with gravy and cheese curds",
                0
        ));
        MenuItems.put(9, new MenuItem(
                9,
                R.drawable.chips,
                "Chilli cheese fries",
                5.00,
                "Fries topped with chilli corn carne and american cheese",
                0
        ));
        MenuItems.put(10, new MenuItem(
                10,
                R.drawable.chips,
                "Chips",
                2.50,
                "Thick cut fries",
                0
        ));
        MenuItems.put(11, new MenuItem(
                11,
                R.drawable.onion_rings,
                "Onion Rings",
                2.50,
                "Beer battered onion rings",
                0
        ));
        MenuItems.put(12, new MenuItem(
                12,
                R.drawable.chicken,
                "2 piece chicken",
                5.00,
                "Kentucky style fried chicken with a crispy batter",
                0
        ));

        MenuItems.put(13, new MenuItem(13,
                R.drawable.corndog,
                "CornDog",
                4.50,
                "Hot dog covered in a crispy beer batter",
                0
                ));

        MenuItems.put(14, new MenuItem(
                14,
                R.drawable.coke,
                "Coke no sugar",
                4.00,
                "500ml bottle of coke",
                0

        ));


        MenuItems.put(15, new MenuItem(
                15,
                R.drawable.milkshake,
                "Oak Milkshake",
                2.50,
                "750ml chocolate oak milkshake",
                0
        ));



    }

}