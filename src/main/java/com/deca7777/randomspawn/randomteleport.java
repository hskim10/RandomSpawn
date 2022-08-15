package com.deca7777.randomspawn;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.deca7777.randomspawn.Main.plugin;
import static org.bukkit.Bukkit.getServer;

public class randomteleport {
    public int center_x;
    public int center_z;
    public int radius;
    public String worldname;
    public Location set_pos(){
        int x,y,z;
        do {
            x = (int) (Math.random() * Math.pow(10, (int) (Math.log10(this.radius) + 1))) % (this.radius + 1)+center_x;
            int x1 = (int)(Math.random() * 10) % 2;
            if(x1 == 0){
                x *= -1;
            }
            z = (int) (Math.random() * Math.pow(10, (int) (Math.log10(this.radius) + 1))) % (this.radius + 1)+center_z;
            int z1 = (int)(Math.random() * 10) % 2;
            if(z1 == 0){
                z *= -1;
            }
            World world = getServer().getWorld(worldname);
            y = world.getHighestBlockYAt(x,z);
            Location l = new Location(world,x,y,z,0,0);
            if(!l.getBlock().getType().equals(Material.LAVA) && !l.getBlock().getType().equals(Material.WATER))
                return new Location(world,x,y+1,z,0,0);
        } while(true);
    }
}
