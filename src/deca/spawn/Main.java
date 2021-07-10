package deca.spawn;

import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class Main extends JavaPlugin {
	@Override
	public void onEnable(){
		File olduser = new File(getDataFolder() + File.separator + "olduser.txt");
		File config = new File(getDataFolder() + File.separator + "config.yml");
		File folder = new File(getDataFolder()+"");
		if(folder.exists() == false) {
			folder.mkdir();
		}
		if(olduser.exists() == false) {
			try {
				olduser.createNewFile();
				OutputStream stream = new FileOutputStream(olduser);
				String abcd = "UUIDs\n";
				byte[] bin = abcd.getBytes();
				stream.write(bin);
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(config.exists() == false) {
			try {
				config.createNewFile();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		getServer().getPluginManager().registerEvents(new RandomTeleport(), this);
	}
	@Override
	public void onDisable(){
	}

	/*public static String aaa(String uuid,int rec) {
		Main m = new Main();
		File olduser = new File(m.bbbb() + File.separator + "olduser.txt");
		if(rec == 0) {
		String str1 = null;
		InputStream stream2;
		try {
			stream2 = new FileInputStream(olduser);
			byte[] bin1 = new byte[(int)olduser.length()];
			str1 = bin1.toString();
			stream2.close();
		} catch (Throwable e1) {
			e1.printStackTrace();
		}
		return str1;
		}
		else if(rec == 1) {
		try {
			OutputStream stream = new FileOutputStream(olduser);
			InputStream stream1 = new FileInputStream(olduser);
			byte[] bin = new byte[(int)olduser.length()+uuid.length()+1];
			stream1.read(bin);
			String abcd = bin.toString();
			abcd = abcd + uuid;
			bin = abcd.getBytes();
			stream.write(bin);
			Bukkit.getConsoleSender().sendMessage(abcd);
			stream.close();
			stream1.close();
		} catch (Throwable ee) {
			ee.printStackTrace();
		}
		return null;
		}
		return null;
	}*/
}
