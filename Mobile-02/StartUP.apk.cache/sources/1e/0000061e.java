package c.r.a.g;

import android.database.sqlite.SQLiteProgram;

/* compiled from: FrameworkSQLiteProgram.java */
/* loaded from: classes.dex */
class d implements c.r.a.d {
    private final SQLiteProgram a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SQLiteProgram sQLiteProgram) {
        this.a = sQLiteProgram;
    }

    @Override // c.r.a.d
    public void B0(int i2) {
        this.a.bindNull(i2);
    }

    @Override // c.r.a.d
    public void I(int i2, double d2) {
        this.a.bindDouble(i2, d2);
    }

    @Override // c.r.a.d
    public void b0(int i2, long j2) {
        this.a.bindLong(i2, j2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    @Override // c.r.a.d
    public void f0(int i2, byte[] bArr) {
        this.a.bindBlob(i2, bArr);
    }

    @Override // c.r.a.d
    public void u(int i2, String str) {
        this.a.bindString(i2, str);
    }
}