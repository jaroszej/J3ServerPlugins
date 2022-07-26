package dev.rosze.j3;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        // registering events
        getServer().getPluginManager().registerEvents(new WelcomeMessage(), this);

        getLogger().info(ChatColor.RED + this.getName() + " is up and running!");
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.RED + this.getName() + " is shut down...");
    }
}