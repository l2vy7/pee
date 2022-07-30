/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.Ares
 *  com.aresclient.connection.packets.C04PacketCosmetic
 *  com.aresclient.connection.packets.Packet
 *  com.aresclient.user.User
 *  com.google.gson.Gson
 *  net.minecraft.util.ResourceLocation
 */
package com.aresclient.user;

import com.aresclient.Ares;
import com.aresclient.connection.packets.C04PacketCosmetic;
import com.aresclient.connection.packets.Packet;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.util.ResourceLocation;

public class User {
    public String UUID;
    public String role;
    public String nametag;
    public float nametagHeight = 1.0f;
    public ResourceLocation capeLocation;
    public Map<String, Boolean> activeCosmetics = new HashMap();

    public User(String UUID2) {
        this.UUID = UUID2;
        this.role = "USER";
        this.nametag = "";
        Ares.getAres().getConnection().getConnection().sentToServer((Packet)new C04PacketCosmetic(UUID2));
    }

    public void setCosmetics(String Json) {
        this.activeCosmetics = (Map)new Gson().fromJson(Json, Map.class);
    }

    public void setUUID(String UUID2) {
        this.UUID = UUID2;
    }

    public void setNametag(String nametag) {
        this.nametag = nametag;
        if (!nametag.isEmpty()) {
            this.nametagHeight = 10.0f;
        }
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setActiveCosmetics(Map<String, Boolean> activeCosmetics) {
        this.activeCosmetics = activeCosmetics;
    }

    public String getUUID() {
        return this.UUID;
    }

    public String getNametag() {
        if (this.nametag == null) {
            return "";
        }
        return this.nametag;
    }

    public String getRole() {
        if (this.role == null) {
            return "";
        }
        return this.role;
    }

    public void update() {
        Ares.getAres().getConnection().getConnection().sentToServer((Packet)new C04PacketCosmetic(this.UUID));
    }
}

