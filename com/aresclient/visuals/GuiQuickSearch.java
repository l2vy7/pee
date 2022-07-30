/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.visuals.GuiQuickSearch
 *  com.aresclient.visuals.utils.items.ImageButtonWithText
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
package com.aresclient.visuals;

import com.aresclient.visuals.utils.items.ImageButtonWithText;
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

public class GuiQuickSearch
extends GuiScreen {
    public static int prevFramerate = 0;
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
        this.buttonList.add(new ImageButtonWithText(8, width / 2 - s1 * 2, k1 - s1 * 1, s1, s1, new ResourceLocation("Ares/Icons/QuickSearch/bw8x1.png"), "Bedwars 8x1", "QuickJoin Bedwars 8x1"));
        this.buttonList.add(new ImageButtonWithText(9, width / 2 - s1, k1 - s1 * 1, s1, s1, new ResourceLocation("Ares/Icons/QuickSearch/bw8x2.png"), "Bedwars 8x2", "QuickJoin Bedwars 8x2"));
        this.buttonList.add(new ImageButtonWithText(10, width / 2, k1 - s1 * 1, s1, s1, new ResourceLocation("Ares/Icons/QuickSearch/bw4x3.png"), "Bedwars 4x3", "QuickJoin Bedwars 4x3"));
        this.buttonList.add(new ImageButtonWithText(11, width / 2 + s1, k1 - s1 * 1, s1, s1, new ResourceLocation("Ares/Icons/QuickSearch/bw4x4.png"), "Bedwars 4x4", "QuickJoin Bedwars 4x4"));
        this.buttonList.add(new ImageButtonWithText(12, width / 2 - s1 * 2, k1 - s1 * 0, s1, s1, new ResourceLocation("Ares/Icons/QuickSearch/SwSoloNormal.png"), "Skywars Solo Normal", "QuickJoin Skywars Solo Normal"));
        this.buttonList.add(new ImageButtonWithText(13, width / 2 - s1, k1 - s1 * 0, s1, s1, new ResourceLocation("Ares/Icons/QuickSearch/SwSoloInsane.png"), "Skywars Solo Insane", "QuickJoin Skywars Solo Insane"));
        this.buttonList.add(new ImageButtonWithText(14, width / 2, k1 - s1 * 0, s1, s1, new ResourceLocation("Ares/Icons/QuickSearch/SwTeamsNormal.png"), "Skywars Teams Normal", "QuickJoin Skywars Teams Normal"));
        this.buttonList.add(new ImageButtonWithText(15, width / 2 + s1, k1 - s1 * 0, s1, s1, new ResourceLocation("Ares/Icons/QuickSearch/SwTeamsInsane.png"), "Skywars Teams Insane", "QuickJoin Skywars Teams Insane"));
    }

    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 8) {
            Minecraft.getMinecraft().thePlayer.sendChatMessage("/play bedwars_eight_one");
        }
        if (button.id == 9) {
            Minecraft.getMinecraft().thePlayer.sendChatMessage("/play bedwars_eight_two");
        }
        if (button.id == 10) {
            Minecraft.getMinecraft().thePlayer.sendChatMessage("/play bedwars_four_three");
        }
        if (button.id == 11) {
            Minecraft.getMinecraft().thePlayer.sendChatMessage("/play bedwars_four_four");
        }
        if (button.id == 12) {
            Minecraft.getMinecraft().thePlayer.sendChatMessage("/play solo_normal");
        }
        if (button.id == 13) {
            Minecraft.getMinecraft().thePlayer.sendChatMessage("/play solo_insane");
        }
        if (button.id == 14) {
            Minecraft.getMinecraft().thePlayer.sendChatMessage("/play teams_normal");
        }
        if (button.id == 15) {
            Minecraft.getMinecraft().thePlayer.sendChatMessage("/play teams_insane");
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

