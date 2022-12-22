package com.github.nulld4201.pixelinventory;

import com.github.nulld4201.pixelinventory.block.PixelFurnaceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "pixel");
    public static final RegistryObject<Block> PIXEL_FURNACE = BLOCKS.register("furnace",
            () -> new PixelFurnaceBlock(Block.Properties.from(Blocks.FURNACE)));
}
