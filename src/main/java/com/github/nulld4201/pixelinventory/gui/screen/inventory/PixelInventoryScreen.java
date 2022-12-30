package com.github.nulld4201.pixelinventory.gui.screen.inventory;

import com.github.nulld4201.pixelinventory.PixelInventoryMain;
import com.github.nulld4201.pixelinventory.gui.screen.gem.PixelGemScreen;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.CreativeScreen;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.util.ResourceLocation;

import static com.github.nulld4201.pixelinventory.PixelInventoryMain.database;

public class PixelInventoryScreen extends InventoryScreen {
    private static final ResourceLocation AVATAR_PLUS_VIEW = new ResourceLocation(PixelInventoryMain.MOD_ID, "textures/gui/plus_button.png");
    private static final ResourceLocation MONEY_BUTTON = new ResourceLocation(PixelInventoryMain.MOD_ID, "textures/gui/moneybutton.png");
    private static final ResourceLocation PIXEL_INVENTORY_BACKGROUND = new ResourceLocation(PixelInventoryMain.MOD_ID, "textures/gui/maininventory.png");
    private static final ResourceLocation BUTTON_RELIC_TOGGLE = new ResourceLocation(PixelInventoryMain.MOD_ID, "textures/gui/relic_enable.png");

    public static boolean isAvatarBig;

    private float oldMouseX;
    private float oldMouseY;
    private float entityPitch;
    private float entityYaw;

    public static ImageButton money_1000;
    public static ImageButton money_100;
    public static ImageButton money_10;
    public static ImageButton money_1;
    public static ImageButton money_1000_disable;
    public static ImageButton money_100_disable;
    public static ImageButton money_10_disable;
    public static ImageButton money_1_disable;

    public static float entityBigPitch = 0;
    public static float entityBigYaw = 0;
    public static boolean isRelicValid = false;

    public PixelInventoryScreen(PlayerEntity player) {
        super(player);
    }

    @Override
    public void tick() {
        if (this.minecraft.playerController.isInCreativeMode()) {
            this.minecraft.displayGuiScreen(new CreativeScreen(this.minecraft.player));
        }
    }

    @Override
    protected void init() {
//        try {
//            database.connect();
//        } catch (ClassNotFoundException | SQLException e) {
//            throw new RuntimeException(e);
//        }
        PixelInventoryMain.LOGGER.warn(database);
        if (this.minecraft.playerController.isInCreativeMode()) {
            this.minecraft.displayGuiScreen(new CreativeScreen(this.minecraft.player));
        } else {
            super.init();
            this.addButton(new ImageButton(this.guiLeft + 72 - 8, this.height / 2 - 12 - 4, 7, 8, 0, 0, 8, AVATAR_PLUS_VIEW,
                    (button) -> {
                        PixelInventoryMain.LOGGER.info("avatar plus");
                        isAvatarBig = !isAvatarBig;
                        entityBigYaw = 0;
                        entityBigPitch = 0;
                    }));
            ImageButton relicButton = new ImageButton(this.guiLeft + 179 - 4, this.height / 2 - 50 - 4, 34, 12, 0, 0, 12, BUTTON_RELIC_TOGGLE,
                    (button) -> {
                        PixelInventoryMain.LOGGER.info("toggle relic");
                        this.closeScreen();
                        this.minecraft.displayGuiScreen(new PixelGemScreen());
                    });
            this.addButton(relicButton);
            relicButton.visible = isRelicValid;

            money_1000 = new ImageButton(this.guiLeft + 181 - 4, this.height / 2 - 20 - 4, 16, 11, 48, 0, 11, MONEY_BUTTON,
                    (button) -> {
                        PixelInventoryMain.LOGGER.info("click 1000");
                    });
            this.addButton(money_1000);
            money_100 = new ImageButton(this.guiLeft + 181 - 4, this.height / 2 - 8 - 4, 16, 11, 32, 0, 11, MONEY_BUTTON,
                    (button) -> {
                        PixelInventoryMain.LOGGER.info("click 100");
                    });
            this.addButton(money_100);
            money_10 = new ImageButton(this.guiLeft + 181 - 4, this.height / 2 + 4 - 4, 16, 11, 16, 0, 11, MONEY_BUTTON,
                    (button) -> {
                        PixelInventoryMain.LOGGER.info("click 10");
                    });
            this.addButton(money_10);
            money_1 = new ImageButton(this.guiLeft + 181 - 4, this.height / 2 + 16 - 4, 16, 11, 0, 0, 11, MONEY_BUTTON,
                    (button) -> {
                        PixelInventoryMain.LOGGER.info("click 1");
                    });
            this.addButton(money_1);

            money_1000_disable = new ImageButton(this.guiLeft + 181 - 4, this.height / 2 - 20 - 4, 16, 11, 48, 22, 0, MONEY_BUTTON,
                    (button) -> {
                        PixelInventoryMain.LOGGER.info("disabled");
                        this.minecraft.getSoundHandler().stop();
                    });
            this.addButton(money_1000_disable);
            money_1000_disable.visible = false;
            money_100_disable = new ImageButton(this.guiLeft + 181 - 4, this.height / 2 - 8 - 4, 16, 11, 32, 22, 0, MONEY_BUTTON,
                    (button) -> {
                        PixelInventoryMain.LOGGER.info("disabled");
                        this.minecraft.getSoundHandler().stop();
                    });
            this.addButton(money_100_disable);
            money_100_disable.visible = false;
            money_10_disable = new ImageButton(this.guiLeft + 181 - 4, this.height / 2 + 4 - 4, 16, 11, 16, 22, 0, MONEY_BUTTON,
                    (button) -> {
                        PixelInventoryMain.LOGGER.info("disabled");
                        this.minecraft.getSoundHandler().stop();
                    });
            this.addButton(money_10_disable);
            money_10_disable.visible = false;
            money_1_disable = new ImageButton(this.guiLeft + 181 - 4, this.height / 2 + 16 - 4, 16, 11, 0, 22, 0, MONEY_BUTTON,
                    (button) -> {
                        PixelInventoryMain.LOGGER.info("disabled");
                        this.minecraft.getSoundHandler().stop();
                    });
            this.addButton(money_1_disable);
            money_1_disable.visible = false;
        }
    }

    public static int xIn, yIn;

    @Override
    @SuppressWarnings("deprecation")
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(PIXEL_INVENTORY_BACKGROUND);
        int i = this.guiLeft;
        int j = this.guiTop;
        xIn = i - 4;
        yIn = j - 4;
        this.blit(matrixStack, i - 4, j - 4, 0, 0, 213, 174);
        this.entityPitch = (float)(i + 52) - this.oldMouseX - 4;
        this.entityYaw = (float)(j + 70 - 50) - this.oldMouseY;
        drawEntityOnScreen(this.guiLeft + 52 - 4, this.guiTop + 75 - 4, 30, this.entityPitch, this.entityYaw, this.minecraft.player);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        super.render(matrixStack, mouseX, mouseY, partialTicks);

        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
        this.oldMouseX = (float)mouseX;
        this.oldMouseY = (float)mouseY;

        if (isAvatarBig) {
            drawEntityOnScreen(this.guiLeft / 2 + 5, this.guiTop + this.ySize - 20, 50, entityBigYaw, entityBigPitch, this.minecraft.player);
        }

        buttonVisible(money_1000_disable, money_1000);
        buttonVisible(money_100_disable, money_100);
        buttonVisible(money_10_disable, money_10);
        buttonVisible(money_1_disable, money_1);
//        Main.LOGGER.warn(this.minecraft.player.getActivePotionEffects().size());
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == 61) {
            if (!isAvatarBig) {
                entityBigYaw = 0;
                entityBigPitch = 0;
            }
            isAvatarBig = !isAvatarBig;
            return true;
        } else if (keyCode == 263 && isAvatarBig) {
            if (entityBigYaw < 90) {
                entityBigYaw += 1;
                PixelInventoryMain.LOGGER.info(entityBigYaw);
            }
            return true;
        } else if (keyCode == 262 && isAvatarBig) {
            if (entityBigYaw > -90) {
                entityBigYaw -= 1;
                PixelInventoryMain.LOGGER.info(entityBigYaw);
            }
            return true;
        } else if (keyCode == 265 && isAvatarBig) {
            if (entityPitch < 90) {
                entityBigPitch += 1;
                PixelInventoryMain.LOGGER.info(entityBigPitch);
            }
            return true;
        } else if (keyCode == 264 && isAvatarBig) {
            if (entityPitch > -90) {
                entityBigPitch -= 1;
                PixelInventoryMain.LOGGER.info(entityBigPitch);
            }
            return true;
        }
        InputMappings.Input mouseKey = InputMappings.getInputByCode(keyCode, scanCode);
        if (super.keyPressed(keyCode, scanCode, modifiers)) {
            return true;
        } else if (this.minecraft.gameSettings.keyBindInventory.isActiveAndMatches(mouseKey)) {
            this.closeScreen();
            return true;
        } else {
            boolean handled = this.itemStackMoved(keyCode, scanCode);// Forge MC-146650: Needs to return true when the key is handled
            if (this.hoveredSlot != null && this.hoveredSlot.getHasStack()) {
                if (this.minecraft.gameSettings.keyBindPickBlock.isActiveAndMatches(mouseKey)) {
                    this.handleMouseClick(this.hoveredSlot, this.hoveredSlot.slotNumber, 0, ClickType.CLONE);
                    handled = true;
                } else if (this.minecraft.gameSettings.keyBindDrop.isActiveAndMatches(mouseKey)) {
                    this.handleMouseClick(this.hoveredSlot, this.hoveredSlot.slotNumber, hasControlDown() ? 1 : 0, ClickType.THROW);
                    handled = true;
                }
            } else if (this.minecraft.gameSettings.keyBindDrop.isActiveAndMatches(mouseKey)) {
                handled = true; // Forge MC-146650: Emulate MC bug, so we don't drop from hotbar when pressing drop without hovering over a item.
            }

            return handled;
        }
    }

    private void buttonVisible(Button b1, Button b2) {
        b1.visible = this.minecraft.player.inventory.getFirstEmptyStack() == -1;
        b2.visible = this.minecraft.player.inventory.getFirstEmptyStack() != -1;
    }
}
