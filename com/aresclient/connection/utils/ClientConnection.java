/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.Ares
 *  com.aresclient.connection.WebSocket
 *  com.aresclient.connection.packets.C01PacketLogin
 *  com.aresclient.connection.packets.C02PacketQuit
 *  com.aresclient.connection.packets.C11PacketReconnect
 *  com.aresclient.connection.packets.C15PacketJoinServer
 *  com.aresclient.connection.packets.Packet
 *  com.aresclient.connection.utils.ClientConnection
 *  com.aresclient.connection.utils.KeyUtils
 *  com.mojang.util.UUIDTypeAdapter
 *  net.minecraft.client.Minecraft
 */
package com.aresclient.connection.utils;

import com.aresclient.Ares;
import com.aresclient.connection.WebSocket;
import com.aresclient.connection.packets.C01PacketLogin;
import com.aresclient.connection.packets.C02PacketQuit;
import com.aresclient.connection.packets.C11PacketReconnect;
import com.aresclient.connection.packets.C15PacketJoinServer;
import com.aresclient.connection.packets.Packet;
import com.aresclient.connection.utils.KeyUtils;
import com.mojang.util.UUIDTypeAdapter;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;

public class ClientConnection {
    public static ArrayList<String> players;
    private static WebSocket connection;
    public static String UUID;
    public static String username;
    public static boolean isAuthenticated;
    public static boolean isclosed;
    public PrivateKey privatekey;

    static {
        isclosed = true;
    }

    public void connect() {
        new /* Unavailable Anonymous Inner Class!! */.start();
    }

    public WebSocket getConnection() {
        return connection;
    }

    public void disconnect() {
        if (!isclosed) {
            connection.sentToServer((Packet)new C02PacketQuit(username, UUID, Ares.getAres().getData().clientVersion));
            connection.close();
            isclosed = true;
        }
    }

    public void reconnect() {
        if (!isclosed) {
            KeyPair pair = KeyUtils.generateRSAKeyPair();
            this.privatekey = pair.getPrivate();
            Ares.getAres().getConnection().getConnection().sentToServer((Packet)new C11PacketReconnect(username, UUID, Ares.getAres().getData().clientVersion, pair.getPublic().getEncoded()));
        }
    }

    public void auth() {
        if (!isclosed) {
            KeyPair pair = KeyUtils.generateRSAKeyPair();
            this.privatekey = pair.getPrivate();
            Ares.getAres().getConnection().getConnection().sentToServer((Packet)new C01PacketLogin(username, UUID, Ares.getAres().getData().clientVersion, pair.getPublic().getEncoded()));
        }
    }

    public static String convertToUUID(String UUID2) {
        return UUIDTypeAdapter.fromString((String)UUID2).toString();
    }

    public static void setServer(String server) {
        if (Ares.getAres().getData().lastServer != server) {
            Ares.getAres().getData().lastServer = server;
            connection.sentToServer((Packet)new C15PacketJoinServer(server));
        }
    }

    public static void load() {
        if (!isclosed) {
            if (!Minecraft.getMinecraft().getSession().getUsername().isEmpty()) {
                username = Minecraft.getMinecraft().getSession().getUsername();
            }
            if (!Minecraft.getMinecraft().getSession().getUsername().equals(Minecraft.getMinecraft().getSession().getPlayerID().toString())) {
                try {
                    UUID = UUIDTypeAdapter.fromString((String)Minecraft.getMinecraft().getSession().getPlayerID()).toString();
                }
                catch (IllegalArgumentException e) {
                    UUID = "00000000-0000-0000-0000-000000000000";
                    isclosed = true;
                }
            }
        }
    }

    static /* synthetic */ void access$0(WebSocket webSocket) {
        connection = webSocket;
    }

    static /* synthetic */ WebSocket access$1() {
        return connection;
    }
}

