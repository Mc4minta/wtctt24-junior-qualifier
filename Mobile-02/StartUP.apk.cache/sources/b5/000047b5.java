package e.g.a.c.i.v.j;

import android.database.Cursor;
import e.g.a.c.i.v.j.b0;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final /* synthetic */ class n implements b0.b {
    private final b0 a;

    /* renamed from: b  reason: collision with root package name */
    private final List f13069b;

    /* renamed from: c  reason: collision with root package name */
    private final e.g.a.c.i.l f13070c;

    private n(b0 b0Var, List list, e.g.a.c.i.l lVar) {
        this.a = b0Var;
        this.f13069b = list;
        this.f13070c = lVar;
    }

    public static b0.b a(b0 b0Var, List list, e.g.a.c.i.l lVar) {
        return new n(b0Var, list, lVar);
    }

    @Override // e.g.a.c.i.v.j.b0.b
    public Object apply(Object obj) {
        return b0.e0(this.a, this.f13069b, this.f13070c, (Cursor) obj);
    }
}