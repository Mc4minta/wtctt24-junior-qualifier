package e.f.b.b;

import android.content.Context;
import e.f.d.c.l;
import java.io.File;

/* compiled from: DiskCacheConfig.java */
/* loaded from: classes2.dex */
public class c {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12013b;

    /* renamed from: c  reason: collision with root package name */
    private final l<File> f12014c;

    /* renamed from: d  reason: collision with root package name */
    private final long f12015d;

    /* renamed from: e  reason: collision with root package name */
    private final long f12016e;

    /* renamed from: f  reason: collision with root package name */
    private final long f12017f;

    /* renamed from: g  reason: collision with root package name */
    private final h f12018g;

    /* renamed from: h  reason: collision with root package name */
    private final e.f.b.a.a f12019h;

    /* renamed from: i  reason: collision with root package name */
    private final e.f.b.a.c f12020i;

    /* renamed from: j  reason: collision with root package name */
    private final e.f.d.a.b f12021j;

    /* renamed from: k  reason: collision with root package name */
    private final Context f12022k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f12023l;

    /* compiled from: DiskCacheConfig.java */
    /* loaded from: classes2.dex */
    public static class b {
        private int a;

        /* renamed from: b  reason: collision with root package name */
        private String f12024b;

        /* renamed from: c  reason: collision with root package name */
        private l<File> f12025c;

        /* renamed from: d  reason: collision with root package name */
        private long f12026d;

        /* renamed from: e  reason: collision with root package name */
        private long f12027e;

        /* renamed from: f  reason: collision with root package name */
        private long f12028f;

        /* renamed from: g  reason: collision with root package name */
        private h f12029g;

        /* renamed from: h  reason: collision with root package name */
        private e.f.b.a.a f12030h;

        /* renamed from: i  reason: collision with root package name */
        private e.f.b.a.c f12031i;

        /* renamed from: j  reason: collision with root package name */
        private e.f.d.a.b f12032j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f12033k;

        /* renamed from: l  reason: collision with root package name */
        private final Context f12034l;

        /* compiled from: DiskCacheConfig.java */
        /* loaded from: classes2.dex */
        class a implements l<File> {
            a() {
            }

            @Override // e.f.d.c.l
            /* renamed from: a */
            public File get() {
                return b.this.f12034l.getApplicationContext().getCacheDir();
            }
        }

        public c m() {
            e.f.d.c.i.j((this.f12025c == null && this.f12034l == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.f12025c == null && this.f12034l != null) {
                this.f12025c = new a();
            }
            return new c(this);
        }

        private b(Context context) {
            this.a = 1;
            this.f12024b = "image_cache";
            this.f12026d = 41943040L;
            this.f12027e = 10485760L;
            this.f12028f = 2097152L;
            this.f12029g = new e.f.b.b.b();
            this.f12034l = context;
        }
    }

    public static b m(Context context) {
        return new b(context);
    }

    public String a() {
        return this.f12013b;
    }

    public l<File> b() {
        return this.f12014c;
    }

    public e.f.b.a.a c() {
        return this.f12019h;
    }

    public e.f.b.a.c d() {
        return this.f12020i;
    }

    public Context e() {
        return this.f12022k;
    }

    public long f() {
        return this.f12015d;
    }

    public e.f.d.a.b g() {
        return this.f12021j;
    }

    public h h() {
        return this.f12018g;
    }

    public boolean i() {
        return this.f12023l;
    }

    public long j() {
        return this.f12016e;
    }

    public long k() {
        return this.f12017f;
    }

    public int l() {
        return this.a;
    }

    private c(b bVar) {
        e.f.b.a.a aVar;
        e.f.b.a.c cVar;
        e.f.d.a.b bVar2;
        this.a = bVar.a;
        this.f12013b = (String) e.f.d.c.i.g(bVar.f12024b);
        this.f12014c = (l) e.f.d.c.i.g(bVar.f12025c);
        this.f12015d = bVar.f12026d;
        this.f12016e = bVar.f12027e;
        this.f12017f = bVar.f12028f;
        this.f12018g = (h) e.f.d.c.i.g(bVar.f12029g);
        if (bVar.f12030h != null) {
            aVar = bVar.f12030h;
        } else {
            aVar = e.f.b.a.g.b();
        }
        this.f12019h = aVar;
        if (bVar.f12031i != null) {
            cVar = bVar.f12031i;
        } else {
            cVar = e.f.b.a.h.i();
        }
        this.f12020i = cVar;
        if (bVar.f12032j != null) {
            bVar2 = bVar.f12032j;
        } else {
            bVar2 = e.f.d.a.c.b();
        }
        this.f12021j = bVar2;
        this.f12022k = bVar.f12034l;
        this.f12023l = bVar.f12033k;
    }
}