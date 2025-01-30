package com.facebook.react.uimanager;

import android.view.View;
import android.view.ViewParent;

/* compiled from: RootViewUtil.java */
/* loaded from: classes2.dex */
public class e0 {
    public static d0 a(View view) {
        while (!(view instanceof d0)) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                return null;
            }
            e.f.k.a.a.a(parent instanceof View);
            view = (View) parent;
        }
        return (d0) view;
    }
}