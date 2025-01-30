package c.r.a.g;

import android.database.sqlite.SQLiteStatement;
import c.r.a.f;

/* compiled from: FrameworkSQLiteStatement.java */
/* loaded from: classes.dex */
class e extends d implements f {

    /* renamed from: b  reason: collision with root package name */
    private final SQLiteStatement f3220b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f3220b = sQLiteStatement;
    }

    @Override // c.r.a.f
    public long b1() {
        return this.f3220b.executeInsert();
    }

    @Override // c.r.a.f
    public int y() {
        return this.f3220b.executeUpdateDelete();
    }
}