package com.google.android.material.transformation;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.h.k.v;
import com.google.android.material.transformation.FabTransformationBehavior;
import e.g.a.f.l.h;
import e.g.a.f.l.j;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    /* renamed from: g  reason: collision with root package name */
    private Map<View, Integer> f8304g;

    public FabTransformationSheetBehavior() {
    }

    private void c0(View view, boolean z) {
        ViewParent parent = view.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z) {
                this.f8304g = new HashMap(childCount);
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                boolean z2 = (childAt.getLayoutParams() instanceof CoordinatorLayout.f) && (((CoordinatorLayout.f) childAt.getLayoutParams()).f() instanceof FabTransformationScrimBehavior);
                if (childAt != view && !z2) {
                    if (!z) {
                        Map<View, Integer> map = this.f8304g;
                        if (map != null && map.containsKey(childAt)) {
                            v.t0(childAt, this.f8304g.get(childAt).intValue());
                        }
                    } else {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.f8304g.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        v.t0(childAt, 4);
                    }
                }
            }
            if (z) {
                return;
            }
            this.f8304g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    public boolean G(View view, View view2, boolean z, boolean z2) {
        c0(view2, z);
        return super.G(view, view2, z, z2);
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    protected FabTransformationBehavior.e a0(Context context, boolean z) {
        int i2;
        if (z) {
            i2 = e.g.a.f.a.f13226d;
        } else {
            i2 = e.g.a.f.a.f13225c;
        }
        FabTransformationBehavior.e eVar = new FabTransformationBehavior.e();
        eVar.a = h.b(context, i2);
        eVar.f8299b = new j(17, 0.0f, 0.0f);
        return eVar;
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}