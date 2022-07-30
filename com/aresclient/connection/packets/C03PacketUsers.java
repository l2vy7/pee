/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.connection.WebSocket
 *  com.aresclient.connection.packets.C03PacketUsers
 *  com.aresclient.connection.packets.Packet
 *  com.aresclient.connection.utils.ByteBufWrapper
 */
package com.aresclient.connection.packets;

import com.aresclient.connection.WebSocket;
import com.aresclient.connection.packets.Packet;
import com.aresclient.connection.utils.ByteBufWrapper;
import java.io.IOException;

public class C03PacketUsers
extends Packet {
    String list;

    public void write(ByteBufWrapper bufWrapper) {
    }

    public void read(ByteBufWrapper bufWrapper) throws IOException {
        this.list = bufWrapper.readString();
    }

    public void handle(WebSocket ws) {
        ws.handlePacketUsers(this);
    }

    public String getList() {
        return this.list;
    }
}

