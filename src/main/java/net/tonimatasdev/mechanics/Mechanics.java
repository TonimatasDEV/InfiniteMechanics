package net.tonimatasdev.mechanics;

import net.tonimatasdev.mechanics.listeners.BlockListener;
import net.tonimatasdev.mechanics.listeners.EntityListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Mechanics extends JavaPlugin {
    private static Mechanics instance;

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new BlockListener(), this);
        getServer().getPluginManager().registerEvents(new EntityListener(), this);
        getServer().getConsoleSender().sendMessage("Enabling ");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("Disabling ");
    }

    public static Mechanics getInstance() {
        return instance;
    }
}
