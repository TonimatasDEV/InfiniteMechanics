package net.tonimatasdev.minecraftthings;

import net.tonimatasdev.minecraftthings.listeners.BlockListener;
import net.tonimatasdev.minecraftthings.listeners.EntityListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class MinecraftThings extends JavaPlugin {
    private static MinecraftThings instance;

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

    public static MinecraftThings getInstance() {
        return instance;
    }
}
