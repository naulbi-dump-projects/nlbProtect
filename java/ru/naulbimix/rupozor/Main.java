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
        saveDefaultConfig(); // самые крутые утилитки спиздили в этом плагине
        storage = new ListenerCommandStorage(this); // а хуль ты думал?
        storage.addListenerCommand(new essentials_hackCommand()); // дальше пойдёт пиздец, советую просто наблюдать пастинг
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
