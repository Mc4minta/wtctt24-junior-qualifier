package e.g.a.c.i.v.j;

import android.database.sqlite.SQLiteDatabase;
import e.g.a.c.i.v.j.b0;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
final /* synthetic */ class m implements b0.b {
    private final long a;

    private m(long j2) {
        this.a = j2;
    }

    public static b0.b a(long j2) {
        return new m(j2);
    }

    @Override // e.g.a.c.i.v.j.b0.b
    public Object apply(Object obj) {
        Integer valueOf;
        valueOf = Integer.valueOf(((SQLiteDatabase) obj).delete("events", "timestamp_ms < ?", new String[]{String.valueOf(this.a)}));
        return valueOf;
    }
}