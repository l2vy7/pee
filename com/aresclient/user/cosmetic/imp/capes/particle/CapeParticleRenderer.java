/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.user.cosmetic.imp.capes.particle.CapeParticleRenderer
 *  com.aresclient.user.cosmetic.imp.capes.particle.ParticleStar
 *  io.netty.util.internal.ThreadLocalRandom
 *  net.minecraft.entity.EntityLivingBase
 *  org.lwjgl.opengl.GL11
 */
package com.aresclient.user.cosmetic.imp.capes.particle;

import com.aresclient.user.cosmetic.imp.capes.particle.ParticleStar;
import io.netty.util.internal.ThreadLocalRandom;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.opengl.GL11;

public class CapeParticleRenderer {
    private Random random = new Random();
    private List<ParticleStar> starList = new LinkedList();
    private long lastStarSpawned = -1L;

    public void render(EntityLivingBase entitylivingbaseIn, float partialTicks) {
        if (this.lastStarSpawned < System.currentTimeMillis()) {
            this.lastStarSpawned = System.currentTimeMillis() + (long)ThreadLocalRandom.current().nextInt(300, 801);
            double x = (0.5 - this.random.nextDouble()) * 0.6;
            double y = this.random.nextDouble() - 0.025;
            ParticleStar particleStar = new ParticleStar(x, y, System.currentTimeMillis());
            this.starList.add(particleStar);
        }
        GL11.glPushMatrix();
        GL11.glTranslatef((float)0.0f, (float)0.0f, (float)-0.0629f);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        Iterator iterator = this.starList.iterator();
        while (iterator.hasNext()) {
            ParticleStar next = (ParticleStar)iterator.next();
            next.render();
            if (!next.isFadedOut()) continue;
            iterator.remove();
        }
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glPopMatrix();
    }
}

