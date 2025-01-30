package c.r.a.g;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.CancellationSignal;
import android.util.Pair;
import c.r.a.f;
import java.io.IOException;
import java.util.List;

/* compiled from: FrameworkSQLiteDatabase.java */
/* loaded from: classes.dex */
class a implements c.r.a.b {
    private static final String[] a = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f3213b = new String[0];

    /* renamed from: c  reason: collision with root package name */
    private final SQLiteDatabase f3214c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FrameworkSQLiteDatabase.java */
    /* renamed from: c.r.a.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0086a implements SQLiteDatabase.CursorFactory {
        final /* synthetic */ c.r.a.e a;

        C0086a(c.r.a.e eVar) {
            this.a = eVar;
        }

        @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.a.b(new d(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    /* compiled from: FrameworkSQLiteDatabase.java */
    /* loaded from: classes.dex */
    class b implements SQLiteDatabase.CursorFactory {
        final /* synthetic */ c.r.a.e a;

        b(c.r.a.e eVar) {
            this.a = eVar;
        }

        @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.a.b(new d(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(SQLiteDatabase sQLiteDatabase) {
        this.f3214c = sQLiteDatabase;
    }

    @Override // c.r.a.b
    public Cursor A0(c.r.a.e eVar) {
        return this.f3214c.rawQueryWithFactory(new C0086a(eVar), eVar.a(), f3213b, null);
    }

    @Override // c.r.a.b
    public f B(String str) {
        return new e(this.f3214c.compileStatement(str));
    }

    @Override // c.r.a.b
    public boolean F0() {
        return this.f3214c.inTransaction();
    }

    @Override // c.r.a.b
    public Cursor S(c.r.a.e eVar, CancellationSignal cancellationSignal) {
        return this.f3214c.rawQueryWithFactory(new b(eVar), eVar.a(), f3213b, null, cancellationSignal);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SQLiteDatabase sQLiteDatabase) {
        return this.f3214c == sQLiteDatabase;
    }

    @Override // c.r.a.b
    public void c0() {
        this.f3214c.setTransactionSuccessful();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3214c.close();
    }

    @Override // c.r.a.b
    public String getPath() {
        return this.f3214c.getPath();
    }

    @Override // c.r.a.b
    public Cursor i0(String str) {
        return A0(new c.r.a.a(str));
    }

    @Override // c.r.a.b
    public boolean isOpen() {
        return this.f3214c.isOpen();
    }

    @Override // c.r.a.b
    public void o() {
        this.f3214c.beginTransaction();
    }

    @Override // c.r.a.b
    public void p0() {
        this.f3214c.endTransaction();
    }

    @Override // c.r.a.b
    public List<Pair<String, String>> r() {
        return this.f3214c.getAttachedDbs();
    }

    @Override // c.r.a.b
    public void t(String str) throws SQLException {
        this.f3214c.execSQL(str);
    }
}