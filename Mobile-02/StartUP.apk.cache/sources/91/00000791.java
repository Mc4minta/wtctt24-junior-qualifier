package com.bugsnag.android;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ErrorStore.java */
/* loaded from: classes.dex */
public class e0 extends i0<c0> {

    /* renamed from: g  reason: collision with root package name */
    static final Comparator<File> f3645g = new a();

    /* renamed from: h  reason: collision with root package name */
    volatile boolean f3646h;

    /* renamed from: i  reason: collision with root package name */
    private final Semaphore f3647i;

    /* renamed from: j  reason: collision with root package name */
    private final d f3648j;

    /* compiled from: ErrorStore.java */
    /* loaded from: classes.dex */
    static class a implements Comparator<File> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            if (file == null && file2 == null) {
                return 0;
            }
            if (file == null) {
                return 1;
            }
            if (file2 == null) {
                return -1;
            }
            return file.getName().replaceAll("_startupcrash", "").compareTo(file2.getName().replaceAll("_startupcrash", ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ErrorStore.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        final /* synthetic */ List a;

        b(List list) {
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.l(this.a);
            e0.this.f3646h = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ErrorStore.java */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e0 e0Var = e0.this;
            e0Var.l(e0Var.e());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ErrorStore.java */
    /* loaded from: classes.dex */
    public interface d {
        void a(Exception exc, File file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e0(s sVar, Context context, d dVar) {
        super(sVar, context, "/bugsnag-errors/", 128, f3645g);
        this.f3646h = false;
        this.f3647i = new Semaphore(1);
        this.f3648j = dVar;
    }

    private List<File> h(Collection<File> collection) {
        ArrayList arrayList = new ArrayList();
        for (File file : collection) {
            if (m(file)) {
                arrayList.add(file);
            }
        }
        return arrayList;
    }

    private void j(File file) {
        try {
            v0 v0Var = new v0(this.a.c(), d0.f(this.a, file));
            for (h hVar : this.a.h()) {
                if (!hVar.a(v0Var)) {
                    b(Collections.singleton(file));
                    q0.b("Deleting cancelled error file " + file.getName());
                    return;
                }
            }
            this.a.l().a(v0Var, this.a);
            b(Collections.singleton(file));
            q0.b("Deleting sent error file " + file.getName());
        } catch (DeliveryFailureException e2) {
            a(Collections.singleton(file));
            q0.e("Could not send previously saved error(s) to Bugsnag, will try again later", e2);
        } catch (Exception e3) {
            d dVar = this.f3648j;
            if (dVar != null) {
                dVar.a(e3, file);
            }
            b(Collections.singleton(file));
        }
    }

    @Override // com.bugsnag.android.i0
    String f(Object obj) {
        String str;
        if (obj instanceof c0) {
            Map<String, Object> a2 = ((c0) obj).a();
            str = ((a2 instanceof Map) && (a2.get("duration") instanceof Number) && n(((Number) a2.get("duration")).longValue())) ? "_startupcrash" : "";
        } else {
            str = "not-jvm";
        }
        return String.format(Locale.US, "%s%d_%s%s.json", this.f3655b, Long.valueOf(System.currentTimeMillis()), UUID.randomUUID().toString(), str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        if (this.f3655b == null) {
            return;
        }
        try {
            e.a(new c());
        } catch (RejectedExecutionException unused) {
            q0.d("Failed to flush all on-disk errors, retaining unsent errors for later.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        long j2 = 0;
        if (this.a.r() != 0) {
            List<File> e2 = e();
            List<File> h2 = h(e2);
            if (!h2.isEmpty()) {
                this.f3646h = false;
                q0.b("Attempting to send launch crash reports");
                try {
                    e.a(new b(h2));
                } catch (RejectedExecutionException e3) {
                    q0.e("Failed to flush launch crash reports", e3);
                    this.f3646h = true;
                }
                while (!this.f3646h && j2 < 2000) {
                    try {
                        Thread.sleep(50L);
                        j2 += 50;
                    } catch (InterruptedException unused) {
                        q0.d("Interrupted while waiting for launch crash report request");
                    }
                }
                q0.b("Continuing with Bugsnag initialisation");
            }
            a(e2);
        }
        i();
    }

    void l(Collection<File> collection) {
        if (collection.isEmpty()) {
            return;
        }
        if (this.f3647i.tryAcquire(1)) {
            try {
                q0.b(String.format(Locale.US, "Sending %d saved error(s) to Bugsnag", Integer.valueOf(collection.size())));
                for (File file : collection) {
                    j(file);
                }
            } finally {
                this.f3647i.release(1);
            }
        }
    }

    boolean m(File file) {
        return file.getName().endsWith("_startupcrash.json");
    }

    boolean n(long j2) {
        return j2 < this.a.r();
    }
}