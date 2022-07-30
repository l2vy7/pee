/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.utils.ClientMovementInput
 *  com.aresclient.utils.config.ConfigManager
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.settings.GameSettings
 *  net.minecraft.potion.Potion
 *  net.minecraft.util.MovementInput
 */
package com.aresclient.utils;

import com.aresclient.utils.config.ConfigManager;
import java.text.DecimalFormat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.potion.Potion;
import net.minecraft.util.MovementInput;

public class ClientMovementInput
extends MovementInput {
    public static boolean sprint = false;
    private GameSettings gameSettings;
    private int sneakWasPressed = 0;
    private int sprintWasPressed = 0;
    private EntityPlayerSP player;
    private float originalFlySpeed = -1.0f;
    private float boostedFlySpeed;
    private Minecraft mc;
    public boolean flyBoost;
    public float flyBoostFactor;
    public int keyHoldTicks;
    public boolean shiftToggled;
    private static final DecimalFormat df = new DecimalFormat("#.0");

    public ClientMovementInput(GameSettings gameSettings) {
        this.boostedFlySpeed = ConfigManager.settings.boostedFlySpeed;
        this.flyBoost = false;
        this.flyBoostFactor = 1.0f;
        this.keyHoldTicks = 7;
        this.shiftToggled = false;
        this.gameSettings = gameSettings;
        this.mc = Minecraft.getMinecraft();
    }

    public void updatePlayerMoveState() {
        this.player = this.mc.thePlayer;
        this.moveStrafe = 0.0f;
        this.moveForward = 0.0f;
        if (this.gameSettings.keyBindForward.isKeyDown()) {
            this.moveForward += 1.0f;
        }
        if (this.gameSettings.keyBindBack.isKeyDown()) {
            this.moveForward -= 1.0f;
        }
        if (this.gameSettings.keyBindLeft.isKeyDown()) {
            this.moveStrafe += 1.0f;
        }
        if (this.gameSettings.keyBindRight.isKeyDown()) {
            this.moveStrafe -= 1.0f;
        }
        this.jump = this.gameSettings.keyBindJump.isKeyDown();
        this.sneak = this.gameSettings.keyBindSneak.isKeyDown();
        if (this.sneak) {
            this.moveStrafe *= 0.3f;
            this.moveForward *= 0.3f;
        }
        if (ConfigManager.settings.Togglesprint == 2) {
            if (this.gameSettings.keyBindSprint.isKeyDown()) {
                if (this.sprintWasPressed == 0) {
                    this.sprintWasPressed = sprint ? -1 : (this.player.capabilities.isFlying ? -1 : 1);
                    sprint = !sprint;
                } else if (this.sprintWasPressed > 0) {
                    ++this.sprintWasPressed;
                }
            } else {
                if (this.keyHoldTicks > 0 && this.sprintWasPressed > this.keyHoldTicks) {
                    sprint = false;
                }
                this.sprintWasPressed = 0;
            }
            if (sprint && this.moveForward == 1.0f && !this.player.isUsingItem() && !this.player.isPotionActive(Potion.blindness)) {
                this.player.setSprinting(true);
            }
            if (this.flyBoost && this.player.capabilities.isCreativeMode && this.player.capabilities.isFlying && this.mc.getRenderViewEntity() == this.player && sprint) {
                if (this.originalFlySpeed < 0.0f || this.player.capabilities.getFlySpeed() != this.boostedFlySpeed) {
                    this.originalFlySpeed = this.player.capabilities.getFlySpeed();
                }
                this.boostedFlySpeed = this.originalFlySpeed * this.flyBoostFactor;
                this.player.capabilities.setFlySpeed(this.boostedFlySpeed);
                if (this.sneak) {
                    this.player.motionY -= 0.15 * (double)(this.flyBoostFactor - 1.0f);
                }
                if (this.jump) {
                    this.player.motionY += 0.15 * (double)(this.flyBoostFactor - 1.0f);
                }
            } else {
                if (this.player.capabilities.getFlySpeed() == this.boostedFlySpeed) {
                    this.player.capabilities.setFlySpeed(this.originalFlySpeed);
                }
                this.originalFlySpeed = -1.0f;
            }
        } else {
            this.moveStrafe = 0.0f;
            this.moveForward = 0.0f;
            if (this.gameSettings.keyBindForward.isKeyDown()) {
                this.moveForward += 1.0f;
            }
            if (this.gameSettings.keyBindBack.isKeyDown()) {
                this.moveForward -= 1.0f;
            }
            if (this.gameSettings.keyBindLeft.isKeyDown()) {
                this.moveStrafe += 1.0f;
            }
            if (this.gameSettings.keyBindRight.isKeyDown()) {
                this.moveStrafe -= 1.0f;
            }
            this.jump = this.gameSettings.keyBindJump.isKeyDown();
            this.sneak = this.gameSettings.keyBindSneak.isKeyDown();
            if (this.sneak) {
                this.moveStrafe = (float)((double)this.moveStrafe * 0.3);
                this.moveForward = (float)((double)this.moveForward * 0.3);
            }
        }
    }

    public String getDisplayText() {
        String displayText = "";
        boolean isFlying = this.mc.thePlayer.capabilities.isFlying;
        boolean isRiding = this.mc.thePlayer.isRiding();
        boolean isHoldingSneak = this.gameSettings.keyBindSneak.isKeyDown();
        boolean isHoldingSprint = this.gameSettings.keyBindSprint.isKeyDown();
        if (isFlying) {
            displayText = this.originalFlySpeed > 0.0f ? String.valueOf(displayText) + "\u00a7f[" + ConfigManager.settings.ModColor + "Flying (" + df.format(this.boostedFlySpeed / this.originalFlySpeed) + "x Boost)" + "\u00a7f]" : String.valueOf(displayText) + "\u00a7f[" + ConfigManager.settings.ModColor + "Flying" + "\u00a7f]";
        }
        if (isRiding) {
            displayText = String.valueOf(displayText) + "\u00a7f[" + ConfigManager.settings.ModColor + "Riding" + "\u00a7f]";
        } else if (sprint && !isRiding) {
            displayText = isHoldingSprint ? String.valueOf(displayText) + "\u00a7f[" + ConfigManager.settings.ModColor + "Sprinting Held" + "\u00a7f]" : String.valueOf(displayText) + "\u00a7f[" + ConfigManager.settings.ModColor + "Sprinting Toggled" + "\u00a7f]";
        }
        return displayText.trim();
    }
}

