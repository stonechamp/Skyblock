package me.champ.skyblock.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.champ.skyblock.Skyblock;


public class HelpCommand extends SubCommand {
	
	private Skyblock plugin = Skyblock.getInstance();

	@Override
	public void onCommand(Player player, String[] args) {
		
		player.sendMessage(ChatColor.GOLD + " " + ChatColor.BOLD + "Skyblock" + ChatColor.WHITE + " (v 0.1)");
		player.sendMessage(ChatColor.GRAY + "----------------------------");
		player.sendMessage(ChatColor.WHITE + "/sb shop" + ChatColor.GRAY + " - Access the server shop. ");
		player.sendMessage(ChatColor.WHITE + "/sb tpw" + ChatColor.GRAY + " - Teleport to a world. ");
		player.sendMessage(ChatColor.WHITE + "/sb island" + ChatColor.GRAY + " - Island commands ");

	}

	@Override
	public String name() {
		
		return plugin.commandhandler.help;
	}

}
