package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.runtime.backends.g;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public class m {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.datatransport.runtime.backends.e f5855b;

    /* renamed from: c  reason: collision with root package name */
    private final e.g.a.c.i.v.j.c f5856c;

    /* renamed from: d  reason: collision with root package name */
    private final s f5857d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f5858e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.android.datatransport.runtime.synchronization.a f5859f;

    /* renamed from: g  reason: collision with root package name */
    private final e.g.a.c.i.w.a f5860g;

    public m(Context context, com.google.android.datatransport.runtime.backends.e eVar, e.g.a.c.i.v.j.c cVar, s sVar, Executor executor, com.google.android.datatransport.runtime.synchronization.a aVar, e.g.a.c.i.w.a aVar2) {
        this.a = context;
        this.f5855b = eVar;
        this.f5856c = cVar;
        this.f5857d = sVar;
        this.f5858e = executor;
        this.f5859f = aVar;
        this.f5860g = aVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object c(m mVar, com.google.android.datatransport.runtime.backends.g gVar, Iterable iterable, e.g.a.c.i.l lVar, int i2) {
        if (gVar.c() == g.a.TRANSIENT_ERROR) {
            mVar.f5856c.Y0(iterable);
            mVar.f5857d.a(lVar, i2 + 1);
            return null;
        }
        mVar.f5856c.q(iterable);
        if (gVar.c() == g.a.OK) {
            mVar.f5856c.L(lVar, mVar.f5860g.a() + gVar.b());
        }
        if (mVar.f5856c.V0(lVar)) {
            mVar.f5857d.a(lVar, 1);
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object d(m mVar, e.g.a.c.i.l lVar, int i2) {
        mVar.f5857d.a(lVar, i2 + 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(m mVar, e.g.a.c.i.l lVar, int i2, Runnable runnable) {
        try {
            try {
                com.google.android.datatransport.runtime.synchronization.a aVar = mVar.f5859f;
                e.g.a.c.i.v.j.c cVar = mVar.f5856c;
                cVar.getClass();
                aVar.a(k.a(cVar));
                if (!mVar.a()) {
                    mVar.f5859f.a(l.a(mVar, lVar, i2));
                } else {
                    mVar.f(lVar, i2);
                }
            } catch (SynchronizationException unused) {
                mVar.f5857d.a(lVar, i2 + 1);
            }
        } finally {
            runnable.run();
        }
    }

    boolean a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    void f(e.g.a.c.i.l lVar, int i2) {
        com.google.android.datatransport.runtime.backends.g a;
        com.google.android.datatransport.runtime.backends.m a2 = this.f5855b.a(lVar.b());
        Iterable<e.g.a.c.i.v.j.i> iterable = (Iterable) this.f5859f.a(i.a(this, lVar));
        if (iterable.iterator().hasNext()) {
            if (a2 == null) {
                e.g.a.c.i.t.a.a("Uploader", "Unknown backend for %s, deleting event batch for it...", lVar);
                a = com.google.android.datatransport.runtime.backends.g.a();
            } else {
                ArrayList arrayList = new ArrayList();
                for (e.g.a.c.i.v.j.i iVar : iterable) {
                    arrayList.add(iVar.b());
                }
                a = a2.a(com.google.android.datatransport.runtime.backends.f.a().b(arrayList).c(lVar.c()).a());
            }
            this.f5859f.a(j.a(this, a, iterable, lVar, i2));
        }
    }

    public void g(e.g.a.c.i.l lVar, int i2, Runnable runnable) {
        this.f5858e.execute(h.a(this, lVar, i2, runnable));
    }
}