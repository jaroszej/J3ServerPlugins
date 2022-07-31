package dev.rosze.j3;

import dev.rosze.j3.commands.WorldLocations;
import dev.rosze.j3.events.DeathBlurb;
import dev.rosze.j3.events.WelcomeMessage;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        // registering events
        getServer().getPluginManager().registerEvents((Listener) new WelcomeMessage(), this);
        getServer().getPluginManager().registerEvents((Listener) new DeathBlurb(), this);

        // registering commands
        WorldLocations locs = new WorldLocations();
        getCommand("position").setExecutor(locs);


        getLogger().info(this.getName() + " is up and running!");
    }

    @Override
    public void onDisable() {
        getLogger().info(this.getName() + " has shut down... Goodbye!");
    }
}