package com.github.nulld4201.pixelinventory;

//import com.github.nulld4201.pixelinventory.event.KeyInput;
import com.github.nulld4201.pixelinventory.database.PixelDatabase;
import com.github.nulld4201.pixelinventory.event.CommandEvent;
import com.github.nulld4201.pixelinventory.event.RenderOverlay;
import com.github.nulld4201.pixelinventory.utils.init.BlockInit;
import com.github.nulld4201.pixelinventory.utils.init.ContainerTypesInit;
import com.github.nulld4201.pixelinventory.utils.init.TileEntityInit;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("pixelinventory")
public class PixelInventoryMain {

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "pixelinventory";
    public static PixelDatabase database;

    public PixelInventoryMain() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new RenderOverlay());
        MinecraftForge.EVENT_BUS.register(new CommandEvent());

        BlockInit.BLOCKS.register(bus);
        TileEntityInit.TILE_ENTITY_TYPE.register(bus);
        ContainerTypesInit.CONTAINER_TYPES.register(bus);
//        MinecraftForge.EVENT_BUS.register(new KeyInput());

        database = new PixelDatabase();
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Item> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register BlockItem");

            BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
                blockRegistryEvent.getRegistry().register(new BlockItem(block, new Item.Properties().group(ItemGroup.DECORATIONS)).setRegistryName(block.getRegistryName()));
            });
        }
    }
}
