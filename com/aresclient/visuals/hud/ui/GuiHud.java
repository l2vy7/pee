/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.Ares
 *  com.aresclient.utils.UIUtils
 *  com.aresclient.utils.config.ConfigManager
 *  com.aresclient.visuals.hud.base.impl.MoveableModule
 *  com.aresclient.visuals.hud.ui.GuiHud
 *  com.aresclient.visuals.hud.ui.GuiHud$MouseOverFinder
 *  com.aresclient.visuals.utils.items.ImageButton
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.util.ResourceLocation
 */
package com.aresclient.visuals.hud.ui;

import com.aresclient.Ares;
import com.aresclient.utils.UIUtils;
import com.aresclient.utils.config.ConfigManager;
import com.aresclient.visuals.hud.base.impl.MoveableModule;
import com.aresclient.visuals.hud.ui.GuiHud;
import com.aresclient.visuals.utils.items.ImageButton;
import java.awt.Color;
import java.io.IOException;
import java.util.Optional;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;

public class GuiHud
extends GuiScreen {
    private int lastX;
    private int lastY;
    private Optional<MoveableModule> selectedModule;
    ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
    int i = -25;

    public GuiHud() {
        for (MoveableModule module : Ares.getAres().getHudConfig().moveableModules) {
            this.checkIfOutOfScreen(module);
            module.load();
        }
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        int yes = GuiScreen.height - GuiScreen.height / 4;
        this.drawVerticalLine(GuiScreen.width / 2, -1, GuiScreen.height - 30 - this.i, Color.gray.getRGB());
        this.drawHorizontalLine(0, GuiScreen.width, GuiScreen.height / 2, Color.gray.getRGB());
        if (mouseY >= yes && this.i < 0) {
            ++this.i;
        } else if (mouseY <= yes && this.i > -25) {
            --this.i;
        }
        int Size = GuiScreen.height / 12;
        UIUtils.drawRoundedRect((int)(GuiScreen.width / 2 - GuiScreen.width / 6 - Size), (int)(GuiScreen.height - 30 - this.i), (int)(GuiScreen.width / 2 + GuiScreen.width / 6 + Size), (int)(GuiScreen.height - 1 - this.i), (float)((float)(9.0 / (double)this.sr.getScaleFactor())), (int)new Color(30, 30, 30, 180).getRGB());
        int X = GuiScreen.width / 2;
        int Y = GuiScreen.height;
        this.buttonList.clear();
        this.buttonList.add(new ImageButton(8, GuiScreen.width / 2 - Size * 4, GuiScreen.height - Size - Size / 4 - this.i, Size, Size, new ResourceLocation("Ares/Icons/ColorPicker/Yellow.png")));
        this.buttonList.add(new ImageButton(7, GuiScreen.width / 2 - Size * 3, GuiScreen.height - Size - Size / 4 - this.i, Size, Size, new ResourceLocation("Ares/Icons/ColorPicker/Green.png")));
        this.buttonList.add(new ImageButton(6, GuiScreen.width / 2 - Size * 2, GuiScreen.height - Size - Size / 4 - this.i, Size, Size, new ResourceLocation("Ares/Icons/ColorPicker/Red.png")));
        this.buttonList.add(new ImageButton(5, GuiScreen.width / 2 - Size * 1, GuiScreen.height - Size - Size / 4 - this.i, Size, Size, new ResourceLocation("Ares/Icons/ColorPicker/Magenta.png")));
        this.buttonList.add(new ImageButton(4, GuiScreen.width / 2 - Size * 0, GuiScreen.height - Size - Size / 4 - this.i, Size, Size, new ResourceLocation("Ares/Icons/ColorPicker/Blue.png")));
        this.buttonList.add(new ImageButton(3, GuiScreen.width / 2 + Size * 1, GuiScreen.height - Size - Size / 4 - this.i, Size, Size, new ResourceLocation("Ares/Icons/ColorPicker/Turquise.png")));
        this.buttonList.add(new ImageButton(2, GuiScreen.width / 2 + Size * 2, GuiScreen.height - Size - Size / 4 - this.i, Size, Size, new ResourceLocation("Ares/Icons/ColorPicker/Grey.png")));
        this.buttonList.add(new ImageButton(1, GuiScreen.width / 2 + Size * 3, GuiScreen.height - Size - Size / 4 - this.i, Size, Size, new ResourceLocation("Ares/Icons/ColorPicker/White.png")));
        for (MoveableModule module : Ares.getAres().getHudConfig().moveableModules) {
            if (module.position.visible) {
                this.drawHollowRect(module.getX() - 2, module.getY() - 2, module.getWidth() + 1, module.getHeight() + 1, Color.white.getRGB());
                Gui.drawRect((int)(module.getX() - 2), (int)(module.getY() - 2), (int)(module.getX() + module.getWidth()), (int)(module.getY() + module.getHeight()), (int)new Color(200, 200, 200, 150).getRGB());
            } else {
                Gui.drawRect((int)(module.getX() - 2), (int)(module.getY() - 2), (int)(module.getX() + module.getWidth()), (int)(module.getY() + module.getHeight()), (int)new Color(200, 10, 10, 50).getRGB());
                this.drawHollowRect(module.getX() - 2, module.getY() - 2, module.getWidth() + 1, module.getHeight() + 1, new Color(200, 10, 10, 50).getRGB());
            }
            if (module.isRenderDummy()) {
                module.renderDummy();
            } else {
                module.render();
            }
            module.onMove(mouseX, mouseY, this.lastX, this.lastY);
        }
        this.lastX = mouseX;
        this.lastY = mouseY;
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    private void checkIfOutOfScreen(MoveableModule module) {
        if (module.getX() == 0) {
            module.position.setX(1);
            module.position.setY(module.getY());
        }
        if (module.getY() == 0) {
            module.position.setX(module.getX());
            module.position.setY(1);
        }
    }

    private void drawHollowRect(int x, int y, int w, int h, int color) {
        this.drawHorizontalLine(x, x + w, y, color);
        this.drawHorizontalLine(x, x + w, y + h, color);
        this.drawVerticalLine(x, y + h, y, color);
        this.drawVerticalLine(x + w, y + h, y, color);
    }

    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        this.loadMouseOver(mouseX, mouseY);
        if (this.selectedModule != null && this.selectedModule.isPresent()) {
            ((MoveableModule)this.selectedModule.get()).onClick(mouseX, mouseY, mouseButton);
        }
    }

    private void loadMouseOver(int x, int y) {
        this.selectedModule = Ares.getAres().getHudConfig().moveableModules.stream().filter(new MouseOverFinder(this, x, y)).findFirst();
    }

    protected void actionPerformed(GuiButton button) {
        if (button.id == 1) {
            ConfigManager.settings.ModColor = "\u00a7f";
        }
        if (button.id == 2) {
            ConfigManager.settings.ModColor = "\u00a78";
        }
        if (button.id == 3) {
            ConfigManager.settings.ModColor = "\u00a7b";
        }
        if (button.id == 4) {
            ConfigManager.settings.ModColor = "\u00a79";
        }
        if (button.id == 5) {
            ConfigManager.settings.ModColor = "\u00a7d";
        }
        if (button.id == 6) {
            ConfigManager.settings.ModColor = "\u00a7c";
        }
        if (button.id == 7) {
            ConfigManager.settings.ModColor = "\u00a7a";
        }
        if (button.id == 8) {
            ConfigManager.settings.ModColor = "\u00a7e";
        }
    }

    public void initGui() {
        Minecraft.getMinecraft().entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
        this.buttonList.clear();
    }

    public void onGuiClosed() {
        if (this.mc.thePlayer != null) {
            Minecraft.getMinecraft().entityRenderer.loadEntityShader(null);
            super.onGuiClosed();
        }
    }

    protected void mouseReleased(int mouseX, int mouseY, int state) {
        super.mouseReleased(mouseX, mouseY, state);
        for (MoveableModule module : Ares.getAres().getHudConfig().moveableModules) {
            module.onRelease();
            module.save(module.position);
        }
    }
}

