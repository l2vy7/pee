/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.user.role.UserRanks
 */
package com.aresclient.user.role;

import java.awt.Color;

public class UserRanks {
    private static Color admin = Color.decode("#AA0000");
    private static Color mod = Color.decode("#FF5555");
    private static Color helper = Color.decode("#00AAAA");
    private static Color media = new Color(170, 0, 170);
    private static Color dev = Color.decode("#FDAC20");
    private static Color translator = Color.decode("#55FFFF");
    private static Color founder = Color.decode("#5555FF");

    public static Color GetColor(String rank) {
        if (rank == null) {
            return new Color(255, 255, 255);
        }
        if (rank.equalsIgnoreCase("Admin")) {
            return admin;
        }
        if (rank.equalsIgnoreCase("Mod")) {
            return mod;
        }
        if (rank.equalsIgnoreCase("helper")) {
            return helper;
        }
        if (rank.equalsIgnoreCase("Media")) {
            return media;
        }
        if (rank.equalsIgnoreCase("Developer")) {
            return dev;
        }
        if (rank.equalsIgnoreCase("Translator")) {
            return translator;
        }
        if (rank.equalsIgnoreCase("Founder")) {
            return founder;
        }
        return new Color(255, 255, 255);
    }

    public static String GetColorMinecraft(String rank) {
        if (rank == null) {
            return "USER";
        }
        if (rank.equalsIgnoreCase("Admin")) {
            return "\u00a74\u00a7lAdmin";
        }
        if (rank.equalsIgnoreCase("Mod")) {
            return "\u00a7cMod";
        }
        if (rank.equalsIgnoreCase("helper")) {
            return "\u00a73Helper";
        }
        if (rank.equalsIgnoreCase("Media")) {
            return "\u00a75Media";
        }
        if (rank.equalsIgnoreCase("Developer")) {
            return "\u00a76Developer";
        }
        if (rank.equalsIgnoreCase("Translator")) {
            return "\u00a7bTranslator";
        }
        if (rank.equalsIgnoreCase("Founder")) {
            return "\u00a79Founder";
        }
        return "USER";
    }
}

