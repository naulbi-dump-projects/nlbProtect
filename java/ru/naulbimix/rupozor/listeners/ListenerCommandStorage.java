package ru.naulbimix.rupozor.listeners;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class ListenerCommandStorage {

    private List<ListenerCommand> commandList = new ArrayList<ListenerCommand>();

    private JavaPlugin parent;

    public ListenerCommandStorage(JavaPlugin pl){
        this.parent = pl;
    }

    public void addListenerCommand(ListenerCommand command){
        commandList.add(command);
    }

    public boolean containsCommand(String arg){
        boolean b = false;
        for (ListenerCommand command : commandList) {
            if(command.containsCommand(arg)){
                b = true;
                break;
            }
        }
        return b;
    }

    public ListenerCommand getCommand(String arg){
        ListenerCommand cmd = null;
        for (ListenerCommand command : commandList) {
            if(command.containsCommand(arg)){
                cmd = command;
                break;
            }
        }
        return cmd;
    }

    public List<ListenerCommand> getCommands() {
        return commandList;
    }

    public JavaPlugin getParent() {
        return parent;
    }
}
