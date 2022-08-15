package com.deca7777.randomspawn.commands;

import com.deca7777.randomspawn.randomteleport;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

import static com.deca7777.randomspawn.Main.plugin;

public class rt implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0 && (sender instanceof Player)){
            Player player = (Player) sender;
            FileConfiguration config = plugin.getConfig();
            randomteleport ra = new randomteleport();
            ra.center_x = config.getInt("Center-X");
            ra.center_z = config.getInt("Center-Z");
            ra.radius = config.getInt("Radius");
            ra.worldname = config.getString("world");
            ra.p = player;
            player.teleport(ra.set_pos(), PlayerTeleportEvent.TeleportCause.PLUGIN);
            player.sendMessage("Teleported to random position.");
            return true;
        }
        if (args.length == 1){
            Player player = Bukkit.getPlayer(args[0]);
            FileConfiguration config = plugin.getConfig();
            randomteleport ra = new randomteleport();
            ra.center_x = config.getInt("Center-X");
            ra.center_z = config.getInt("Center-Z");
            ra.radius = config.getInt("Radius");
            ra.worldname = config.getString("world");
            ra.p = player;
            player.teleport(ra.set_pos(), PlayerTeleportEvent.TeleportCause.PLUGIN);
            player.sendMessage("Teleported to random position.");
            return true;
        }
        else if (args.length == 4 && (sender instanceof Player)){
            Player player = (Player) sender;
            randomteleport ra = new randomteleport();
            ra.center_x = Integer.parseInt(args[0]);
            ra.center_z = Integer.parseInt(args[1]);
            ra.radius = Integer.parseInt(args[2]);
            ra.worldname = args[3];
            ra.p = player;
            player.teleport(ra.set_pos(), PlayerTeleportEvent.TeleportCause.PLUGIN);
            player.sendMessage("Teleported to random position.");
            return true;
        }
        else if(args.length == 5){
            Player player = Bukkit.getPlayer(args[0]);
            randomteleport ra = new randomteleport();
            ra.center_x =Integer.parseInt(args[1]);
            ra.center_z =Integer.parseInt(args[2]);
            ra.radius =Integer.parseInt(args[3]);
            ra.worldname =args[4];
            ra.p = player;
            player.teleport(ra.set_pos(), PlayerTeleportEvent.TeleportCause.PLUGIN);
            player.sendMessage("Teleported to random position.");
            return true;
        }
        else{
            return false;
        }
    }
}
