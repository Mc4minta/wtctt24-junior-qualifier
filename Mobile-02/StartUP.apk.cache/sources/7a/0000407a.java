package com.toshi.db.g;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.j;
import androidx.room.m;
import androidx.room.n;
import androidx.room.q;
import com.toshi.model.local.room.Bookmark;
import h.c.b0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: BookmarkDao_Impl.java */
/* loaded from: classes2.dex */
public final class c implements com.toshi.db.g.a {
    private final j a;

    /* renamed from: b  reason: collision with root package name */
    private final androidx.room.c<Bookmark> f11090b;

    /* renamed from: c  reason: collision with root package name */
    private final androidx.room.b<Bookmark> f11091c;

    /* renamed from: d  reason: collision with root package name */
    private final q f11092d;

    /* compiled from: BookmarkDao_Impl.java */
    /* loaded from: classes2.dex */
    class a extends androidx.room.c<Bookmark> {
        a(j jVar) {
            super(jVar);
        }

        @Override // androidx.room.c
        /* renamed from: a */
        public void bind(c.r.a.f fVar, Bookmark bookmark) {
            if (bookmark.getUrl() == null) {
                fVar.B0(1);
            } else {
                fVar.u(1, bookmark.getUrl());
            }
            if (bookmark.getTitle() == null) {
                fVar.B0(2);
            } else {
                fVar.u(2, bookmark.getTitle());
            }
            fVar.b0(3, bookmark.getCreatedAt());
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "INSERT OR ABORT INTO `bookmark` (`url`,`title`,`created_at`) VALUES (?,?,?)";
        }
    }

    /* compiled from: BookmarkDao_Impl.java */
    /* loaded from: classes2.dex */
    class b extends androidx.room.b<Bookmark> {
        b(j jVar) {
            super(jVar);
        }

        @Override // androidx.room.b
        /* renamed from: a */
        public void bind(c.r.a.f fVar, Bookmark bookmark) {
            if (bookmark.getUrl() == null) {
                fVar.B0(1);
            } else {
                fVar.u(1, bookmark.getUrl());
            }
        }

        @Override // androidx.room.b, androidx.room.q
        public String createQuery() {
            return "DELETE FROM `bookmark` WHERE `url` = ?";
        }
    }

    /* compiled from: BookmarkDao_Impl.java */
    /* renamed from: com.toshi.db.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0240c extends q {
        C0240c(j jVar) {
            super(jVar);
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "DELETE FROM bookmark";
        }
    }

    /* compiled from: BookmarkDao_Impl.java */
    /* loaded from: classes2.dex */
    class d implements Callable<Void> {
        final /* synthetic */ Bookmark a;

        d(Bookmark bookmark) {
            this.a = bookmark;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            c.this.a.beginTransaction();
            try {
                c.this.f11090b.insert((androidx.room.c) this.a);
                c.this.a.setTransactionSuccessful();
                return null;
            } finally {
                c.this.a.endTransaction();
            }
        }
    }

    /* compiled from: BookmarkDao_Impl.java */
    /* loaded from: classes2.dex */
    class e implements Callable<Void> {
        final /* synthetic */ Bookmark a;

        e(Bookmark bookmark) {
            this.a = bookmark;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            c.this.a.beginTransaction();
            try {
                c.this.f11091c.handle(this.a);
                c.this.a.setTransactionSuccessful();
                return null;
            } finally {
                c.this.a.endTransaction();
            }
        }
    }

    /* compiled from: BookmarkDao_Impl.java */
    /* loaded from: classes2.dex */
    class f implements Callable<Bookmark> {
        final /* synthetic */ m a;

        f(m mVar) {
            this.a = mVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Bookmark call() throws Exception {
            Cursor b2 = androidx.room.t.c.b(c.this.a, this.a, false, null);
            try {
                Bookmark bookmark = b2.moveToFirst() ? new Bookmark(b2.getString(androidx.room.t.b.b(b2, "url")), b2.getString(androidx.room.t.b.b(b2, MessageBundle.TITLE_ENTRY)), b2.getLong(androidx.room.t.b.b(b2, "created_at"))) : null;
                if (bookmark != null) {
                    return bookmark;
                }
                throw new EmptyResultSetException("Query returned empty result set: " + this.a.a());
            } finally {
                b2.close();
            }
        }

        protected void finalize() {
            this.a.f();
        }
    }

    /* compiled from: BookmarkDao_Impl.java */
    /* loaded from: classes2.dex */
    class g implements Callable<List<Bookmark>> {
        final /* synthetic */ m a;

        g(m mVar) {
            this.a = mVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public List<Bookmark> call() throws Exception {
            Cursor b2 = androidx.room.t.c.b(c.this.a, this.a, false, null);
            try {
                int b3 = androidx.room.t.b.b(b2, "url");
                int b4 = androidx.room.t.b.b(b2, MessageBundle.TITLE_ENTRY);
                int b5 = androidx.room.t.b.b(b2, "created_at");
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    arrayList.add(new Bookmark(b2.getString(b3), b2.getString(b4), b2.getLong(b5)));
                }
                return arrayList;
            } finally {
                b2.close();
            }
        }

        protected void finalize() {
            this.a.f();
        }
    }

    public c(j jVar) {
        this.a = jVar;
        this.f11090b = new a(jVar);
        this.f11091c = new b(jVar);
        this.f11092d = new C0240c(jVar);
    }

    @Override // com.toshi.db.g.b
    public b0<Bookmark> a(String str) {
        m c2 = m.c("SELECT * FROM bookmark WHERE url LIKE ?", 1);
        if (str == null) {
            c2.B0(1);
        } else {
            c2.u(1, str);
        }
        return n.a(new f(c2));
    }

    @Override // com.toshi.db.g.b
    public b0<List<Bookmark>> b() {
        return n.a(new g(m.c("SELECT * FROM bookmark", 0)));
    }

    @Override // com.toshi.db.g.b
    public h.c.c c(Bookmark bookmark) {
        return h.c.c.r(new d(bookmark));
    }

    @Override // com.toshi.db.g.b
    public h.c.c d(Bookmark bookmark) {
        return h.c.c.r(new e(bookmark));
    }
}