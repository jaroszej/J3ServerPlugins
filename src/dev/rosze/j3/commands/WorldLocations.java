package dev.rosze.j3.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.DecimalFormat;
import java.util.Arrays;

public class WorldLocations implements CommandExecutor {

    private static final DecimalFormat df = new DecimalFormat("0.0");

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // checks player is in game player (not console user)
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use that command.");
            return true;
        }

        // position
        if (cmd.getName().equalsIgnoreCase("position")) {

            int serverSize = 10;

            // too many args
            if (args.length > 2) {

                player.sendMessage(cmd + " only accepts arguments [player] and [volume (0) or (1)]. Type /help position to learn more.");
            }

            else {
                switch (args.length) {
                    case 1 -> {
                        Bukkit.getLogger().info("args: " + Arrays.toString(args) + " " + Bukkit.getOnlinePlayers().size());
                        // find matching player from list of online players
                        for (Player otherPlayer : Bukkit.getOnlinePlayers()) {
                            if (otherPlayer.getName().equalsIgnoreCase(args[0])) {
                                double x = Double.parseDouble(df.format(otherPlayer.getLocation().getBlockX()));
                                double y = Double.parseDouble(df.format(otherPlayer.getLocation().getBlockY()));
                                double z = Double.parseDouble(df.format(otherPlayer.getLocation().getBlockZ()));
                                serverSize--;
                                player.sendMessage(ChatColor.GRAY + otherPlayer.getPlayerListName() + " is at: x: " + x + ", y: " + y + ", z: " + z);
                            }
                        }
                        // no matching players on the server list
                        if (serverSize == 10) {
                            player.sendMessage(ChatColor.RED + args[0] + "'s location cannot be checked. Are they offline?");
                        }
                    }
                    case 2 -> {
                        Bukkit.getLogger().info("args: " + Arrays.toString(args) + " " + Bukkit.getOnlinePlayers().size());
                        for (Player otherPlayer : Bukkit.getOnlinePlayers()) {
                            if (otherPlayer.getName().equalsIgnoreCase(args[0])) {

                                double x = Double.parseDouble(df.format(otherPlayer.getLocation().getBlockX()));
                                double y = Double.parseDouble(df.format(otherPlayer.getLocation().getBlockY()));
                                double z = Double.parseDouble(df.format(otherPlayer.getLocation().getBlockZ()));
                                serverSize--;

                                switch(args[1]) {
                                    // whisper to user
                                    case "0" -> {
                                        player.sendMessage(ChatColor.GRAY + otherPlayer.getPlayerListName() + " is at: x: " + x + ", y: " + y + ", z: " + z);
                                    }
                                    // broadcast
                                    case "1" -> {
                                        Bukkit.broadcastMessage(otherPlayer.getPlayerListName() + " is at: x: " + x + ", y: " + y + ", z: " + z);
                                    }
                                }
                            }
                        }
                        // no matching players on the server list
                        if (serverSize == 10) {
                            player.sendMessage(args[0] + "'s location cannot be checked. Are they offline?");
                        }
                    }
                    default -> {
                        // get coordinates of player
                        double x = Double.parseDouble(df.format(player.getLocation().getBlockX()));
                        double y = Double.parseDouble(df.format(player.getLocation().getBlockY()));
                        double z = Double.parseDouble(df.format(player.getLocation().getBlockZ()));
                        player.sendMessage(ChatColor.GRAY + "You are at x: " + x + " y: " + y + " z: " + z);
                    }
                }
            }
        }
        return true;
    }


}