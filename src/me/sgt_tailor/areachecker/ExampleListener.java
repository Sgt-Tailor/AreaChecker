package me.sgt_tailor.areachecker;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;


public class ExampleListener implements Listener {
	private Checker checker;
	public ExampleListener(AreaChecker instance){
		checker = new Checker(instance);
	}
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent event) {
			if(checker.playerInArea(event.getPlayer())) {
				event.setCancelled(true);
				event.getPlayer().sendMessage(ChatColor.RED + "You are not allowed to do this while you are in this area");
				return;
			}
		
		
	}

}
