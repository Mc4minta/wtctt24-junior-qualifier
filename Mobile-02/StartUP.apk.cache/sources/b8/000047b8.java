package e.g.a.c.i.v.j;

import android.database.sqlite.SQLiteDatabase;
import e.g.a.c.i.v.j.b0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public final /* synthetic */ class q implements b0.d {
    private final SQLiteDatabase a;

    private q(SQLiteDatabase sQLiteDatabase) {
        this.a = sQLiteDatabase;
    }

    public static b0.d b(SQLiteDatabase sQLiteDatabase) {
        return new q(sQLiteDatabase);
    }

    @Override // e.g.a.c.i.v.j.b0.d
    public Object a() {
        return b0.z(this.a);
    }
}