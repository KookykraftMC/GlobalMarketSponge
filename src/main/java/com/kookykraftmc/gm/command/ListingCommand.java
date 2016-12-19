package com.kookykraftmc.gm.command;

import com.kookykraftmc.gm.Listing;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.data.type.HandPreference;
import org.spongepowered.api.data.type.HandType;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import static org.spongepowered.api.data.type.HandTypes.MAIN_HAND;

public class ListingCommand implements CommandExecutor {

    Listing listing;

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        if (src instanceof Player) {
            Player seller = (Player) src;
            listing = new Listing();
            listing.setSeller(seller);

            listing.setItem(seller.getItemInHand(MAIN_HAND).get());

            src.sendMessage(Text.of(
                    TextColors.AQUA,
                    listing.getSeller().getName() +
                    " has created a listing of " +
                    listing.getItem().getQuantity() + " " +
                    listing.getItem().getItem().toString()
            ));
        }
        //TODO: Create Listing, nonGUI. Handles both player and admin creation.
        return CommandResult.success();
    }
}
