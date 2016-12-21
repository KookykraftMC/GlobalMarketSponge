package com.kookykraftmc.gm.command;

import com.kookykraftmc.gm.GlobalMarket;
import com.kookykraftmc.gm.listing.Listing;
import com.kookykraftmc.gm.listing.ListingHandler;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import java.math.BigDecimal;

import static org.spongepowered.api.data.type.HandTypes.MAIN_HAND;

public class ListingCommand implements CommandExecutor {

    private ListingHandler listingHandler;

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (src instanceof Player) {

            listingHandler = GlobalMarket.listingHandler;

            Player seller = (Player) src;
            BigDecimal price = argsPrice(src, args);
            Listing listing;

            if (getItemInHand(seller) != null) {
                listing = new Listing(seller, getItemInHand(seller), price);
                listingHandler.createSQLListing(seller, getItemInHand(seller), price);

                src.sendMessage(Text.of(
                        TextColors.AQUA,
                        listing.getSeller().getName() +
                                " has listed " +
                                listing.getItem().getQuantity() + " " +
                                listing.getItem().getItem().getId().substring(10) +
                                " for $" + listing.getPrice()
                ));
            } else {
                src.sendMessage(Text.of(
                        TextColors.RED,
                        "Error: There is no item in your hand."
                ));
            }


        }
        //TODO: Create Listing, nonGUI. Handles both player and admin creation.
        return CommandResult.success();
    }

    private ItemStack getItemInHand(Player player) {
        return player.getItemInHand(MAIN_HAND).orElse(null);
    }


    private BigDecimal argsPrice(CommandSource src, CommandContext args) {
        String arg = args.getOne(Text.of("price")).get().toString(); //No need to check for isPresent here.
        return new BigDecimal(arg).setScale(2, BigDecimal.ROUND_FLOOR);
    }
}
