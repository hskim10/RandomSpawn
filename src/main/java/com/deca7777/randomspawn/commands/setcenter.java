package com.deca7777.randomspawn.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import static com.deca7777.randomspawn.Main.plugin;

public class setcenter implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(args.length == 2) {
            Player player = (Player) sender;
            FileConfiguration config = plugin.getConfig();
            try {
                config.set("Center-X", Integer.parseInt(args[0]));
                config.set("Center-Z", Integer.parseInt(args[0]));
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
