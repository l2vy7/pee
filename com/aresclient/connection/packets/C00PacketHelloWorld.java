/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.connection.WebSocket
 *  com.aresclient.connection.packets.C00PacketHelloWorld
 *  com.aresclient.connection.packets.Packet
 *  com.aresclient.connection.utils.ByteBufWrapper
 */
package com.aresclient.connection.packets;

import com.aresclient.connection.WebSocket;
import com.aresclient.connection.packets.Packet;
import com.aresclient.connection.utils.ByteBufWrapper;
import java.io.IOException;

public class C00PacketHelloWorld
extends Packet {
    private String message;

    public C00PacketHelloWorld() {
    }

    public C00PacketHelloWorld(String message) {
        this.message = message;
    }

    public void write(ByteBufWrapper bufWrapper) {
        bufWrapper.writeString("test123");
    }

    public void read(ByteBufWrapper bufWrapper) throws IOException {
        System.out.println(bufWrapper.readString());
    }

    public void handle(WebSocket ws) {
    }
}

