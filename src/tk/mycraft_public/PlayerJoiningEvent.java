package tk.mycraft_public;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoiningEvent implements Listener{
	
	private SimpleFreeze core;
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		if (core.frozen.contains(player.getName()))
		{
		    player.sendMessage(ChatColor.RED + ">>                                                                      <<");
		    player.sendMessage(ChatColor.RED + ">> You have been frozen so you will not be able to move. <<");
		    player.sendMessage(ChatColor.RED + ">>                                                                      <<");
		}
	}
}
