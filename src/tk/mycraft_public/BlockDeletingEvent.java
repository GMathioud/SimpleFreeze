package tk.mycraft_public;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockDeletingEvent implements Listener{
	
	private SimpleFreeze core;
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		if (core.frozen.contains(player.getName()))
		{
			event.setCancelled(true);
		}
	}
}
