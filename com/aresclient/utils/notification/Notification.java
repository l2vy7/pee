/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.utils.GuiImages
 *  com.aresclient.utils.UIUtils
 *  com.aresclient.utils.notification.Notification
 *  com.aresclient.utils.notification.NotificationType
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.ScaledResolution
 */
package com.aresclient.utils.notification;

import com.aresclient.utils.GuiImages;
import com.aresclient.utils.UIUtils;
import com.aresclient.utils.notification.NotificationType;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;

public class Notification {
    private NotificationType type;
    private String title;
    private String message;
    private long start;
    private long fadedIn;
    private long fadeOut;
    private long end;
    ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());

    public Notification(NotificationType type, String title, String messsage, int length) {
        this.type = type;
        this.title = title;
        this.message = messsage;
        this.fadedIn = 200 * messsage.length();
        this.fadeOut = this.fadedIn + (long)(500 * messsage.length());
        this.end = this.fadeOut + this.fadedIn;
    }

    public void setMessage(String message) {
        this.message = message;
        this.fadedIn = 200 * message.length();
        this.fadeOut = this.fadedIn + (long)(500 * message.length());
        this.end = this.fadeOut + this.fadedIn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public void show() {
        this.start = System.currentTimeMillis();
    }

    public boolean isShown() {
        return this.getTime() <= this.end;
    }

    private long getTime() {
        return System.currentTimeMillis() - this.start;
    }

    public void render() {
        double offset = 0.0;
        int width = 120;
        int height = 30;
        long time = this.getTime();
        String Icon = "Tipp";
        offset = time < this.fadedIn ? Math.tanh((double)time / (double)this.fadedIn * 3.0) * (double)width : (time > this.fadeOut ? Math.tanh(3.0 - (double)(time - this.fadeOut) / (double)(this.end - this.fadeOut) * 3.0) * (double)width : (double)width);
        Color color = new Color(30, 30, 30, 220);
        if (this.type == NotificationType.INFO) {
            Color color1 = new Color(0, 26, 169);
            Icon = "Tipp";
        } else if (this.type == NotificationType.WARNING) {
            Color color1 = new Color(204, 193, 0);
            Icon = "Warning";
        } else {
            Color color1 = new Color(204, 0, 18);
            int i = Math.max(0, Math.min(255, (int)(Math.sin((double)time / 100.0) * 255.0 / 2.0 + 127.5)));
            color = new Color(i, 0, 0, 220);
        }
        FontRenderer fontRenderer = Minecraft.getMinecraft().fontRendererObj;
        UIUtils.drawRoundedRect((int)-5, (int)5, (int)((int)offset + 5), (int)(height + 5), (float)5.0f, (int)color.getRGB());
        fontRenderer.drawString(this.title, (int)offset - width + 30, 11, Color.white.getRGB());
        fontRenderer.drawString(this.message, (int)offset - width + 30, 21, Color.white.getRGB());
        GuiImages.drawPicture((int)((int)offset - width + 5), (int)10, (int)20, (int)20, (String)("Ares/Icons/Notifications/" + Icon + ".png"));
    }

    private void drawRoundedRect(int x, int y, int width, int height, int cornerRadius, Color color) {
        UIUtils.drawRoundedRect((int)x, (int)y, (int)width, (int)height, (float)cornerRadius, (int)color.getRGB());
    }
}

