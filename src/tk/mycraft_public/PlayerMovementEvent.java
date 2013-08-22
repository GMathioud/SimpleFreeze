package tk.mycraft_public;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMovementEvent implements Listener{
	
	private SimpleFreeze core;
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		if (core.frozen.contains(player.getName()))
		{
			player.teleport(player);
		}
	}
}
