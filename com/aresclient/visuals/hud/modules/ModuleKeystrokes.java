/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.visuals.hud.base.impl.MoveableModule
 *  com.aresclient.visuals.hud.modules.ModuleKeystrokes
 *  com.aresclient.visuals.utils.Keystrokes
 */
package com.aresclient.visuals.hud.modules;

import com.aresclient.visuals.hud.base.impl.MoveableModule;
import com.aresclient.visuals.utils.Keystrokes;

public class ModuleKeystrokes
extends MoveableModule {
    Keystrokes keystroke = new Keystrokes();

    public ModuleKeystrokes(int x, int y) {
        super(x, y, true);
    }

    public void render() {
        this.keystroke.draw(this.getX() - 1, this.getY() - 1);
    }

    public int getWidth() {
        return 60;
    }

    public int getHeight() {
        return 80;
    }

    public String getName() {
        return "Keystrokes";
    }
}

