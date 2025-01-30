package e.f.h.a.a;

import android.content.Context;
import com.facebook.soloader.SoLoader;
import e.f.j.e.h;
import e.f.j.e.i;
import e.f.j.e.k;
import java.io.IOException;

/* compiled from: Fresco.java */
/* loaded from: classes2.dex */
public class c {
    private static final Class<?> a = c.class;

    /* renamed from: b  reason: collision with root package name */
    private static f f12135b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f12136c;

    private c() {
    }

    public static h a() {
        return b().i();
    }

    public static k b() {
        return k.k();
    }

    public static boolean c() {
        return f12136c;
    }

    public static void d(Context context) {
        f(context, null, null);
    }

    public static void e(Context context, i iVar) {
        f(context, iVar, null);
    }

    public static void f(Context context, i iVar, b bVar) {
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("Fresco#initialize");
        }
        if (f12136c) {
            e.f.d.d.a.w(a, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            f12136c = true;
        }
        try {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.a("Fresco.initialize->SoLoader.init");
            }
            SoLoader.e(context, 0);
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
            Context applicationContext = context.getApplicationContext();
            if (iVar == null) {
                k.t(applicationContext);
            } else {
                k.u(iVar);
            }
            g(applicationContext, bVar);
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
        } catch (IOException e2) {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
            throw new RuntimeException("Could not initialize SoLoader", e2);
        }
    }

    private static void g(Context context, b bVar) {
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("Fresco.initializeDrawee");
        }
        f fVar = new f(context, bVar);
        f12135b = fVar;
        e.f.h.i.e.g(fVar);
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
    }

    public static e h() {
        return f12135b.get();
    }
}