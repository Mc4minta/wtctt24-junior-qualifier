package e.j.i;

import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.toshi.model.local.room.Bookmark;
import java.util.List;

/* compiled from: BookmarkRepository.kt */
@ApplicationScoped
/* loaded from: classes2.dex */
public final class u1 implements e.j.i.i2.a {
    private final com.toshi.db.g.b a;

    /* renamed from: b */
    private final kotlin.h f13650b;

    /* renamed from: c */
    private final h.c.a0 f13651c;

    /* renamed from: d */
    private final h.c.v0.a<List<Bookmark>> f13652d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BookmarkRepository.kt */
    /* loaded from: classes2.dex */
    public static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Bookmark, h.c.c> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a() {
            super(1);
            u1.this = r1;
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final h.c.c invoke(Bookmark it) {
            kotlin.jvm.internal.m.g(it, "it");
            return u1.this.a.d(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BookmarkRepository.kt */
    /* loaded from: classes2.dex */
    public static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.a<h.c.k0.a> {
        public static final b a = new b();

        b() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        public final h.c.k0.a invoke() {
            return new h.c.k0.a();
        }
    }

    public u1(com.toshi.db.g.b bookmarkDao) {
        kotlin.h b2;
        kotlin.jvm.internal.m.g(bookmarkDao, "bookmarkDao");
        this.a = bookmarkDao;
        b2 = kotlin.k.b(b.a);
        this.f13650b = b2;
        h.c.a0 c2 = h.c.u0.a.c();
        kotlin.jvm.internal.m.f(c2, "io()");
        this.f13651c = c2;
        h.c.v0.a<List<Bookmark>> d2 = h.c.v0.a.d();
        kotlin.jvm.internal.m.f(d2, "create()");
        this.f13652d = d2;
    }

    public static final void d(Throwable th) {
        l.a.a.f(th, "Could not add bookmark", new Object[0]);
    }

    public static final Bookmark f(Bookmark it) {
        kotlin.jvm.internal.m.g(it, "it");
        if (it.isValidBookmark()) {
            return it;
        }
        throw new IllegalStateException("Trying to delete an invalid bookmark");
    }

    private final h.c.k0.a h() {
        return (h.c.k0.a) this.f13650b.getValue();
    }

    public static /* synthetic */ void i(Throwable th) {
        d(th);
    }

    public static /* synthetic */ void j(u1 u1Var, List list) {
        p(u1Var, list);
    }

    public static /* synthetic */ void k(Throwable th) {
        o(th);
    }

    public static /* synthetic */ void l(Throwable th) {
        q(th);
    }

    public static /* synthetic */ Bookmark m(Bookmark bookmark) {
        return f(bookmark);
    }

    public static final void o(Throwable th) {
        l.a.a.f(th, "Could not load bookmarks", new Object[0]);
    }

    public static final void p(u1 this$0, List list) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.f13652d.onNext(list);
    }

    public static final void q(Throwable th) {
        l.a.a.f(th, "Error while fetching bookmarks", new Object[0]);
    }

    public h.c.b0<Bookmark> c(String url, String title) {
        kotlin.jvm.internal.m.g(url, "url");
        kotlin.jvm.internal.m.g(title, "title");
        Bookmark bookmark = new Bookmark(url, title, System.currentTimeMillis());
        if (!bookmark.isValidBookmark()) {
            h.c.b0<Bookmark> error = h.c.b0.error(new IllegalStateException("Trying to add an invalid bookmark"));
            kotlin.jvm.internal.m.f(error, "error(IllegalStateException(\"Trying to add an invalid bookmark\"))");
            return error;
        }
        h.c.b0<Bookmark> doOnError = this.a.c(bookmark).x(bookmark).subscribeOn(this.f13651c).doOnError(new h.c.m0.f() { // from class: e.j.i.a
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                u1.i((Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(doOnError, "bookmarkDao.insert(bookmark)\n            .toSingleDefault(bookmark)\n            .subscribeOn(concurrentScheduler)\n            .doOnError { Timber.e(it, \"Could not add bookmark\") }");
        return doOnError;
    }

    public h.c.b0<Bookmark> e(String url) {
        kotlin.jvm.internal.m.g(url, "url");
        h.c.b0<R> map = this.a.a(url).subscribeOn(this.f13651c).map(new h.c.m0.n() { // from class: e.j.i.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return u1.m((Bookmark) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "bookmarkDao.get(url)\n            .subscribeOn(concurrentScheduler)\n            .map {\n                if (!it.isValidBookmark()) throw IllegalStateException(\"Trying to delete an invalid bookmark\")\n                else it\n            }");
        return e.j.f.t.a(map, new a());
    }

    public h.c.s<List<Bookmark>> g() {
        h.c.s<List<Bookmark>> hide = this.f13652d.hide();
        kotlin.jvm.internal.m.f(hide, "bookmarksSubject.hide()");
        return hide;
    }

    public void n() {
        h().b(this.a.b().subscribeOn(this.f13651c).doOnError(new h.c.m0.f() { // from class: e.j.i.c
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                u1.k((Throwable) obj);
            }
        }).subscribe(new h.c.m0.f() { // from class: e.j.i.b
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                u1.j(u1.this, (List) obj);
            }
        }, new h.c.m0.f() { // from class: e.j.i.d
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                u1.l((Throwable) obj);
            }
        }));
    }

    @Override // com.coinbase.wallet.core.interfaces.Startable
    public void start() {
        n();
    }
}