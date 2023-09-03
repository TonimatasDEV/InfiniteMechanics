package net.tonimatasdev.infinitemechanics.listeners;

import net.tonimatasdev.infinitemechanics.InfiniteMechanics;
import net.tonimatasdev.infinitemechanics.util.BlockUtil;
import net.tonimatasdev.infinitemechanics.util.WorldUtil;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class EntityListener implements Listener {
    @EventHandler
    private void mechanic1(ProjectileHitEvent event) {
        if (InfiniteMechanics.disabledWorlds.contains(event.getEntity().getWorld())) return;
        if (!InfiniteMechanics.getInstance().getConfig().getBoolean("1")) return;
        if (event.getHitBlockFace() != BlockFace.UP) return;

        if (event.getEntity() instanceof Snowball snowball) {
            if (event.getHitBlock() == null) return;

            Block hitBlock = event.getHitBlock();
            if (hitBlock.getType() != Material.SNOW) return;

            int snowLayer = BlockUtil.getSnowLayer(hitBlock);

            if (snowLayer == 8) {
                hitBlock.setType(Material.SNOW_BLOCK);
            } else if (snowLayer > 1) {
                WorldUtil.setSnowOrAddSnowLayer(hitBlock.getWorld(), hitBlock.getLocation());
                return;
            }

            Location snowLocation = new Location(snowball.getWorld(), hitBlock.getX(), hitBlock.getY() + 1, hitBlock.getZ());
            WorldUtil.setSnowOrAddSnowLayer(hitBlock.getWorld(), snowLocation);
        }
    }
}
