/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.visuals.utils.items.AnimatedButton
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package com.aresclient.visuals.utils.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/*
 * Exception performing whole class analysis ignored.
 */
public class AnimatedButton
extends GuiButton {
    private int ani = 0;
    private int frames = 1;
    public String path;

    public AnimatedButton(int buttonId, int x, int y, int widthIn, int heightIn, String path) {
        super(buttonId, x, y, widthIn, heightIn, "");
        this.path = path;
    }

    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
        if (this.enabled) {
            boolean bl = this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
            if (this.hovered) {
                if (this.ani < 2) {
                    ++this.ani;
                }
            } else if (this.ani > 0) {
                --this.ani;
            }
            if (this.hovered) {
                if (this.frames < 28) {
                    ++this.frames;
                }
            } else if (this.frames > 1) {
                --this.frames;
            }
            AnimatedButton.drawTexture((ResourceLocation)new ResourceLocation(String.valueOf(this.path) + this.frames + ").png"), (float)(this.xPosition - this.ani), (float)(this.yPosition - this.ani), (float)(this.width + this.ani * 2), (float)(this.height + this.ani * 2));
        } else {
            boolean bl = this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
            if (this.hovered) {
                if (this.ani < 2) {
                    ++this.ani;
                }
            } else if (this.ani > 0) {
                --this.ani;
            }
            if (this.hovered) {
                if (this.frames < 28) {
                    ++this.frames;
                }
            } else if (this.frames > 1) {
                --this.frames;
            }
            AnimatedButton.drawTexture((ResourceLocation)new ResourceLocation(String.valueOf(this.path) + this.frames + ").png"), (float)(this.xPosition - this.ani), (float)(this.yPosition - this.ani), (float)(this.width + this.ani * 2), (float)(this.height + this.ani * 2));
            AnimatedButton.drawTexture((ResourceLocation)new ResourceLocation("Ares/barrier.png"), (float)(this.xPosition - 3 - this.ani), (float)(this.yPosition - 3 - this.ani), (float)(this.width + 6 + this.ani * 2), (float)(this.height + 6 + this.ani * 2));
        }
    }

    public void setImage(String path) {
        this.path = path;
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

