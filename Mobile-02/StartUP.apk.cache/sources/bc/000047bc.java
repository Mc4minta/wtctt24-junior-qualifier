package e.g.a.c.i.v.j;

import android.database.Cursor;
import e.g.a.c.i.v.j.b0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final /* synthetic */ class u implements b0.b {
    private static final u a = new u();

    private u() {
    }

    public static b0.b a() {
        return a;
    }

    @Override // e.g.a.c.i.v.j.b0.b
    public Object apply(Object obj) {
        return Boolean.valueOf(((Cursor) obj).moveToNext());
    }
}