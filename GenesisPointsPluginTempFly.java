package studio.magemonkey.genesis.pointsystem;

import com.moneybags.tempfly.TempFly;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

public class GenesisPointsPluginTempFly extends GenesisPointsPlugin {
    private TempFly tp;

    public GenesisPointsPluginTempFly() {
        super("TempFly", "TP");

        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("TempFly");
        if (plugin != null) {
            tp= ((TempFly) plugin);
        }
    }

    @Override
    public double getPoints(OfflinePlayer player) {
        UUID playerUUID = player.getUniqueId();
        return tp.getAPI().getFlightTime(playerUUID);
    }

    @Override
    public double setPoints(OfflinePlayer player, double points) {
        UUID playerUUID = player.getUniqueId();
        tp.getAPI().setFlightTime(playerUUID, points);
        return points;
    }

    @Override
    public double takePoints(OfflinePlayer player, double points) {
        UUID playerUUID = player.getUniqueId();
        tp.getAPI().removeFlightTime(playerUUID, points);
        return getPoints(player);
    }

    @Override
    public double givePoints(OfflinePlayer player, double points) {
        UUID playerUUID = player.getUniqueId();
        tp.getAPI().addFlightTime(playerUUID, points);
        return getPoints(player);
    }

    @Override
    public boolean usesDoubleValues() {
        return false;
    }

}
