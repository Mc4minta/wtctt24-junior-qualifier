package com.google.android.material.internal;

import android.widget.ImageButton;

/* compiled from: VisibilityAwareImageButton.java */
/* loaded from: classes2.dex */
public class j extends ImageButton {
    private int a;

    public final void b(int i2, boolean z) {
        super.setVisibility(i2);
        if (z) {
            this.a = i2;
        }
    }

    public final int getUserSetVisibility() {
        return this.a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i2) {
        b(i2, true);
    }
}