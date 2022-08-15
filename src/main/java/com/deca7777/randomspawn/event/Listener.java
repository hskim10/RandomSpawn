package com.deca7777.randomspawn.event;

import com.deca7777.randomspawn.randomteleport;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

import static com.deca7777.randomspawn.Main.plugin;
import static java.lang.Thread.sleep;

public class Listener implements org.bukkit.event.Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onRespawn(PlayerRespawnEvent e) {
        if(!e.isBedSpawn()&&!e.isAnchorSpawn()){
            Player player = e.getPlayer();
            FileConfiguration config = plugin.getConfig();
            randomteleport ra = new randomteleport();
            ra.center_x = config.getInt("Center-X");
            ra.center_z = config.getInt("Center-Z");
            ra.radius = config.getInt("Radius");
            ra.worldname = config.getString("world");
            ra.p = player;
            e.setRespawnLocation(ra.set_pos());
            player.sendMessage("Teleported to random position.");
        }
    }

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
            ra.p = player;
            player.teleport(ra.set_pos());
            player.sendMessage("Teleported to random position.");
        }
    }
}
