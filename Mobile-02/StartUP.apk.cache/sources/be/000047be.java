package e.g.a.c.i.v.j;

import android.database.sqlite.SQLiteDatabase;
import e.g.a.c.i.v.j.b0;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
final /* synthetic */ class w implements b0.b {
    private final b0 a;

    /* renamed from: b  reason: collision with root package name */
    private final e.g.a.c.i.l f13071b;

    /* renamed from: c  reason: collision with root package name */
    private final e.g.a.c.i.h f13072c;

    private w(b0 b0Var, e.g.a.c.i.l lVar, e.g.a.c.i.h hVar) {
        this.a = b0Var;
        this.f13071b = lVar;
        this.f13072c = hVar;
    }

    public static b0.b a(b0 b0Var, e.g.a.c.i.l lVar, e.g.a.c.i.h hVar) {
        return new w(b0Var, lVar, hVar);
    }

    @Override // e.g.a.c.i.v.j.b0.b
    public Object apply(Object obj) {
        return b0.k0(this.a, this.f13071b, this.f13072c, (SQLiteDatabase) obj);
    }
}