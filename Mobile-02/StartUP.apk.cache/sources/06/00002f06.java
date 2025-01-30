package com.facebook.react.uimanager.f1;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.facebook.react.uimanager.IllegalViewOperationException;

/* compiled from: BaseLayoutAnimation.java */
/* loaded from: classes2.dex */
abstract class c extends com.facebook.react.uimanager.f1.a {

    /* compiled from: BaseLayoutAnimation.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.OPACITY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.SCALE_XY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.SCALE_X.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.SCALE_Y.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.facebook.react.uimanager.f1.a
    Animation b(View view, int i2, int i3, int i4, int i5) {
        b bVar = this.f5083d;
        if (bVar != null) {
            int i6 = a.a[bVar.ordinal()];
            if (i6 == 1) {
                return new l(view, g() ? view.getAlpha() : 0.0f, g() ? 0.0f : view.getAlpha());
            } else if (i6 == 2) {
                float f2 = g() ? 1.0f : 0.0f;
                float f3 = g() ? 0.0f : 1.0f;
                return new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
            } else if (i6 == 3) {
                return new ScaleAnimation(g() ? 1.0f : 0.0f, g() ? 0.0f : 1.0f, 1.0f, 1.0f, 1, 0.5f, 1, 0.0f);
            } else if (i6 == 4) {
                return new ScaleAnimation(1.0f, 1.0f, g() ? 1.0f : 0.0f, g() ? 0.0f : 1.0f, 1, 0.0f, 1, 0.5f);
            } else {
                throw new IllegalViewOperationException("Missing animation for property : " + this.f5083d);
            }
        }
        throw new IllegalViewOperationException("Missing animated property from animation config");
    }

    @Override // com.facebook.react.uimanager.f1.a
    boolean e() {
        return this.f5084e > 0 && this.f5083d != null;
    }

    abstract boolean g();
}