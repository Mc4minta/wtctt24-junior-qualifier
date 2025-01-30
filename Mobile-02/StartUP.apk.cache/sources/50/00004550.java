package e.f.b.b;

import e.f.b.a.c;
import java.io.IOException;

/* compiled from: SettableCacheEvent.java */
/* loaded from: classes2.dex */
public class j implements e.f.b.a.b {
    private static final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static j f12056b;

    /* renamed from: c  reason: collision with root package name */
    private static int f12057c;

    /* renamed from: d  reason: collision with root package name */
    private e.f.b.a.d f12058d;

    /* renamed from: e  reason: collision with root package name */
    private String f12059e;

    /* renamed from: f  reason: collision with root package name */
    private long f12060f;

    /* renamed from: g  reason: collision with root package name */
    private long f12061g;

    /* renamed from: h  reason: collision with root package name */
    private long f12062h;

    /* renamed from: i  reason: collision with root package name */
    private IOException f12063i;

    /* renamed from: j  reason: collision with root package name */
    private c.a f12064j;

    /* renamed from: k  reason: collision with root package name */
    private j f12065k;

    private j() {
    }

    public static j a() {
        synchronized (a) {
            j jVar = f12056b;
            if (jVar != null) {
                f12056b = jVar.f12065k;
                jVar.f12065k = null;
                f12057c--;
                return jVar;
            }
            return new j();
        }
    }

    private void c() {
        this.f12058d = null;
        this.f12059e = null;
        this.f12060f = 0L;
        this.f12061g = 0L;
        this.f12062h = 0L;
        this.f12063i = null;
        this.f12064j = null;
    }

    public void b() {
        synchronized (a) {
            if (f12057c < 5) {
                c();
                f12057c++;
                j jVar = f12056b;
                if (jVar != null) {
                    this.f12065k = jVar;
                }
                f12056b = this;
            }
        }
    }

    public j d(e.f.b.a.d dVar) {
        this.f12058d = dVar;
        return this;
    }

    public j e(long j2) {
        this.f12061g = j2;
        return this;
    }

    public j f(long j2) {
        this.f12062h = j2;
        return this;
    }

    public j g(c.a aVar) {
        this.f12064j = aVar;
        return this;
    }

    public j h(IOException iOException) {
        this.f12063i = iOException;
        return this;
    }

    public j i(long j2) {
        this.f12060f = j2;
        return this;
    }

    public j j(String str) {
        this.f12059e = str;
        return this;
    }
}