package com.facebook.react.views.text;

import org.spongycastle.i18n.TextBundle;

/* compiled from: ReactRawTextShadowNode.java */
/* loaded from: classes2.dex */
public class k extends com.facebook.react.uimanager.z {
    private String C = null;

    public String n1() {
        return this.C;
    }

    @com.facebook.react.uimanager.c1.a(name = TextBundle.TEXT_ENTRY)
    public void setText(String str) {
        this.C = str;
        w0();
    }

    @Override // com.facebook.react.uimanager.z, com.facebook.react.uimanager.y
    public boolean t() {
        return true;
    }

    @Override // com.facebook.react.uimanager.z
    public String toString() {
        return L() + " [text: " + this.C + "]";
    }
}