package me.champ.skyblock.commands;

import java.util.ArrayList;
import java.util.Iterator;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;

import me.champ.skyblock.Skyblock;



public class CommandHandler implements CommandExecutor {
	
	private ArrayList<SubCommand> commands = new ArrayList<SubCommand>();
	private Skyblock plugin = Skyblock.getInstance();

	//SubCommands
	public String base = "sb";
	public String shop = "shop";
	public String help = "help";
	public String tpw = "tpw"; //Teleport to world
	public String island = "island";
	
	public CommandHandler() {
		this.init();
	}
	
	public void init() {
		plugin.getCommand(base).setExecutor(this);
		
		
		this.commands.add(new HelpCommand());
		this.commands.add(new TeleportWorldCommand());
		this.commands.add(new IslandCommand());
		//this.commands.add(new ShopCommand());
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String name, String[] args) {
		
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Nice try! Only players can run this command ;)");
			return true;
		}
		
		Player player = (Player) sender;
		
		if (command.getName().equalsIgnoreCase(base)) {
			
			if (args.length == 0) {
				player.performCommand("sb help");
				return true;
			}
			
			SubCommand sub = this.get(args[0]);
			
			if (sub == null) {
				player.sendMessage(ChatColor.RED + "Invalid command");
			}
			
            
            sub.onCommand(player,args);
            
		}	
		return true;
	}
	
	public SubCommand get(String name) {
		Iterator<SubCommand> subcommands = this.commands.iterator();
		
		while(subcommands.hasNext()) {
			SubCommand subCmd = subcommands.next();
			
			if (subCmd.name().equalsIgnoreCase(name)) {
				return subCmd;
			}
		}
		return null;
	}

}
