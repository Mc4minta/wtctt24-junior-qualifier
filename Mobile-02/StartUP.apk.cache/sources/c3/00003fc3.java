package com.swmansion.gesturehandler.react;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.uimanager.v;
import e.i.a.l;
import e.i.a.p;

/* compiled from: RNViewConfigurationHelper.java */
/* loaded from: classes2.dex */
public class j implements p {

    /* compiled from: RNViewConfigurationHelper.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.facebook.react.uimanager.p.values().length];
            a = iArr;
            try {
                iArr[com.facebook.react.uimanager.p.BOX_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.facebook.react.uimanager.p.BOX_NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.facebook.react.uimanager.p.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // e.i.a.p
    public l a(View view) {
        com.facebook.react.uimanager.p pointerEvents = view instanceof v ? ((v) view).getPointerEvents() : com.facebook.react.uimanager.p.AUTO;
        if (!view.isEnabled()) {
            if (pointerEvents == com.facebook.react.uimanager.p.AUTO) {
                return l.BOX_NONE;
            }
            if (pointerEvents == com.facebook.react.uimanager.p.BOX_ONLY) {
                return l.NONE;
            }
        }
        int i2 = a.a[pointerEvents.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return l.AUTO;
                }
                return l.NONE;
            }
            return l.BOX_NONE;
        }
        return l.BOX_ONLY;
    }

    @Override // e.i.a.p
    public boolean b(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT < 18 || viewGroup.getClipChildren()) {
            return true;
        }
        if (viewGroup instanceof com.facebook.react.views.view.f) {
            return "hidden".equals(((com.facebook.react.views.view.f) viewGroup).getOverflow());
        }
        return false;
    }

    @Override // e.i.a.p
    public View c(ViewGroup viewGroup, int i2) {
        if (viewGroup instanceof com.facebook.react.views.view.f) {
            return viewGroup.getChildAt(((com.facebook.react.views.view.f) viewGroup).a(i2));
        }
        return viewGroup.getChildAt(i2);
    }
}