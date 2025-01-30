package e.g.a.c.i.v;

import e.g.a.c.i.l;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
final /* synthetic */ class a implements Runnable {
    private final c a;

    /* renamed from: b  reason: collision with root package name */
    private final l f13021b;

    /* renamed from: c  reason: collision with root package name */
    private final e.g.a.c.h f13022c;

    /* renamed from: d  reason: collision with root package name */
    private final e.g.a.c.i.h f13023d;

    private a(c cVar, l lVar, e.g.a.c.h hVar, e.g.a.c.i.h hVar2) {
        this.a = cVar;
        this.f13021b = lVar;
        this.f13022c = hVar;
        this.f13023d = hVar2;
    }

    public static Runnable a(c cVar, l lVar, e.g.a.c.h hVar, e.g.a.c.i.h hVar2) {
        return new a(cVar, lVar, hVar, hVar2);
    }

    @Override // java.lang.Runnable
    public void run() {
        c.c(this.a, this.f13021b, this.f13022c, this.f13023d);
    }
}