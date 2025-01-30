package com.toshi.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.h.k.v;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.Metadata;

/* compiled from: FixAppBarLayoutBehavior.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJO\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013JG\u0010\u0017\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/toshi/view/custom/FixAppBarLayoutBehavior;", "Lcom/google/android/material/appbar/AppBarLayout$Behavior;", "", "dy", "Lcom/google/android/material/appbar/AppBarLayout;", "child", "Landroid/view/View;", "target", "type", "Lkotlin/x;", "o0", "(ILcom/google/android/material/appbar/AppBarLayout;Landroid/view/View;I)V", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "coordinatorLayout", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "g0", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/google/android/material/appbar/AppBarLayout;Landroid/view/View;IIIII)V", "dx", "", "consumed", "f0", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/google/android/material/appbar/AppBarLayout;Landroid/view/View;II[II)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class FixAppBarLayoutBehavior extends AppBarLayout.Behavior {
    public FixAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private final void o0(int i2, AppBarLayout appBarLayout, View view, int i3) {
        if (i3 == 1) {
            int D = D();
            if ((i2 >= 0 || D != 0) && (i2 <= 0 || D != (-appBarLayout.getTotalScrollRange()))) {
                return;
            }
            v.F0(view, 1);
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* renamed from: f0 */
    public void q(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, int i2, int i3, int[] consumed, int i4) {
        kotlin.jvm.internal.m.g(coordinatorLayout, "coordinatorLayout");
        kotlin.jvm.internal.m.g(child, "child");
        kotlin.jvm.internal.m.g(target, "target");
        kotlin.jvm.internal.m.g(consumed, "consumed");
        super.f0(coordinatorLayout, child, target, i2, i3, consumed, i4);
        o0(i3, child, target, i4);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* renamed from: g0 */
    public void s(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, int i2, int i3, int i4, int i5, int i6) {
        kotlin.jvm.internal.m.g(coordinatorLayout, "coordinatorLayout");
        kotlin.jvm.internal.m.g(child, "child");
        kotlin.jvm.internal.m.g(target, "target");
        super.g0(coordinatorLayout, child, target, i2, i3, i4, i5, i6);
        o0(i5, child, target, i6);
    }
}