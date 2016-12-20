package com.kookykraftmc.gm.listing;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.inventory.ItemStack;

import java.math.BigDecimal;

/**
 * Data Structure to hold information about listings. This may change in the future but ¯\_(ツ)_/¯
 */
public class Listing {
    //TODO: Check listing creation for an ItemType:NONE, and then reject the creation.
    private ItemStack item;
    private Player seller;
    private BigDecimal price;

    public Listing(Player seller, ItemStack item, BigDecimal price) {
        setSeller(seller);
        setItem(item);
        setPrice(price);
    }

    public ItemStack getItem() {
        return item;
    }

    public Player getSeller() {
        return seller;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }

    public void setSeller(Player seller) {
        this.seller = seller;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
