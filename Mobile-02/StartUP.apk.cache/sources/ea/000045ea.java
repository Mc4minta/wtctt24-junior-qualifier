package e.f.h.i;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: AspectRatioMeasure.java */
/* loaded from: classes2.dex */
public class a {

    /* compiled from: AspectRatioMeasure.java */
    /* renamed from: e.f.h.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0270a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f12364b;
    }

    private static boolean a(int i2) {
        return i2 == 0 || i2 == -2;
    }

    public static void b(C0270a c0270a, float f2, ViewGroup.LayoutParams layoutParams, int i2, int i3) {
        if (f2 <= 0.0f || layoutParams == null) {
            return;
        }
        if (a(layoutParams.height)) {
            c0270a.f12364b = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0270a.a) - i2) / f2) + i3), c0270a.f12364b), 1073741824);
        } else if (a(layoutParams.width)) {
            c0270a.a = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0270a.f12364b) - i3) * f2) + i2), c0270a.a), 1073741824);
        }
    }
}