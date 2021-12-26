package eltrabug.eltrabug;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class Eltrabug extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Eltrabug Plugin Enabled");
        bug();
    }

    private void bug() {
        BukkitRunnable brun = new BukkitRunnable() {
            @Override
            public void run() {
                for(World w : Bukkit.getWorlds()) {
                    for(Player p : w.getPlayers()) {
                        if(p.getInventory().getChestplate() != null) {
                            if(p.getInventory().getChestplate().getType().equals(Material.ELYTRA)) {
                                p.setGliding(true);
                            }
                        }
                    }
                }
            }
        };brun.runTaskTimer(this, 0, 0);
    }

    @Override
    public void onDisable() {
        System.out.println("Eltrabug Plugin Disabled");
    }
}
