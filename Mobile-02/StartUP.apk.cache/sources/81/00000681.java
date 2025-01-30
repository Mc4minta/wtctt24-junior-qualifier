package c.s;

import android.view.View;

/* compiled from: VisibilityPropagation.java */
/* loaded from: classes.dex */
public abstract class x0 extends b0 {
    private static final String[] a = {"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};

    private static int d(e0 e0Var, int i2) {
        int[] iArr;
        if (e0Var == null || (iArr = (int[]) e0Var.a.get("android:visibilityPropagation:center")) == null) {
            return -1;
        }
        return iArr[i2];
    }

    @Override // c.s.b0
    public void a(e0 e0Var) {
        View view = e0Var.f3289b;
        Integer num = (Integer) e0Var.a.get("android:visibility:visibility");
        if (num == null) {
            num = Integer.valueOf(view.getVisibility());
        }
        e0Var.a.put("android:visibilityPropagation:visibility", num);
        view.getLocationOnScreen(r2);
        int[] iArr = {iArr[0] + Math.round(view.getTranslationX())};
        iArr[0] = iArr[0] + (view.getWidth() / 2);
        iArr[1] = iArr[1] + Math.round(view.getTranslationY());
        iArr[1] = iArr[1] + (view.getHeight() / 2);
        e0Var.a.put("android:visibilityPropagation:center", iArr);
    }

    @Override // c.s.b0
    public String[] b() {
        return a;
    }

    public int e(e0 e0Var) {
        Integer num;
        if (e0Var == null || (num = (Integer) e0Var.a.get("android:visibilityPropagation:visibility")) == null) {
            return 8;
        }
        return num.intValue();
    }

    public int f(e0 e0Var) {
        return d(e0Var, 0);
    }

    public int g(e0 e0Var) {
        return d(e0Var, 1);
    }
}