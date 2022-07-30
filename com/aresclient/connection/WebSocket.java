/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.Ares
 *  com.aresclient.connection.WebSocket
 *  com.aresclient.connection.packets.C03PacketUsers
 *  com.aresclient.connection.packets.C04PacketCosmetic
 *  com.aresclient.connection.packets.C05PacketInfo
 *  com.aresclient.connection.packets.C08PacketServerHash
 *  com.aresclient.connection.packets.C09PacketComplete
 *  com.aresclient.connection.packets.Packet
 *  com.aresclient.connection.utils.ByteBufWrapper
 *  com.aresclient.connection.utils.ClientConnection
 *  com.aresclient.connection.utils.KeyUtils
 *  com.aresclient.user.User
 *  com.google.gson.Gson
 *  io.netty.buffer.Unpooled
 *  net.minecraft.client.Minecraft
 *  org.java_websocket.client.WebSocketClient
 *  org.java_websocket.handshake.ServerHandshake
 */
package com.aresclient.connection;

import com.aresclient.Ares;
import com.aresclient.connection.packets.C03PacketUsers;
import com.aresclient.connection.packets.C04PacketCosmetic;
import com.aresclient.connection.packets.C05PacketInfo;
import com.aresclient.connection.packets.C08PacketServerHash;
import com.aresclient.connection.packets.C09PacketComplete;
import com.aresclient.connection.packets.Packet;
import com.aresclient.connection.utils.ByteBufWrapper;
import com.aresclient.connection.utils.ClientConnection;
import com.aresclient.connection.utils.KeyUtils;
import com.aresclient.user.User;
import com.google.gson.Gson;
import io.netty.buffer.Unpooled;
import java.net.URI;
import java.nio.ByteBuffer;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

public class WebSocket
extends WebSocketClient {
    public WebSocket(URI serverUri) {
        super(serverUri);
    }

    public void onClose(int arg0, String arg1, boolean arg2) {
    }

    public void onError(Exception arg0) {
    }

    public void onMessage(String arg0) {
    }

    public void onMessage(ByteBuffer bytes) {
        this.handleIncoming(new ByteBufWrapper(Unpooled.wrappedBuffer((byte[])bytes.array())));
    }

    public void onOpen(ServerHandshake arg0) {
        if (Objects.equals(Minecraft.getMinecraft().getSession().getUsername(), Minecraft.getMinecraft().getSession().getPlayerID())) {
            this.close();
            ClientConnection.isclosed = true;
        }
    }

    public void sentToServer(Packet packet) {
        if (!this.isOpen() || this.isClosed() || ClientConnection.isclosed) {
            return;
        }
        ByteBufWrapper buf = new ByteBufWrapper(Unpooled.buffer());
        buf.writeVarInt(((Integer)Packet.REGISTRY.get(packet.getClass())).intValue());
        packet.write(buf);
        this.send(buf.buf().array());
    }

    public void handleIncoming(ByteBufWrapper buf) {
        int n = buf.readVarInt();
        Class packetClass = (Class)Packet.REGISTRY.inverse().get((Object)n);
        try {
            Packet packet;
            Packet packet2 = packet = packetClass == null ? null : (Packet)packetClass.newInstance();
            if (packet == null) {
                return;
            }
            packet.read(buf);
            packet.handle(this);
        }
        catch (Exception exception) {
            System.out.println("Error from: " + packetClass);
            exception.printStackTrace();
        }
    }

    public void handlePacketInfo(C05PacketInfo packetInfo) {
        Ares.getAres().getData().clientVersion.trim().equals(packetInfo.getServerBuild().trim());
    }

    public void handlePacketTag(C04PacketCosmetic packetTag) {
        User user = Ares.getAres().getUserManger().getUser(packetTag.getUUID());
        if (user == null) {
            return;
        }
        user.setCosmetics(packetTag.getCosmeticJson());
        user.setRole(packetTag.getRole());
        user.setNametag(packetTag.getTag());
    }

    public void handleServerHash(C08PacketServerHash packetHash) {
        try {
            String serverHash = new String(KeyUtils.decryptRSA((byte[])packetHash.key, (PrivateKey)Ares.getAres().getConnection().privatekey));
            Minecraft.getMinecraft().getSessionService().joinServer(Minecraft.getMinecraft().getSession().getProfile(), Minecraft.getMinecraft().getSession().getToken(), serverHash);
            this.sentToServer((Packet)new C09PacketComplete());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handlePacketUsers(C03PacketUsers c03PacketUsers) {
        ClientConnection.players = (ArrayList)new Gson().fromJson(c03PacketUsers.getList(), ArrayList.class);
    }
}

