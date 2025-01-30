package com.google.firebase.installations;

import android.text.TextUtils;
import com.google.android.gms.common.internal.t;
import com.google.firebase.FirebaseException;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.r.d;
import com.google.firebase.installations.r.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.firebase:firebase-installations@@16.2.2 */
/* loaded from: classes2.dex */
public class h implements i {
    private static final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadFactory f9209b = new a();

    /* renamed from: c  reason: collision with root package name */
    private final com.google.firebase.c f9210c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.firebase.installations.r.c f9211d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.firebase.installations.q.c f9212e;

    /* renamed from: f  reason: collision with root package name */
    private final p f9213f;

    /* renamed from: g  reason: collision with root package name */
    private final com.google.firebase.installations.q.b f9214g;

    /* renamed from: h  reason: collision with root package name */
    private final n f9215h;

    /* renamed from: i  reason: collision with root package name */
    private final Object f9216i;

    /* renamed from: j  reason: collision with root package name */
    private final ExecutorService f9217j;

    /* renamed from: k  reason: collision with root package name */
    private final ExecutorService f9218k;

    /* renamed from: l  reason: collision with root package name */
    private final List<o> f9219l;

    /* compiled from: com.google.firebase:firebase-installations@@16.2.2 */
    /* loaded from: classes2.dex */
    class a implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", Integer.valueOf(this.a.getAndIncrement())));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-installations@@16.2.2 */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f9220b;

        static {
            int[] iArr = new int[e.b.values().length];
            f9220b = iArr;
            try {
                iArr[e.b.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9220b[e.b.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9220b[e.b.AUTH_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[d.b.values().length];
            a = iArr2;
            try {
                iArr2[d.b.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[d.b.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(com.google.firebase.c cVar, com.google.firebase.i.h hVar, com.google.firebase.f.c cVar2) {
        this(new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f9209b), cVar, new com.google.firebase.installations.r.c(cVar.g(), hVar, cVar2), new com.google.firebase.installations.q.c(cVar), new p(), new com.google.firebase.installations.q.b(cVar), new n());
    }

    private com.google.android.gms.tasks.g<m> g() {
        com.google.android.gms.tasks.h hVar = new com.google.android.gms.tasks.h();
        k kVar = new k(this.f9213f, hVar);
        synchronized (this.f9216i) {
            this.f9219l.add(kVar);
        }
        return hVar.a();
    }

    private com.google.android.gms.tasks.g<String> h() {
        com.google.android.gms.tasks.h hVar = new com.google.android.gms.tasks.h();
        l lVar = new l(hVar);
        synchronized (this.f9216i) {
            this.f9219l.add(lVar);
        }
        return hVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Void i() throws FirebaseInstallationsException, IOException {
        com.google.firebase.installations.q.d c2 = this.f9212e.c();
        if (c2.k()) {
            try {
                this.f9211d.d(p(), c2.d(), s(), c2.f());
            } catch (FirebaseException unused) {
                throw new FirebaseInstallationsException("Failed to delete a Firebase Installation.", FirebaseInstallationsException.a.BAD_CONFIG);
            }
        }
        this.f9212e.a(c2.r());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        n(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        n(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        n(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m(boolean r3) {
        /*
            r2 = this;
            com.google.firebase.installations.q.d r0 = r2.r()
            boolean r1 = r0.i()     // Catch: java.io.IOException -> L51
            if (r1 != 0) goto L22
            boolean r1 = r0.l()     // Catch: java.io.IOException -> L51
            if (r1 == 0) goto L11
            goto L22
        L11:
            if (r3 != 0) goto L1d
            com.google.firebase.installations.p r3 = r2.f9213f     // Catch: java.io.IOException -> L51
            boolean r3 = r3.b(r0)     // Catch: java.io.IOException -> L51
            if (r3 == 0) goto L1c
            goto L1d
        L1c:
            return
        L1d:
            com.google.firebase.installations.q.d r3 = r2.o(r0)     // Catch: java.io.IOException -> L51
            goto L26
        L22:
            com.google.firebase.installations.q.d r3 = r2.w(r0)     // Catch: java.io.IOException -> L51
        L26:
            com.google.firebase.installations.q.c r0 = r2.f9212e
            r0.a(r3)
            boolean r0 = r3.i()
            if (r0 == 0) goto L3c
            com.google.firebase.installations.FirebaseInstallationsException r0 = new com.google.firebase.installations.FirebaseInstallationsException
            com.google.firebase.installations.FirebaseInstallationsException$a r1 = com.google.firebase.installations.FirebaseInstallationsException.a.BAD_CONFIG
            r0.<init>(r1)
            r2.x(r3, r0)
            goto L50
        L3c:
            boolean r0 = r3.j()
            if (r0 == 0) goto L4d
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "cleared fid due to auth error"
            r0.<init>(r1)
            r2.x(r3, r0)
            goto L50
        L4d:
            r2.y(r3)
        L50:
            return
        L51:
            r3 = move-exception
            r2.x(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.h.m(boolean):void");
    }

    private final void n(boolean z) {
        com.google.firebase.installations.q.d r = r();
        if (z) {
            r = r.p();
        }
        y(r);
        this.f9218k.execute(g.a(this, z));
    }

    private com.google.firebase.installations.q.d o(com.google.firebase.installations.q.d dVar) throws IOException {
        com.google.firebase.installations.r.e e2 = this.f9211d.e(p(), dVar.d(), s(), dVar.f());
        int i2 = b.f9220b[e2.b().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return dVar.r();
                }
                throw new IOException();
            }
            return dVar.q("BAD CONFIG");
        }
        return dVar.o(e2.c(), e2.d(), this.f9213f.a());
    }

    private com.google.firebase.installations.q.d r() {
        com.google.firebase.installations.q.d c2;
        synchronized (a) {
            com.google.firebase.installations.b a2 = com.google.firebase.installations.b.a(this.f9210c.g(), "generatefid.lock");
            c2 = this.f9212e.c();
            if (c2.j()) {
                c2 = this.f9212e.a(c2.t(v(c2)));
            }
            if (a2 != null) {
                a2.b();
            }
        }
        return c2;
    }

    private void u() {
        t.g(q());
        t.g(s());
        t.g(p());
    }

    private String v(com.google.firebase.installations.q.d dVar) {
        if ((!this.f9210c.i().equals("CHIME_ANDROID_SDK") && !this.f9210c.q()) || !dVar.m()) {
            return this.f9215h.a();
        }
        String f2 = this.f9214g.f();
        return TextUtils.isEmpty(f2) ? this.f9215h.a() : f2;
    }

    private com.google.firebase.installations.q.d w(com.google.firebase.installations.q.d dVar) throws IOException {
        com.google.firebase.installations.r.d c2 = this.f9211d.c(p(), dVar.d(), s(), q(), dVar.d().length() == 11 ? this.f9214g.i() : null);
        int i2 = b.a[c2.e().ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return dVar.q("BAD CONFIG");
            }
            throw new IOException();
        }
        return dVar.s(c2.c(), c2.d(), this.f9213f.a(), c2.b().c(), c2.b().d());
    }

    private void x(com.google.firebase.installations.q.d dVar, Exception exc) {
        synchronized (this.f9216i) {
            Iterator<o> it = this.f9219l.iterator();
            while (it.hasNext()) {
                if (it.next().a(dVar, exc)) {
                    it.remove();
                }
            }
        }
    }

    private void y(com.google.firebase.installations.q.d dVar) {
        synchronized (this.f9216i) {
            Iterator<o> it = this.f9219l.iterator();
            while (it.hasNext()) {
                if (it.next().b(dVar)) {
                    it.remove();
                }
            }
        }
    }

    @Override // com.google.firebase.installations.i
    public com.google.android.gms.tasks.g<m> a(boolean z) {
        u();
        com.google.android.gms.tasks.g<m> g2 = g();
        if (z) {
            this.f9217j.execute(d.a(this));
        } else {
            this.f9217j.execute(e.a(this));
        }
        return g2;
    }

    @Override // com.google.firebase.installations.i
    public com.google.android.gms.tasks.g<Void> b() {
        return com.google.android.gms.tasks.j.c(this.f9217j, f.a(this));
    }

    @Override // com.google.firebase.installations.i
    public com.google.android.gms.tasks.g<String> getId() {
        u();
        com.google.android.gms.tasks.g<String> h2 = h();
        this.f9217j.execute(c.a(this));
        return h2;
    }

    String p() {
        return this.f9210c.j().b();
    }

    String q() {
        return this.f9210c.j().c();
    }

    String s() {
        if (TextUtils.isEmpty(this.f9210c.j().e())) {
            return this.f9210c.j().d();
        }
        return this.f9210c.j().e();
    }

    h(ExecutorService executorService, com.google.firebase.c cVar, com.google.firebase.installations.r.c cVar2, com.google.firebase.installations.q.c cVar3, p pVar, com.google.firebase.installations.q.b bVar, n nVar) {
        this.f9216i = new Object();
        this.f9219l = new ArrayList();
        this.f9210c = cVar;
        this.f9211d = cVar2;
        this.f9212e = cVar3;
        this.f9213f = pVar;
        this.f9214g = bVar;
        this.f9215h = nVar;
        this.f9217j = executorService;
        this.f9218k = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f9209b);
    }
}