package e.f.j.a.a;

import e.f.b.a.d;
import e.f.j.c.f;
import e.f.j.d.h;

/* compiled from: AnimatedFactoryProvider.java */
/* loaded from: classes2.dex */
public class b {
    private static boolean a;

    /* renamed from: b  reason: collision with root package name */
    private static a f12403b;

    public static a a(f fVar, e.f.j.e.f fVar2, h<d, e.f.j.i.b> hVar, boolean z) {
        if (!a) {
            try {
                f12403b = (a) Class.forName("com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl").getConstructor(f.class, e.f.j.e.f.class, h.class, Boolean.TYPE).newInstance(fVar, fVar2, hVar, Boolean.valueOf(z));
            } catch (Throwable unused) {
            }
            if (f12403b != null) {
                a = true;
            }
        }
        return f12403b;
    }
}