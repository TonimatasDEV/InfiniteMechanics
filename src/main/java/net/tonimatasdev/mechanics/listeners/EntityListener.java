package net.tonimatasdev.mechanics.listeners;

import net.tonimatasdev.mechanics.util.BlockUtil;
import net.tonimatasdev.mechanics.util.WorldUtil;
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
    private void onProjectileHit(ProjectileHitEvent event) {
        if (event.getHitBlockFace() == BlockFace.UP) {
            if (event.getEntity() instanceof Snowball snowball) {
                if (event.getHitBlock() != null) {
                    Block hitBlock = event.getHitBlock();
                    if (hitBlock.getType() == Material.SNOW) {
                        int snowLayer = BlockUtil.getSnowLayer(hitBlock);

                        if (snowLayer == 8) {
                            hitBlock.setType(Material.SNOW_BLOCK);
                        } else if (snowLayer > 1) {
                            WorldUtil.setSnowOrAddSnowLayer(hitBlock.getWorld(), hitBlock.getLocation());
                            return;
                        }
                    }

                    Location snowLocation = new Location(snowball.getWorld(), hitBlock.getX(), hitBlock.getY() + 1, hitBlock.getZ());
                    WorldUtil.setSnowOrAddSnowLayer(hitBlock.getWorld(), snowLocation);
                }
            }
        }
    }
}
