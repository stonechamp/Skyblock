package me.champ.skyblock.commands;

import org.bukkit.entity.Player;

public abstract class SubCommand {
	
	public SubCommand() {
		
	}
	
	public abstract void onCommand(Player player, String[] args);
	
	public abstract String name();

}
