package net.tonimatasdev.minecraftthings.util;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Snow;

public class WorldUtil {
    public static void placeBlock(World world, Location location, Material material) {
        world.getBlockAt(location).setType(material);
    }

    public static void setSnowOrAddSnowLayer(World world, Location location) {
        Block snow = world.getBlockAt(location);

        if (snow.getType() == Material.SNOW ) {
            BlockUtil.addSnowLayer(snow);
        } else if (snow.getType() == Material.AIR) {
            world.getBlockAt(location).setType(Material.SNOW);
        }
    }
}
