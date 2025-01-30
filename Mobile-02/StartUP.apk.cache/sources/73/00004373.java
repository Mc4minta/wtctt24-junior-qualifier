package com.toshi.view.fragment.s0;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import kotlin.jvm.internal.m;

/* compiled from: FadePageTransformer.kt */
/* loaded from: classes2.dex */
public final class a implements ViewPager.k {
    @Override // androidx.viewpager.widget.ViewPager.k
    public void a(View view, float f2) {
        m.g(view, "view");
        if (f2 < -1.0f || f2 > 1.0f) {
            view.setAlpha(0.0f);
            return;
        }
        int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (i2 <= 0 || f2 <= 1.0f) {
            float f3 = 1;
            view.setAlpha(i2 <= 0 ? f2 + f3 : f3 - f2);
            return;
        }
        if (i2 == 0) {
            view.setAlpha(1.0f);
        }
    }
}