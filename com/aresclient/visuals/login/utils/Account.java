/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.visuals.login.utils.Account
 */
package com.aresclient.visuals.login.utils;

public class Account {
    private String type;
    private String accessToken;
    private String username;

    public Account(String username, String accessToken, String type) {
        this.username = username;
        this.accessToken = accessToken;
        this.type = type;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getType() {
        return this.type;
    }

    public String getUsername() {
        return this.username;
    }
}

