/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.utils.GuiImages
 *  com.aresclient.utils.config.ConfigManager
 *  com.aresclient.visuals.GuiSearchTest
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.GuiTextField
 *  org.lwjgl.input.Keyboard
 */
package com.aresclient.visuals;

import com.aresclient.utils.GuiImages;
import com.aresclient.utils.config.ConfigManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import org.lwjgl.input.Keyboard;

public final class GuiSearchTest
extends GuiScreen {
    private final GuiScreen previousScreen;
    private List<String> texts = new ArrayList();
    private GuiTextField username;
    int rotate = 0;
    int s = 2;

    public GuiSearchTest(GuiScreen previousScreen) {
        this.previousScreen = previousScreen;
        for (int i = 0; 200 > i; ++i) {
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            StringBuilder sb = new StringBuilder();
            Random random = new Random();
            int length = 7;
            for (int i2 = 0; i2 < length; ++i2) {
                int index = random.nextInt(alphabet.length());
                char randomChar = alphabet.charAt(index);
                sb.append(randomChar);
            }
            this.texts.add(sb.toString());
        }
    }

    protected void actionPerformed(GuiButton button) {
        switch (button.id) {
            case 1: {
                this.mc.displayGuiScreen(this.previousScreen);
            }
        }
    }

    public void drawScreen(int x2, int y2, float z2) {
        this.drawDefaultBackground();
        GuiImages.drawBackgroundPicture((int)width, (int)height, (String)("Ares/Wallpaper/bg" + ConfigManager.settings.wallpaper + ".png"));
        this.username.drawTextBox();
        int st = 0;
        for (int i = 0; this.texts.size() > i; ++i) {
            String text = (String)this.texts.get(i);
            if (!text.toLowerCase().contains(this.username.getText().toLowerCase())) continue;
            this.drawString(this.fontRendererObj, text, width / 2, height / 2 + (st += 10), -1);
        }
        super.drawScreen(x2, y2, z2);
    }

    public void initGui() {
        int var3 = height / 4 + 24;
        this.buttonList.add(new GuiButton(1, width / 2 - 100, var3 + 72 + 12 + 24, "Back"));
        this.username = new GuiTextField(var3, this.mc.fontRendererObj, width / 2 - 100, 60, 200, 20);
        this.username.setFocused(true);
        Keyboard.enableRepeatEvents((boolean)true);
    }

    protected void keyTyped(char character, int key) {
        try {
            super.keyTyped(character, key);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        if (character == '\t' && !this.username.isFocused()) {
            this.username.setFocused(true);
        }
        if (character == '\r') {
            this.actionPerformed((GuiButton)this.buttonList.get(0));
        }
        this.search();
        this.username.textboxKeyTyped(character, key);
    }

    private void search() {
        System.out.println(this.username.getText());
    }

    protected void mouseClicked(int x2, int y2, int button) {
        try {
            super.mouseClicked(x2, y2, button);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        this.username.mouseClicked(x2, y2, button);
    }

    public void onGuiClosed() {
        Keyboard.enableRepeatEvents((boolean)false);
    }

    public void updateScreen() {
        this.username.updateCursorCounter();
    }
}

