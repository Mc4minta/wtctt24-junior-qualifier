package e.f.h.e;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* compiled from: ScalingUtils.java */
/* loaded from: classes2.dex */
public class q {

    /* compiled from: ScalingUtils.java */
    /* loaded from: classes2.dex */
    public static abstract class a implements b {
        @Override // e.f.h.e.q.b
        public Matrix a(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3) {
            b(matrix, rect, i2, i3, f2, f3, rect.width() / i2, rect.height() / i3);
            return matrix;
        }

        public abstract void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5);
    }

    /* compiled from: ScalingUtils.java */
    /* loaded from: classes2.dex */
    public interface b {
        public static final b a = j.f12328j;

        /* renamed from: b  reason: collision with root package name */
        public static final b f12313b = i.f12327j;

        /* renamed from: c  reason: collision with root package name */
        public static final b f12314c = g.f12325j;

        /* renamed from: d  reason: collision with root package name */
        public static final b f12315d = h.f12326j;

        /* renamed from: e  reason: collision with root package name */
        public static final b f12316e = c.f12321j;

        /* renamed from: f  reason: collision with root package name */
        public static final b f12317f = e.f12323j;

        /* renamed from: g  reason: collision with root package name */
        public static final b f12318g = d.f12322j;

        /* renamed from: h  reason: collision with root package name */
        public static final b f12319h = k.f12329j;

        /* renamed from: i  reason: collision with root package name */
        public static final b f12320i = f.f12324j;

        Matrix a(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3);
    }

    /* compiled from: ScalingUtils.java */
    /* loaded from: classes2.dex */
    private static class c extends a {

        /* renamed from: j  reason: collision with root package name */
        public static final b f12321j = new c();

        private c() {
        }

        @Override // e.f.h.e.q.a
        public void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            matrix.setTranslate((int) (rect.left + ((rect.width() - i2) * 0.5f) + 0.5f), (int) (rect.top + ((rect.height() - i3) * 0.5f) + 0.5f));
        }

        public String toString() {
            return "center";
        }
    }

    /* compiled from: ScalingUtils.java */
    /* loaded from: classes2.dex */
    private static class d extends a {

        /* renamed from: j  reason: collision with root package name */
        public static final b f12322j = new d();

        private d() {
        }

        @Override // e.f.h.e.q.a
        public void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float height;
            float f6;
            if (f5 > f4) {
                f6 = rect.left + ((rect.width() - (i2 * f5)) * 0.5f);
                height = rect.top;
                f4 = f5;
            } else {
                height = ((rect.height() - (i3 * f4)) * 0.5f) + rect.top;
                f6 = rect.left;
            }
            matrix.setScale(f4, f4);
            matrix.postTranslate((int) (f6 + 0.5f), (int) (height + 0.5f));
        }

        public String toString() {
            return "center_crop";
        }
    }

    /* compiled from: ScalingUtils.java */
    /* loaded from: classes2.dex */
    private static class e extends a {

        /* renamed from: j  reason: collision with root package name */
        public static final b f12323j = new e();

        private e() {
        }

        @Override // e.f.h.e.q.a
        public void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float min = Math.min(Math.min(f4, f5), 1.0f);
            float width = rect.left + ((rect.width() - (i2 * min)) * 0.5f);
            float height = rect.top + ((rect.height() - (i3 * min)) * 0.5f);
            matrix.setScale(min, min);
            matrix.postTranslate((int) (width + 0.5f), (int) (height + 0.5f));
        }

        public String toString() {
            return "center_inside";
        }
    }

    /* compiled from: ScalingUtils.java */
    /* loaded from: classes2.dex */
    private static class f extends a {

        /* renamed from: j  reason: collision with root package name */
        public static final b f12324j = new f();

        private f() {
        }

        @Override // e.f.h.e.q.a
        public void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float min = Math.min(f4, f5);
            matrix.setScale(min, min);
            matrix.postTranslate((int) (rect.left + 0.5f), (int) (rect.top + (rect.height() - (i3 * min)) + 0.5f));
        }

        public String toString() {
            return "fit_bottom_start";
        }
    }

    /* compiled from: ScalingUtils.java */
    /* loaded from: classes2.dex */
    private static class g extends a {

        /* renamed from: j  reason: collision with root package name */
        public static final b f12325j = new g();

        private g() {
        }

        @Override // e.f.h.e.q.a
        public void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float min = Math.min(f4, f5);
            float width = rect.left + ((rect.width() - (i2 * min)) * 0.5f);
            float height = rect.top + ((rect.height() - (i3 * min)) * 0.5f);
            matrix.setScale(min, min);
            matrix.postTranslate((int) (width + 0.5f), (int) (height + 0.5f));
        }

        public String toString() {
            return "fit_center";
        }
    }

    /* compiled from: ScalingUtils.java */
    /* loaded from: classes2.dex */
    private static class h extends a {

        /* renamed from: j  reason: collision with root package name */
        public static final b f12326j = new h();

        private h() {
        }

        @Override // e.f.h.e.q.a
        public void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float min = Math.min(f4, f5);
            matrix.setScale(min, min);
            matrix.postTranslate((int) (rect.left + (rect.width() - (i2 * min)) + 0.5f), (int) (rect.top + (rect.height() - (i3 * min)) + 0.5f));
        }

        public String toString() {
            return "fit_end";
        }
    }

    /* compiled from: ScalingUtils.java */
    /* loaded from: classes2.dex */
    private static class i extends a {

        /* renamed from: j  reason: collision with root package name */
        public static final b f12327j = new i();

        private i() {
        }

        @Override // e.f.h.e.q.a
        public void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float min = Math.min(f4, f5);
            matrix.setScale(min, min);
            matrix.postTranslate((int) (rect.left + 0.5f), (int) (rect.top + 0.5f));
        }

        public String toString() {
            return "fit_start";
        }
    }

    /* compiled from: ScalingUtils.java */
    /* loaded from: classes2.dex */
    private static class j extends a {

        /* renamed from: j  reason: collision with root package name */
        public static final b f12328j = new j();

        private j() {
        }

        @Override // e.f.h.e.q.a
        public void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            matrix.setScale(f4, f5);
            matrix.postTranslate((int) (rect.left + 0.5f), (int) (rect.top + 0.5f));
        }

        public String toString() {
            return "fit_xy";
        }
    }

    /* compiled from: ScalingUtils.java */
    /* loaded from: classes2.dex */
    private static class k extends a {

        /* renamed from: j  reason: collision with root package name */
        public static final b f12329j = new k();

        private k() {
        }

        @Override // e.f.h.e.q.a
        public void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float f6;
            float max;
            if (f5 > f4) {
                float f7 = i2 * f5;
                f6 = rect.left + Math.max(Math.min((rect.width() * 0.5f) - (f2 * f7), 0.0f), rect.width() - f7);
                max = rect.top;
                f4 = f5;
            } else {
                f6 = rect.left;
                float f8 = i3 * f4;
                max = Math.max(Math.min((rect.height() * 0.5f) - (f3 * f8), 0.0f), rect.height() - f8) + rect.top;
            }
            matrix.setScale(f4, f4);
            matrix.postTranslate((int) (f6 + 0.5f), (int) (max + 0.5f));
        }

        public String toString() {
            return "focus_crop";
        }
    }

    /* compiled from: ScalingUtils.java */
    /* loaded from: classes2.dex */
    public interface l {
        Object getState();
    }

    public static p a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof p) {
            return (p) drawable;
        }
        if (drawable instanceof e.f.h.e.c) {
            return a(((e.f.h.e.c) drawable).k());
        }
        if (drawable instanceof e.f.h.e.a) {
            e.f.h.e.a aVar = (e.f.h.e.a) drawable;
            int f2 = aVar.f();
            for (int i2 = 0; i2 < f2; i2++) {
                p a2 = a(aVar.c(i2));
                if (a2 != null) {
                    return a2;
                }
            }
        }
        return null;
    }
}