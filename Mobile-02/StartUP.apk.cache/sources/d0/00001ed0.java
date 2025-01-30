package com.coinbase.wallet.features.lend.views;

import android.graphics.Rect;
import android.view.View;
import kotlin.Metadata;

/* compiled from: LendDashboardFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\"\u001a\u0010\u0004\u001a\u00020\u0001*\u00020\u00008B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroid/view/View;", "", "getTransitionPercent", "(Landroid/view/View;)F", "transitionPercent", "app_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendDashboardFragmentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final float getTransitionPercent(View view) {
        if (view.isShown()) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            int measuredHeight = view.getMeasuredHeight() / 2;
            int i2 = rect.bottom;
            if (i2 - measuredHeight >= 0) {
                return 0.0f;
            }
            return (measuredHeight - i2) / measuredHeight;
        }
        return 1.0f;
    }
}