package com.kookykraftmc.gm;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.service.economy.Currency;

/**
 * Data Structure to hold information about listings. This may change in the future but ¯\_(ツ)_/¯
 */
public class Listing {
    private ItemStack item;
    private Player seller;
    private Currency price;



    public ItemStack getItem() {
        return item;
    }

    public Player getSeller() {
        return seller;
    }

    public Currency getPrice() {
        return price;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }

    public void setSeller(Player seller) {
        this.seller = seller;
    }

    public void setPrice(Currency price) {
        this.price = price;
    }
}
