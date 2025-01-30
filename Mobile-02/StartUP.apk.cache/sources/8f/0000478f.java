package e.g.a.c.i.v;

import com.google.android.datatransport.runtime.synchronization.a;
import e.g.a.c.i.l;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final /* synthetic */ class b implements a.InterfaceC0134a {
    private final c a;

    /* renamed from: b  reason: collision with root package name */
    private final l f13024b;

    /* renamed from: c  reason: collision with root package name */
    private final e.g.a.c.i.h f13025c;

    private b(c cVar, l lVar, e.g.a.c.i.h hVar) {
        this.a = cVar;
        this.f13024b = lVar;
        this.f13025c = hVar;
    }

    public static a.InterfaceC0134a a(c cVar, l lVar, e.g.a.c.i.h hVar) {
        return new b(cVar, lVar, hVar);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0134a
    public Object execute() {
        return c.b(this.a, this.f13024b, this.f13025c);
    }
}