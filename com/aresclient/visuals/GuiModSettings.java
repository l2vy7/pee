/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.utils.GuiImages
 *  com.aresclient.utils.config.Config
 *  com.aresclient.utils.config.ConfigManager
 *  com.aresclient.visuals.GuiAresMenu
 *  com.aresclient.visuals.GuiCosmetics
 *  com.aresclient.visuals.GuiModSettings
 *  com.aresclient.visuals.GuiTimechanger
 *  com.aresclient.visuals.utils.items.AnimatedButton
 *  com.aresclient.visuals.utils.items.ImageButtonWithText
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiMultiplayer
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.ScaledResolution
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

import com.aresclient.utils.GuiImages;
import com.aresclient.utils.config.Config;
import com.aresclient.utils.config.ConfigManager;
import com.aresclient.visuals.GuiAresMenu;
import com.aresclient.visuals.GuiCosmetics;
import com.aresclient.visuals.GuiTimechanger;
import com.aresclient.visuals.utils.items.AnimatedButton;
import com.aresclient.visuals.utils.items.ImageButtonWithText;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
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
public class GuiModSettings
extends GuiScreen {
    public static int prevFramerate = 0;
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
    ScaledResolution scaledresolution = new ScaledResolution(Minecraft.getMinecraft());
    int i = this.scaledresolution.getScaledWidth();
    int j = this.scaledresolution.getScaledHeight();

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.oldMouseX = mouseX;
        this.oldMouseY = mouseY;
        int x = width / 2 + width / 3;
        int y = height / 2 + height / 6;
        int i = -100;
        int j = 10;
        GuiModSettings.drawEntityOnScreen((int)(i + 51), (int)(j + 75), (int)30, (float)((float)(i + 51) - this.oldMouseX), (float)((float)(j + 75 - 50) - this.oldMouseY), (EntityLivingBase)this.mc.thePlayer);
        GuiModSettings.drawEntityOnScreen((int)x, (int)y, (int)50, (float)((float)x - this.oldMouseX), (float)((float)y - this.oldMouseY - 75.0f), (EntityLivingBase)this.mc.thePlayer);
        if (ConfigManager.settings.CustomCrosshair != 1) {
            GuiImages.drawPictureWithTextureOffset((int)(i / 2 - 7), (int)(j / 2 - 7 + j / 4), (int)0, (int)0, (int)16, (int)16, (String)("Ares/Crosshairs/Crosshair" + ConfigManager.settings.CustomCrosshair + ".png"));
        }
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
        this.buttonList.add(new AnimatedButton(1, 10, k - s * 1, s, s, "Ares/Icons/Animated/Settings/Settings ("));
        this.buttonList.add(new AnimatedButton(2, 10, k, s, s, "Ares/Icons/Animated/Cosmetics/Cosmetics ("));
        this.buttonList.add(new AnimatedButton(3, 12, k + s * 1 + 2, s - 4, s - 4, "Ares/Icons/Animated/Mods/Mods ("));
        this.buttonList.add(new AnimatedButton(5, 10, k + s * 2, s, s, "Ares/Icons/Animated/Multiplayer/Multiplayer ("));
        this.buttonList.add(new AnimatedButton(6, 10, k + s * 3, s, s, "Ares/Icons/Animated/Timechanger/Timechanger ("));
        this.buttonList.add(new AnimatedButton(7, 10, k + s * 4, s, s, "Ares/Icons/Animated/Exit/Exit ("));
        int s1 = height / 8;
        int k1 = s1 * 3 - s1 / 2;
        this.buttonList.add(new ImageButtonWithText(8, width / 2 - s1 * 2, k1 - s1 * 1, s1, s1, new ResourceLocation("Ares/Icons/Toggles/Mods/Fullbright" + Icon1 + ".png"), "Fullbright", I18n.format((String)"ares.mods.fullbright", (Object[])new Object[0])));
        this.buttonList.add(new ImageButtonWithText(9, width / 2 - s1, k1 - s1 * 1, s1, s1, new ResourceLocation("Ares/Icons/Toggles/Mods/Itemphisics" + ConfigManager.settings.Itemphisics + ".png"), "Itemphysics", I18n.format((String)"ares.mods.itemphysics", (Object[])new Object[0])));
        this.buttonList.add(new ImageButtonWithText(10, width / 2, k1 - s1 * 1, s1, s1, new ResourceLocation("Ares/Icons/Toggles/Mods/Lefthand" + ConfigManager.settings.LeftHand + ".png"), "Lefthand", I18n.format((String)"ares.mods.lefthand", (Object[])new Object[0])));
        this.buttonList.add(new ImageButtonWithText(11, width / 2 + s1, k1 - s1 * 1, s1, s1, new ResourceLocation("Ares/Icons/Toggles/Mods/Togglesprint" + ConfigManager.settings.Togglesprint + ".png"), "Togglesprint", I18n.format((String)"ares.mods.togglesprint", (Object[])new Object[0])));
        this.buttonList.add(new ImageButtonWithText(12, width / 2 - s1 * 2, k1 - s1 * 0, s1, s1, new ResourceLocation("Ares/Icons/Toggles/Mods/ZoomAnimation" + ConfigManager.settings.ZoomAnimation + ".png"), "Zoom Animation", I18n.format((String)"ares.mods.zoomanimation", (Object[])new Object[0])));
        this.buttonList.add(new ImageButtonWithText(13, width / 2 - s1, k1 - s1 * 0, s1, s1, new ResourceLocation("Ares/Icons/Toggles/Mods/HitDelayFix" + ConfigManager.settings.HitDelayFix + ".png"), "HitDelay Fix", I18n.format((String)"ares.mods.hitdelayfix", (Object[])new Object[0])));
        this.buttonList.add(new ImageButtonWithText(14, width / 2, k1 - s1 * 0, s1, s1, new ResourceLocation("Ares/Icons/Toggles/Mods/OldAnimations" + ConfigManager.settings.useOldAnimations + ".png"), "OldAnimations", I18n.format((String)"ares.mods.useoldanimations", (Object[])new Object[0])));
        this.buttonList.add(new ImageButtonWithText(15, width / 2 + s1, k1 - s1 * 0, s1, s1, new ResourceLocation("Ares/Icons/Toggles/Mods/ArrowTrail" + ConfigManager.settings.ArrowTrail + ".png"), "ArrowTrails", I18n.format((String)"ares.mods.arrowtrail", (Object[])new Object[0])));
        this.buttonList.add(new ImageButtonWithText(16, width / 2 - s1 * 2, k1 - s1 * -1, s1, s1, new ResourceLocation("Ares/Icons/Toggles/Mods/TntTimer" + ConfigManager.settings.TntTimer + ".png"), "Tnt Timer", I18n.format((String)"ares.mods.tnttimer", (Object[])new Object[0])));
        this.buttonList.add(new ImageButtonWithText(17, width / 2 - s1, k1 - s1 * -1, s1, s1, new ResourceLocation("Ares/Icons/Toggles/Mods/CustomCrosshair" + ConfigManager.settings.CustomCrosshair + ".png"), "Custom Crosshair", I18n.format((String)"ares.mods.customcrosshair", (Object[])new Object[0])));
        this.buttonList.add(new ImageButtonWithText(18, width / 2, k1 - s1 * -1, s1, s1, new ResourceLocation("Ares/Icons/Toggles/Mods/BlockOverlay" + ConfigManager.settings.BlockOverlay + ".png"), "Custom SelectionBox", I18n.format((String)"ares.mods.blockoverlay", (Object[])new Object[0])));
        this.buttonList.add(new ImageButtonWithText(19, width / 2 + s1, k1 - s1 * -1, s1, s1, new ResourceLocation("Ares/Icons/Toggles/Mods/Particle" + ConfigManager.settings.Particle + ".png"), "More Particles", I18n.format((String)"ares.mods.moreparticle", (Object[])new Object[0])));
        this.buttonList.add(new ImageButtonWithText(20, width / 2 - s1 * 2, k1 - s1 * -2, s1, s1, new ResourceLocation("Ares/Icons/Toggles/Mods/rgbhits" + ConfigManager.settings.RGBHits + ".png"), "RGB Hits", I18n.format((String)"ares.mods.RGBHits", (Object[])new Object[0])));
    }

    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 7) {
            this.mc.displayGuiScreen(null);
            this.mc.setIngameFocus();
        }
        if (button.id == 1) {
            this.mc.displayGuiScreen((GuiScreen)new GuiAresMenu());
        }
        if (button.id == 2) {
            this.mc.displayGuiScreen((GuiScreen)new GuiCosmetics());
        }
        if (button.id == 3) {
            this.mc.displayGuiScreen((GuiScreen)new GuiModSettings());
        }
        if (button.id == 5) {
            this.mc.displayGuiScreen((GuiScreen)new GuiMultiplayer((GuiScreen)this));
        }
        if (button.id == 6) {
            this.mc.displayGuiScreen((GuiScreen)new GuiTimechanger());
        }
        if (button.id == 8) {
            if (Icon1 == 1) {
                Icon1 = 2;
                this.mc.gameSettings.gammaSetting = 100.0f;
            } else {
                Icon1 = 1;
                this.mc.gameSettings.gammaSetting = 0.0f;
            }
            this.updatebuttons();
        }
        if (button.id == 9) {
            ConfigManager.settings.Itemphisics = ConfigManager.settings.Itemphisics == 1 ? 2 : 1;
            this.updatebuttons();
        }
        if (button.id == 10) {
            ConfigManager.settings.LeftHand = ConfigManager.settings.LeftHand == 1 ? 2 : 1;
            this.updatebuttons();
        }
        if (button.id == 11) {
            ConfigManager.settings.Togglesprint = ConfigManager.settings.Togglesprint == 1 ? 2 : 1;
            this.updatebuttons();
        }
        if (button.id == 20) {
            ConfigManager.settings.Togglesneak = ConfigManager.settings.Togglesneak == 1 ? 2 : 1;
            this.updatebuttons();
        }
        if (button.id == 12) {
            ConfigManager.settings.ZoomAnimation = ConfigManager.settings.ZoomAnimation == 1 ? 2 : 1;
            this.updatebuttons();
        }
        if (button.id == 13) {
            ConfigManager.settings.HitDelayFix = ConfigManager.settings.HitDelayFix == 1 ? 2 : 1;
            this.updatebuttons();
        }
        if (button.id == 14) {
            ConfigManager.settings.useOldAnimations = !ConfigManager.settings.useOldAnimations;
            this.updatebuttons();
        }
        if (button.id == 15) {
            ConfigManager.settings.ArrowTrail = ConfigManager.settings.ArrowTrail < 4 ? ++ConfigManager.settings.ArrowTrail : 1;
            this.updatebuttons();
        }
        if (button.id == 16) {
            ConfigManager.settings.TntTimer = ConfigManager.settings.TntTimer == 1 ? 2 : 1;
            this.updatebuttons();
        }
        if (button.id == 17) {
            ConfigManager.settings.CustomCrosshair = ConfigManager.settings.CustomCrosshair < 7 ? ++ConfigManager.settings.CustomCrosshair : 1;
            this.updatebuttons();
        }
        if (button.id == 18) {
            if (ConfigManager.settings.BlockOverlay == 1) {
                ConfigManager.settings.BlockOverlay = 2;
                Config.red = 0.9f;
                Config.green = 0.32f;
                Config.blue = 0.25f;
                Config.thickness = 4.0f;
            } else if (ConfigManager.settings.BlockOverlay == 2) {
                ConfigManager.settings.BlockOverlay = 3;
                Config.red = 0.0f;
                Config.green = 0.8f;
                Config.blue = 0.2f;
                Config.thickness = 4.0f;
            } else if (ConfigManager.settings.BlockOverlay == 3) {
                ConfigManager.settings.BlockOverlay = 4;
                Config.red = 0.0f;
                Config.green = 0.4f;
                Config.blue = 1.0f;
                Config.thickness = 4.0f;
            } else if (ConfigManager.settings.BlockOverlay == 4) {
                ConfigManager.settings.BlockOverlay = 5;
                Config.red = 7.0f;
                Config.green = 0.0f;
                Config.blue = 0.9f;
                Config.thickness = 4.0f;
            } else if (ConfigManager.settings.BlockOverlay == 5) {
                ConfigManager.settings.BlockOverlay = 6;
                Config.red = 0.92156f;
                Config.green = 0.5373f;
                Config.blue = 0.239f;
                Config.thickness = 4.0f;
            } else if (ConfigManager.settings.BlockOverlay == 6) {
                ConfigManager.settings.BlockOverlay = 1;
                Config.red = 0.0f;
                Config.green = 0.0f;
                Config.blue = 0.0f;
                Config.thickness = 2.0f;
            }
            this.updatebuttons();
        }
        if (button.id == 19) {
            ConfigManager.settings.Particle = ConfigManager.settings.Particle == 1 ? 2 : 1;
            this.updatebuttons();
        }
        if (button.id == 20) {
            ConfigManager.settings.RGBHits = ConfigManager.settings.RGBHits < 6 ? ++ConfigManager.settings.RGBHits : 1;
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

