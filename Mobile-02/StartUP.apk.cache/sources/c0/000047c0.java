package e.g.a.c.i.v.j;

import android.database.sqlite.SQLiteDatabase;
import e.g.a.c.i.v.j.b0;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
final /* synthetic */ class y implements b0.b {
    private final String a;

    private y(String str) {
        this.a = str;
    }

    public static b0.b a(String str) {
        return new y(str);
    }

    @Override // e.g.a.c.i.v.j.b0.b
    public Object apply(Object obj) {
        return b0.o0(this.a, (SQLiteDatabase) obj);
    }
}