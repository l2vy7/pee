/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.visuals.hud.base.FileManager
 *  com.aresclient.visuals.hud.base.Position
 *  com.aresclient.visuals.hud.base.impl.MoveableModule
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.ScaledResolution
 */
package com.aresclient.visuals.hud.base.impl;

import com.aresclient.visuals.hud.base.FileManager;
import com.aresclient.visuals.hud.base.Position;
import java.io.File;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public abstract class MoveableModule {
    int randomNum = ThreadLocalRandom.current().nextInt(0, 1001);
    public static Minecraft minecraft = Minecraft.getMinecraft();
    public ScaledResolution sr = new ScaledResolution(minecraft);
    public Position position;
    public boolean isDrag;

    public MoveableModule(int x, int y, boolean enable) {
        this.position = new Position(x, y, enable);
        this.position = this.loadPositionFromFile();
    }

    public abstract void render();

    public void renderDummy() {
    }

    public boolean isRenderDummy() {
        return false;
    }

    public int getY() {
        return this.position.getY();
    }

    public int getX() {
        return this.position.getX();
    }

    public abstract int getWidth();

    public abstract int getHeight();

    public Position getPosition() {
        return this.position;
    }

    public abstract String getName();

    public void onClick(int mouseX, int mouseY, int button) {
        if (mouseX >= this.getX() && mouseY >= this.getY() && mouseX < this.getX() + this.getWidth() && mouseY < this.getY() + this.getHeight()) {
            if (button == 0) {
                this.isDrag = true;
            } else if (button == 1) {
                this.position.visible = !this.position.visible;
            }
        }
    }

    public void onRelease() {
        this.isDrag = false;
    }

    public void onMove(int mouseX, int mouseY, int lastX, int lastY) {
        if (this.isDrag) {
            this.adjustBounds(this);
            this.position.x += mouseX - lastX;
            this.position.y += mouseY - lastY;
        }
    }

    private void adjustBounds(MoveableModule m) {
        ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft());
        int screenWidth = res.getScaledWidth();
        int screenHeight = res.getScaledHeight();
        int absoluteX = Math.max(0, Math.min(m.getX(), Math.max(screenWidth - m.getWidth(), 0)));
        int absoluteY = Math.max(0, Math.min(m.getY(), Math.max(screenHeight - m.getHeight(), 0)));
        m.position.setX(absoluteX);
        m.position.setY(absoluteY);
    }

    public Position load() {
        return this.position;
    }

    public void save(Position pos) {
        this.position = pos;
        this.savePositionToFile();
    }

    private File getFolder() {
        File folder = new File(FileManager.getModsDirectory(), this.getClass().getSimpleName());
        folder.mkdirs();
        return folder;
    }

    private void savePositionToFile() {
        FileManager.writeJsonToFile((File)new File(this.getFolder(), "pos.json"), (Object)this.position);
    }

    private Position loadPositionFromFile() {
        Position loaded = (Position)FileManager.readFromJson((File)new File(this.getFolder(), "pos.json"), Position.class);
        if (loaded == null) {
            this.position = loaded = new Position(100, 100, true);
            this.savePositionToFile();
        }
        return loaded;
    }
}

