package e.g.a.c.i.v.j;

import android.database.sqlite.SQLiteDatabase;
import e.g.a.c.i.v.j.b0;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
final /* synthetic */ class a0 implements b0.b {
    private final b0 a;

    /* renamed from: b  reason: collision with root package name */
    private final e.g.a.c.i.l f13047b;

    private a0(b0 b0Var, e.g.a.c.i.l lVar) {
        this.a = b0Var;
        this.f13047b = lVar;
    }

    public static b0.b a(b0 b0Var, e.g.a.c.i.l lVar) {
        return new a0(b0Var, lVar);
    }

    @Override // e.g.a.c.i.v.j.b0.b
    public Object apply(Object obj) {
        return b0.O(this.a, this.f13047b, (SQLiteDatabase) obj);
    }
}