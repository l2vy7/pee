/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.utils.EnumDisconnection
 */
package com.aresclient.utils;

/*
 * Exception performing whole class analysis ignored.
 */
public enum EnumDisconnection {
    CRACKED(1),
    WRONG_VERSION(2),
    FAILED_AUTHENTICATION(3),
    BANNED(4);

    public int id;

    private EnumDisconnection(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static EnumDisconnection findEnum(int id) {
        for (EnumDisconnection enums : EnumDisconnection.values()) {
            if (enums.getId() != id) continue;
            return enums;
        }
        return null;
    }
}

