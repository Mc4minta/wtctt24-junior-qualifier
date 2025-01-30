package e.f.h.f;

import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import e.f.d.c.i;
import e.f.h.e.g;
import e.f.h.e.j;
import e.f.h.e.k;
import e.f.h.e.l;
import e.f.h.e.m;
import e.f.h.e.o;
import e.f.h.e.p;
import e.f.h.e.q;
import e.f.h.f.d;

/* compiled from: WrappingUtils.java */
/* loaded from: classes2.dex */
public class e {
    private static final Drawable a = new ColorDrawable(0);

    private static Drawable a(Drawable drawable, d dVar, Resources resources) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            k kVar = new k(resources, bitmapDrawable.getBitmap(), bitmapDrawable.getPaint());
            b(kVar, dVar);
            return kVar;
        } else if (drawable instanceof NinePatchDrawable) {
            o oVar = new o((NinePatchDrawable) drawable);
            b(oVar, dVar);
            return oVar;
        } else if ((drawable instanceof ColorDrawable) && Build.VERSION.SDK_INT >= 11) {
            l b2 = l.b((ColorDrawable) drawable);
            b(b2, dVar);
            return b2;
        } else {
            e.f.d.d.a.C("WrappingUtils", "Don't know how to round that drawable: %s", drawable);
            return drawable;
        }
    }

    static void b(j jVar, d dVar) {
        jVar.c(dVar.i());
        jVar.l(dVar.d());
        jVar.a(dVar.b(), dVar.c());
        jVar.h(dVar.g());
        jVar.f(dVar.k());
        jVar.e(dVar.h());
    }

    static e.f.h.e.c c(e.f.h.e.c cVar) {
        while (true) {
            Drawable k2 = cVar.k();
            if (k2 == cVar || !(k2 instanceof e.f.h.e.c)) {
                break;
            }
            cVar = (e.f.h.e.c) k2;
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Drawable d(Drawable drawable, d dVar, Resources resources) {
        try {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.a("WrappingUtils#maybeApplyLeafRounding");
            }
            if (drawable != null && dVar != null && dVar.j() == d.a.BITMAP_ONLY) {
                if (drawable instanceof g) {
                    e.f.h.e.c c2 = c((g) drawable);
                    c2.setDrawable(a(c2.setDrawable(a), dVar, resources));
                    return drawable;
                }
                Drawable a2 = a(drawable, dVar, resources);
                if (e.f.j.m.b.d()) {
                    e.f.j.m.b.b();
                }
                return a2;
            }
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
            return drawable;
        } finally {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Drawable e(Drawable drawable, d dVar) {
        try {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.a("WrappingUtils#maybeWrapWithRoundedOverlayColor");
            }
            if (drawable != null && dVar != null && dVar.j() == d.a.OVERLAY_COLOR) {
                m mVar = new m(drawable);
                b(mVar, dVar);
                mVar.q(dVar.f());
                return mVar;
            }
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
            return drawable;
        } finally {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Drawable f(Drawable drawable, q.b bVar) {
        return g(drawable, bVar, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Drawable g(Drawable drawable, q.b bVar, PointF pointF) {
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("WrappingUtils#maybeWrapWithScaleType");
        }
        if (drawable != null && bVar != null) {
            p pVar = new p(drawable, bVar);
            if (pointF != null) {
                pVar.s(pointF);
            }
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
            return pVar;
        }
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
        return drawable;
    }

    static void h(j jVar) {
        jVar.c(false);
        jVar.i(0.0f);
        jVar.a(0, 0.0f);
        jVar.h(0.0f);
        jVar.f(false);
        jVar.e(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(e.f.h.e.c cVar, d dVar, Resources resources) {
        e.f.h.e.c c2 = c(cVar);
        Drawable k2 = c2.k();
        if (dVar != null && dVar.j() == d.a.BITMAP_ONLY) {
            if (k2 instanceof j) {
                b((j) k2, dVar);
            } else if (k2 != null) {
                c2.setDrawable(a);
                c2.setDrawable(a(k2, dVar, resources));
            }
        } else if (k2 instanceof j) {
            h((j) k2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(e.f.h.e.c cVar, d dVar) {
        Drawable k2 = cVar.k();
        if (dVar != null && dVar.j() == d.a.OVERLAY_COLOR) {
            if (k2 instanceof m) {
                m mVar = (m) k2;
                b(mVar, dVar);
                mVar.q(dVar.f());
                return;
            }
            cVar.setDrawable(e(cVar.setDrawable(a), dVar));
        } else if (k2 instanceof m) {
            Drawable drawable = a;
            cVar.setDrawable(((m) k2).n(drawable));
            drawable.setCallback(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p k(e.f.h.e.c cVar, q.b bVar) {
        Drawable f2 = f(cVar.setDrawable(a), bVar);
        cVar.setDrawable(f2);
        i.h(f2, "Parent has no child drawable!");
        return (p) f2;
    }
}