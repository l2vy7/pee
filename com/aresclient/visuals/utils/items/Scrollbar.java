/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.aresclient.utils.UIUtils
 *  com.aresclient.visuals.utils.items.Scrollbar
 *  com.aresclient.visuals.utils.items.Scrollbar$EnumMouseAction
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.WorldRenderer
 *  org.lwjgl.input.Mouse
 */
package com.aresclient.visuals.utils.items;

import com.aresclient.utils.UIUtils;
import com.aresclient.visuals.utils.items.Scrollbar;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import org.lwjgl.input.Mouse;

/*
 * Exception performing whole class analysis ignored.
 */
public class Scrollbar {
    private int listSize;
    private double entryHeight;
    private double scrollY;
    private double barLength;
    private double backLength;
    private int posTop;
    private int posBottom;
    private double left;
    private double top;
    private double right;
    private int speed = 10;
    private double clickY;
    private boolean hold;
    private boolean requestBottom;
    private int spaceBelow = 0;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$com$aresclient$visuals$utils$items$Scrollbar$EnumMouseAction;

    public void reset() {
        this.scrollY = 0.0;
    }

    public void init() {
        this.mouseInput();
    }

    public Scrollbar(int entryHeight) {
        this.entryHeight = entryHeight;
        this.setDefaultPosition();
    }

    public void update(int listSize) {
        if (this.listSize == listSize) {
            return;
        }
        this.listSize = listSize;
        if (this.requestBottom) {
            this.scrollY = -2.147483648E9;
            this.requestBottom = false;
            this.checkOutOfBorders();
        }
    }

    public void setPosition(int left, int top, int right, int bottom) {
        this.left = left;
        this.posTop = top;
        this.right = right;
        this.posBottom = bottom;
        this.calc();
    }

    public void calc() {
        double pixelInView;
        double totalPixels = (double)this.listSize * this.entryHeight + (double)this.spaceBelow;
        double backLength = pixelInView = (double)(this.posBottom - this.posTop);
        if (pixelInView >= totalPixels) {
            return;
        }
        double dPixelInView = pixelInView;
        double dTotalPixels = totalPixels;
        double scale = dPixelInView / dTotalPixels;
        double barLength = scale * backLength;
        double scroll = this.scrollY / scale * scale * scale;
        this.top = -scroll + (double)this.posTop;
        this.barLength = barLength;
        this.backLength = backLength;
    }

    public void setDefaultPosition() {
        this.setPosition(Minecraft.getMinecraft().displayHeight / 2 + 150, 40, Minecraft.getMinecraft().displayWidth / 2 + 156, Minecraft.getMinecraft().displayHeight - 40);
    }

    public boolean isHidden() {
        return this.listSize == 0 || (double)(this.posBottom - this.posTop) >= (double)this.listSize * this.entryHeight + (double)this.spaceBelow;
    }

    public void draw(int mouseX, int mouseY) {
        this.mouseAction(mouseX, mouseY, EnumMouseAction.DRAGGING);
        this.draw();
    }

    public void draw() {
        this.checkOutOfBorders();
        if (this.isHidden()) {
            return;
        }
        this.calc();
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)0, (int)1);
        GlStateManager.disableAlpha();
        GlStateManager.shadeModel((int)7425);
        GlStateManager.disableTexture2D();
        UIUtils.drawRoundedRect((int)((int)this.left - 0), (int)(this.posTop + 1), (int)((int)this.right + 0), (int)(this.posBottom - 1), (float)1.0f, (int)Color.black.getRGB(), (float)0.4f);
        UIUtils.drawRoundedRect((int)((int)this.left - 1), (int)((int)this.top), (int)((int)this.right + 1), (int)((int)this.top + (int)this.barLength), (float)1.0f, (int)-1, (float)0.5f);
        GlStateManager.enableTexture2D();
        GlStateManager.shadeModel((int)7424);
        GlStateManager.enableAlpha();
        GlStateManager.disableBlend();
    }

    public boolean isHoverSlider(int mouseX, int mouseY) {
        return (double)mouseX < this.right + 1.0 && (double)mouseX > this.left - 1.0 && (double)mouseY > this.top && (double)mouseY < this.top + this.barLength;
    }

    public boolean isHoverTotalScrollbar(int mouseX, int mouseY) {
        return (double)mouseX < this.right && (double)mouseX > this.left && mouseY > this.posTop && mouseY < this.posBottom;
    }

    public boolean isScrolledToTop() {
        return this.getScrollY() == 0.0;
    }

    /*
     * Exception decompiling
     */
    public void mouseAction(int mouseX, int mouseY, EnumMouseAction mouseAction) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * java.lang.NullPointerException
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchEnumRewriter.tryRewriteEclipse(SwitchEnumRewriter.java:234)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchEnumRewriter.tryRewrite(SwitchEnumRewriter.java:151)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchEnumRewriter.rewrite(SwitchEnumRewriter.java:85)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:838)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:258)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:192)
         * org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         * org.benf.cfr.reader.entities.Method.analyse(Method.java:521)
         * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1035)
         * org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:922)
         * org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:253)
         * org.benf.cfr.reader.Driver.doJar(Driver.java:135)
         * org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
         * org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException(Decompilation failed);
    }

    public void mouseInput() {
        int wheel = Mouse.getEventDWheel();
        if (wheel > 0) {
            this.scrollY += (double)this.speed;
        } else if (wheel < 0) {
            this.scrollY -= (double)this.speed;
        }
        if (wheel != 0) {
            this.checkOutOfBorders();
        }
    }

    public void checkOutOfBorders() {
        if ((double)this.listSize * this.entryHeight + (double)this.spaceBelow + this.scrollY < (double)(this.posBottom - this.posTop)) {
            this.scrollY += (double)(this.posBottom - this.posTop) - ((double)this.listSize * this.entryHeight + (double)this.spaceBelow + this.scrollY);
        }
        if (this.scrollY > 0.0) {
            this.scrollY = 0.0;
        }
    }

    public void setPosition(double left, double top, double right, double bottom) {
        this.setPosition((int)left, (int)top, (int)right, (int)bottom);
    }

    public void requestBottom() {
        this.requestBottom = true;
    }

    public void scrollTo(int index) {
        this.scrollY += (double)(this.posBottom - this.posTop) - ((double)index * this.entryHeight + (double)this.spaceBelow + this.scrollY) - (this.entryHeight + (double)this.spaceBelow);
        this.checkOutOfBorders();
    }

    public int getListSize() {
        return this.listSize;
    }

    public double getEntryHeight() {
        return this.entryHeight;
    }

    public double getScrollY() {
        return this.scrollY;
    }

    public double getBarLength() {
        return this.barLength;
    }

    public double getBackLength() {
        return this.backLength;
    }

    public int getPosTop() {
        return this.posTop;
    }

    public int getPosBottom() {
        return this.posBottom;
    }

    public double getLeft() {
        return this.left;
    }

    public double getTop() {
        return this.top;
    }

    public double getRight() {
        return this.right;
    }

    public int getSpeed() {
        return this.speed;
    }

    public double getClickY() {
        return this.clickY;
    }

    public boolean isHold() {
        return this.hold;
    }

    public boolean isRequestBottom() {
        return this.requestBottom;
    }

    public int getSpaceBelow() {
        return this.spaceBelow;
    }

    public void setListSize(int listSize) {
        this.listSize = listSize;
    }

    public void setEntryHeight(double entryHeight) {
        this.entryHeight = entryHeight;
    }

    public void setScrollY(double scrollY) {
        this.scrollY = scrollY;
    }

    public void setBarLength(double barLength) {
        this.barLength = barLength;
    }

    public void setBackLength(double backLength) {
        this.backLength = backLength;
    }

    public void setPosTop(int posTop) {
        this.posTop = posTop;
    }

    public void setPosBottom(int posBottom) {
        this.posBottom = posBottom;
    }

    public void setLeft(double left) {
        this.left = left;
    }

    public void setTop(double top) {
        this.top = top;
    }

    public void setRight(double right) {
        this.right = right;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setClickY(double clickY) {
        this.clickY = clickY;
    }

    public void setHold(boolean hold) {
        this.hold = hold;
    }

    public void setRequestBottom(boolean requestBottom) {
        this.requestBottom = requestBottom;
    }

    public void setSpaceBelow(int spaceBelow) {
        this.spaceBelow = spaceBelow;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$aresclient$visuals$utils$items$Scrollbar$EnumMouseAction() {
        if ($SWITCH_TABLE$com$aresclient$visuals$utils$items$Scrollbar$EnumMouseAction != null) {
            return $SWITCH_TABLE$com$aresclient$visuals$utils$items$Scrollbar$EnumMouseAction;
        }
        int[] arrn = new int[EnumMouseAction.values().length];
        try {
            arrn[EnumMouseAction.CLICKED.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            arrn[EnumMouseAction.DRAGGING.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            arrn[EnumMouseAction.RELEASED.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        $SWITCH_TABLE$com$aresclient$visuals$utils$items$Scrollbar$EnumMouseAction = arrn;
        return arrn;
    }
}

