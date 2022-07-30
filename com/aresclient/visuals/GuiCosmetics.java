/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.utils.config.ConfigManager
 *  com.aresclient.visuals.GuiAresMenu
 *  com.aresclient.visuals.GuiCosmetics
 *  com.aresclient.visuals.GuiModSettings
 *  com.aresclient.visuals.GuiSkinchanger
 *  com.aresclient.visuals.GuiTimechanger
 *  com.aresclient.visuals.cape.GuiCapes
 *  com.aresclient.visuals.cosmetic.GuiCustomizeBandana
 *  com.aresclient.visuals.cosmetic.GuiPets
 *  com.aresclient.visuals.utils.items.AnimatedButton
 *  com.aresclient.visuals.utils.items.ImageButton
 *  com.aresclient.visuals.utils.items.ImageButtonWithText
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.AbstractClientPlayer
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

import com.aresclient.utils.config.ConfigManager;
import com.aresclient.visuals.GuiAresMenu;
import com.aresclient.visuals.GuiModSettings;
import com.aresclient.visuals.GuiSkinchanger;
import com.aresclient.visuals.GuiTimechanger;
import com.aresclient.visuals.cape.GuiCapes;
import com.aresclient.visuals.cosmetic.GuiCustomizeBandana;
import com.aresclient.visuals.cosmetic.GuiPets;
import com.aresclient.visuals.utils.items.AnimatedButton;
import com.aresclient.visuals.utils.items.ImageButton;
import com.aresclient.visuals.utils.items.ImageButtonWithText;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
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

/*
 * Exception performing whole class analysis ignored.
 */
public class GuiCosmetics
extends GuiScreen {
    public static int prevFramerate = 0;
    public static int Icon1 = ConfigManager.settings.Wings;
    public static int Icon2 = ConfigManager.settings.Bandana;
    public static int Icon3 = ConfigManager.settings.Halo;
    public static int Icon4 = ConfigManager.settings.WitchHat;
    public static int Icon5 = ConfigManager.settings.BunnyEars;
    public static int Icon6 = ConfigManager.settings.Blaze;
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
    public static AbstractClientPlayer plr;
    private float oldMouseX;
    private float oldMouseY;

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.oldMouseX = mouseX;
        this.oldMouseY = mouseY;
        int x = width / 2 + width / 3;
        int y = height / 2 + height / 6;
        int i = -100;
        int j = 10;
        GuiCosmetics.drawEntityOnScreen((int)(i + 51), (int)(j + 75), (int)30, (float)((float)(i + 51) - this.oldMouseX), (float)((float)(j + 75 - 50) - this.oldMouseY), (EntityLivingBase)this.mc.thePlayer);
        GuiCosmetics.drawEntityOnScreen((int)x, (int)y, (int)50, (float)((float)x - this.oldMouseX), (float)((float)y - this.oldMouseY - 75.0f), (EntityLivingBase)this.mc.thePlayer);
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
        this.buttonList.add(new AnimatedButton(2, 12, k + 2, s - 4, s - 4, "Ares/Icons/Animated/Cosmetics/Cosmetics ("));
        this.buttonList.add(new AnimatedButton(3, 10, k + s * 1, s, s, "Ares/Icons/Animated/Mods/Mods ("));
        this.buttonList.add(new AnimatedButton(5, 10, k + s * 2, s, s, "Ares/Icons/Animated/Multiplayer/Multiplayer ("));
        this.buttonList.add(new AnimatedButton(6, 10, k + s * 3, s, s, "Ares/Icons/Animated/Timechanger/Timechanger ("));
        this.buttonList.add(new AnimatedButton(7, 10, k + s * 4, s, s, "Ares/Icons/Animated/Exit/Exit ("));
        int x = width / 2 + width / 3 - s / 2;
        int y = height / 2 + height / 6 + s / 2;
        this.buttonList.add(new ImageButtonWithText(24, x, y, s, s, new ResourceLocation("Ares/Icons/Toggles/Cosmetics/Customize.png"), "Customize", I18n.format((String)"ares.cosmetic.customize", (Object[])new Object[0])));
        this.buttonList.add(new ImageButtonWithText(25, x - s - 5, y, s, s, new ResourceLocation("Ares/Icons/Toggles/Cosmetics/Capes.png"), "Capes", I18n.format((String)"ares.cosmetic.capes", (Object[])new Object[0])));
        this.buttonList.add(new ImageButtonWithText(26, x + s + 5, y, s, s, new ResourceLocation("Ares/Icons/Toggles/Cosmetics/Skinchanger.png"), "Skins", I18n.format((String)"ares.cosmetic.skins", (Object[])new Object[0])));
        this.buttonList.add(new ImageButtonWithText(27, x, y + s + 5, s, s, new ResourceLocation("Ares/Icons/Toggles/Pets/Pets.png"), "Pets", I18n.format((String)"Cute Pets :D", (Object[])new Object[0])));
        int s1 = height / 8;
        int k1 = s1 * 3 - s1 / 2;
        this.buttonList.add(new ImageButton(8, width / 2 - s1 * 2, k1 - s1 * 1, s1, s1, new ResourceLocation("Ares/Icons/Toggles/Cosmetics/Wings" + Icon1 + ".png")));
        this.buttonList.add(new ImageButton(9, width / 2 - s1, k1 - s1 * 1, s1, s1, new ResourceLocation("Ares/Icons/Toggles/Cosmetics/Bandana" + Icon2 + ".png")));
        this.buttonList.add(new ImageButton(10, width / 2, k1 - s1 * 1, s1, s1, new ResourceLocation("Ares/Icons/Toggles/Cosmetics/Halo" + Icon3 + ".png")));
        this.buttonList.add(new ImageButton(11, width / 2 + s1, k1 - s1 * 1, s1, s1, new ResourceLocation("Ares/Icons/Toggles/Cosmetics/WitchHat" + Icon4 + ".png")));
        this.buttonList.add(new ImageButton(12, width / 2 - s1 * 2, k1 - s1 * 0, s1, s1, new ResourceLocation("Ares/Icons/Toggles/Cosmetics/BunnyEars" + Icon5 + ".png")));
        this.buttonList.add(new ImageButton(13, width / 2 - s1 * 1, k1 - s1 * 0, s1, s1, new ResourceLocation("Ares/Icons/Toggles/Cosmetics/Blaze" + Icon6 + ".png")));
    }

    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 24) {
            this.mc.displayGuiScreen((GuiScreen)new GuiCustomizeBandana());
        }
        if (button.id == 25) {
            this.mc.displayGuiScreen((GuiScreen)new GuiCapes());
        }
        if (button.id == 26) {
            this.mc.displayGuiScreen((GuiScreen)new GuiSkinchanger());
        }
        if (button.id == 27) {
            this.mc.displayGuiScreen((GuiScreen)new GuiPets());
        }
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
            this.mc.displayGuiScreen((GuiScreen)new GuiMultiplayer(null));
        }
        if (button.id == 6) {
            this.mc.displayGuiScreen((GuiScreen)new GuiTimechanger());
        }
        if (button.id == 8) {
            if (Icon1 == 1) {
                Icon1 = 2;
                ConfigManager.settings.Wings = 2;
            } else {
                Icon1 = 1;
                ConfigManager.settings.Wings = 1;
            }
            this.updatebuttons();
        }
        if (button.id == 9) {
            if (Icon2 == 1) {
                Icon2 = 2;
                ConfigManager.settings.Bandana = 2;
            } else {
                Icon2 = 1;
                ConfigManager.settings.Bandana = 1;
            }
            this.updatebuttons();
        }
        if (button.id == 10) {
            if (Icon3 == 1) {
                Icon3 = 2;
                ConfigManager.settings.Halo = 2;
            } else {
                Icon3 = 1;
                ConfigManager.settings.Halo = 1;
            }
            this.updatebuttons();
        }
        if (button.id == 11) {
            if (Icon4 == 1) {
                Icon4 = 2;
                ConfigManager.settings.WitchHat = 2;
            } else {
                Icon4 = 1;
                ConfigManager.settings.WitchHat = 1;
            }
            this.updatebuttons();
        }
        if (button.id == 12) {
            if (Icon5 == 1) {
                Icon5 = 2;
                ConfigManager.settings.BunnyEars = 2;
            } else {
                Icon5 = 1;
                ConfigManager.settings.BunnyEars = 1;
            }
            this.updatebuttons();
        }
        if (button.id == 13) {
            if (Icon6 == 1) {
                Icon6 = 2;
                ConfigManager.settings.Blaze = 2;
            } else {
                Icon6 = 1;
                ConfigManager.settings.Blaze = 1;
            }
            this.updatebuttons();
        }
        if (button.id == 14) {
            Icon7 = Icon7 == 1 ? 2 : 1;
            this.updatebuttons();
        }
        if (button.id == 15) {
            Icon8 = Icon8 == 1 ? 2 : 1;
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
        this.updatebuttons();
    }

    public static void loadPlayer(AbstractClientPlayer plr2) {
        plr = plr2;
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

