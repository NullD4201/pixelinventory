package com.github.nulld4201.pixelinventory.commands;

import com.github.nulld4201.pixelinventory.gui.screen.gem.PixelGemScreen;
import com.github.nulld4201.pixelinventory.gui.screen.inventory.PixelInventoryScreen;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

public class SetGemVisible {
    public SetGemVisible(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("#pixelgem").requires((source) -> source.hasPermissionLevel(2))
                .then(Commands.literal("enable")
                        .then(Commands.literal("gem1").executes((command) -> {
                            PixelGemScreen.gemVisibleMap.put("gem1", true);

                            return 0;
                        }))
                        .then(Commands.literal("gem2").executes((command) -> {
                            PixelGemScreen.gemVisibleMap.put("gem2", true);
                            return 0;
                        }))
                        .then(Commands.literal("gem3").executes((command) -> {
                            PixelGemScreen.gemVisibleMap.put("gem3", true);
                            return 0;
                        }))
                        .then(Commands.literal("gem4").executes((command) -> {
                            PixelGemScreen.gemVisibleMap.put("gem4", true);
                            return 0;
                        }))
                        .then(Commands.literal("gem5").executes((command) -> {
                            PixelGemScreen.gemVisibleMap.put("gem5", true);
                            return 0;
                        }))
                        .then(Commands.literal("gem6").executes((command) -> {
                            PixelGemScreen.gemVisibleMap.put("gem6", true);
                            return 0;
                        }))
                        .then(Commands.literal("gem7").executes((command) -> {
                            PixelGemScreen.gemVisibleMap.put("gem7", true);
                            return 0;
                        }))
                        .then(Commands.literal("gem8").executes((command) -> {
                            PixelGemScreen.gemVisibleMap.put("gem8", true);
                            return 0;
                        }))
                        .then(Commands.literal("gem9").executes((command) -> {
                            PixelGemScreen.gemVisibleMap.put("gem9", true);
                            return 0;
                        }))
                )
                .then(Commands.literal("disable")
                        .then(Commands.literal("gem1").executes((command) -> {
                            PixelGemScreen.gemVisibleMap.put("gem1", false);
                            return 1;
                        }))
                        .then(Commands.literal("gem2").executes((command) -> {
                            PixelGemScreen.gemVisibleMap.put("gem2", false);
                            return 1;
                        }))
                        .then(Commands.literal("gem3").executes((command) -> {
                            PixelGemScreen.gemVisibleMap.put("gem3", false);
                            return 1;
                        }))
                        .then(Commands.literal("gem4").executes((command) -> {
                            PixelGemScreen.gemVisibleMap.put("gem4", false);
                            return 1;
                        }))
                        .then(Commands.literal("gem5").executes((command) -> {
                            PixelGemScreen.gemVisibleMap.put("gem5", false);
                            return 1;
                        }))
                        .then(Commands.literal("gem6").executes((command) -> {
                            PixelGemScreen.gemVisibleMap.put("gem6", false);
                            return 1;
                        }))
                        .then(Commands.literal("gem7").executes((command) -> {
                            PixelGemScreen.gemVisibleMap.put("gem7", false);
                            return 1;
                        }))
                        .then(Commands.literal("gem8").executes((command) -> {
                            PixelGemScreen.gemVisibleMap.put("gem8", false);
                            return 1;
                        }))
                        .then(Commands.literal("gem9").executes((command) -> {
                            PixelGemScreen.gemVisibleMap.put("gem9", false);
                            return 1;
                        }))
                ));
    }
}
