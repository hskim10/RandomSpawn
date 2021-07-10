package deca.spawn;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

public class RandomTeleport implements Listener{
	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerJoin(PlayerJoinEvent e) {
		ExecutorService ep = Executors.newCachedThreadPool();
		ep.execute(() -> {
			String str1 = null;
			String uuid = e.getPlayer().getUniqueId().toString()+"\n";
			File olduser = new File("plugins/RandomSpawn" + File.separator + "olduser.txt");
			InputStream stream2;
			try {
				stream2 = new FileInputStream(olduser);
				byte[] bin1 = new byte[(int)olduser.length()];
				stream2.read(bin1);
				str1 = new String(bin1);
				stream2.close();
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
			if(str1.indexOf(uuid) != -1) {
				return;
			}
			else if(str1.indexOf(uuid) == -1){
				try {
					FileWriter fr = new FileWriter(olduser,true);
					BufferedWriter br = new BufferedWriter(fr);
					br.write(uuid);
					br.close();
					fr.close();
				} catch (Throwable ee) {
					ee.printStackTrace();
				}
				int x=0;
				int y=0;
				int z=0;
				while(true) {
					Material[] blocks = new Material[131];
					int tmpx = (int)(Math.random()*60001)+1;
					if(tmpx < 30001) {
						tmpx = tmpx * -1;
					}
					else if(tmpx > 30001) {
						tmpx = tmpx - 30001;
					}
					else {
						tmpx = 0;
					}
					int tmpz = (int)(Math.random()*60001)+1;
					if(tmpz < 30001) {
						tmpz = tmpz * -1;
					}
					else if(tmpz > 30001) {
						tmpz = tmpz - 30001;
					}
					else {
						tmpz = 0;
					}
					for(int i = 50; i < 131; i++) {
						blocks[i] = Bukkit.getWorld("world").getBlockAt(tmpx,i,tmpz).getType();
					}
					int count=0;
					int tt=0;
					Bukkit.getConsoleSender().sendMessage(tmpx+","+tmpz+", after for");
					for(int i = 50; i < 131; i++) {
						if(i >= 51&&blocks[i].equals(Material.AIR)) {
							count++;
							if(count == 10) {
								x = tmpx;
								y = tt;
								z = tmpz;
								break;
							}
							else if(count == 1 && (blocks[i-1].equals(Material.WATER) == false && blocks[i-1].equals(Material.LAVA) == false)) {
								tt = i;
							}
							else if(count > 1) {
								continue;
							}
							else {
								count = 0;
							}
						}
						else {
							count=0;
						}
					}
					if(count == 10) {
						Player p = e.getPlayer();
								Bukkit.getConsoleSender().sendMessage("teleporting, x="+x+"y="+y+"z="+z);
								Location l = new Location(Bukkit.getWorld("world"),x,y,z);
								p.teleport(l);
								p.sendMessage(ChatColor.YELLOW+"처음 접속하셨습니다. 자동으로 스폰 위치가 정해집니다...");
								ItemStack a = new ItemStack(Material.GLASS_BOTTLE);
								for(int i = 0; i < 12; i++) {
									p.getInventory().addItem(a);
								}
								break;
					}
					else {
						continue;
					}
				}
			}
			return;
		});
	}
}
