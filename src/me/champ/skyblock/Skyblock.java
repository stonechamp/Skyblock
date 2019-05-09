package me.champ.skyblock;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;

import me.champ.skyblock.commands.CommandHandler;
import me.champ.skyblock.utils.ChatUtil;
import me.champ.skyblock.world.WorldGeneration;

public class Skyblock extends JavaPlugin {
	
	public static Skyblock plugin;
	public CommandHandler commandhandler;
	
	public WorldEditPlugin wep;
	
	@Override
	public void onEnable() {
		plugin = this;
		
		commandhandler = new CommandHandler();
		wep = (WorldEditPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
		
		File file = new File(getServer().getWorldContainer(), "skyblock");
		if(!(file.exists())) {
			Bukkit.getConsoleSender().sendMessage(ChatUtil.log("&l&eSkyblock world doesn't exist, creating now..."));
			WorldGeneration skyblockWorld = new WorldGeneration("skyblock");
			skyblockWorld.create();
		}else {
			Bukkit.getConsoleSender().sendMessage(ChatUtil.log("&l&aSkyblock world exists!"));
		}
	}
	
	
	public static Skyblock getInstance() {
		return plugin;
	}

}
