package me.sgt_tailor.areachecker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Checker {
	private AreaChecker plugin;
	private HashMap<String, Area> areas;
	private List<String> names;
	public Checker(AreaChecker instance) {
		plugin = instance;
		areas = plugin.areas;
		names = plugin.names;
	}
	
	public boolean areaExists(String name) {
		if(names.contains(name)) {
			return true;
		}
		return false;
	}
	
	public boolean playerInArea(Player p, String area) {
		if(names.contains(area)) {
			Area aname = areas.get(area);
			ArrayList<Integer> points = aname.getPoints();
			
			String world = aname.getWorld();
			int x1 = points.get(0);
			int y1 = points.get(1);
			int z1 = points.get(2);
			
			int x2 = points.get(3);
			int y2 = points.get(4);
			int z2 = points.get(5);
			
			x1 = Math.min(x1, x2);
			y1 = Math.min(y1, y2);
			z1 = Math.min(z1, z2);
			
			x2 = Math.max(x1, x2);
			y2 = Math.max(y1, y2);
			z2 = Math.max(z1, z2);
			
			Location ploc = p.getLocation();
			long px = Math.round(ploc.getX());
			long py = Math.round(ploc.getX());
			long pz = Math.round(ploc.getX());
			
			if(world.equals(p.getWorld())) {
				if(px >= x1 && px <= x2) {
					if(py >= y1 && py <= y2) {
						if(pz >= z1 && pz <= z2) {
							return true;
						}
					}
				}
			}
		}
		
		
		return false;
	}
	public boolean playerInArea(Player p) {
		for(int i=0; i < plugin.names.size(); i++) {
			Area area = areas.get(plugin.names.get(i));
			ArrayList<Integer> points = area.getPoints();
			
			String world = area.getWorld();
			int x1 = points.get(0);
			int y1 = points.get(1);
			int z1 = points.get(2);
			
			int x2 = points.get(3);
			int y2 = points.get(4);
			int z2 = points.get(5);

			Location ploc = p.getLocation();
			long px = Math.round(ploc.getX());
			long py = Math.round(ploc.getY());
			long pz = Math.round(ploc.getZ());
			
			if(world.equals(p.getWorld().getName())) {
				if((px >= x1 && px <= x2) || (px <= x1 && px >= x2)) {
					if((py >= y1 && py <= y2) || (py <= y1 && py >= y2)) {
						if((pz >= z1 && pz <= z2) || (pz <= z1 && pz >= z2)) {
							return true;
						}
					}
				}
			}
		}
		return false;
		
	}
	public void newArea(String name, Area area) {
		plugin.areas.put(name, area);
		plugin.names.add(name);
		
		ArrayList<Integer> points = area.getPoints();
		
		String world = area.getWorld();
		int x1 = points.get(0);
		int y1 = points.get(1);
		int z1 = points.get(2);
		
		int x2 = points.get(3);
		int y2 = points.get(4);
		int z2 = points.get(5);
		
		plugin.getConfig().set(name + ".world", world );
		plugin.getConfig().set(name + ".x1", x1);
		plugin.getConfig().set(name + ".y1", y1);
		plugin.getConfig().set(name + ".z1", z1);

		plugin.getConfig().set(name + ".x2", x2);
		plugin.getConfig().set(name + ".y2", y2);
		plugin.getConfig().set(name + ".z2", z2);
		
		plugin.getConfig().set("area-names", plugin.names);
		
		saveConfig();
	}
	public void saveConfig() {
		plugin.saveConfig();
	}

}
