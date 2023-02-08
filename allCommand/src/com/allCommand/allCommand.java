package com.allCommand;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.allCommand.commands.goHome;
import com.allCommand.commands.setHome;
import com.allCommand.file.makeFile;
import com.allCommand.plugin.pluginEvent;

public class allCommand extends JavaPlugin{
	//버킷의 콘솔을 선언하고 대입하는 과정
		public ConsoleCommandSender console = Bukkit.getConsoleSender();
		
		//서버 > plugins의 플러그인안의 data.txt 파일을 선언하고 대입하는 과정 
		private final File f = new File(getDataFolder(), "/data.txt");
		
		/**
		 * 버킷 켜질 때 실행되는 함수
		 */
		@Override
		public void onEnable() {
			console.sendMessage(ChatColor.AQUA + "[플러그인 활성화중입니다.]");
			
			pluginEvent.setPlugin(this);
			makeFile.setPlugin(this);
			
			pluginEvent pluginEvent = new pluginEvent();
			makeFile makeFile = new makeFile();
			
			//해당 커맨드 사용한다는 의미
			getCommand("setHome").setExecutor(new setHome());
			getCommand("goHome").setExecutor(new goHome());
			
			//서버의 플러그인 매니저에 이벤트 등록
			getServer().getPluginManager().registerEvents(pluginEvent, this);
			makeFile.makeFile(makeFile.f);
			makeFile.mapToFile(makeFile.f, pluginEvent.map);
			makeFile.fileToMap(makeFile.f, pluginEvent.map);
		}
}
