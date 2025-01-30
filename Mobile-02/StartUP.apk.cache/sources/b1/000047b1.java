package e.g.a.c.i.v.j;

import android.database.sqlite.SQLiteDatabase;
import e.g.a.c.i.v.j.b0;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
final /* synthetic */ class j implements b0.b {
    private final long a;

    /* renamed from: b  reason: collision with root package name */
    private final e.g.a.c.i.l f13067b;

    private j(long j2, e.g.a.c.i.l lVar) {
        this.a = j2;
        this.f13067b = lVar;
    }

    public static b0.b a(long j2, e.g.a.c.i.l lVar) {
        return new j(j2, lVar);
    }

    @Override // e.g.a.c.i.v.j.b0.b
    public Object apply(Object obj) {
        return b0.r0(this.a, this.f13067b, (SQLiteDatabase) obj);
    }
}