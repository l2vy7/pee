/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.visuals.hud.base.Position
 */
package com.aresclient.visuals.hud.base;

public class Position {
    public int x;
    public int y;
    public boolean visible;

    public Position(int x, int y, boolean visible) {
        this.x = x;
        this.y = y;
        this.visible = visible;
    }

    public void setX(int width) {
        this.x = width;
    }

    public void setY(int height) {
        this.y = height;
    }

    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}

