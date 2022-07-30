/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.utils.config.ConfigManager
 *  com.aresclient.visuals.GuiCosmetics
 *  com.aresclient.visuals.GuiSkinchanger
 *  com.aresclient.visuals.utils.items.ImageButton
 *  com.aresclient.visuals.utils.items.ImageButtonWithText
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.client.resources.I18n
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.util.ResourceLocation
 */
package com.aresclient.visuals;

import com.aresclient.utils.config.ConfigManager;
import com.aresclient.visuals.GuiCosmetics;
import com.aresclient.visuals.utils.items.ImageButton;
import com.aresclient.visuals.utils.items.ImageButtonWithText;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

/*
 * Exception performing whole class analysis ignored.
 */
public class GuiSkinchanger
extends GuiScreen {
    public static int Icon1 = ConfigManager.settings.Wings;
    public static int Icon2 = ConfigManager.settings.Bandana;
    public static int Icon3 = ConfigManager.settings.Halo;
    public static int Icon4 = ConfigManager.settings.WitchHat;
    public static int Icon5 = 1;
    public static int Icon6 = 1;
    public static int Icon7 = 1;
    public static int Icon8 = 1;
    public static int Icon9 = 1;
    public static int Icon10 = 1;
    public static int Icon11 = 1;
    public static int Icon12 = 1;
    public static int Icon13 = 1;
    public static int Icon14 = 1;
    public static int Icon15 = 1;
    public static int Icon16 = 1;
    private float oldMouseX;
    private float oldMouseY;

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.oldMouseX = mouseX;
        this.oldMouseY = mouseY;
        int x = width / 2;
        int y = height / 2 + height / 6 + height / 6 - 20;
        int i = -100;
        int j = 10;
        GuiSkinchanger.drawEntityOnScreen((int)(i + 51), (int)(j + 75), (int)30, (float)((float)(i + 51) - this.oldMouseX), (float)((float)(j + 75 - 50) - this.oldMouseY), (EntityLivingBase)this.mc.thePlayer);
        GuiSkinchanger.drawEntityOnScreen((int)x, (int)y, (int)75, (float)((float)x - this.oldMouseX), (float)((float)y - this.oldMouseY - 75.0f), (EntityLivingBase)this.mc.thePlayer);
    }

    public void initGui() {
        Minecraft.getMinecraft().entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
        super.initGui();
        this.updatebuttons();
    }

    private void updatebuttons() {
        int s = height / 10;
        int k = s * 3 - s / 2;
        this.buttonList.clear();
        this.buttonList.add(new ImageButton(1, 10, k - s * 1, s, s, new ResourceLocation("Ares/Icons/Skins/Skin1.png")));
        this.buttonList.add(new ImageButton(2, 10, k, s, s, new ResourceLocation("Ares/Icons/Skins/Skin2.png")));
        this.buttonList.add(new ImageButton(3, 10, k + s * 1, s, s, new ResourceLocation("Ares/Icons/Skins/Skin3.png")));
        this.buttonList.add(new ImageButton(7, 10, k + s * 2, s, s, new ResourceLocation("Ares/Icons/Skins/Skin7.png")));
        this.buttonList.add(new ImageButton(8, 10, k + s * 3, s, s, new ResourceLocation("Ares/Icons/Skins/Skin8.png")));
        this.buttonList.add(new ImageButton(6, 10, k + s * 4, s, s, new ResourceLocation("Ares/Icons/Toggles/Cosmetics/Skinchanger.png")));
        this.buttonList.add(new ImageButton(7, 10, k + s * 5, s, s, new ResourceLocation("Ares/Icons/Toggles/Cosmetics/Skinchanger.png")));
        this.buttonList.add(new ImageButton(4, 20 + s, k - s * 1, s, s, new ResourceLocation("Ares/Icons/Skins/Skin4.png")));
        this.buttonList.add(new ImageButton(5, 20 + s, k, s, s, new ResourceLocation("Ares/Icons/Skins/Skin5.png")));
        this.buttonList.add(new ImageButton(6, 20 + s, k + s * 1, s, s, new ResourceLocation("Ares/Icons/Skins/Skin6.png")));
        this.buttonList.add(new ImageButton(4, 20 + s, k + s * 2, s, s, new ResourceLocation("Ares/Icons/Toggles/Cosmetics/Skinchanger.png")));
        this.buttonList.add(new ImageButton(5, 20 + s, k + s * 3, s, s, new ResourceLocation("Ares/Icons/Toggles/Cosmetics/Skinchanger.png")));
        this.buttonList.add(new ImageButton(6, 20 + s, k + s * 4, s, s, new ResourceLocation("Ares/Icons/Toggles/Cosmetics/Skinchanger.png")));
        this.buttonList.add(new ImageButton(7, 20 + s, k + s * 5, s, s, new ResourceLocation("Ares/Icons/Toggles/Cosmetics/Skinchanger.png")));
        int x = width / 2 + width / 3 - s / 2;
        int y = height / 2 + height / 6 + s / 2;
        this.buttonList.add(new ImageButtonWithText(25, x - s - 5, y, s, s, new ResourceLocation("Ares/Icons/Skins/Skintype" + ConfigManager.settings.SkinChanger + ".png"), "Skin Type", I18n.format((String)"ares.cosmetic.skins.skintype", (Object[])new Object[0])));
        this.buttonList.add(new ImageButton(24, x, y, s, s, new ResourceLocation("Ares/Icons/Toggles/Cosmetics/Exit.png")));
        this.buttonList.add(new ImageButtonWithText(26, x + s + 5, y, s, s, new ResourceLocation("Ares/Icons/Skins/type" + ConfigManager.settings.SkinType + ".png"), "Body Type", I18n.format((String)"ares.cosmetic.skins.bodytype", (Object[])new Object[0])));
        int s1 = height / 8;
        int k1 = s1 * 3 - s1 / 2;
    }

    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 25) {
            ConfigManager.settings.SkinChanger = ConfigManager.settings.SkinChanger == 1 ? 2 : 1;
            this.updatebuttons();
        }
        if (button.id == 26) {
            ConfigManager.settings.SkinType = ConfigManager.settings.SkinType == 1 ? 2 : 1;
            this.updatebuttons();
        }
        if (button.id == 24) {
            this.mc.displayGuiScreen((GuiScreen)new GuiCosmetics());
        }
        if (button.id == 27) {
            this.mc.displayGuiScreen(null);
            this.mc.setIngameFocus();
        }
        if (button.id == 1) {
            ConfigManager.settings.skinpath = "Ares/Skins/Skin1.png";
        }
        if (button.id == 2) {
            ConfigManager.settings.skinpath = "Ares/Skins/Skin2.png";
        }
        if (button.id == 3) {
            ConfigManager.settings.skinpath = "Ares/Skins/Skin3.png";
        }
        if (button.id == 4) {
            ConfigManager.settings.skinpath = "Ares/Skins/Skin4.png";
        }
        if (button.id == 5) {
            ConfigManager.settings.skinpath = "Ares/Skins/Skin5.png";
        }
        if (button.id == 6) {
            ConfigManager.settings.skinpath = "Ares/Skins/Skin6.png";
        }
        if (button.id == 7) {
            ConfigManager.settings.skinpath = "Ares/Skins/Skin7.png";
        }
        if (button.id == 8) {
            ConfigManager.settings.skinpath = "Ares/Skins/Skin8.png";
        }
    }

    public void onGuiClosed() {
        if (this.mc.thePlayer != null) {
            Minecraft.getMinecraft().entityRenderer.loadEntityShader(null);
            super.onGuiClosed();
        }
    }

    public static void drawEntityOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase ent) {
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)posX, (float)posY, (float)50.0f);
        GlStateManager.scale((float)(-scale), (float)scale, (float)scale);
        GlStateManager.rotate((float)180.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        float f = ent.renderYawOffset;
        float f1 = ent.rotationYaw;
        float f2 = ent.rotationPitch;
        float f3 = ent.prevRotationYawHead;
        float f4 = ent.rotationYawHead;
        GlStateManager.rotate((float)135.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate((float)-135.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.rotate((float)(-((float)Math.atan(mouseY / 40.0f)) * 20.0f), (float)1.0f, (float)0.0f, (float)0.0f);
        ent.renderYawOffset = (float)Math.atan(mouseX / 40.0f) * 20.0f;
        ent.rotationYaw = (float)Math.atan(mouseX / 40.0f) * 40.0f;
        ent.rotationPitch = -((float)Math.atan(mouseY / 40.0f)) * 20.0f;
        ent.rotationYawHead = ent.rotationYaw;
        ent.prevRotationYawHead = ent.rotationYaw;
        GlStateManager.translate((float)0.0f, (float)0.0f, (float)0.0f);
        RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
        rendermanager.setPlayerViewY(180.0f);
        rendermanager.setRenderShadow(false);
        rendermanager.renderEntityWithPosYaw((Entity)ent, 0.0, 0.0, 0.0, 0.0f, 1.0f);
        rendermanager.setRenderShadow(true);
        ent.renderYawOffset = f;
        ent.rotationYaw = f1;
        ent.rotationPitch = f2;
        ent.prevRotationYawHead = f3;
        ent.rotationYawHead = f4;
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture((int)OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture((int)OpenGlHelper.defaultTexUnit);
    }
}

