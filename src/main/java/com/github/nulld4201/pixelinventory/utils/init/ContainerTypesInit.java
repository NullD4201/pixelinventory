package com.github.nulld4201.pixelinventory.utils.init;

import com.github.nulld4201.pixelinventory.PixelInventoryMain;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerTypesInit {

    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister
            .create(ForgeRegistries.CONTAINERS, PixelInventoryMain.MOD_ID);
}
