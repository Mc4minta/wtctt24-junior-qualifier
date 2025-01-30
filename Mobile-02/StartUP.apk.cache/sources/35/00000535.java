package c.h.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.d.c;
import androidx.core.content.d.f;
import c.h.i.f;

/* compiled from: TypefaceCompat.java */
@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class d {
    private static final j a;

    /* renamed from: b  reason: collision with root package name */
    private static final c.e.e<String, Typeface> f2931b;

    /* compiled from: TypefaceCompat.java */
    /* loaded from: classes.dex */
    public static class a extends f.c {
        private f.a a;

        public a(f.a aVar) {
            this.a = aVar;
        }

        @Override // c.h.i.f.c
        public void a(int i2) {
            f.a aVar = this.a;
            if (aVar != null) {
                aVar.d(i2);
            }
        }

        @Override // c.h.i.f.c
        public void b(Typeface typeface) {
            f.a aVar = this.a;
            if (aVar != null) {
                aVar.e(typeface);
            }
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            a = new i();
        } else if (i2 >= 28) {
            a = new h();
        } else if (i2 >= 26) {
            a = new g();
        } else if (i2 >= 24 && f.m()) {
            a = new f();
        } else if (i2 >= 21) {
            a = new e();
        } else {
            a = new j();
        }
        f2931b = new c.e.e<>(16);
    }

    public static Typeface a(Context context, Typeface typeface, int i2) {
        Typeface g2;
        if (context != null) {
            return (Build.VERSION.SDK_INT >= 21 || (g2 = g(context, typeface, i2)) == null) ? Typeface.create(typeface, i2) : g2;
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i2) {
        return a.c(context, cancellationSignal, bVarArr, i2);
    }

    public static Typeface c(Context context, c.a aVar, Resources resources, int i2, int i3, f.a aVar2, Handler handler, boolean z) {
        Typeface b2;
        if (aVar instanceof c.d) {
            c.d dVar = (c.d) aVar;
            Typeface h2 = h(dVar.c());
            if (h2 != null) {
                if (aVar2 != null) {
                    aVar2.b(h2, handler);
                }
                return h2;
            }
            boolean z2 = !z ? aVar2 != null : dVar.a() != 0;
            int d2 = z ? dVar.d() : -1;
            b2 = c.h.i.f.a(context, dVar.b(), i3, z2, d2, f.a.c(handler), new a(aVar2));
        } else {
            b2 = a.b(context, (c.b) aVar, resources, i3);
            if (aVar2 != null) {
                if (b2 != null) {
                    aVar2.b(b2, handler);
                } else {
                    aVar2.a(-3, handler);
                }
            }
        }
        if (b2 != null) {
            f2931b.d(e(resources, i2, i3), b2);
        }
        return b2;
    }

    public static Typeface d(Context context, Resources resources, int i2, String str, int i3) {
        Typeface e2 = a.e(context, resources, i2, str, i3);
        if (e2 != null) {
            f2931b.d(e(resources, i2, i3), e2);
        }
        return e2;
    }

    private static String e(Resources resources, int i2, int i3) {
        return resources.getResourcePackageName(i2) + "-" + i2 + "-" + i3;
    }

    public static Typeface f(Resources resources, int i2, int i3) {
        return f2931b.c(e(resources, i2, i3));
    }

    private static Typeface g(Context context, Typeface typeface, int i2) {
        j jVar = a;
        c.b i3 = jVar.i(typeface);
        if (i3 == null) {
            return null;
        }
        return jVar.b(context, i3, context.getResources(), i2);
    }

    private static Typeface h(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface create = Typeface.create(str, 0);
        Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
        if (create == null || create.equals(create2)) {
            return null;
        }
        return create;
    }
}