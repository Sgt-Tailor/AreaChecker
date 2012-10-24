package me.sgt_tailor.areachecker;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ACCommandExecutor implements CommandExecutor {
	private Checker checker;
	private HashMap<String, Area> points;
	public ACCommandExecutor(AreaChecker instance) {
		points = instance.points;
		checker = new Checker(instance);
	}
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] arg) {
		
		if(cmd.getName().equalsIgnoreCase("acpoint1"))
		{
			if(sender instanceof Player){
				
				int x = (int) Math.round(((Player) sender).getLocation().getX());
				int y = (int) Math.round(((Player) sender).getLocation().getY());
				int z = (int) Math.round(((Player) sender).getLocation().getZ());
				Area a;
				if(!points.containsKey(sender.getName())) {
					a = new Area(((Player) sender).getWorld().getName(), x, y, z, x, y, z);
				}
				else {
					a = points.get(sender.getName());
					a.setPoint1(x, y, z);
				}
				points.put(sender.getName(), a);
				sender.sendMessage(ChatColor.GREEN + "First point set");
				return true;
			}
		}
		if(cmd.getName().equalsIgnoreCase("acpoint2")){
			if(sender instanceof Player){
				int x = (int) Math.round(((Player) sender).getLocation().getX());
				int y = (int) Math.round(((Player) sender).getLocation().getY());
				int z = (int) Math.round(((Player) sender).getLocation().getZ());
				Area a;
				if(!points.containsKey(sender.getName())) {
					a = new Area(((Player) sender).getWorld().getName(), x, y, z, x, y, z);
				}
				else {
					a = points.get(sender.getName());
					a.setPoint2(x, y, z);
				}
				points.put(sender.getName(), a);
				sender.sendMessage(ChatColor.GREEN + "Second point set");
				return true;
			}
		}
		if(cmd.getName().equalsIgnoreCase("accreate")){
			if(sender instanceof Player) {
			if(arg.length ==1){//shadowlapse create <name>
				Area a;
				if(!points.containsKey(sender.getName())) {
					sender.sendMessage(ChatColor.RED + "You must select a region first");
					return true;
				}
				a = points.get(sender.getName());
				
				checker.newArea(arg[0], a);
				
				sender.sendMessage(ChatColor.GREEN + "Region created");
				return true;
				
				
				
				
				
				
				} 
			}
			
		}	
		return false;
	}

}
