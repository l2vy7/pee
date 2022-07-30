/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.utils.config.Config
 */
package com.aresclient.utils.config;

public class Config {
    public int wallpaper = 1;
    public boolean useOldAnimations = true;
    public boolean useToggleSprint = true;
    public boolean useToggleSneak = false;
    public boolean Timechanger = false;
    public int Itemphisics = 1;
    public int LeftHand = 1;
    public int Togglesprint = 2;
    public int Togglesneak = 1;
    public int SkinChanger = 1;
    public int ZoomAnimation = 1;
    public int HitDelayFix = 2;
    public int ArrowTrail = 1;
    public int TntTimer = 1;
    public int CustomCrosshair = 1;
    public int Particle = 1;
    public int enablecosmetics = 1;
    public int Timer = 1;
    public int Bossbar = 2;
    public int OriginalScoreboard = 1;
    public int BlockOverlay = 1;
    public static float red;
    public static float green;
    public static float blue;
    public static float alpha;
    public static float thickness;
    public int RGBHits;
    public boolean AnimatedCape;
    public int MaxFrames;
    public float boostedFlySpeed;
    public int Time;
    public int Wings;
    public int WingsTexture;
    public int Bandana;
    public int BandanaTexture;
    public int Halo;
    public int HaloTexture;
    public int WitchHat;
    public int WitchHatTexture;
    public int BunnyEars;
    public int BunnyEarsTexture;
    public int Blaze;
    public int BlazeTexture;
    public String skinpath;
    public String capepath;
    public String capemode = "ares";
    public String ModColor;
    public int SkinType;
    public int Shoulder;
    public int BlazePet;
    public int SlimePet;
    public int GhastPet;
    public int BatPet;
    public int SquidPet;
    public int WitherPet;
    public int NoPet;
    public boolean showTutorial = true;
    public int armormode = 1;

    public Config() {
        red = 0.0f;
        green = 0.0f;
        blue = 0.0f;
        alpha = 0.4f;
        thickness = 2.0f;
        this.RGBHits = 1;
        this.AnimatedCape = false;
        this.MaxFrames = 17;
        this.boostedFlySpeed = 1.0f;
        this.Time = 18000;
        this.Wings = 1;
        this.WingsTexture = 1;
        this.Bandana = 1;
        this.BandanaTexture = 1;
        this.Halo = 1;
        this.HaloTexture = 1;
        this.WitchHat = 1;
        this.WitchHatTexture = 1;
        this.BunnyEars = 1;
        this.BunnyEarsTexture = 2;
        this.Blaze = 1;
        this.BlazeTexture = 1;
        this.skinpath = "Ares/Skins/Default.png";
        this.capepath = "Ares/Capes/v3/cape1.png";
        this.ModColor = "\u00a7c";
        this.SkinType = 1;
        this.Shoulder = 1;
        this.BatPet = 1;
        this.SquidPet = 1;
        this.GhastPet = 1;
        this.SlimePet = 1;
        this.WitherPet = 1;
        this.BlazePet = 1;
        this.NoPet = 2;
    }
}

