package com.github.nulld4201.pixelinventory.utils;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.ClientRegistry;

import java.awt.event.KeyEvent;

@OnlyIn(Dist.CLIENT)
public class BindKey {
    public static KeyBinding rotateModelLeft;
    public static KeyBinding rotateModelRight;
    public static KeyBinding rotateModelUp;
    public static KeyBinding rotateModelDown;
    public static KeyBinding playerModelBig;

    public static void register() {
        rotateModelLeft = create("플레이어 모델 왼쪽으로 회전", 263);
        rotateModelRight = create("플레이어 모델 오른쪽으로 회전", 262);
        rotateModelUp = create("플레이어 모델 위로 회전", 265);
        rotateModelDown = create("플레이어 모델 아래로 회전", 264);
        playerModelBig = create("크게 보기", KeyEvent.VK_EQUALS);

        ClientRegistry.registerKeyBinding(rotateModelLeft);
        ClientRegistry.registerKeyBinding(rotateModelRight);
        ClientRegistry.registerKeyBinding(rotateModelUp);
        ClientRegistry.registerKeyBinding(rotateModelDown);
        ClientRegistry.registerKeyBinding(playerModelBig);
    }

    private static KeyBinding create(String name, int key) {
        return new KeyBinding(name, key, "PixelInventory");
    }
}
