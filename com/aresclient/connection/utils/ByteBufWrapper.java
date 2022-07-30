/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.connection.utils.ByteBufWrapper
 *  com.google.common.base.Charsets
 *  com.google.common.base.Supplier
 *  io.netty.buffer.ByteBuf
 */
package com.aresclient.connection.utils;

import com.google.common.base.Charsets;
import com.google.common.base.Supplier;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.util.UUID;
import java.util.function.Consumer;

public class ByteBufWrapper {
    private final ByteBuf buf;

    public ByteBufWrapper(ByteBuf buf) {
        this.buf = buf;
    }

    public void writeVarInt(int b) {
        while ((b & 0xFFFFFF80) != 0) {
            this.buf.writeByte(b & 0x7F | 0x80);
            b >>>= 7;
        }
        this.buf.writeByte(b);
    }

    public int readVarInt() {
        byte b;
        int i = 0;
        int chunk = 0;
        do {
            b = this.buf.readByte();
            i |= (b & 0x7F) << chunk++ * 7;
            if (chunk <= 5) continue;
            throw new RuntimeException("VarInt too big");
        } while ((b & 0x80) == 128);
        return i;
    }

    public String readStringFromBuffer(int p_150789_1_) throws IOException {
        int var2 = this.readVarInt();
        if (var2 > p_150789_1_ * 4) {
            throw new IOException("The received encoded string buffer length is longer than maximum allowed (" + var2 + " > " + p_150789_1_ * 4 + ")");
        }
        if (var2 < 0) {
            throw new IOException("The received encoded string buffer length is less than zero! Weird string!");
        }
        String var3 = new String(this.buf.readBytes(var2).array(), Charsets.UTF_8);
        if (var3.length() > p_150789_1_) {
            throw new IOException("The received string length is longer than maximum allowed (" + var2 + " > " + p_150789_1_ + ")");
        }
        return var3;
    }

    public <T> void writeOptional(T obj, Consumer<T> consumer) {
        this.buf.writeBoolean(obj != null);
        if (obj != null) {
            consumer.accept(obj);
        }
    }

    public <T> T readOptional(Supplier<T> supplier) {
        boolean isPresent = this.buf.readBoolean();
        return (T)(isPresent ? supplier.get() : null);
    }

    public void writeString(String s) {
        byte[] arr = s.getBytes(Charsets.UTF_8);
        this.writeVarInt(arr.length);
        this.buf.writeBytes(arr);
    }

    public String readString() {
        int len = this.readVarInt();
        byte[] buffer = new byte[len];
        this.buf.readBytes(buffer);
        return new String(buffer, Charsets.UTF_8);
    }

    public void writeByteArray(byte[] arr) {
        this.writeVarInt(arr.length);
        this.buf.writeBytes(arr);
    }

    public byte[] readByteArray() {
        int len = this.readVarInt();
        byte[] buffer = new byte[len];
        this.buf.readBytes(buffer);
        return buffer;
    }

    public void writeUUID(UUID uuid) {
        this.buf.writeLong(uuid.getMostSignificantBits());
        this.buf.writeLong(uuid.getLeastSignificantBits());
    }

    public UUID readUUID() {
        long mostSigBits = this.buf.readLong();
        long leastSigBits = this.buf.readLong();
        return new UUID(mostSigBits, leastSigBits);
    }

    public ByteBuf buf() {
        return this.buf;
    }
}

