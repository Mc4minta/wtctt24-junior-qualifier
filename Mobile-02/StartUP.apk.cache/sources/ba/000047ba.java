package e.g.a.c.i.v.j;

import e.g.a.c.i.v.j.b0;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
final /* synthetic */ class s implements b0.d {
    private final h0 a;

    private s(h0 h0Var) {
        this.a = h0Var;
    }

    public static b0.d b(h0 h0Var) {
        return new s(h0Var);
    }

    @Override // e.g.a.c.i.v.j.b0.d
    public Object a() {
        return this.a.getWritableDatabase();
    }
}