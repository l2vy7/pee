/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.visuals.GuiColorpicker
 *  com.aresclient.visuals.GuiCosmetics
 *  com.aresclient.visuals.GuiTimechanger
 *  com.aresclient.visuals.utils.items.ImageButtonWithText
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiMultiplayer
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

import com.aresclient.visuals.GuiCosmetics;
import com.aresclient.visuals.GuiTimechanger;
import com.aresclient.visuals.utils.items.ImageButtonWithText;
import java.awt.Color;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class GuiColorpicker
extends GuiScreen {
    public static int prevFramerate = 0;
    public static Color ModColor = new Color(255, 100, 100, 50);
    public static int Icon1 = 1;
    public static int Icon2 = 1;
    public static int Icon3 = 1;
    public static int Icon4 = 1;
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
    int i = -30;

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.oldMouseX = mouseX;
        this.oldMouseY = mouseY;
        int x = width / 2 + width / 3;
        int y = height / 2 + height / 6;
        this.drawCenteredString(this.fontRendererObj, I18n.format((String)("Current Color" + mouseY), (Object[])new Object[0]), width / 2, 20, ModColor.getRGB());
    }

    public void initGui() {
        prevFramerate = this.mc.gameSettings.limitFramerate;
        this.mc.gameSettings.limitFramerate = 60;
        Minecraft.getMinecraft().entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
        super.initGui();
        this.updatebuttons();
    }

    private void updatebuttons() {
        int s = height / 10;
        int k = s * 3 - s / 2;
        this.buttonList.clear();
        int s1 = height / 8;
        int k1 = s1 * 3 - s1 / 2;
        this.buttonList.add(new ImageButtonWithText(8, width / 2 - s1 * 2, k1 - s1 * 1, s1, s1, new ResourceLocation("Ares/Icons/ColorPicker/DarkGreen.png"), "DarkGreen", "Changes the color of your Modules"));
        this.buttonList.add(new ImageButtonWithText(9, width / 2 - s1, k1 - s1 * 1, s1, s1, new ResourceLocation("Ares/Icons/ColorPicker/LightGreen.png"), "LightGreen", "Changes the color of your Modules"));
        this.buttonList.add(new ImageButtonWithText(10, width / 2, k1 - s1 * 1, s1, s1, new ResourceLocation("Ares/Icons/ColorPicker/Purple.png"), "Purple", "Changes the color of your Modules"));
        this.buttonList.add(new ImageButtonWithText(11, width / 2 + s1, k1 - s1 * 1, s1, s1, new ResourceLocation("Ares/Icons/ColorPicker/Pink.png"), "Pink", "Changes the color of your Modules"));
        this.buttonList.add(new ImageButtonWithText(12, width / 2 - s1 * 2, k1 - s1 * 0, s1, s1, new ResourceLocation("Ares/Icons/ColorPicker/Orange.png"), "Orange", "Changes the color of your Modules"));
        this.buttonList.add(new ImageButtonWithText(13, width / 2 - s1, k1 - s1 * 0, s1, s1, new ResourceLocation("Ares/Icons/ColorPicker/LightOrange.png"), "LightOrange", "Changes the color of your Modules"));
        this.buttonList.add(new ImageButtonWithText(14, width / 2, k1 - s1 * 0, s1, s1, new ResourceLocation("Ares/Icons/ColorPicker/Red.png"), "Red", "Changes the color of your Modules"));
        this.buttonList.add(new ImageButtonWithText(15, width / 2 + s1, k1 - s1 * 0, s1, s1, new ResourceLocation("Ares/Icons/ColorPicker/Yellow.png"), "Yellow", "Changes the color of your Modules"));
    }

    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 7) {
            this.mc.displayGuiScreen(null);
            this.mc.setIngameFocus();
        }
        if (button.id == 1) {
            this.mc.displayGuiScreen((GuiScreen)new GuiColorpicker());
        }
        if (button.id == 2) {
            this.mc.displayGuiScreen((GuiScreen)new GuiCosmetics());
        }
        if (button.id == 5) {
            this.mc.displayGuiScreen((GuiScreen)new GuiMultiplayer((GuiScreen)this));
        }
        if (button.id == 6) {
            this.mc.displayGuiScreen((GuiScreen)new GuiTimechanger());
        }
        if (button.id == 8) {
            ModColor = new Color(30, 71, 41, 255);
            this.updatebuttons();
        }
        if (button.id == 9) {
            ModColor = new Color(31, 237, 86, 255);
            this.updatebuttons();
        }
        if (button.id == 10) {
            ModColor = new Color(96, 0, 191, 255);
            this.updatebuttons();
        }
        if (button.id == 11) {
            ModColor = new Color(255, 0, 234, 255);
            this.updatebuttons();
        }
        if (button.id == 12) {
            ModColor = new Color(255, 111, 0, 255);
            this.updatebuttons();
        }
        if (button.id == 13) {
            ModColor = new Color(255, 162, 0, 255);
            this.updatebuttons();
        }
        if (button.id == 14) {
            ModColor = new Color(255, 34, 0, 255);
            this.updatebuttons();
        }
        if (button.id == 15) {
            ModColor = new Color(255, 221, 0, 255);
            this.updatebuttons();
        }
        if (button.id == 16) {
            Icon9 = Icon9 == 1 ? 2 : 1;
            this.updatebuttons();
        }
        if (button.id == 17) {
            Icon10 = Icon10 == 1 ? 2 : 1;
            this.updatebuttons();
        }
        if (button.id == 18) {
            Icon11 = Icon11 == 1 ? 2 : 1;
            this.updatebuttons();
        }
        if (button.id == 19) {
            Icon12 = Icon12 == 1 ? 2 : 1;
            this.updatebuttons();
        }
        if (button.id == 20) {
            Icon13 = Icon13 == 1 ? 2 : 1;
            this.updatebuttons();
        }
        if (button.id == 21) {
            Icon14 = Icon14 == 1 ? 2 : 1;
            this.updatebuttons();
        }
        if (button.id == 22) {
            Icon15 = Icon15 == 1 ? 2 : 1;
            this.updatebuttons();
        }
        if (button.id == 23) {
            Icon16 = Icon16 == 1 ? 2 : 1;
            this.updatebuttons();
        }
    }

    public void onGuiClosed() {
        if (this.mc.thePlayer != null) {
            this.mc.gameSettings.limitFramerate = prevFramerate;
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

