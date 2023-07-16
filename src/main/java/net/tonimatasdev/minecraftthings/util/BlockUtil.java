package net.tonimatasdev.minecraftthings.util;

import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Snow;

public class BlockUtil {
    public static void addSnowLayer(Block snow) {
        BlockData blockData = snow.getBlockData();
        int layers = ((Snow) blockData).getLayers();

        if (layers < 8) {
            BlockData newBlockData = blockData.clone();
            ((Snow) newBlockData).setLayers(layers + 1);
            snow.setBlockData(newBlockData);
        }
    }

    public static int getSnowLayer(Block snow) {
        return ((Snow) snow.getBlockData()).getLayers();
    }
}
