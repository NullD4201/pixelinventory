package com.github.nulld4201.pixelinventory.event;

import com.github.nulld4201.pixelinventory.commands.SetRelicValid;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class CommandEvent {
    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {
        new SetRelicValid(event.getDispatcher());
    }
}
