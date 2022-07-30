/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.visuals.utils.items.DropDownMenu$List
 */
package com.aresclient.visuals.utils.items;

import java.util.List;

public class DropDownMenu$List {
    private List<String> items;
    private String Header;

    public DropDownMenu$List(List<String> items, String Header) {
        this.Header = Header;
        this.items = items;
    }

    public void setHeader(String header) {
        this.Header = header;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public List<String> getItems() {
        return this.items;
    }

    public String getHeader() {
        return this.Header;
    }
}

