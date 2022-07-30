/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.user.cosmetic.imp.capes.AresCapeImageBuffer
 *  com.aresclient.user.cosmetic.imp.capes.AresCapeUtils
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.renderer.IImageBuffer
 *  net.minecraft.client.renderer.ThreadDownloadImageData
 *  net.minecraft.client.renderer.texture.ITextureObject
 *  net.minecraft.client.renderer.texture.SimpleTexture
 *  net.minecraft.client.renderer.texture.TextureManager
 *  net.minecraft.src.Config
 *  net.minecraft.util.ResourceLocation
 */
package com.aresclient.user.cosmetic.imp.capes;

import com.aresclient.user.cosmetic.imp.capes.AresCapeImageBuffer;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.regex.Pattern;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.IImageBuffer;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;

/*
 * Exception performing whole class analysis ignored.
 */
public class AresCapeUtils {
    private static final Pattern PATTERN_USERNAME = Pattern.compile("[a-zA-Z0-9_]+");

    public static void downloadCape(AbstractClientPlayer player) {
        String s = player.getNameClear();
        String s2 = player.getUniqueID().toString();
        if (s != null && !s.isEmpty() && !s.contains("\u0000") && PATTERN_USERNAME.matcher(s).matches()) {
            String s1 = "http://5.9.155.217/capeserver/" + s2;
            ResourceLocation resourcelocation = new ResourceLocation("cape/" + s2);
            TextureManager texturemanager = Minecraft.getMinecraft().getTextureManager();
            ITextureObject itextureobject = texturemanager.getTexture(resourcelocation);
            if (itextureobject != null && itextureobject instanceof ThreadDownloadImageData) {
                ThreadDownloadImageData threaddownloadimagedata = (ThreadDownloadImageData)itextureobject;
                if (threaddownloadimagedata.imageFound != null) {
                    if (threaddownloadimagedata.imageFound.booleanValue()) {
                        player.setLocationOfAresCape(resourcelocation);
                        if (threaddownloadimagedata.getImageBuffer() instanceof AresCapeImageBuffer) {
                            AresCapeImageBuffer capeimagebuffer1 = (AresCapeImageBuffer)threaddownloadimagedata.getImageBuffer();
                            player.setElytraOfCape(capeimagebuffer1.isElytraOfCape());
                        }
                    }
                    return;
                }
            }
            AresCapeImageBuffer capeimagebuffer = new AresCapeImageBuffer(player, resourcelocation);
            ThreadDownloadImageData threaddownloadimagedata1 = new ThreadDownloadImageData(null, s1, null, (IImageBuffer)capeimagebuffer);
            threaddownloadimagedata1.pipeline = true;
            texturemanager.loadTexture(resourcelocation, (ITextureObject)threaddownloadimagedata1);
        }
    }

    public static BufferedImage parseCape(BufferedImage img) {
        int j;
        int i = 64;
        int k = img.getWidth();
        int l = img.getHeight();
        for (j = 32; i < k || j < l; i *= 2, j *= 2) {
        }
        BufferedImage bufferedimage = new BufferedImage(i, j, 2);
        Graphics graphics = bufferedimage.getGraphics();
        graphics.drawImage(img, 0, 0, null);
        graphics.dispose();
        return bufferedimage;
    }

    public static boolean isElytraCape(BufferedImage imageRaw, BufferedImage imageFixed) {
        return imageRaw.getWidth() > imageFixed.getHeight();
    }

    public static void reloadCape(AbstractClientPlayer player) {
        String s = player.getUniqueID().toString();
        ResourceLocation resourcelocation = new ResourceLocation("cape/" + s);
        TextureManager texturemanager = Config.getTextureManager();
        ITextureObject itextureobject = texturemanager.getTexture(resourcelocation);
        if (itextureobject instanceof SimpleTexture) {
            SimpleTexture simpletexture = (SimpleTexture)itextureobject;
            simpletexture.deleteGlTexture();
            texturemanager.deleteTexture(resourcelocation);
        }
        player.setLocationOfAresCape(null);
        player.setElytraOfCape(false);
        AresCapeUtils.downloadCape((AbstractClientPlayer)player);
    }
}

