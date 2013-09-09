package fr.pitiqui.AllInOne;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener
{
	public void onEnable()
	{
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("write"))
		{   
            if (args.length == 0) {
                    p.sendMessage(ChatColor.RED + "You did not specify a name!");
                    return false;
            }
            
            if (args.length == 1) {
                p.sendMessage(ChatColor.RED + "You must specify a message!");
                return false;
            }
            
            String message = "";
            for (int LOL = 1; LOL < args.length; LOL ++)	 
            {
            		message = message + args[LOL] + " ";
           	}
            String argument1 = args[0];
            p = Bukkit.getServer().getPlayer(argument1);
            p.chat(message);
            return true;
		}
		return false;
	}
}