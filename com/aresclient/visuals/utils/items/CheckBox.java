/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.visuals.utils.items.CheckBox
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.WorldRenderer
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package com.aresclient.visuals.utils.items;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/*
 * Exception performing whole class analysis ignored.
 */
public class CheckBox
extends GuiButton {
    public boolean state = false;
    private static Color color = Color.black;

    public CheckBox(int buttonId, int x, int y) {
        super(buttonId, x, y, "");
    }

    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
        if (this.enabled && this.visible) {
            int out = 15;
            int in = 13;
            this.drawRoundedRect(this.xPosition, this.yPosition, out, out, 2, Color.gray);
            this.drawRoundedRect(this.xPosition + 1, this.yPosition + 1, in, in, 1, color);
            if (this.state) {
                CheckBox.drawTexture((ResourceLocation)new ResourceLocation("Ares/Icons/checkbox/check.png"), (float)this.xPosition, (float)this.yPosition, (float)15.0f, (float)15.0f);
            }
        }
    }

    public boolean mousePressed(Minecraft mc, int mouseX, int mouseY) {
        return this.enabled && this.visible && mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + 15 && mouseY < this.yPosition + this.height;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean getState() {
        return this.state;
    }

    private void drawRoundedRect(int x, int y, int width, int height, int cornerRadius, Color color) {
        Gui.drawRect((int)x, (int)(y + cornerRadius), (int)(x + cornerRadius), (int)(y + height - cornerRadius), (int)color.getRGB());
        Gui.drawRect((int)(x + cornerRadius), (int)y, (int)(x + width - cornerRadius), (int)(y + height), (int)color.getRGB());
        Gui.drawRect((int)(x + width - cornerRadius), (int)(y + cornerRadius), (int)(x + width), (int)(y + height - cornerRadius), (int)color.getRGB());
        this.drawArc(x + cornerRadius, y + cornerRadius, cornerRadius, 0, 90, color);
        this.drawArc(x + width - cornerRadius, y + cornerRadius, cornerRadius, 270, 360, color);
        this.drawArc(x + width - cornerRadius, y + height - cornerRadius, cornerRadius, 180, 270, color);
        this.drawArc(x + cornerRadius, y + height - cornerRadius, cornerRadius, 90, 180, color);
    }

    private void drawArc(int x, int y, int radius, int startAngle, int endAngle, Color color) {
        GL11.glPushMatrix();
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glColor4f((float)((float)color.getRed() / 255.0f), (float)((float)color.getGreen() / 255.0f), (float)((float)color.getBlue() / 255.0f), (float)((float)color.getAlpha() / 255.0f));
        WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
        worldRenderer.begin(6, DefaultVertexFormats.POSITION);
        worldRenderer.pos((double)x, (double)y, 0.0).endVertex();
        for (int i = (int)((double)startAngle / 360.0 * 100.0); i <= (int)((double)endAngle / 360.0 * 100.0); ++i) {
            double angle = Math.PI * 2 * (double)i / 100.0 + Math.toRadians(180.0);
            worldRenderer.pos((double)x + Math.sin(angle) * (double)radius, (double)y + Math.cos(angle) * (double)radius, 0.0).endVertex();
        }
        Tessellator.getInstance().draw();
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glPopMatrix();
    }

    public static void drawTexture(ResourceLocation resourceLocation, float x, float y, float width, float height) {
        GL11.glPushMatrix();
        float size = width / 2.0f;
        GL11.glEnable((int)3042);
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2848);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        Minecraft.getMinecraft().getTextureManager().bindTexture(resourceLocation);
        GL11.glBegin((int)7);
        GL11.glTexCoord2d((double)(0.0f / size), (double)(0.0f / size));
        GL11.glVertex2d((double)x, (double)y);
        GL11.glTexCoord2d((double)(0.0f / size), (double)((0.0f + size) / size));
        GL11.glVertex2d((double)x, (double)(y + height));
        GL11.glTexCoord2d((double)((0.0f + size) / size), (double)((0.0f + size) / size));
        GL11.glVertex2d((double)(x + width), (double)(y + height));
        GL11.glTexCoord2d((double)((0.0f + size) / size), (double)(0.0f / size));
        GL11.glVertex2d((double)(x + width), (double)y);
        GL11.glEnd();
        GL11.glEnable((int)3553);
        GL11.glDisable((int)2848);
        GL11.glDisable((int)3042);
        GL11.glPopMatrix();
    }
}

