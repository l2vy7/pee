/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.connection.WebSocket
 *  com.aresclient.connection.packets.C10PacketDisconnect
 *  com.aresclient.connection.packets.Packet
 *  com.aresclient.connection.utils.ByteBufWrapper
 *  com.aresclient.utils.EnumDisconnection
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiScreen
 */
package com.aresclient.connection.packets;

import com.aresclient.connection.WebSocket;
import com.aresclient.connection.packets.Packet;
import com.aresclient.connection.utils.ByteBufWrapper;
import com.aresclient.utils.EnumDisconnection;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

public class C10PacketDisconnect
extends Packet {
    EnumDisconnection enums;

    public void write(ByteBufWrapper bufWrapper) {
    }

    public void read(ByteBufWrapper bufWrapper) throws IOException {
        this.enums = EnumDisconnection.findEnum((int)bufWrapper.readVarInt());
    }

    public void handle(WebSocket ws) {
        System.out.println(this.enums.name());
        GuiScreen screen = Minecraft.getMinecraft().currentScreen;
        if (this.enums != EnumDisconnection.CRACKED && this.enums != EnumDisconnection.FAILED_AUTHENTICATION && this.enums != EnumDisconnection.WRONG_VERSION) {
            return;
        }
    }
}

