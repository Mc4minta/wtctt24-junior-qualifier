package c.r.a.g;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import c.r.a.c;

/* compiled from: FrameworkSQLiteOpenHelper.java */
/* loaded from: classes.dex */
class b implements c.r.a.c {
    private final a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FrameworkSQLiteOpenHelper.java */
    /* loaded from: classes.dex */
    public static class a extends SQLiteOpenHelper {
        final c.r.a.g.a[] a;

        /* renamed from: b  reason: collision with root package name */
        final c.a f3217b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f3218c;

        /* compiled from: FrameworkSQLiteOpenHelper.java */
        /* renamed from: c.r.a.g.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0087a implements DatabaseErrorHandler {
            final /* synthetic */ c.a a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ c.r.a.g.a[] f3219b;

            C0087a(c.a aVar, c.r.a.g.a[] aVarArr) {
                this.a = aVar;
                this.f3219b = aVarArr;
            }

            @Override // android.database.DatabaseErrorHandler
            public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                this.a.c(a.b(this.f3219b, sQLiteDatabase));
            }
        }

        a(Context context, String str, c.r.a.g.a[] aVarArr, c.a aVar) {
            super(context, str, null, aVar.a, new C0087a(aVar, aVarArr));
            this.f3217b = aVar;
            this.a = aVarArr;
        }

        static c.r.a.g.a b(c.r.a.g.a[] aVarArr, SQLiteDatabase sQLiteDatabase) {
            c.r.a.g.a aVar = aVarArr[0];
            if (aVar == null || !aVar.a(sQLiteDatabase)) {
                aVarArr[0] = new c.r.a.g.a(sQLiteDatabase);
            }
            return aVarArr[0];
        }

        c.r.a.g.a a(SQLiteDatabase sQLiteDatabase) {
            return b(this.a, sQLiteDatabase);
        }

        synchronized c.r.a.b c() {
            this.f3218c = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (this.f3218c) {
                close();
                return c();
            }
            return a(writableDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public synchronized void close() {
            super.close();
            this.a[0] = null;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.f3217b.b(a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.f3217b.d(a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            this.f3218c = true;
            this.f3217b.e(a(sQLiteDatabase), i2, i3);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (this.f3218c) {
                return;
            }
            this.f3217b.f(a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            this.f3218c = true;
            this.f3217b.g(a(sQLiteDatabase), i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, String str, c.a aVar) {
        this.a = d(context, str, aVar);
    }

    private a d(Context context, String str, c.a aVar) {
        return new a(context, str, new c.r.a.g.a[1], aVar);
    }

    @Override // c.r.a.c
    public void a(boolean z) {
        this.a.setWriteAheadLoggingEnabled(z);
    }

    @Override // c.r.a.c
    public c.r.a.b b() {
        return this.a.c();
    }

    @Override // c.r.a.c
    public String c() {
        return this.a.getDatabaseName();
    }

    @Override // c.r.a.c
    public void close() {
        this.a.close();
    }
}