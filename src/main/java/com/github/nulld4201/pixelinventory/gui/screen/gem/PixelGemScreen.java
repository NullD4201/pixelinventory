package com.github.nulld4201.pixelinventory.gui.screen.gem;

import com.github.nulld4201.pixelinventory.Main;
import com.github.nulld4201.pixelinventory.gui.screen.inventory.PixelInventoryScreen;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;

import java.util.HashMap;
import java.util.Map;

public class PixelGemScreen extends Screen {
    private static final ResourceLocation GEM1_RES = new ResourceLocation(Main.MOD_ID, "textures/gui/gem/bat_stone.png");
    private static final ResourceLocation GEM2_RES = new ResourceLocation(Main.MOD_ID, "textures/gui/gem/devil_stone.png");
    private static final ResourceLocation GEM3_RES = new ResourceLocation(Main.MOD_ID, "textures/gui/gem/dog_stone.png");
    private static final ResourceLocation GEM4_RES = new ResourceLocation(Main.MOD_ID, "textures/gui/gem/wood_stone.png");
    private static final ResourceLocation GEM5_RES = new ResourceLocation(Main.MOD_ID, "textures/gui/gem/soul_stone.png");
    private static final ResourceLocation GEM6_RES = new ResourceLocation(Main.MOD_ID, "textures/gui/gem/turtle_stone.png");
    private static final ResourceLocation GEM7_RES = new ResourceLocation(Main.MOD_ID, "textures/gui/gem/viking_stone.png");
    private static final ResourceLocation GEM8_RES = new ResourceLocation(Main.MOD_ID, "textures/gui/gem/wizard_stone.png");
    private static final ResourceLocation GEM9_RES = new ResourceLocation(Main.MOD_ID, "textures/gui/gem/mushroom_stone.png");
    private static final ResourceLocation BUTTON_ITEM_TOGGLE = new ResourceLocation(Main.MOD_ID, "textures/gui/item_enable.png");
    private static final ResourceLocation PIXEL_RELIC_INVENTORY = new ResourceLocation(Main.MOD_ID, "textures/gui/relicinventory.png");

    public static Map<String, Boolean> gemVisibleMap = new HashMap<>();

    public ImageButton gem1 = new ImageButton(0, 0, 16, 16, 0, 0, 0, GEM1_RES, 16, 16,
            (button) -> {
                Main.LOGGER.warn("gem1");
            },
            (tooltipButton, tooltipMatrixStack, tooltipMouseX, tooltipMouseY) -> {
        if (tooltipButton.visible) {
            if (tooltipMousePos(tooltipButton, tooltipMouseX, tooltipMouseY, 4, 12, 5, 11) || tooltipMousePos(tooltipButton, tooltipMouseX, tooltipMouseY, 5, 11, 4, 12) || tooltipMousePos(tooltipButton, tooltipMouseX, tooltipMouseY, 6, 10, 3, 13))
                this.renderTooltip(tooltipMatrixStack, new StringTextComponent("gem1"), tooltipMouseX, tooltipMouseY);
        }
            },
            new StringTextComponent("gem1 button")
    );
    public ImageButton gem2 = new ImageButton(0, 0, 16, 16, 0, 0, 0, GEM2_RES, 16, 16,
            (button) -> {
                Main.LOGGER.warn("gem2");
            },
            (tooltipButton, tooltipMatrixStack, tooltipMouseX, tooltipMouseY) -> {
        if (tooltipButton.visible) {
            if (tooltipMousePos(tooltipButton, tooltipMouseX, tooltipMouseY, 4, 12, 5, 11) || tooltipMousePos(tooltipButton, tooltipMouseX, tooltipMouseY, 5, 11, 4, 12) || tooltipMousePos(tooltipButton, tooltipMouseX, tooltipMouseY, 6, 10, 3, 13))
                this.renderTooltip(tooltipMatrixStack, new StringTextComponent("gem2"), tooltipMouseX, tooltipMouseY);
        }
            },
            new StringTextComponent("gem2 button")
    );
    public ImageButton gem3 = new ImageButton(0, 0, 16, 16, 0, 0, 0, GEM3_RES, 16, 16,
            (button) -> {
                Main.LOGGER.warn("gem3");
            },
            (tooltipButton, tooltipMatrixStack, tooltipMouseX, tooltipMouseY) -> {
        if (tooltipButton.visible) {
            if (tooltipMousePos(tooltipButton, tooltipMouseX, tooltipMouseY, 4, 12, 5, 11) || tooltipMousePos(tooltipButton, tooltipMouseX, tooltipMouseY, 5, 11, 4, 12) || tooltipMousePos(tooltipButton, tooltipMouseX, tooltipMouseY, 6, 10, 3, 13))
                this.renderTooltip(tooltipMatrixStack, new StringTextComponent("gem3"), tooltipMouseX, tooltipMouseY);
        }
            },
            new StringTextComponent("gem3 button")
    );
    public ImageButton gem4 = new ImageButton(0, 0, 16, 16, 0, 0, 0, GEM4_RES, 16, 16,
            (button) -> {
                Main.LOGGER.warn("gem4");
            },
            (tooltipButton, tooltipMatrixStack, tooltipMouseX, tooltipMouseY) -> {
        if (tooltipButton.visible) {
            if (tooltipMousePos(tooltipButton, tooltipMouseX, tooltipMouseY, 4, 12, 5, 11) || tooltipMousePos(tooltipButton, tooltipMouseX, tooltipMouseY, 5, 11, 4, 12) || tooltipMousePos(tooltipButton, tooltipMouseX, tooltipMouseY, 6, 10, 3, 13))
                this.renderTooltip(tooltipMatrixStack, new StringTextComponent("gem4"), tooltipMouseX, tooltipMouseY);
        }
            },
            new StringTextComponent("gem4 button")
    );
    public ImageButton gem5 = new ImageButton(0, 0, 16, 16, 0, 0, 0, GEM5_RES, 16, 16,
            (button) -> {
                Main.LOGGER.warn("gem5");
            },
            (tooltipButton, tooltipMatrixStack, tooltipMouseX, tooltipMouseY) -> {
        if (tooltipButton.visible) {
            if (tooltipMousePos(tooltipButton, tooltipMouseX, tooltipMouseY, 4, 12, 5, 11) || tooltipMousePos(tooltipButton, tooltipMouseX, tooltipMouseY, 5, 11, 4, 12) || tooltipMousePos(tooltipButton, tooltipMouseX, tooltipMouseY, 6, 10, 3, 13))
                this.renderTooltip(tooltipMatrixStack, new StringTextComponent("gem5"), tooltipMouseX, tooltipMouseY);
        }
            },
            new StringTextComponent("gem5 button")
    );
    public ImageButton gem6 = new ImageButton(0, 0, 16, 16, 0, 0, 0, GEM6_RES, 16, 16,
            (button) -> {
                Main.LOGGER.warn("gem6");
            },
            (tooltipButton, tooltipMatrixStack, tooltipMouseX, tooltipMouseY) -> {
        if (tooltipButton.visible) {
            if (tooltipMousePos(tooltipButton, tooltipMouseX, tooltipMouseY, 4, 12, 5, 11) || tooltipMousePos(tooltipButton, tooltipMouseX, tooltipMouseY, 5, 11, 4, 12) || tooltipMousePos(tooltipButton, tooltipMouseX, tooltipMouseY, 6, 10, 3, 13))
                this.renderTooltip(tooltipMatrixStack, new StringTextComponent("gem6"), tooltipMouseX, tooltipMouseY);
        }
            },
            new StringTextComponent("gem6 button")
    );
    public ImageButton gem7 = new ImageButton(0, 0, 16, 16, 0, 0, 0, GEM7_RES, 16, 16,
            (button) -> {
                Main.LOGGER.warn("gem7");
            },
            (tooltipButton, tooltipMatrixStack, tooltipMouseX, tooltipMouseY) -> {
        if (tooltipButton.visible) {
            if (tooltipMousePos(tooltipButton, tooltipMouseX, tooltipMouseY, 4, 12, 5, 11) || tooltipMousePos(tooltipButton, tooltipMouseX, tooltipMouseY, 5, 11, 4, 12) || tooltipMousePos(tooltipButton, tooltipMouseX, tooltipMouseY, 6, 10, 3, 13))
                this.renderTooltip(tooltipMatrixStack, new StringTextComponent("gem7"), tooltipMouseX, tooltipMouseY);
        }
            },
            new StringTextComponent("gem7 button")
    );
    public ImageButton gem8 = new ImageButton(0, 0, 16, 16, 0, 0, 0, GEM8_RES, 16, 16,
            (button) -> {
                Main.LOGGER.warn("gem8");
            },
            (tooltipButton, tooltipMatrixStack, tooltipMouseX, tooltipMouseY) -> {
        if (tooltipButton.visible) {
            if (tooltipMousePos(tooltipButton, tooltipMouseX, tooltipMouseY, 4, 12, 5, 11) || tooltipMousePos(tooltipButton, tooltipMouseX, tooltipMouseY, 5, 11, 4, 12) || tooltipMousePos(tooltipButton, tooltipMouseX, tooltipMouseY, 6, 10, 3, 13))
                this.renderTooltip(tooltipMatrixStack, new StringTextComponent("gem8"), tooltipMouseX, tooltipMouseY);
        }
            },
            new StringTextComponent("gem8 button")
    );
    public ImageButton gem9 = new ImageButton(0, 0, 16, 16, 0, 0, 0, GEM9_RES, 16, 16,
            (button) -> {
                Main.LOGGER.warn("gem9");
            },
            (tooltipButton, tooltipMatrixStack, tooltipMouseX, tooltipMouseY) -> {
        if (tooltipButton.visible) {
            if (tooltipMousePos(tooltipButton, tooltipMouseX, tooltipMouseY, 4, 12, 5, 11) || tooltipMousePos(tooltipButton, tooltipMouseX, tooltipMouseY, 5, 11, 4, 12) || tooltipMousePos(tooltipButton, tooltipMouseX, tooltipMouseY, 6, 10, 3, 13))
                this.renderTooltip(tooltipMatrixStack, new StringTextComponent("gem9"), tooltipMouseX, tooltipMouseY);
        }
            },
            new StringTextComponent("gem9 button")
    );

    private static boolean tooltipMousePos(Button tooltipButton, int mouseX, int mouseY, int xPosMin, int xPosMax, int yPosMin, int yPosMax) {
        return (mouseX >= tooltipButton.x + xPosMin && mouseX < tooltipButton.x + xPosMax && mouseY >= tooltipButton.y + 5 && mouseY < tooltipButton.y + yPosMax);
    }

    public PixelGemScreen() {
        super(new StringTextComponent("gem screen"));
    }

    @Override
    protected void init() {
        gemVisibleMap.putIfAbsent("gem1", false);
        gemVisibleMap.putIfAbsent("gem2", false);
        gemVisibleMap.putIfAbsent("gem3", false);
        gemVisibleMap.putIfAbsent("gem4", false);
        gemVisibleMap.putIfAbsent("gem5", false);
        gemVisibleMap.putIfAbsent("gem6", false);
        gemVisibleMap.putIfAbsent("gem7", false);
        gemVisibleMap.putIfAbsent("gem8", false);
        gemVisibleMap.putIfAbsent("gem9", false);

        gem1.setPosition(this.width / 2 - 80, this.height / 2 + 59);
        this.addButton(gem1);
        gem2.setPosition(this.width / 2 - 62, this.height / 2 + 59);
        this.addButton(gem2);
        gem3.setPosition(this.width / 2 - 44, this.height / 2 + 59);
        this.addButton(gem3);
        gem4.setPosition(this.width / 2 - 26, this.height / 2 + 59);
        this.addButton(gem4);
        gem5.setPosition(this.width / 2 - 8, this.height / 2 + 59);
        this.addButton(gem5);
        gem6.setPosition(this.width / 2 + 10, this.height / 2 + 59);
        this.addButton(gem6);
        gem7.setPosition(this.width / 2 + 28, this.height / 2 + 59);
        this.addButton(gem7);
        gem8.setPosition(this.width / 2 + 46, this.height / 2 + 59);
        this.addButton(gem8);
        gem9.setPosition(this.width / 2 + 64, this.height / 2 + 59);
        this.addButton(gem9);

        ImageButton relicButton = new ImageButton(this.width / 2 + 87, this.height / 2 - 72, 34, 12, 0, 0, 12, BUTTON_ITEM_TOGGLE,
                (button) -> {
                    Main.LOGGER.info("toggle item");
                    this.closeScreen();
                    this.minecraft.displayGuiScreen(new PixelInventoryScreen(this.minecraft.player));
                });
        this.addButton(relicButton);
    }

    @Override
    @SuppressWarnings("deprecation")
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.enableBlend();
        this.minecraft.getTextureManager().bindTexture(PIXEL_RELIC_INVENTORY);
        this.blit(matrixStack, PixelInventoryScreen.xIn, PixelInventoryScreen.yIn, 0, 0, 213, 210);
        RenderSystem.disableBlend();

        gem1.visible = gemVisibleMap.getOrDefault("gem1", false);
        gem2.visible = gemVisibleMap.getOrDefault("gem2", false);
        gem3.visible = gemVisibleMap.getOrDefault("gem3", false);
        gem4.visible = gemVisibleMap.getOrDefault("gem4", false);
        gem5.visible = gemVisibleMap.getOrDefault("gem5", false);
        gem6.visible = gemVisibleMap.getOrDefault("gem6", false);
        gem7.visible = gemVisibleMap.getOrDefault("gem7", false);
        gem8.visible = gemVisibleMap.getOrDefault("gem8", false);
        gem9.visible = gemVisibleMap.getOrDefault("gem9", false);

        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
