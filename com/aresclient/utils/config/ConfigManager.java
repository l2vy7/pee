/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.utils.config.Config
 *  com.aresclient.utils.config.ConfigManager
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  org.apache.commons.io.IOUtils
 */
package com.aresclient.utils.config;

import com.aresclient.utils.config.Config;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import org.apache.commons.io.IOUtils;

/*
 * Exception performing whole class analysis ignored.
 */
public class ConfigManager {
    public static File configFile = new File("Ares/Ares.json");
    public static Config settings;
    public static boolean loaded;

    static {
        loaded = false;
    }

    public static void save() throws FileNotFoundException {
        if (settings != null) {
            if (!configFile.exists()) {
                ConfigManager.loadProperties((boolean)true);
            }
            GsonBuilder gsonbuilder = new GsonBuilder();
            Gson gson = gsonbuilder.setPrettyPrinting().create();
            PrintWriter printwriter = new PrintWriter(new FileOutputStream(configFile));
            printwriter.print(gson.toJson((Object)settings));
            printwriter.flush();
            printwriter.close();
        }
    }

    public static void loadProperties(boolean loop) {
        block9: {
            try {
                loaded = true;
                String s = "{}";
                try {
                    if (!configFile.exists()) {
                        configFile.getParentFile().mkdir();
                        configFile.createNewFile();
                        s = new Gson().toJson((Object)new Config());
                    } else {
                        s = IOUtils.toString((InputStream)new FileInputStream(configFile));
                        s = s.replace("\u00a7cl", "\u00a7cf").replace("\u00a7ck", "\u00a7cf").replace("\u00a7cm", "\u00a7cf").replace("\u00a7cn", "\u00a7cf").replace("\u00a7cr", "\u00a7cf").replace("\u00c2", "");
                    }
                }
                catch (IOException ioexception) {
                    ioexception.printStackTrace();
                    if (loop) {
                        ConfigManager.delete();
                    }
                    return;
                }
                if ((Config)new Gson().fromJson(s, Config.class) == null) {
                    s = new Gson().toJson((Object)new Config());
                }
                if ((settings = (Config)new Gson().fromJson(s, Config.class)) == null && loop) {
                    ConfigManager.delete();
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
                if (!loop) break block9;
                ConfigManager.delete();
            }
        }
    }

    private static void delete() {
        System.out.println("Settings could not be loaded.");
        if (configFile.exists()) {
            System.out.println("Delete broken config file..");
            settings = (Config)new Gson().fromJson(new Gson().toJson((Object)new Config()), Config.class);
            try {
                ConfigManager.save();
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Can't delete the config file?! @ " + configFile.getAbsolutePath());
        }
        ConfigManager.loadProperties((boolean)false);
    }
}

