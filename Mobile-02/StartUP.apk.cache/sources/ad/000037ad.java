package com.google.android.material.internal;

import android.graphics.PorterDuff;
import android.view.View;
import c.h.k.v;

/* compiled from: ViewUtils.java */
/* loaded from: classes2.dex */
public class i {
    public static boolean a(View view) {
        return v.y(view) == 1;
    }

    public static PorterDuff.Mode b(int i2, PorterDuff.Mode mode) {
        if (i2 != 3) {
            if (i2 != 5) {
                if (i2 != 9) {
                    switch (i2) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }
}