/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.addon.GuiAddons
 *  com.aresclient.visuals.utils.items.Scrollbar
 *  com.aresclient.visuals.utils.items.Scrollbar$EnumMouseAction
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.WorldRenderer
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 */
package com.aresclient.addon;

import com.aresclient.visuals.utils.items.Scrollbar;
import java.io.IOException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class GuiAddons
extends GuiScreen {
    public Scrollbar scrollBar;
    public GuiScreen parent;

    public GuiAddons(GuiScreen parent) {
        this.parent = parent;
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
    }

    public void initGui() {
    }

    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 0) {
            this.mc.displayGuiScreen(this.parent);
        }
    }

    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.scrollBar.mouseInput();
    }

    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        this.scrollBar.mouseAction(mouseX, mouseY, Scrollbar.EnumMouseAction.CLICKED);
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    protected void mouseClickMove(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick) {
        this.scrollBar.mouseAction(mouseX, mouseY, Scrollbar.EnumMouseAction.DRAGGING);
        super.mouseClickMove(mouseX, mouseY, clickedMouseButton, timeSinceLastClick);
    }

    protected void mouseReleased(int mouseX, int mouseY, int state) {
        super.mouseReleased(mouseX, mouseY, state);
        this.scrollBar.mouseAction(mouseX, mouseY, Scrollbar.EnumMouseAction.RELEASED);
    }

    public void drawOverlayBackground(int startY, int endY) {
        int endAlpha = 255;
        int startAlpha = 255;
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        this.mc.getTextureManager().bindTexture(optionsBackground);
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        worldrenderer.pos(0.0, (double)endY, 0.0).tex(0.0, (double)((float)endY / 32.0f)).color(64, 64, 64, 255).endVertex();
        worldrenderer.pos((double)(0 + width), (double)endY, 0.0).tex((double)((float)width / 32.0f), (double)((float)endY / 32.0f)).color(64, 64, 64, 255).endVertex();
        worldrenderer.pos((double)(0 + width), (double)startY, 0.0).tex((double)((float)width / 32.0f), (double)((float)startY / 32.0f)).color(64, 64, 64, 255).endVertex();
        worldrenderer.pos(0.0, (double)startY, 0.0).tex(0.0, (double)((float)startY / 32.0f)).color(64, 64, 64, 255).endVertex();
        tessellator.draw();
    }

    public void drawGradientShadowTop(double y, double left, double right) {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        int i1 = 4;
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableAlpha();
        GlStateManager.shadeModel((int)7425);
        GlStateManager.enableTexture2D();
        this.mc.getTextureManager().bindTexture(optionsBackground);
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        worldrenderer.pos(left, y + 4.0, 0.0).tex(0.0, 1.0).color(0, 0, 0, 0).endVertex();
        worldrenderer.pos(right, y + 4.0, 0.0).tex(1.0, 1.0).color(0, 0, 0, 0).endVertex();
        worldrenderer.pos(right, y, 0.0).tex(1.0, 0.0).color(0, 0, 0, 255).endVertex();
        worldrenderer.pos(left, y, 0.0).tex(0.0, 0.0).color(0, 0, 0, 255).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel((int)7424);
        GlStateManager.enableAlpha();
        GlStateManager.disableBlend();
    }

    public void drawGradientShadowBottom(double y, double left, double right) {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        int i1 = 4;
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableAlpha();
        GlStateManager.shadeModel((int)7425);
        GlStateManager.enableTexture2D();
        this.mc.getTextureManager().bindTexture(optionsBackground);
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        worldrenderer.pos(left, y, 0.0).tex(0.0, 1.0).color(0, 0, 0, 255).endVertex();
        worldrenderer.pos(right, y, 0.0).tex(1.0, 1.0).color(0, 0, 0, 255).endVertex();
        worldrenderer.pos(right, y - 4.0, 0.0).tex(1.0, 0.0).color(0, 0, 0, 0).endVertex();
        worldrenderer.pos(left, y - 4.0, 0.0).tex(0.0, 0.0).color(0, 0, 0, 0).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel((int)7424);
        GlStateManager.enableAlpha();
        GlStateManager.disableBlend();
    }
}

