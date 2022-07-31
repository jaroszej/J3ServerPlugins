package dev.rosze.j3.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.text.DecimalFormat;

// send player a readout of their EXP value on 0 hp and death
public class DeathBlurb implements Listener {

    // exp from level 0 to 63 (64 options)
    private static final int[] expTable = {0, 7, 16, 27, 40, 55, 72, 91, 112, 135, 160, 187, 216, 247, 280, 315, 352, 394, 441, 493, 550, 612, 679, 751, 828, 910, 997, 1089, 1186, 1288, 1395, 1507, 1628, 1758, 1897, 2045, 2202, 2368, 2543, 2727, 2920, 3122, 3333, 3553, 3782, 4020, 4267, 4523, 4788, 5062, 5345, 5637, 5938, 6248, 6567, 6895, 7232, 7578, 7933, 8297, 8670, 9052, 9443, 9843};

    private static final DecimalFormat df = new DecimalFormat("0.0");

    public static float getExpConversion(int level, double expPercent) {

        float value;

        if (level == 63) {
            value = 0;

        } else {
            // returns the amount of exp to the next level
            value = (float) ((expTable[level + 1] - expTable[level]) * expPercent);
        }

        return value;
    }

    @EventHandler
    public static void onDeath(PlayerDeathEvent e) {
        Player player = e.getEntity();

        int level = player.getLevel();

        int levelEXP = expTable[level];

        // float exp = Float.parseFloat(df.format(levelEXP + getExpConversion(level, player.getExp())));
        float exp = Float.parseFloat((df.format(levelEXP + getExpConversion(level, player.getExp()))));

        double x = Double.parseDouble(df.format(player.getLocation().getBlockX()));
        double y = Double.parseDouble(df.format(player.getLocation().getBlockY()));
        double z = Double.parseDouble(df.format(player.getLocation().getBlockZ()));

        player.sendMessage(ChatColor.GRAY + "You lost " + exp + " EXP at x: " + x + ", y: " + y + ", z: " + z);
    }

}