package com.deca7777.randomspawn;

import com.deca7777.randomspawn.commands.rt;
import com.deca7777.randomspawn.commands.setcenter;
import com.deca7777.randomspawn.commands.setradius;
import com.deca7777.randomspawn.event.onRespawn;
import com.deca7777.randomspawn.event.onJoin;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;


public class Main extends JavaPlugin {
	public static org.bukkit.plugin.Plugin plugin = null;

	@Override
	public void onEnable() {
		plugin = this;
		saveResource("config.yml", false);
		getServer().getPluginManager().registerEvents(new onRespawn(), this);
		getServer().getPluginManager().registerEvents(new onJoin(), this);
		this.getCommand("rt").setExecutor(new rt());
		this.getCommand("setcenter").setExecutor(new setcenter());
		this.getCommand("setradius").setExecutor(new setradius());
		getLogger().log(Level.INFO, "RandomSpwan Enabled!");
	}

	@Override
	public void onDisable() {
		getLogger().log(Level.INFO, "RandomSpwan Disabled!");
	}
}
