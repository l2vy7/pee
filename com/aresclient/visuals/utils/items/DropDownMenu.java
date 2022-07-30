/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.visuals.utils.items.DropDownMenu
 *  com.aresclient.visuals.utils.items.DropDownMenu$List
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.WorldRenderer
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package com.aresclient.visuals.utils.items;

import com.aresclient.visuals.utils.items.DropDownMenu;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/*
 * Exception performing whole class analysis ignored.
 */
public class DropDownMenu
extends GuiButton {
    public List dropDownMenu$List;
    public boolean active = false;
    public String selected = null;

    public DropDownMenu(int buttonId, int x, int y, List dropDownMenu_List) {
        super(buttonId, x, y, dropDownMenu_List.getHeader());
        this.dropDownMenu$List = dropDownMenu_List;
    }

    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
        if (this.enabled && this.visible) {
            ResourceLocation dropDownImage = new ResourceLocation("Ares/Icons/dropdown/dropdown.png");
            int dropdownImageSize = 12;
            int amount = this.dropDownMenu$List.getItems().size();
            int scaled = mc.fontRendererObj.getStringWidth(this.dropDownMenu$List.getHeader()) + 2;
            if (this.active) {
                DropDownMenu.drawRect((int)(this.xPosition + 1), (int)(this.yPosition - 1), (int)(this.xPosition + scaled - 1 + dropdownImageSize), (int)(this.yPosition + dropdownImageSize + amount * 18), (int)Color.gray.getRGB());
            }
            DropDownMenu.drawRect((int)(this.xPosition - 1), (int)(this.yPosition - 1), (int)(this.xPosition + scaled + 1 + dropdownImageSize), (int)(this.yPosition + scaled / 2 + 1), (int)-6250336);
            DropDownMenu.drawRect((int)this.xPosition, (int)this.yPosition, (int)(this.xPosition + scaled + dropdownImageSize), (int)(this.yPosition + scaled / 2), (int)-16777216);
            this.drawString(mc.fontRendererObj, this.dropDownMenu$List.getHeader(), this.xPosition + 1, this.yPosition + 3, Color.white.getRGB());
            DropDownMenu.drawTexture((ResourceLocation)dropDownImage, (float)(this.xPosition + scaled), (float)(this.yPosition + 4), (float)10.0f, (float)6.0f);
            if (this.active) {
                for (int i = 0; i < this.dropDownMenu$List.getItems().size(); ++i) {
                    String selected = (String)this.dropDownMenu$List.getItems().get(i);
                    this.drawString(mc.fontRendererObj, selected, this.xPosition + 1, this.yPosition + 20 + i * 18, Color.white.getRGB());
                }
            }
        }
    }

    public void mouseReleased(int mouseX, int mouseY) {
        int scaled = Minecraft.getMinecraft().fontRendererObj.getStringWidth(this.dropDownMenu$List.getHeader()) + 2;
        if (mouseX > this.xPosition && mouseX < this.xPosition + scaled + 10 && mouseY < this.yPosition + scaled / 2 + 1) {
            this.active = !this.active;
        }
    }

    private void drawRoundedRect(int x, int y, int width, int height, int cornerRadius, Color color) {
        Gui.drawRect((int)x, (int)(y + cornerRadius), (int)(x + cornerRadius), (int)(y + height - cornerRadius), (int)color.getRGB());
        Gui.drawRect((int)(x + cornerRadius), (int)y, (int)(x + width - cornerRadius), (int)(y + height), (int)color.getRGB());
        Gui.drawRect((int)(x + width - cornerRadius), (int)(y + cornerRadius), (int)(x + width), (int)(y + height - cornerRadius), (int)color.getRGB());
        this.drawArc(x + cornerRadius, y + cornerRadius, cornerRadius, 0, 90, color);
        this.drawArc(x + width - cornerRadius, y + cornerRadius, cornerRadius, 270, 360, color);
        this.drawArc(x + width - cornerRadius, y + height - cornerRadius, cornerRadius, 180, 270, color);
        this.drawArc(x + cornerRadius, y + height - cornerRadius, cornerRadius, 90, 180, color);
    }

    private void drawArc(int x, int y, int radius, int startAngle, int endAngle, Color color) {
        GL11.glPushMatrix();
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glColor4f((float)((float)color.getRed() / 255.0f), (float)((float)color.getGreen() / 255.0f), (float)((float)color.getBlue() / 255.0f), (float)((float)color.getAlpha() / 255.0f));
        WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
        worldRenderer.begin(6, DefaultVertexFormats.POSITION);
        worldRenderer.pos((double)x, (double)y, 0.0).endVertex();
        for (int i = (int)((double)startAngle / 360.0 * 100.0); i <= (int)((double)endAngle / 360.0 * 100.0); ++i) {
            double angle = Math.PI * 2 * (double)i / 100.0 + Math.toRadians(180.0);
            worldRenderer.pos((double)x + Math.sin(angle) * (double)radius, (double)y + Math.cos(angle) * (double)radius, 0.0).endVertex();
        }
        Tessellator.getInstance().draw();
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glPopMatrix();
    }

    public static void drawTexture(ResourceLocation resourceLocation, float x, float y, float width, float height) {
        GL11.glPushMatrix();
        float size = width / 2.0f;
        GL11.glEnable((int)3042);
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2848);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        Minecraft.getMinecraft().getTextureManager().bindTexture(resourceLocation);
        GL11.glBegin((int)7);
        GL11.glTexCoord2d((double)(0.0f / size), (double)(0.0f / size));
        GL11.glVertex2d((double)x, (double)y);
        GL11.glTexCoord2d((double)(0.0f / size), (double)((0.0f + size) / size));
        GL11.glVertex2d((double)x, (double)(y + height));
        GL11.glTexCoord2d((double)((0.0f + size) / size), (double)((0.0f + size) / size));
        GL11.glVertex2d((double)(x + width), (double)(y + height));
        GL11.glTexCoord2d((double)((0.0f + size) / size), (double)(0.0f / size));
        GL11.glVertex2d((double)(x + width), (double)y);
        GL11.glEnd();
        GL11.glEnable((int)3553);
        GL11.glDisable((int)2848);
        GL11.glDisable((int)3042);
        GL11.glPopMatrix();
    }
}

