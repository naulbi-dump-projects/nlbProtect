package ru.naulbimix.rupozor.listeners;

import org.bukkit.entity.Player;

import java.util.Arrays;

public interface ListenerCommand {

    String[] getCommand();

    boolean onCommand(Player p, String label, String[] args);

    boolean isCancelled();

    default boolean containsCommand(String arg){
        return  Arrays.asList(getCommand()).contains(arg.toLowerCase());
    }
}
