package com.google.android.material.appbar;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.internal.h;
import e.g.a.f.g;

/* compiled from: ViewUtilsLollipop.java */
/* loaded from: classes2.dex */
class e {
    private static final int[] a = {16843848};

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(View view, float f2) {
        int integer = view.getResources().getInteger(g.a);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j2 = integer;
        stateListAnimator.addState(new int[]{16842766, e.g.a.f.b.f13235j, -e.g.a.f.b.f13236k}, ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(j2));
        stateListAnimator.addState(new int[]{16842766}, ObjectAnimator.ofFloat(view, "elevation", f2).setDuration(j2));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(0L));
        view.setStateListAnimator(stateListAnimator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(View view, AttributeSet attributeSet, int i2, int i3) {
        Context context = view.getContext();
        TypedArray h2 = h.h(context, attributeSet, a, i2, i3, new int[0]);
        try {
            if (h2.hasValue(0)) {
                view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, h2.getResourceId(0, 0)));
            }
        } finally {
            h2.recycle();
        }
    }
}