/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.utils.updater.GuiUpdate
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiMainMenu
 *  net.minecraft.client.gui.GuiOptionButton
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.resources.I18n
 */
package com.aresclient.utils.updater;

import java.io.IOException;
import java.net.URI;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;

public class GuiUpdate
extends GuiScreen {
    public void initGui() {
        this.buttonList.clear();
        this.buttonList.add(new GuiOptionButton(0, width / 2 - 155, height / 4 + 120 + 12, I18n.format((String)"gui.toTitle", (Object[])new Object[0])));
        this.buttonList.add(new GuiOptionButton(1, width / 2 - 155 + 160, height / 4 + 120 + 12, I18n.format((String)"menu.quit", (Object[])new Object[0])));
    }

    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 0) {
            GuiMainMenu.showed = true;
            this.mc.displayGuiScreen((GuiScreen)new GuiMainMenu());
        } else if (button.id == 1) {
            try {
                Class<?> oclass = Class.forName("java.awt.Desktop");
                Object object = oclass.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
                oclass.getMethod("browse", URI.class).invoke(object, new URI("https://www.aresclient.com/download"));
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            this.mc.shutdown();
        }
    }

    protected void keyTyped(char typedChar, int keyCode) throws IOException {
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, "\u00a7nNew Ares Update!", width / 2, height / 4 - 60 + 20, -1);
        this.drawString(this.fontRendererObj, "\u00a7lAres Client \u00a7rdetected a new update!", width / 2 - 140, height / 4 - 60 + 60 + 0, -1);
        this.drawString(this.fontRendererObj, "If you want to play with this Version", width / 2 - 140, height / 4 - 60 + 60 + 18, -1);
        this.drawString(this.fontRendererObj, "you can without any problems!", width / 2 - 140, height / 4 - 60 + 60 + 27, -1);
        this.drawString(this.fontRendererObj, "To prevent any bugs just update the Client!", width / 2 - 140, height / 4 - 60 + 60 + 36, -1);
        this.drawString(this.fontRendererObj, "Please Contact us on our Discord Server", width / 2 - 140, height / 4 - 60 + 60 + 54, -1);
        this.drawString(this.fontRendererObj, "if this Screen is not removing.", width / 2 - 140, height / 4 - 60 + 60 + 63, -1);
        this.drawString(this.fontRendererObj, "\u00a7n\u00a7ldiscord.gg/mVksrDr", width / 2 - 140, height / 4 - 60 + 60 + 81, -1);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}

