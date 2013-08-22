package tk.mycraft_public;

import java.util.HashSet;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleFreeze extends JavaPlugin{

	private Logger logger;
	public HashSet<Player> frozen;
	public String prefix = "" + ChatColor.GRAY + ChatColor.BOLD + "[" + ChatColor.GREEN + ChatColor.BOLD + "SimpleFreeze" + ChatColor.GRAY + ChatColor.BOLD + "]" + ChatColor.WHITE + " ";
	private static SimpleFreeze instance = new SimpleFreeze();
	
	private SimpleFreeze(){
		
	}
	
	public static SimpleFreeze getInstance(){
		return instance;
	}
	
	@Override
	public void onEnable() {
		logger = getLogger();
		PluginManager manager = getServer().getPluginManager();
		manager.registerEvents(new PlayerJoiningEvent(), this);
		manager.registerEvents(new BlockPlacingEvent(), this);
		manager.registerEvents(new BlockPlacingEvent(), this);
		manager.registerEvents(new PlayerMovementEvent(), this);
		frozen = new HashSet<Player>();
		logger.info(this.getDescription().getVersion() + " has been enabled!");
	}
	
	@Override
	public void onDisable() {
		logger.info(this.getDescription().getVersion() + " has been disabled!");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] Args) {
		if (commandlabel.equalsIgnoreCase("freeze"))
		{
    		if (Args.length == 0) return false;
			
			Player target = Bukkit.getPlayer(Args[0]);
			if (target == null)
			{
				sender.sendMessage(prefix + "Player not found.");
				return true;
			}
			if (frozen.contains(target.getName()))
			{
				sender.sendMessage(target.getDisplayName() + " is already frozen.");
				return true;
			}
			frozen.add(target);
			if (sender instanceof Player)
			{
				Player player = (Player) sender;
			    //TODO: target.sendMessage("You were frozen by " + player.getDisplayName());
			    Bukkit.broadcastMessage(target.getDisplayName() + " was frozen by " + player.getDisplayName());
			}
			else
			{
			    sender.sendMessage(target.getName() + "was frozen.");
				//TODO: target.sendMessage("You were frozen by " + sender.getName());
				Bukkit.broadcastMessage(target.getDisplayName() + " was frozen by " + sender.getName());
			}
			return true;
		}
		else if (commandlabel.equalsIgnoreCase("unfreeze"))
		{
			if (Args.length == 0) return false;
			
			Player target = Bukkit.getPlayer(Args[0]);
			if (target == null)
			{
				sender.sendMessage(prefix + "Player not found.");
				return true;
			}
			if (frozen.contains(target))
			{
				frozen.remove(target);
				if (sender instanceof Player)
				{
					Player player = (Player) sender;
					//TODO: target.sendMessage("You were unfrozen by " + player.getDisplayName());
					Bukkit.broadcastMessage(target.getDisplayName() + " was unfrozen by " + player.getDisplayName());
				}
				else
				{
					sender.sendMessage(target.getName() + " was frozen.");
				    //TODO: target.sendMessage("You were unfrozen by " + sender.getName());
					Bukkit.broadcastMessage(target.getDisplayName() + " was unfrozen by " + sender.getName());
			    }
			}
			return true;
		}
		return false;
	}	
}