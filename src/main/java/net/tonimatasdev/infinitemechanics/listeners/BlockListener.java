package net.tonimatasdev.infinitemechanics.listeners;

import net.tonimatasdev.infinitemechanics.InfiniteMechanics;
import net.tonimatasdev.infinitemechanics.util.BlockUtil;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockListener implements Listener {
    @EventHandler
    private void mechanic2(BlockPlaceEvent event) {
        if (InfiniteMechanics.disabledWorlds.contains(event.getBlock().getWorld())) return;
        if (!InfiniteMechanics.getInstance().getConfig().getBoolean("2")) return;
        if (event.getBlockPlaced().getType() != Material.SNOW) return;

        Block placedBlock = event.getBlock();

        if (BlockUtil.getSnowLayer(placedBlock) == 8) {
            event.getBlock().setType(Material.SNOW_BLOCK);
        }

    }
}
