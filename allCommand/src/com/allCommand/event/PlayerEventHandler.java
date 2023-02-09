package com.allCommand.event;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerEventHandler implements Listener {
	public ConsoleCommandSender console = Bukkit.getConsoleSender();
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action action = event.getAction();
		Block clickedBlock = event.getClickedBlock();
		
		console.sendMessage("action >> " + action.toString());
		console.sendMessage("clickedBlock >> " + clickedBlock.toString());
		console.sendMessage("clickedBlockType >> " + clickedBlock.getType().toString());
	}

}
