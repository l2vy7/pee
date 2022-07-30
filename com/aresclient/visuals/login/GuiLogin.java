/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.Ares
 *  com.aresclient.utils.GuiImages
 *  com.aresclient.utils.UIUtils
 *  com.aresclient.utils.config.ConfigManager
 *  com.aresclient.visuals.login.GuiLogin
 *  com.aresclient.visuals.login.utils.Account
 *  com.aresclient.visuals.utils.items.Scrollbar
 *  com.aresclient.visuals.utils.items.Scrollbar$EnumMouseAction
 *  com.aresclient.visuals.utils.items.TextField
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.ScaledResolution
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.opengl.GL11
 */
package com.aresclient.visuals.login;

import com.aresclient.Ares;
import com.aresclient.utils.GuiImages;
import com.aresclient.utils.UIUtils;
import com.aresclient.utils.config.ConfigManager;
import com.aresclient.visuals.login.utils.Account;
import com.aresclient.visuals.utils.items.Scrollbar;
import com.aresclient.visuals.utils.items.TextField;
import java.awt.Color;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public final class GuiLogin
extends GuiScreen {
    private final GuiScreen previousScreen;
    public Scrollbar scrollBar;
    private TextField username;
    int rotate = 0;
    int s = 2;

    public GuiLogin(GuiScreen previousScreen) {
        this.previousScreen = previousScreen;
    }

    protected void actionPerformed(GuiButton button) {
    }

    public void drawScreen(int x2, int y2, float z2) {
        this.drawDefaultBackground();
        GuiImages.drawBackgroundPicture((int)width, (int)height, (String)("Ares/Wallpaper/bg" + ConfigManager.settings.wallpaper + ".png"));
        UIUtils.drawRoundedRect((int)70, (int)10, (int)(width - 70), (int)(height - 10), (float)2.0f, (int)Color.black.getRGB(), (float)0.5f);
        this.username.drawTextBox();
        double totalEntryHeight = 0.0;
        double posY = 50.0 + this.scrollBar.getScrollY();
        for (int i = 0; i < Ares.getAres().getAccountManager().accounts.size(); ++i) {
            Account account = (Account)Ares.getAres().getAccountManager().accounts.get(i);
            GL11.glEnable((int)3089);
            this.glScissor(70.0, 50.0, (double)(width - 70), (double)(height - 20));
            this.fontRendererObj.drawStringWithShadow(account.getUsername(), 80.0f, (float)((int)posY), -1);
            GL11.glDisable((int)3089);
            posY += 30.0;
            totalEntryHeight += 50.0;
        }
        this.scrollBar.setEntryHeight(totalEntryHeight / (double)Ares.getAres().getAccountManager().accounts.size());
        this.scrollBar.update(Ares.getAres().getAccountManager().accounts.size());
        this.scrollBar.draw();
        super.drawScreen(x2, y2, z2);
    }

    public void initGui() {
        int var3 = height / 4 + 24;
        this.buttonList.add(new GuiButton(1, 6, height - 34, 60, 20, "Back"));
        this.username = new TextField(var3, this.mc.fontRendererObj, width - 74 - 100, 15, 100, 20);
        this.username.setFocused(false);
        this.scrollBar = new Scrollbar(0);
        this.scrollBar.init();
        this.scrollBar.setSpeed(20);
        this.scrollBar.setPosition(width - 72, 10, width - 70, height - 10);
        this.scrollBar.update(Ares.getAres().getAccountManager().accounts.size());
        Keyboard.enableRepeatEvents((boolean)true);
    }

    protected void keyTyped(char character, int key) {
        try {
            super.keyTyped(character, key);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        if (character == '\r') {
            this.actionPerformed((GuiButton)this.buttonList.get(0));
        }
        this.username.textboxKeyTyped(character, key);
    }

    public void onGuiClosed() {
        Keyboard.enableRepeatEvents((boolean)false);
    }

    public void updateScreen() {
        this.username.updateCursorCounter();
    }

    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.scrollBar.mouseInput();
    }

    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        this.scrollBar.mouseAction(mouseX, mouseY, Scrollbar.EnumMouseAction.CLICKED);
        this.username.mouseClicked(mouseX, mouseY, mouseButton);
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

    private void glScissor(double x, double y, double width, double height) {
        ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
        Minecraft mc = Minecraft.getMinecraft();
        GL11.glScissor((int)((int)(x * (double)mc.displayWidth / (double)scaledResolution.getScaledWidth())), (int)((int)(((double)scaledResolution.getScaledHeight() - (y += height)) * (double)mc.displayHeight / (double)scaledResolution.getScaledHeight())), (int)((int)(width * (double)mc.displayWidth / (double)scaledResolution.getScaledWidth())), (int)((int)(height * (double)mc.displayHeight / (double)scaledResolution.getScaledHeight())));
    }
}

