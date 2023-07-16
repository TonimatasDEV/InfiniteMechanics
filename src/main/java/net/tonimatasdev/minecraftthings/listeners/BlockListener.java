package net.tonimatasdev.minecraftthings.listeners;

import net.tonimatasdev.minecraftthings.util.BlockUtil;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockListener implements Listener {
    @EventHandler
    private void onPlaceBlock(BlockPlaceEvent event) {
        if (event.getBlockPlaced().getType() == Material.SNOW) {
            Block placedBlock = event.getBlock();

            if (BlockUtil.getSnowLayer(placedBlock) == 8) {
                event.getBlock().setType(Material.SNOW_BLOCK);
            }
        }
    }
}
