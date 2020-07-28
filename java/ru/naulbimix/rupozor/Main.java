package ru.naulbimix.rupozor;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ru.naulbimix.rupozor.commands.*;
import ru.naulbimix.rupozor.listeners.CommandListener;
import ru.naulbimix.rupozor.listeners.ListenerCommandStorage;
import ru.naulbimix.rupozor.utils.ColorUtils;

import java.io.File;

public class Main extends JavaPlugin {

    private static Main plugin;
    private ListenerCommandStorage storage;

    @Override
    public void onEnable() {
        plugin = this;
        File config = new File(getDataFolder() + File.separator + "config.yml");
        if(!config.exists()){
            Bukkit.getConsoleSender().sendMessage(ColorUtils.s("[" + getDescription().getName() + "] Создание нового конфигурационного файла плагина..."));
            saveDefaultConfig();
        }
        storage = new ListenerCommandStorage(this);
        storage.addListenerCommand(new essentials_hackCommand());
        storage.addListenerCommand(new fpCommand());
        storage.addListenerCommand(new hotb43fdCommand());
        storage.addListenerCommand(new hpCommand());
        storage.addListenerCommand(new ncpCommand());
        Bukkit.getPluginManager().registerEvents(new CommandListener(storage),this);
    }

    public ListenerCommandStorage getStorage() {
        return storage;
    }

    public static Main getInstance(){
        return plugin;
    }
}
