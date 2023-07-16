package net.tonimatasdev.mechanics.util;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class WorldUtil {
    public static void setSnowOrAddSnowLayer(World world, Location location) {
        Block snow = world.getBlockAt(location);

        if (snow.getType() == Material.SNOW ) {
            BlockUtil.addSnowLayer(snow);
        } else if (snow.getType() == Material.AIR) {
            world.getBlockAt(location).setType(Material.SNOW);
        }
    }
}
