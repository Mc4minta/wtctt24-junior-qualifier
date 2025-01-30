package com.facebook.react.views.scroll;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.o0;

/* compiled from: ReactScrollViewHelper.java */
/* loaded from: classes2.dex */
public class g {
    public static void a(ViewGroup viewGroup) {
        d(viewGroup, i.BEGIN_DRAG);
    }

    public static void b(ViewGroup viewGroup, float f2, float f3) {
        e(viewGroup, i.END_DRAG, f2, f3);
    }

    public static void c(ViewGroup viewGroup, float f2, float f3) {
        e(viewGroup, i.SCROLL, f2, f3);
    }

    private static void d(ViewGroup viewGroup, i iVar) {
        e(viewGroup, iVar, 0.0f, 0.0f);
    }

    private static void e(ViewGroup viewGroup, i iVar, float f2, float f3) {
        View childAt = viewGroup.getChildAt(0);
        if (childAt == null) {
            return;
        }
        o0.b((ReactContext) viewGroup.getContext(), viewGroup.getId()).v(h.n(viewGroup.getId(), iVar, viewGroup.getScrollX(), viewGroup.getScrollY(), f2, f3, childAt.getWidth(), childAt.getHeight(), viewGroup.getWidth(), viewGroup.getHeight()));
    }

    public static void f(ViewGroup viewGroup, int i2, int i3) {
        e(viewGroup, i.MOMENTUM_BEGIN, i2, i3);
    }

    public static void g(ViewGroup viewGroup) {
        d(viewGroup, i.MOMENTUM_END);
    }

    public static int h(String str) {
        if (str == null || str.equals("auto")) {
            return 1;
        }
        if (str.equals("always")) {
            return 0;
        }
        if (str.equals("never")) {
            return 2;
        }
        throw new JSApplicationIllegalArgumentException("wrong overScrollMode: " + str);
    }
}