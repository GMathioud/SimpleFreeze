package tk.mycraft_public;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlacingEvent implements Listener{
	
	private SimpleFreeze core;
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		if (core.frozen.contains(player.getName()))
		{
			event.setCancelled(true);
		}
	}
}
