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

    }

    @Override
    public double getPoints(OfflinePlayer player) {
        return TempFly.getAPI().getFlightTime(player.getUniqueId());
    }

    @Override
    public double setPoints(OfflinePlayer player, double points) {
        TempFly.getAPI().setFlightTime(player.getUniqueId(), (int) points);
        return points;
    }

    @Override
    public double takePoints(OfflinePlayer player, double points) {
        TempFly.getAPI().removeFlightTime(player.getUniqueId(), (int) points);
        return getPoints(player);
    }

    @Override
    public double givePoints(OfflinePlayer player, double points) {
        TempFly.getAPI().addFlightTime(player.getUniqueId(), (int) points);
        return getPoints(player);
    }

    @Override
    public boolean usesDoubleValues() {
        return false;
    }

}
