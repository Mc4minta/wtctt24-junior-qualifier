package androidx.room;

import c.r.a.c;
import java.io.File;

/* compiled from: SQLiteCopyOpenHelperFactory.java */
/* loaded from: classes.dex */
class p implements c.InterfaceC0085c {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final File f2297b;

    /* renamed from: c  reason: collision with root package name */
    private final c.InterfaceC0085c f2298c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, File file, c.InterfaceC0085c interfaceC0085c) {
        this.a = str;
        this.f2297b = file;
        this.f2298c = interfaceC0085c;
    }

    @Override // c.r.a.c.InterfaceC0085c
    public c.r.a.c a(c.b bVar) {
        return new o(bVar.a, this.a, this.f2297b, bVar.f3210c.a, this.f2298c.a(bVar));
    }
}