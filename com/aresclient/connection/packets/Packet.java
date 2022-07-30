/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.connection.WebSocket
 *  com.aresclient.connection.packets.C01PacketLogin
 *  com.aresclient.connection.packets.C02PacketQuit
 *  com.aresclient.connection.packets.C03PacketUsers
 *  com.aresclient.connection.packets.C04PacketCosmetic
 *  com.aresclient.connection.packets.C05PacketInfo
 *  com.aresclient.connection.packets.C06PacketPing
 *  com.aresclient.connection.packets.C08PacketServerHash
 *  com.aresclient.connection.packets.C09PacketComplete
 *  com.aresclient.connection.packets.C10PacketDisconnect
 *  com.aresclient.connection.packets.C11PacketReconnect
 *  com.aresclient.connection.packets.C15PacketJoinServer
 *  com.aresclient.connection.packets.Packet
 *  com.aresclient.connection.utils.ByteBufWrapper
 *  com.google.common.collect.BiMap
 *  com.google.common.collect.HashBiMap
 */
package com.aresclient.connection.packets;

import com.aresclient.connection.WebSocket;
import com.aresclient.connection.packets.C01PacketLogin;
import com.aresclient.connection.packets.C02PacketQuit;
import com.aresclient.connection.packets.C03PacketUsers;
import com.aresclient.connection.packets.C04PacketCosmetic;
import com.aresclient.connection.packets.C05PacketInfo;
import com.aresclient.connection.packets.C06PacketPing;
import com.aresclient.connection.packets.C08PacketServerHash;
import com.aresclient.connection.packets.C09PacketComplete;
import com.aresclient.connection.packets.C10PacketDisconnect;
import com.aresclient.connection.packets.C11PacketReconnect;
import com.aresclient.connection.packets.C15PacketJoinServer;
import com.aresclient.connection.utils.ByteBufWrapper;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.io.IOException;

public abstract class Packet {
    public static BiMap<Class<? extends Packet>, Integer> REGISTRY = HashBiMap.create();

    static {
        REGISTRY.put(C01PacketLogin.class, (Object)1);
        REGISTRY.put(C02PacketQuit.class, (Object)2);
        REGISTRY.put(C03PacketUsers.class, (Object)3);
        REGISTRY.put(C04PacketCosmetic.class, (Object)4);
        REGISTRY.put(C05PacketInfo.class, (Object)5);
        REGISTRY.put(C06PacketPing.class, (Object)7);
        REGISTRY.put(C08PacketServerHash.class, (Object)8);
        REGISTRY.put(C09PacketComplete.class, (Object)9);
        REGISTRY.put(C11PacketReconnect.class, (Object)11);
        REGISTRY.put(C10PacketDisconnect.class, (Object)10);
        REGISTRY.put(C15PacketJoinServer.class, (Object)15);
    }

    public abstract void write(ByteBufWrapper var1);

    public abstract void read(ByteBufWrapper var1) throws IOException;

    public abstract void handle(WebSocket var1);
}

