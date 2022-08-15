package com.deca7777.randomspawn.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import static com.deca7777.randomspawn.Main.plugin;

public class setradius implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        Player player = (Player) sender;
        FileConfiguration config = plugin.getConfig();
        if(args.length == 1) {
            try {
                config.set("Radius", Integer.parseInt(args[0]));
                return true;
            } catch(Exception e){
                e.printStackTrace();
                return false;
            }
        }
        else{
            return false;
        }
    }
}
