/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.utils.config.ConfigManager
 *  com.aresclient.visuals.utils.Keystrokes
 *  com.aresclient.visuals.utils.Keystrokes$Key
 *  com.aresclient.visuals.utils.Keystrokes$KeystrokesMode
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.renderer.OpenGlHelper
 *  org.lwjgl.opengl.GL11
 */
package com.aresclient.visuals.utils;

import com.aresclient.utils.config.ConfigManager;
import com.aresclient.visuals.utils.Keystrokes;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.OpenGlHelper;
import org.lwjgl.opengl.GL11;

public class Keystrokes {
    private KeystrokesMode mode = KeystrokesMode.WASD;

    public FontRenderer getFontRenderer() {
        return Minecraft.getMinecraft().fontRendererObj;
    }

    public void setMode(KeystrokesMode mode) {
        this.mode = mode;
    }

    public void draw(int x, int y) {
        this.mode = KeystrokesMode.WASD;
        GL11.glPushMatrix();
        for (Key key : this.mode.getKeys()) {
            int textWidth = this.getFontRenderer().getStringWidth(key.getName());
            Gui.drawRect((int)(x + key.getX()), (int)(y + key.getY()), (int)(x + key.getX() + key.getWidth()), (int)(y + key.getY() + key.getHeight()), (int)(key.isDown() ? new Color(255, 255, 255, 102).getRGB() : new Color(0, 0, 0, 150).getRGB()));
            this.getFontRenderer().drawString(key.isDown() ? String.valueOf(ConfigManager.settings.ModColor) + key.getName() : key.getName(), x + key.getX() + key.getWidth() / 2 - textWidth / 2, y + key.getY() + key.getHeight() / 2 - 4, Color.WHITE.getRGB());
            this.getFontRenderer().drawString("\u00a7f", x + key.getX() + key.getWidth() / 2 - textWidth / 2, y + key.getY() + key.getHeight() / 2 + 4, -1);
        }
        GL11.glPopMatrix();
    }

    public static void drawRoundedRect(int x0, int y0, int x1, int y1, float radius, int color) {
        int i = 18;
        float f = 5.0f;
        float f2 = (float)(color >> 24 & 0xFF) / 255.0f;
        float f3 = (float)(color >> 16 & 0xFF) / 255.0f;
        float f4 = (float)(color >> 8 & 0xFF) / 255.0f;
        float f5 = (float)(color & 0xFF) / 255.0f;
        GL11.glDisable((int)2884);
        GL11.glDisable((int)3553);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        OpenGlHelper.glBlendFunc((int)770, (int)771, (int)1, (int)0);
        GL11.glColor4f((float)f3, (float)f4, (float)f5, (float)f2);
        GL11.glBegin((int)5);
        GL11.glVertex2f((float)((float)x0 + radius), (float)y0);
        GL11.glVertex2f((float)((float)x0 + radius), (float)y1);
        GL11.glVertex2f((float)((float)x1 - radius), (float)y0);
        GL11.glVertex2f((float)((float)x1 - radius), (float)y1);
        GL11.glEnd();
        GL11.glBegin((int)5);
        GL11.glVertex2f((float)x0, (float)((float)y0 + radius));
        GL11.glVertex2f((float)((float)x0 + radius), (float)((float)y0 + radius));
        GL11.glVertex2f((float)x0, (float)((float)y1 - radius));
        GL11.glVertex2f((float)((float)x0 + radius), (float)((float)y1 - radius));
        GL11.glEnd();
        GL11.glBegin((int)5);
        GL11.glVertex2f((float)x1, (float)((float)y0 + radius));
        GL11.glVertex2f((float)((float)x1 - radius), (float)((float)y0 + radius));
        GL11.glVertex2f((float)x1, (float)((float)y1 - radius));
        GL11.glVertex2f((float)((float)x1 - radius), (float)((float)y1 - radius));
        GL11.glEnd();
        GL11.glBegin((int)6);
        float f6 = (float)x1 - radius;
        float f7 = (float)y0 + radius;
        GL11.glVertex2f((float)f6, (float)f7);
        for (int j = 0; j <= 18; ++j) {
            float f8 = (float)j * 5.0f;
            GL11.glVertex2f((float)((float)((double)f6 + (double)radius * Math.cos(Math.toRadians(f8)))), (float)((float)((double)f7 - (double)radius * Math.sin(Math.toRadians(f8)))));
        }
        GL11.glEnd();
        GL11.glBegin((int)6);
        f6 = (float)x0 + radius;
        f7 = (float)y0 + radius;
        GL11.glVertex2f((float)f6, (float)f7);
        for (int k = 0; k <= 18; ++k) {
            float f9 = (float)k * 5.0f;
            GL11.glVertex2f((float)((float)((double)f6 - (double)radius * Math.cos(Math.toRadians(f9)))), (float)((float)((double)f7 - (double)radius * Math.sin(Math.toRadians(f9)))));
        }
        GL11.glEnd();
        GL11.glBegin((int)6);
        f6 = (float)x0 + radius;
        f7 = (float)y1 - radius;
        GL11.glVertex2f((float)f6, (float)f7);
        for (int l = 0; l <= 18; ++l) {
            float f10 = (float)l * 5.0f;
            GL11.glVertex2f((float)((float)((double)f6 - (double)radius * Math.cos(Math.toRadians(f10)))), (float)((float)((double)f7 + (double)radius * Math.sin(Math.toRadians(f10)))));
        }
        GL11.glEnd();
        GL11.glBegin((int)6);
        f6 = (float)x1 - radius;
        f7 = (float)y1 - radius;
        GL11.glVertex2f((float)f6, (float)f7);
        for (int i2 = 0; i2 <= 18; ++i2) {
            float f11 = (float)i2 * 5.0f;
            GL11.glVertex2f((float)((float)((double)f6 + (double)radius * Math.cos(Math.toRadians(f11)))), (float)((float)((double)f7 + (double)radius * Math.sin(Math.toRadians(f11)))));
        }
        GL11.glEnd();
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2884);
        GL11.glDisable((int)3042);
    }
}

