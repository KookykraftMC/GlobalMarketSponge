package com.kookykraftmc.gm.command;

import com.kookykraftmc.gm.GlobalMarket;
import jdk.nashorn.internal.objects.Global;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;

/**
 * This class exists purely to handle commands. It will then be delegated to other classes for specific instances
 * of commands.
 */
public class CommandHandler {
    //TODO: Base Menu
    //TODO: Send to player's stock
    //TODO: Create an Infinite (Admin) Server Listing
    //TODO: Reload Command
    //TODO: Create a Player Listing from Command ?Possible?

    private CommandSpec menuCommand;
    private GlobalMarket globalMarket;

    public CommandHandler() {
        menuCommand = CommandSpec.builder()
                .description(Text.of("GlobalMarket Menu"))
                .permission("gms.use")
                .executor(new MenuCommand())
//                .arguments(
//                GenericArguments.onlyOne(GenericArguments.player(Text.of("player")))//,
//                GenericArguments.remainingJoinedStrings(Text.of("message"))
//                )
                .build();


    }

    /**
     * Registers each command.
     */
    public void registerCommands() {
        Sponge.getCommandManager().register(globalMarket, menuCommand, "market", "gm");
    }
}
