package me.champ.skyblock.commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.world.DataException;

import me.champ.skyblock.Skyblock;
import me.champ.skyblock.utils.ChatUtil;
import me.champ.skyblock.utils.Schematic;
import me.champ.skyblock.world.WorldGeneration;
import net.md_5.bungee.api.ChatColor;

public class TeleportWorldCommand extends SubCommand {
	
	private Skyblock plugin = Skyblock.getInstance();

	@Override
	public void onCommand(Player player, String[] args) {
		
		if (args.length == 1) {
			player.sendMessage(ChatColor.GOLD + " " + ChatColor.BOLD + "Skyblock" + ChatColor.WHITE + " (v 0.1)");
			player.sendMessage(ChatColor.GRAY + "----------------------------");
			player.sendMessage(ChatColor.WHITE + "/sb tpw <world name>" + ChatColor.GRAY + " - Teleport to a world. ");
		}
		
		if (args.length == 2) {
			
			String worldName = args[1];
			File file = new File(plugin.getServer().getWorldContainer(), worldName);
			
			WorldGeneration world = new WorldGeneration(worldName);
			
			if (file.exists() && !(worldName.equals("skyblock"))) {
				
				if (Bukkit.getWorld(worldName) == null) {
					world.create();
					player.sendMessage(ChatUtil.log("&aLoading world..."));
				}
				
				Location loc = new Location(Bukkit.getWorld(worldName), 100, 100, 100);
				player.teleport(loc);
				return;
				
			}  else if (file.exists() && worldName.equals("skyblock")) {
				if (Bukkit.getWorld("skyblock") == null) {
					WorldGeneration skyblock = new WorldGeneration("skyblock");
					skyblock.create();
					player.sendMessage(ChatUtil.log("&eLoading world..."));
					
				}
				Location loc = new Location(Bukkit.getWorld(worldName), 100, 100, 100);
				player.teleport(loc);
				
			}
		}
		
		

	}

	@Override
	public String name() {
		
		return plugin.commandhandler.tpw;
	}

}
