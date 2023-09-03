package net.tonimatasdev.mechanics;

import net.tonimatasdev.mechanics.listeners.BlockListener;
import net.tonimatasdev.mechanics.listeners.EntityListener;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class InfiniteEvents extends JavaPlugin {
    private static InfiniteEvents instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new BlockListener(), this);
        getServer().getPluginManager().registerEvents(new EntityListener(), this);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "InfiniteEvents has been enabled.");
    }

    @Override
    public void onDisable() {
        reloadConfig();
        saveConfig();
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "InfiniteEvents has been disabled.");
    }

    public static InfiniteEvents getInstance() {
        return instance;
    }
}
