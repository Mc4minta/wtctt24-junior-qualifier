package com.facebook.react.views.view;

import android.view.View;
import com.facebook.yoga.n;

/* compiled from: MeasureUtil.java */
/* loaded from: classes2.dex */
public class b {
    public static int a(float f2, n nVar) {
        if (nVar == n.EXACTLY) {
            return View.MeasureSpec.makeMeasureSpec((int) f2, 1073741824);
        }
        if (nVar == n.AT_MOST) {
            return View.MeasureSpec.makeMeasureSpec((int) f2, Integer.MIN_VALUE);
        }
        return View.MeasureSpec.makeMeasureSpec(0, 0);
    }
}