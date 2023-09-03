package net.tonimatasdev.infinitemechanics;

import net.tonimatasdev.infinitemechanics.listeners.BlockListener;
import net.tonimatasdev.infinitemechanics.listeners.EntityListener;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class InfiniteMechanics extends JavaPlugin {
    private static InfiniteMechanics instance;
    public static List<World> disabledWorlds = new ArrayList<>();

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        for (String worldName : getConfig().getStringList("disabledWorlds")) {
            World world = getServer().getWorld(worldName);

            if (world == null) return;

            disabledWorlds.add(world);
        }

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

    public static InfiniteMechanics getInstance() {
        return instance;
    }
}
