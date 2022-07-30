/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.Ares
 *  com.aresclient.discordrpc.DiscordApp
 *  net.arikia.dev.drpc.DiscordEventHandlers
 *  net.arikia.dev.drpc.DiscordRPC
 *  net.arikia.dev.drpc.DiscordRichPresence
 *  net.arikia.dev.drpc.DiscordRichPresence$Builder
 *  net.arikia.dev.drpc.OSUtil
 */
package com.aresclient.discordrpc;

import com.aresclient.Ares;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.arikia.dev.drpc.OSUtil;

public class DiscordApp {
    private static String key = "919703601012674640";
    private static String partyid;
    public static boolean running;
    private static long created;

    public static void init() {
        created = System.currentTimeMillis();
        running = true;
        DiscordRPC rpc = new DiscordRPC();
        DiscordEventHandlers handlers = new DiscordEventHandlers();
        DiscordRichPresence discordPresence = new DiscordRichPresence();
        if (new OSUtil().isWindows()) {
            new /* Unavailable Anonymous Inner Class!! */.start();
            DiscordRPC.discordInitialize((String)key, (DiscordEventHandlers)handlers, (boolean)true);
        } else {
            running = false;
        }
    }

    public static void close() {
        running = false;
        DiscordRPC.discordShutdown();
    }

    public static void update(String line, String line2, boolean timestaps) {
        if (!running) {
            return;
        }
        DiscordRichPresence.Builder b = new DiscordRichPresence.Builder(line2);
        b.setBigImage("main", "Minecraft 1.8.9 x " + Ares.getAres().getData().clientVersion);
        b.setDetails(line);
        b.setInstance(true);
        if (timestaps) {
            b.setStartTimestamps(created);
        }
        DiscordRPC.discordUpdatePresence((DiscordRichPresence)b.build());
    }
}

