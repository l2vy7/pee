/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.connection.WebSocket
 *  com.aresclient.connection.packets.C01PacketLogin
 *  com.aresclient.connection.packets.Packet
 *  com.aresclient.connection.utils.ByteBufWrapper
 */
package com.aresclient.connection.packets;

import com.aresclient.connection.WebSocket;
import com.aresclient.connection.packets.Packet;
import com.aresclient.connection.utils.ByteBufWrapper;
import java.io.IOException;
import java.util.UUID;

public class C01PacketLogin
extends Packet {
    private String name;
    private String UUID;
    private String clientBuild;
    private byte[] key;

    public C01PacketLogin(String name, String UUID2, String clientBuild, byte[] key) {
        this.UUID = UUID2;
        this.name = name;
        this.clientBuild = clientBuild;
        this.key = key;
    }

    public C01PacketLogin() {
    }

    public void write(ByteBufWrapper bufWrapper) {
        bufWrapper.writeUUID(UUID.fromString(this.UUID));
        bufWrapper.writeString(this.name);
        bufWrapper.writeString(this.clientBuild);
        bufWrapper.writeByteArray(this.key);
    }

    public void read(ByteBufWrapper bufWrapper) throws IOException {
    }

    public void handle(WebSocket ws) {
    }
}

