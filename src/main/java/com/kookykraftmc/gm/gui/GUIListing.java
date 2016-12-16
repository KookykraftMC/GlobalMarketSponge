package com.kookykraftmc.gm.gui;

import com.kookykraftmc.gm.GlobalMarket;
import jdk.nashorn.internal.objects.Global;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.property.InventoryDimension;
import org.spongepowered.api.item.inventory.property.InventoryTitle;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.title.Title;

//This is a Stub. Ignore this until I do more with it. --Sol

public class GUIListing {

    GlobalMarket globalMarket;
    Inventory inventory;
    String inventoryTitle = "Market Listings";

    public GUIListing() {

        inventory = Inventory.builder()
                .property(InventoryTitle.PROPERTY_NAME, InventoryTitle.of(Text.of(inventoryTitle)))
                .property(InventoryDimension.PROPERTY_NAM, new InventoryDimension(9, 6))
                .build(globalMarket.getInstance());

    }
}
