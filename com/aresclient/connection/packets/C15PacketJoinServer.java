/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.connection.WebSocket
 *  com.aresclient.connection.packets.C15PacketJoinServer
 *  com.aresclient.connection.packets.Packet
 *  com.aresclient.connection.utils.ByteBufWrapper
 */
package com.aresclient.connection.packets;

import com.aresclient.connection.WebSocket;
import com.aresclient.connection.packets.Packet;
import com.aresclient.connection.utils.ByteBufWrapper;
import java.io.IOException;

public class C15PacketJoinServer
extends Packet {
    public String lastServer;

    public C15PacketJoinServer() {
    }

    public C15PacketJoinServer(String lastServer) {
        this.lastServer = lastServer;
    }

    public void write(ByteBufWrapper bufWrapper) {
        bufWrapper.writeString(this.lastServer);
    }

    public void read(ByteBufWrapper bufWrapper) throws IOException {
    }

    public void handle(WebSocket ws) {
    }
}

