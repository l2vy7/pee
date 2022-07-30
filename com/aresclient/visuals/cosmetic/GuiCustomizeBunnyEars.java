/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.utils.UIUtils
 *  com.aresclient.utils.config.ConfigManager
 *  com.aresclient.visuals.GuiCosmetics
 *  com.aresclient.visuals.cosmetic.GuiCustomizeBandana
 *  com.aresclient.visuals.cosmetic.GuiCustomizeBlaze
 *  com.aresclient.visuals.cosmetic.GuiCustomizeBunnyEars
 *  com.aresclient.visuals.cosmetic.GuiCustomizeHalo
 *  com.aresclient.visuals.cosmetic.GuiCustomizeWings
 *  com.aresclient.visuals.utils.items.ImageButton
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.util.ResourceLocation
 */
package com.aresclient.visuals.cosmetic;

import com.aresclient.utils.UIUtils;
import com.aresclient.utils.config.ConfigManager;
import com.aresclient.visuals.GuiCosmetics;
import com.aresclient.visuals.cosmetic.GuiCustomizeBandana;
import com.aresclient.visuals.cosmetic.GuiCustomizeBlaze;
import com.aresclient.visuals.cosmetic.GuiCustomizeHalo;
import com.aresclient.visuals.cosmetic.GuiCustomizeWings;
import com.aresclient.visuals.utils.items.ImageButton;
import java.awt.Color;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

/*
 * Exception performing whole class analysis ignored.
 */
public class GuiCustomizeBunnyEars
extends GuiScreen {
    private float oldMouseX;
    private float oldMouseY;
    int i = 0;
    ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        int yes = height - height / 4;
        if (mouseY >= yes && this.i < 0) {
            ++this.i;
        } else if (mouseY <= yes && this.i > -25) {
            --this.i;
        }
        int Size = height / 12;
        UIUtils.drawRoundedRect((int)(width / 2 - width / 6 - Size), (int)(height - 30 - this.i), (int)(width / 2 + width / 6 + Size), (int)(height - 1 - this.i), (float)((float)(9.0 / (double)this.sr.getScaleFactor())), (int)new Color(200, 200, 200, 150).getRGB());
        int X = width / 2;
        int Y = height;
        this.buttonList.clear();
        this.buttonList.add(new ImageButton(14, width / 2 - Size * 4, height - Size - Size / 4 - this.i, Size, Size, new ResourceLocation("Ares/cosmetic/buttons/Bandana.png")));
        this.buttonList.add(new ImageButton(15, width / 2 - Size * 3, height - Size - Size / 4 - this.i, Size, Size, new ResourceLocation("Ares/cosmetic/buttons/Blaze.png")));
        this.buttonList.add(new ImageButton(16, width / 2 - Size * 2, height - Size - Size / 4 - this.i, Size, Size, new ResourceLocation("Ares/cosmetic/buttons/BunnyEars.png")));
        this.buttonList.add(new ImageButton(17, width / 2 - Size * 1, height - Size - Size / 4 - this.i, Size, Size, new ResourceLocation("Ares/cosmetic/buttons/Halo.png")));
        this.buttonList.add(new ImageButton(18, width / 2 - Size * 0, height - Size - Size / 4 - this.i, Size, Size, new ResourceLocation("Ares/cosmetic/buttons/Wings.png")));
        this.buttonList.add(new ImageButton(3, width / 2 + Size * 1, height - Size - Size / 4 - this.i, Size, Size, new ResourceLocation("Ares/cosmetic/buttons/witchhat.png")));
        this.buttonList.add(new ImageButton(2, width / 2 + Size * 2, height - Size - Size / 4 - this.i, Size, Size, new ResourceLocation("Ares/Icons/ColorPicker/White.png")));
        this.buttonList.add(new ImageButton(1, width / 2 + Size * 3, height - Size - Size / 4 - this.i, Size, Size, new ResourceLocation("Ares/Icons/ColorPicker/White.png")));
        this.updatebuttons();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.oldMouseX = mouseX;
        this.oldMouseY = mouseY;
        int x = width / 2;
        int y = height / 2 + height / 6 + height / 6 - 20;
        int i = -100;
        int j = 10;
        GuiCustomizeBunnyEars.drawEntityOnScreen((int)(i + 51), (int)(j + 75), (int)30, (float)((float)(i + 51) - this.oldMouseX), (float)((float)(j + 75 - 50) - this.oldMouseY), (EntityLivingBase)this.mc.thePlayer);
        GuiCustomizeBunnyEars.drawEntityOnScreen((int)x, (int)y, (int)75, (float)(width / 2 - mouseX), (float)(height / 2 - mouseY - 60), (EntityLivingBase)this.mc.thePlayer);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    public void initGui() {
        Minecraft.getMinecraft().entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
        super.initGui();
        this.updatebuttons();
    }

    private void updatebuttons() {
        int s = height / 10;
        int k = s * 3 - s / 2;
        this.buttonList.add(new ImageButton(1, 10, k - s * 1, s, s, new ResourceLocation("Ares/cosmetic/BunnyEars/button1.png")));
        this.buttonList.add(new ImageButton(2, 10, k, s, s, new ResourceLocation("Ares/cosmetic/BunnyEars/button2.png")));
        this.buttonList.add(new ImageButton(3, 10, k + s * 1, s, s, new ResourceLocation("Ares/cosmetic/BunnyEars/button3.png")));
        this.buttonList.add(new ImageButton(7, 10, k + s * 2, s, s, new ResourceLocation("Ares/cosmetic/BunnyEars/button7.png")));
        this.buttonList.add(new ImageButton(4, 20 + s, k - s * 1, s, s, new ResourceLocation("Ares/cosmetic/BunnyEars/button4.png")));
        this.buttonList.add(new ImageButton(5, 20 + s, k, s, s, new ResourceLocation("Ares/cosmetic/BunnyEars/button5.png")));
        this.buttonList.add(new ImageButton(6, 20 + s, k + s * 1, s, s, new ResourceLocation("Ares/cosmetic/BunnyEars/button6.png")));
        int x = width / 2 + width / 3 - s / 2;
        int y = height / 2 + height / 6 + s / 2;
        this.buttonList.add(new ImageButton(24, x, y, s, s, new ResourceLocation("Ares/Icons/Toggles/Cosmetics/Exit.png")));
        int s1 = height / 8;
        int k1 = s1 * 3 - s1 / 2;
    }

    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 24) {
            this.mc.displayGuiScreen((GuiScreen)new GuiCosmetics());
        }
        if (button.id == 1) {
            ConfigManager.settings.BunnyEarsTexture = 1;
        }
        if (button.id == 2) {
            ConfigManager.settings.BunnyEarsTexture = 2;
        }
        if (button.id == 3) {
            ConfigManager.settings.BunnyEarsTexture = 3;
        }
        if (button.id == 4) {
            ConfigManager.settings.BunnyEarsTexture = 4;
        }
        if (button.id == 5) {
            ConfigManager.settings.BunnyEarsTexture = 5;
        }
        if (button.id == 6) {
            ConfigManager.settings.BunnyEarsTexture = 6;
        }
        if (button.id == 7) {
            ConfigManager.settings.BunnyEarsTexture = 7;
        }
        if (button.id == 14) {
            this.mc.displayGuiScreen((GuiScreen)new GuiCustomizeBandana());
        }
        if (button.id == 15) {
            this.mc.displayGuiScreen((GuiScreen)new GuiCustomizeBlaze());
        }
        if (button.id == 17) {
            this.mc.displayGuiScreen((GuiScreen)new GuiCustomizeHalo());
        }
        if (button.id == 18) {
            this.mc.displayGuiScreen((GuiScreen)new GuiCustomizeWings());
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

