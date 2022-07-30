/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.Ares
 *  com.aresclient.connection.packets.C06PacketPing
 *  com.aresclient.connection.packets.Packet
 *  com.aresclient.connection.utils.ClientConnection
 *  com.aresclient.discordrpc.DiscordApp
 *  com.aresclient.user.UserManager
 *  com.aresclient.utils.Data
 *  com.aresclient.utils.config.ConfigManager
 *  com.aresclient.visuals.hud.base.FileManager
 *  com.aresclient.visuals.hud.base.HUDConfig
 *  com.aresclient.visuals.hud.ui.GuiHud
 *  com.aresclient.visuals.login.utils.AccountManager
 *  com.google.common.base.Stopwatch
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiScreen
 */
package com.aresclient;

import com.aresclient.connection.packets.C06PacketPing;
import com.aresclient.connection.packets.Packet;
import com.aresclient.connection.utils.ClientConnection;
import com.aresclient.discordrpc.DiscordApp;
import com.aresclient.user.UserManager;
import com.aresclient.utils.Data;
import com.aresclient.utils.config.ConfigManager;
import com.aresclient.visuals.hud.base.FileManager;
import com.aresclient.visuals.hud.base.HUDConfig;
import com.aresclient.visuals.hud.ui.GuiHud;
import com.aresclient.visuals.login.utils.AccountManager;
import com.google.common.base.Stopwatch;
import java.awt.Color;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

public class Ares {
    private static int ClientColor = new Color(170, 255, 170).getRGB();
    private HUDConfig hudConfig;
    private Stopwatch stopwatch;
    private Data data = new Data();
    private static Ares ares = new Ares();
    private ExecutorService executor = Executors.newFixedThreadPool(3);
    private UserManager userManger = new UserManager();
    private ClientConnection connection = new ClientConnection();
    private AccountManager accountManager = new AccountManager();

    public void startMinecraft() {
        DiscordApp.init();
        this.hudConfig = new HUDConfig();
        ConfigManager.loadProperties((boolean)true);
        this.stopwatch = Stopwatch.createStarted();
        FileManager.init();
        this.connection.connect();
        DiscordApp.update((String)"Idle", (String)"", (boolean)false);
        this.accountManager.load();
    }

    public void stopMinecraft() {
        this.connection.disconnect();
        DiscordApp.close();
        try {
            ConfigManager.save();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        this.stopwatch.stop();
    }

    public HUDConfig getHudConfig() {
        return this.hudConfig;
    }

    public void runTick() {
        if (Minecraft.getMinecraft().gameSettings.keyBindAresHud.isPressed()) {
            Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new GuiHud());
        }
        if (this.data.lastPing != 0L) {
            if (TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis() - this.data.lastPing) == 2L) {
                this.data.lastPing = System.currentTimeMillis();
                this.connection.getConnection().sentToServer((Packet)new C06PacketPing());
            }
        } else {
            this.data.lastPing = System.currentTimeMillis();
        }
    }

    public Data getData() {
        return this.data;
    }

    public static Ares getAres() {
        return ares;
    }

    public ExecutorService getExecutor() {
        return this.executor;
    }

    public UserManager getUserManger() {
        return this.userManger;
    }

    public int getColor() {
        return ClientColor;
    }

    public ClientConnection getConnection() {
        return this.connection;
    }

    public Stopwatch getStopwatch() {
        return this.stopwatch;
    }

    public AccountManager getAccountManager() {
        return this.accountManager;
    }
}

