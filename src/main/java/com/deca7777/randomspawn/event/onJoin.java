package com.deca7777.randomspawn.event;

import com.deca7777.randomspawn.randomteleport;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static com.deca7777.randomspawn.Main.plugin;

public class onJoin implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if (!player.hasPlayedBefore()) {
            FileConfiguration config = plugin.getConfig();
            randomteleport ra = new randomteleport();
            ra.center_x = config.getInt("Center-X");
            ra.center_z = config.getInt("Center-Z");
            ra.radius = config.getInt("Radius");
            ra.worldname = config.getString("world");
            player.teleport(ra.set_pos());
            player.sendMessage("Teleported to random position...");
        }
    }
}
