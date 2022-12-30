package com.github.nulld4201.pixelinventory.event;

import com.github.nulld4201.pixelinventory.PixelInventoryMain;
import com.github.nulld4201.pixelinventory.gui.screen.inventory.PixelInventoryScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Mod.EventBusSubscriber
public class RenderOverlay {

    private final Minecraft minecraft = Minecraft.getInstance();
    protected int scaledWidth;
    protected int scaledHeight;

    protected ResourceLocation ARMOR_HUD_ICONS = new ResourceLocation(PixelInventoryMain.MOD_ID, "textures/gui/armor.png");

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onGameOverlayRender(RenderGameOverlayEvent.Pre event) {
        if (event.getType().equals(RenderGameOverlayEvent.ElementType.ARMOR)) {
            int armorValue = 0;
            if (minecraft.player != null) {
                ItemStack headItem = minecraft.player.getItemStackFromSlot(EquipmentSlotType.HEAD);
                ItemStack chestItem = minecraft.player.getItemStackFromSlot(EquipmentSlotType.CHEST);
                ItemStack legItem = minecraft.player.getItemStackFromSlot(EquipmentSlotType.LEGS);
                ItemStack feetItem = minecraft.player.getItemStackFromSlot(EquipmentSlotType.FEET);

                if (headItem.getItem() instanceof ArmorItem) armorValue += regDouble(headItem.getAttributeModifiers(EquipmentSlotType.HEAD).get(Attributes.ARMOR).toString());
                if (chestItem.getItem() instanceof ArmorItem) armorValue += regDouble(chestItem.getAttributeModifiers(EquipmentSlotType.CHEST).get(Attributes.ARMOR).toString());
                if (legItem.getItem() instanceof ArmorItem) armorValue += regDouble(legItem.getAttributeModifiers(EquipmentSlotType.LEGS).get(Attributes.ARMOR).toString());
                if (feetItem.getItem() instanceof ArmorItem) armorValue += regDouble(feetItem.getAttributeModifiers(EquipmentSlotType.FEET).get(Attributes.ARMOR).toString());
            }

            if (armorValue != 0) {
                this.scaledWidth = this.minecraft.getMainWindow().getScaledWidth();
                this.scaledHeight = this.minecraft.getMainWindow().getScaledHeight();
                int i1 = (this.scaledWidth - 25) / 2;
                int j1 = this.scaledHeight - 60;
                this.minecraft.getTextureManager().bindTexture(ARMOR_HUD_ICONS);
                if (armorValue > 40) armorValue = 40;
                if (armorValue % 10 != 0)
                    this.minecraft.ingameGUI.blit(event.getMatrixStack(), i1, j1, (armorValue % 10 - 1) * 25, (armorValue / 10) * 25, 25, 25);
                else
                    this.minecraft.ingameGUI.blit(event.getMatrixStack(), i1, j1, 225, (armorValue / 10 - 1) * 25, 25, 25);

                event.setCanceled(true);
            }
        } else {
            this.minecraft.getTextureManager().bindTexture(AbstractGui.GUI_ICONS_LOCATION);
        }

// if (event.getType() == RenderGameOverlayEvent.ElementType.POTION_ICONS) {
//     event.setCanceled(true);
// }
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onGuiRenderEvent(GuiOpenEvent event) {
        if (event.getGui() instanceof InventoryScreen) {
            event.setGui(new PixelInventoryScreen(this.minecraft.player));
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onGuiInitEvent(GuiScreenEvent.InitGuiEvent event) {
        List<Widget> widgets = event.getWidgetList();
        for (Widget widget : widgets) {
            if (widget instanceof ImageButton && widget.getWidth() == 20) {
                widget.visible = false;
            }
        }
    }

    private static double regDouble(String string) {
        Pattern pattern = Pattern.compile("(\\d+[.]+\\d)");
        Matcher matcher = pattern.matcher(string);

        if (matcher.find()) return Double.parseDouble(matcher.group());
        else return 0.0D;
    }
}
