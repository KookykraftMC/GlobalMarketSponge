package com.kookykraftmc.gm.listing;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.inventory.ItemStack;

import java.math.BigDecimal;

//Handles listings. Amazing.
public class ListingHandler {

    Listing listing;

    public Listing create(Player player, ItemStack item, BigDecimal price) {
        Listing listing = new Listing(player, item, price);

        //Add to Storage

        return listing;
    }

    boolean remove() {
        //na
        return false;
    }

    boolean expire() {
        //meh
        return false;
    }

    boolean list() {
        //ok
        return false;
    }

    boolean mail() {
        //wat
        return false;
    }
}
