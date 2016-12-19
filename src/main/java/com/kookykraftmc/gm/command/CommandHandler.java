package com.kookykraftmc.gm.command;

import com.kookykraftmc.gm.GlobalMarket;
import jdk.nashorn.internal.objects.Global;
import org.spongepowered.api.Game;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextColors;

import java.util.List;
import java.util.Map;

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

    private CommandSpec command;

    public CommandHandler() {
        CommandSpec helpCommand = CommandSpec.builder()
                .description(Text.of("GlobalMarket Help"))
                .permission("gms.help")
                .executor(new HelpCommand())
                .build();

        CommandSpec reloadCommand = CommandSpec.builder()
                .description(Text.of("Reload GlobalMarket"))
                .permission("gms.reload")
                .executor(new ReloadCommand())
                .build();

        CommandSpec listingCommand = CommandSpec.builder()
                .description(Text.of("Create GlobalMarket listing"))
                .permission("gms.create")
                .executor(new ListingCommand())
                .build();

        CommandSpec menuCommand = CommandSpec.builder()
                .description(Text.of("GlobalMarket Menu"))
                .permission("gms.use")
                .executor(new MenuCommand())
                .build();


        //The main command of the plugin. This MUST be initialized after all of the children or bad things will happen!
        command = CommandSpec.builder()
                .description(Text.of("GlobalMarket Menu"))
                .permission("gms.use")
                .child(helpCommand, "help")
                .child(reloadCommand, "reload")
                .child(menuCommand, "menu")
                .child(listingCommand, "create")
                .executor(new MenuCommand())
                .build();


    }

    public void registerCommands(Game game, PluginContainer plugin) {
        game.getCommandManager().register(plugin, command, "gm");

        plugin.getLogger().info("GlobalMarket commands have been registered!");
    }

}
