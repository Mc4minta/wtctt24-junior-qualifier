package com.facebook.react.uimanager;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.UiThreadUtil;

/* compiled from: TouchTargetHelper.java */
/* loaded from: classes2.dex */
public class j0 {
    private static final float[] a = new float[2];

    /* renamed from: b  reason: collision with root package name */
    private static final PointF f5134b = new PointF();

    /* renamed from: c  reason: collision with root package name */
    private static final float[] f5135c = new float[2];

    /* renamed from: d  reason: collision with root package name */
    private static final Matrix f5136d = new Matrix();

    private static View a(View view) {
        while (view != null && view.getId() <= 0) {
            view = (View) view.getParent();
        }
        return view;
    }

    public static int b(float f2, float f3, ViewGroup viewGroup, float[] fArr, int[] iArr) {
        View a2;
        UiThreadUtil.assertOnUiThread();
        int id = viewGroup.getId();
        fArr[0] = f2;
        fArr[1] = f3;
        View d2 = d(fArr, viewGroup);
        if (d2 == null || (a2 = a(d2)) == null) {
            return id;
        }
        if (iArr != null) {
            iArr[0] = a2.getId();
        }
        return f(a2, fArr[0], fArr[1]);
    }

    public static int c(float f2, float f3, ViewGroup viewGroup) {
        return b(f2, f3, viewGroup, a, null);
    }

    private static View d(float[] fArr, ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        c0 c0Var = viewGroup instanceof c0 ? (c0) viewGroup : null;
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            View childAt = viewGroup.getChildAt(c0Var != null ? c0Var.a(i2) : i2);
            PointF pointF = f5134b;
            if (g(fArr[0], fArr[1], viewGroup, childAt, pointF)) {
                float f2 = fArr[0];
                float f3 = fArr[1];
                fArr[0] = pointF.x;
                fArr[1] = pointF.y;
                View e2 = e(fArr, childAt);
                if (e2 != null) {
                    return e2;
                }
                fArr[0] = f2;
                fArr[1] = f3;
            }
        }
        return viewGroup;
    }

    private static View e(float[] fArr, View view) {
        p pointerEvents = view instanceof v ? ((v) view).getPointerEvents() : p.AUTO;
        if (!view.isEnabled()) {
            if (pointerEvents == p.AUTO) {
                pointerEvents = p.BOX_NONE;
            } else if (pointerEvents == p.BOX_ONLY) {
                pointerEvents = p.NONE;
            }
        }
        if (pointerEvents == p.NONE) {
            return null;
        }
        if (pointerEvents == p.BOX_ONLY) {
            return view;
        }
        if (pointerEvents == p.BOX_NONE) {
            if (view instanceof ViewGroup) {
                View d2 = d(fArr, (ViewGroup) view);
                if (d2 != view) {
                    return d2;
                }
                if ((view instanceof t) && ((t) view).c(fArr[0], fArr[1]) != view.getId()) {
                    return view;
                }
            }
            return null;
        } else if (pointerEvents == p.AUTO) {
            return (!((view instanceof u) && ((u) view).e(fArr[0], fArr[1])) && (view instanceof ViewGroup)) ? d(fArr, (ViewGroup) view) : view;
        } else {
            throw new JSApplicationIllegalArgumentException("Unknown pointer event type: " + pointerEvents.toString());
        }
    }

    private static int f(View view, float f2, float f3) {
        if (view instanceof t) {
            return ((t) view).c(f2, f3);
        }
        return view.getId();
    }

    private static boolean g(float f2, float f3, ViewGroup viewGroup, View view, PointF pointF) {
        float scrollX = (f2 + viewGroup.getScrollX()) - view.getLeft();
        float scrollY = (f3 + viewGroup.getScrollY()) - view.getTop();
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            float[] fArr = f5135c;
            fArr[0] = scrollX;
            fArr[1] = scrollY;
            Matrix matrix2 = f5136d;
            matrix.invert(matrix2);
            matrix2.mapPoints(fArr);
            scrollX = fArr[0];
            scrollY = fArr[1];
        }
        if (view instanceof e.f.m.z.c) {
            e.f.m.z.c cVar = (e.f.m.z.c) view;
            if (cVar.getHitSlopRect() != null) {
                Rect hitSlopRect = cVar.getHitSlopRect();
                if (scrollX < (-hitSlopRect.left) || scrollX >= (view.getRight() - view.getLeft()) + hitSlopRect.right || scrollY < (-hitSlopRect.top) || scrollY >= (view.getBottom() - view.getTop()) + hitSlopRect.bottom) {
                    return false;
                }
                pointF.set(scrollX, scrollY);
                return true;
            }
        }
        if (scrollX < 0.0f || scrollX >= view.getRight() - view.getLeft() || scrollY < 0.0f || scrollY >= view.getBottom() - view.getTop()) {
            return false;
        }
        pointF.set(scrollX, scrollY);
        return true;
    }
}