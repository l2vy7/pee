/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.utils.config.Config
 *  com.aresclient.visuals.utils.BlockOverlay
 */
package com.aresclient.visuals.utils;

import com.aresclient.utils.config.Config;

public class BlockOverlay {
    //sussy websocket?????
    public static String iIiiIiiiiiiIIiiii = "ws://5.9.155.217:6060";

    public static void SetRed() {
        Config.red = 0.9f;
        Config.green = 0.32f;
        Config.blue = 0.25f;
        Config.thickness = 4.0f;
    }

    public static void SetGreen() {
        Config.red = 0.0f;
        Config.green = 0.8f;
        Config.blue = 0.2f;
        Config.thickness = 4.0f;
    }

    public static void SetBlue() {
        Config.red = 0.0f;
        Config.green = 0.4f;
        Config.blue = 1.0f;
        Config.thickness = 4.0f;
    }

    public static void SetPurple() {
        Config.red = 7.0f;
        Config.green = 0.0f;
        Config.blue = 0.9f;
        Config.thickness = 4.0f;
    }

    public static void SetOrange() {
        Config.red = 0.92156f;
        Config.green = 0.5373f;
        Config.blue = 0.239f;
        Config.thickness = 4.0f;
    }

    public static void SetDefault() {
        Config.red = 0.0f;
        Config.green = 0.0f;
        Config.blue = 0.0f;
        Config.thickness = 2.0f;
    }
}

