package net.tonimatasdev.minecraftthings;

import net.tonimatasdev.minecraftthings.listeners.EntityListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class MinecraftThings extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EntityListener(), this);
    }

    @Override
    public void onDisable() {
    }
}
