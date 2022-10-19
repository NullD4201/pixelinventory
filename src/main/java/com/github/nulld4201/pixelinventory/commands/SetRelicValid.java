package com.github.nulld4201.pixelinventory.commands;

import com.github.nulld4201.pixelinventory.gui.screen.inventory.PixelInventoryScreen;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

public class SetRelicValid {
    public SetRelicValid(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("#pixelinventory").requires((source) -> source.hasPermissionLevel(2))
                .then(Commands.literal("setrelicvalid").executes((command) -> {
                    setRelicValid(true);
                    return 0;
                })
                ).then(Commands.literal("setrelicinvalid").executes((command) -> {
                    setRelicValid(false);
                    return 1;
                })));
    }

    private void setRelicValid(boolean isvalid) {
        PixelInventoryScreen.isRelicValid = isvalid;
    }
}
