/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.connection.WebSocket
 *  com.aresclient.connection.packets.C05PacketInfo
 *  com.aresclient.connection.packets.Packet
 *  com.aresclient.connection.utils.ByteBufWrapper
 */
package com.aresclient.connection.packets;

import com.aresclient.connection.WebSocket;
import com.aresclient.connection.packets.Packet;
import com.aresclient.connection.utils.ByteBufWrapper;
import java.io.IOException;

public class C05PacketInfo
extends Packet {
    private String serverBuild;

    public void write(ByteBufWrapper bufWrapper) {
    }

    public void read(ByteBufWrapper bufWrapper) throws IOException {
        this.serverBuild = bufWrapper.readString();
    }

    public void handle(WebSocket ws) {
        ws.handlePacketInfo(this);
    }

    public String getServerBuild() {
        return this.serverBuild;
    }
}

