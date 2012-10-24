package me.sgt_tailor.areachecker;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class AreaChecker extends JavaPlugin {
	public HashMap<String, Area> areas = new HashMap<String, Area>();
	public List<String> names;
	public Logger logger = Logger.getLogger("Minecraft");
	public HashMap<String, Area> points = new HashMap<String, Area>();
	
	public void onEnable() {
		File file = new File(getDataFolder().getAbsolutePath(), "config.yml");
		if(!file.exists()) {
			this.saveDefaultConfig();
		}
		loadAreas();
		this.getCommand("acpoint1").setExecutor(new ACCommandExecutor(this));
		this.getCommand("acpoint2").setExecutor(new ACCommandExecutor(this));
		this.getCommand("accreate").setExecutor(new ACCommandExecutor(this));
		PluginManager pm =  this.getServer().getPluginManager();
		pm.registerEvents(new ExampleListener(this), this);
		
		
	}
	
	public void onDisable() {
		
	}
	private void loadAreas() {
		names = this.getConfig().getStringList("area-names");
		for(int i = 0; i< names.size(); i++) {
			String areaname = names.get(i);
			logger.info(names.get(i));
			int x1 = this.getConfig().getInt(areaname + ".x1");
			int y1 = this.getConfig().getInt(areaname + ".y1");
			int z1 = this.getConfig().getInt(areaname + ".z1");
			
			int x2 = this.getConfig().getInt(areaname + ".x2");
			int y2 = this.getConfig().getInt(areaname + ".y2");
			int z2 = this.getConfig().getInt(areaname + ".z2");
			
			String world = this.getConfig().getString(areaname + ".world");
			
			Area newarea = new Area(world,x1, y1, z1, x2, y2, z2);
			areas.put(areaname, newarea);
		}
		
	}

}
