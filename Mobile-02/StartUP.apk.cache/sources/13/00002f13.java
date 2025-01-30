package com.facebook.react.uimanager.f1;

import android.view.View;
import android.view.animation.Animation;

/* compiled from: LayoutUpdateAnimation.java */
/* loaded from: classes2.dex */
class k extends a {
    @Override // com.facebook.react.uimanager.f1.a
    Animation b(View view, int i2, int i3, int i4, int i5) {
        boolean z = false;
        boolean z2 = (view.getX() == ((float) i2) && view.getY() == ((float) i3)) ? false : true;
        if (view.getWidth() != i4 || view.getHeight() != i5) {
            z = true;
        }
        if (z2 || z) {
            return new m(view, i2, i3, i4, i5);
        }
        return null;
    }

    @Override // com.facebook.react.uimanager.f1.a
    boolean e() {
        return this.f5084e > 0;
    }
}