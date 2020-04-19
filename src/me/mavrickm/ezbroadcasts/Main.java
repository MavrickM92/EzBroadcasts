package me.mavrickm.ezbroadcasts;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements CommandExecutor {

	@Override
	public void onEnable() {
		getLogger().info("EzBroadcasts enabled");
		
		getCommand("broadcast").setExecutor(this);
		
		this.getConfig().options().copyDefaults();
		saveDefaultConfig();
		
		
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		if(cmd.getName().equalsIgnoreCase("broadcast")) {
			if(!sender.hasPermission("ezbroadcast.broadcast")) {
				sender.sendMessage(ChatColor.RED + "You don't have permission to execute this command!");
			} else {
				if(args.length >= 0) {
					StringBuilder message = new StringBuilder();
					for(int i = 0; i < args.length; i++) {
						message.append(args[i]).append(" ");
					}
					for(Player r : Bukkit.getOnlinePlayers()) {
						r.sendMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("Prefix")) +
								      ChatColor.translateAlternateColorCodes('&', ChatColor.WHITE + message.toString()));
					}
					
				}
			}
		}
				
		return true;
	}
	
}
