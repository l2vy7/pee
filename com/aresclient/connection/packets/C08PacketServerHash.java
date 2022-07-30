/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.connection.WebSocket
 *  com.aresclient.connection.packets.C08PacketServerHash
 *  com.aresclient.connection.packets.Packet
 *  com.aresclient.connection.utils.ByteBufWrapper
 */
package com.aresclient.connection.packets;

import com.aresclient.connection.WebSocket;
import com.aresclient.connection.packets.Packet;
import com.aresclient.connection.utils.ByteBufWrapper;
import java.io.IOException;

public class C08PacketServerHash
extends Packet {
    public byte[] key;

    public void write(ByteBufWrapper bufWrapper) {
    }

    public void read(ByteBufWrapper bufWrapper) throws IOException {
        this.key = bufWrapper.readByteArray();
    }

    public void handle(WebSocket ws) {
        ws.handleServerHash(this);
    }
}

