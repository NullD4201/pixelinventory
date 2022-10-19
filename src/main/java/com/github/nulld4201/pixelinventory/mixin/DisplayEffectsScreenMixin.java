package com.github.nulld4201.pixelinventory.mixin;

import com.github.nulld4201.pixelinventory.gui.screen.inventory.PixelInventoryScreen;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.DisplayEffectsScreen;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.text.ITextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DisplayEffectsScreen.class)
public abstract class DisplayEffectsScreenMixin<T extends Container> extends ContainerScreen<T> {
    public DisplayEffectsScreenMixin(T abstractContainerMenu, PlayerInventory inventory, ITextComponent component) {
        super(abstractContainerMenu, inventory, component);
    }

    @Inject(method = "renderEffects", at = @At("HEAD"), cancellable = true)
    private void renderEffects(MatrixStack poseStack, CallbackInfo callbackInfo) {
        if (PixelInventoryScreen.isAvatarBig)
            callbackInfo.cancel();
    }
}
