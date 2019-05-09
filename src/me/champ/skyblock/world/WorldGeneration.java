package me.champ.skyblock.world;

import java.io.File;

import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.entity.Player;

import me.champ.skyblock.Skyblock;
import me.champ.skyblock.utils.ChatUtil;

public class WorldGeneration {
	
	private static Skyblock plugin = Skyblock.getInstance();
	
	public String name;
	File file;
	
	public WorldGeneration(String name) {
		this.name = name;
	}
	
	public void create() {
		WorldCreator wc = new WorldCreator(name);

		wc.type(WorldType.FLAT);
		wc.generatorSettings("2;0;1;");

		wc.createWorld();
	}
	
	public boolean exists() {
		file = new File(plugin.getServer().getWorldContainer(), name);
		if (!(file.exists())) {
			return false;
		}
		return true;
	}

}
