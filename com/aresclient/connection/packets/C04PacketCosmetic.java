/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.connection.WebSocket
 *  com.aresclient.connection.packets.C04PacketCosmetic
 *  com.aresclient.connection.packets.Packet
 *  com.aresclient.connection.utils.ByteBufWrapper
 */
package com.aresclient.connection.packets;

import com.aresclient.connection.WebSocket;
import com.aresclient.connection.packets.Packet;
import com.aresclient.connection.utils.ByteBufWrapper;
import java.util.UUID;

public class C04PacketCosmetic
extends Packet {
    public String UUId;
    public String role;
    public String tag;
    public String cosmeticJson;

    public C04PacketCosmetic() {
    }

    public C04PacketCosmetic(String uuid) {
        this.UUId = uuid;
    }

    public void write(ByteBufWrapper bufWrapper) {
        bufWrapper.writeUUID(UUID.fromString(this.UUId));
    }

    public void read(ByteBufWrapper bufWrapper) {
        this.UUId = bufWrapper.readString();
        this.role = bufWrapper.readString();
        this.tag = bufWrapper.readString();
        this.cosmeticJson = bufWrapper.readString();
    }

    public void handle(WebSocket ws) {
        ws.handlePacketTag(this);
    }

    public String getUUID() {
        return this.UUId;
    }

    public String getRole() {
        return this.role;
    }

    public String getTag() {
        return this.tag;
    }

    public String getCosmeticJson() {
        return this.cosmeticJson;
    }
}

