package com.google.firebase.remoteconfig.internal;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public class e {
    private static final Map<String, e> a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final Executor f9422b = d.a();

    /* renamed from: c  reason: collision with root package name */
    private final ExecutorService f9423c;

    /* renamed from: d  reason: collision with root package name */
    private final m f9424d;

    /* renamed from: e  reason: collision with root package name */
    private com.google.android.gms.tasks.g<f> f9425e = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-config@@19.0.4 */
    /* loaded from: classes2.dex */
    public static class b<TResult> implements com.google.android.gms.tasks.e<TResult>, com.google.android.gms.tasks.d, com.google.android.gms.tasks.b {
        private final CountDownLatch a;

        private b() {
            this.a = new CountDownLatch(1);
        }

        public boolean a(long j2, TimeUnit timeUnit) throws InterruptedException {
            return this.a.await(j2, timeUnit);
        }

        @Override // com.google.android.gms.tasks.b
        public void b() {
            this.a.countDown();
        }

        @Override // com.google.android.gms.tasks.d
        public void c(Exception exc) {
            this.a.countDown();
        }

        @Override // com.google.android.gms.tasks.e
        public void onSuccess(TResult tresult) {
            this.a.countDown();
        }
    }

    private e(ExecutorService executorService, m mVar) {
        this.f9423c = executorService;
        this.f9424d = mVar;
    }

    private static <TResult> TResult a(com.google.android.gms.tasks.g<TResult> gVar, long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        b bVar = new b();
        Executor executor = f9422b;
        gVar.g(executor, bVar);
        gVar.e(executor, bVar);
        gVar.a(executor, bVar);
        if (bVar.a(j2, timeUnit)) {
            if (gVar.q()) {
                return gVar.m();
            }
            throw new ExecutionException(gVar.l());
        }
        throw new TimeoutException("Task await timed out.");
    }

    public static synchronized e f(ExecutorService executorService, m mVar) {
        e eVar;
        synchronized (e.class) {
            String b2 = mVar.b();
            Map<String, e> map = a;
            if (!map.containsKey(b2)) {
                map.put(b2, new e(executorService, mVar));
            }
            eVar = map.get(b2);
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ com.google.android.gms.tasks.g h(e eVar, boolean z, f fVar, Void r3) throws Exception {
        if (z) {
            eVar.k(fVar);
        }
        return com.google.android.gms.tasks.j.e(fVar);
    }

    private synchronized void k(f fVar) {
        this.f9425e = com.google.android.gms.tasks.j.e(fVar);
    }

    public void b() {
        synchronized (this) {
            this.f9425e = com.google.android.gms.tasks.j.e(null);
        }
        this.f9424d.a();
    }

    public synchronized com.google.android.gms.tasks.g<f> c() {
        com.google.android.gms.tasks.g<f> gVar = this.f9425e;
        if (gVar == null || (gVar.p() && !this.f9425e.q())) {
            ExecutorService executorService = this.f9423c;
            m mVar = this.f9424d;
            mVar.getClass();
            this.f9425e = com.google.android.gms.tasks.j.c(executorService, c.a(mVar));
        }
        return this.f9425e;
    }

    public f d() {
        return e(5L);
    }

    f e(long j2) {
        synchronized (this) {
            com.google.android.gms.tasks.g<f> gVar = this.f9425e;
            if (gVar != null && gVar.q()) {
                return this.f9425e.m();
            }
            try {
                return (f) a(c(), j2, TimeUnit.SECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException e2) {
                Log.d("FirebaseRemoteConfig", "Reading from storage file failed.", e2);
                return null;
            }
        }
    }

    public com.google.android.gms.tasks.g<f> i(f fVar) {
        return j(fVar, true);
    }

    public com.google.android.gms.tasks.g<f> j(f fVar, boolean z) {
        return com.google.android.gms.tasks.j.c(this.f9423c, com.google.firebase.remoteconfig.internal.a.a(this, fVar)).s(this.f9423c, com.google.firebase.remoteconfig.internal.b.b(this, z, fVar));
    }
}