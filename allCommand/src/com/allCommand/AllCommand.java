package com.allCommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.allCommand.commands.GoHome;
import com.allCommand.commands.SaveMoney;
import com.allCommand.commands.SetHome;
import com.allCommand.event.DeathEvent;
import com.allCommand.event.PlayerEventHandler;
import com.allCommand.event.PluginEvent;
import com.allCommand.file.MakeFile;

public class AllCommand extends JavaPlugin{
	//버킷의 콘솔을 선언하고 대입하는 과정
	public ConsoleCommandSender console = Bukkit.getConsoleSender();
	
	//서버 > plugins의 플러그인안의 data.txt 파일을 선언하고 대입하는 과정 
//	private final File f = new File(getDataFolder(), "/data.txt");
	
	/**
	 * 버킷 켜질 때 실행되는 함수
	 */
	@Override
	public void onEnable(){
		console.sendMessage(ChatColor.AQUA + "[플러그인 활성화중입니다.]");
		
		PluginEvent.setPlugin(this);
		MakeFile.setPlugin(this);
		
		PluginEvent pluginEvent = new PluginEvent();
		PlayerEventHandler playerEventHandler = new PlayerEventHandler();
		DeathEvent deathEvent = new DeathEvent();
//		MakeFile makeFile = new MakeFile();
		
		//해당 커맨드 사용한다는 의미
		getCommand("setHome").setExecutor(new SetHome());
		getCommand("goHome").setExecutor(new GoHome());
		getCommand("bank").setExecutor(new SaveMoney());
		
		//서버의 플러그인 매니저에 이벤트 등록
		getServer().getPluginManager().registerEvents(deathEvent, this);
		getServer().getPluginManager().registerEvents(pluginEvent, this);
		getServer().getPluginManager().registerEvents(playerEventHandler, this);
	}
}
