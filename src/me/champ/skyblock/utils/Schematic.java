package me.champ.skyblock.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;


import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.schematic.MCEditSchematicFormat;
import com.sk89q.worldedit.world.DataException;


import me.champ.skyblock.Skyblock;

public class Schematic {
	
	private static Skyblock plugin = Skyblock.getInstance();
	
	@SuppressWarnings("deprecation")
	public static void load(Player player) {
		Location location = player.getLocation().subtract(0, 8, 2);
	    WorldEditPlugin worldEditPlugin = (WorldEditPlugin)Bukkit.getPluginManager().getPlugin("WorldEdit");
	    File schematic = new File(worldEditPlugin.getDataFolder() + File.separator + "/schematics/island.schematic");
	    EditSession session = worldEditPlugin.getWorldEdit().getEditSessionFactory().getEditSession(new BukkitWorld(location.getWorld()), 10000);
	    try
	    {
	      CuboidClipboard clipboard = MCEditSchematicFormat.getFormat(schematic).load(schematic);
	      clipboard.rotate2D(90);
	      clipboard.paste(session, new Vector(location.getX(), location.getY(), location.getZ()), false);
	    }
	    catch (MaxChangedBlocksException|DataException|IOException e)
	    {
	      e.printStackTrace();
	    }
	}
	
	

}
