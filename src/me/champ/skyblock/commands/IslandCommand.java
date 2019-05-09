package me.champ.skyblock.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import me.champ.skyblock.Skyblock;
import me.champ.skyblock.utils.ChatUtil;
import me.champ.skyblock.utils.Schematic;
import me.champ.skyblock.world.WorldGeneration;

public class IslandCommand extends SubCommand {

	private Skyblock plugin = Skyblock.getInstance();
	
	@Override
	public void onCommand(Player player, String[] args) {
		//TODO: Open island GUI
		
		if (args.length == 2) {
			if (args[1].equalsIgnoreCase("create")) {
				if (Bukkit.getWorld("skyblock") == null) {
					WorldGeneration skyblock = new WorldGeneration("skyblock");
					skyblock.create();
					player.sendMessage(ChatUtil.log("&eLoading world..."));
					
				}
				Location loc = new Location(Bukkit.getWorld("skyblock"), 100, 100, 100);
				player.teleport(loc);
				
				Schematic.load(player);
			}
		}

	}

	@Override
	public String name() {
		
		return plugin.commandhandler.island;
	}

}
