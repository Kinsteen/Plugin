package fr.pitiqui.AllInOne;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener
{
	Logger log = Bukkit.getLogger();
	public void onEnable()
	{
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        log.info("[All-In-One] Yeah you start All-In-One !");
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
            for (int i = 1; i < args.length; i ++)	 
            {
            		message = message + args[i] + " ";
           	}
            String argument1 = args[0];
            p = Bukkit.getServer().getPlayer(argument1);
            p.chat(message);
            return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("health"))
		{ 
			int Hp;
			Hp = Integer.parseInt(args[0]); 
			p.setMaxHealth(Hp);
			p.setHealth(Hp);
			return true;
		}
		
		if (cmd.getName().equalsIgnoreCase("heal"))
		{ 
			p.setHealth(p.getMaxHealth());
			return true;
		}
		return false;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e)
	{
		log.info("[All-In-One] A player join ! Set health...");
		int Hp = 40;
		e.getPlayer().setMaxHealth(Hp);
		e.getPlayer().setHealth(Hp);
		log.info("[All-In-One] Yup ! That it's !");
	}
}