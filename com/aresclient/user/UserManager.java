/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.user.User
 *  com.aresclient.user.UserManager
 *  com.aresclient.user.cosmetic.Cosmetic
 *  com.aresclient.user.cosmetic.imp.CosmeticBandana
 *  com.aresclient.user.cosmetic.imp.CosmeticBlaze
 *  com.aresclient.user.cosmetic.imp.CosmeticBunnyEars
 *  com.aresclient.user.cosmetic.imp.CosmeticDragonWings
 *  com.aresclient.user.cosmetic.imp.CosmeticHalo
 *  com.aresclient.user.cosmetic.imp.CosmeticWitchHat
 *  com.google.common.collect.BiMap
 *  com.google.common.collect.HashBiMap
 *  net.minecraft.util.ResourceLocation
 */
package com.aresclient.user;

import com.aresclient.user.User;
import com.aresclient.user.cosmetic.Cosmetic;
import com.aresclient.user.cosmetic.imp.CosmeticBandana;
import com.aresclient.user.cosmetic.imp.CosmeticBlaze;
import com.aresclient.user.cosmetic.imp.CosmeticBunnyEars;
import com.aresclient.user.cosmetic.imp.CosmeticDragonWings;
import com.aresclient.user.cosmetic.imp.CosmeticHalo;
import com.aresclient.user.cosmetic.imp.CosmeticWitchHat;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.minecraft.util.ResourceLocation;

public class UserManager {
    public BiMap<Integer, Class<? extends Cosmetic>> REGISTRY = HashBiMap.create();
    public BiMap<String, User> users = HashBiMap.create();

    public UserManager() {
        this.REGISTRY.put((Object)1, CosmeticBandana.class);
        this.REGISTRY.put((Object)2, CosmeticBlaze.class);
        this.REGISTRY.put((Object)3, CosmeticBunnyEars.class);
        this.REGISTRY.put((Object)4, CosmeticDragonWings.class);
        this.REGISTRY.put((Object)5, CosmeticHalo.class);
        this.REGISTRY.put((Object)6, CosmeticWitchHat.class);
    }

    public void addPlayer(String UUID2) {
        if (!this.users.containsKey((Object)UUID2)) {
            this.users.put((Object)UUID2, (Object)new User(UUID2));
        } else {
            ((User)this.users.get((Object)UUID2)).update();
        }
    }

    public User getUser(String UUID2) {
        return this.users.containsKey((Object)UUID2) ? (User)this.users.get((Object)UUID2) : null;
    }

    public boolean hasCosmetic(String UUID2, int id) {
        if (this.users.containsKey((Object)UUID2)) {
            User user = (User)this.users.get((Object)UUID2);
            if (this.REGISTRY.containsKey((Object)id)) {
                if (user.activeCosmetics.containsKey(String.valueOf(id))) {
                    return (Boolean)user.activeCosmetics.get(String.valueOf(id)) != false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public ResourceLocation getCosmeticLocation(String UUID2, String cosmeticid) {
        return null;
    }
}

