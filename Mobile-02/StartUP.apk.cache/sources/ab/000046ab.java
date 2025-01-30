package e.f.j.l;

import android.os.SystemClock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: JobScheduler.java */
/* loaded from: classes2.dex */
public class u {
    private final Executor a;

    /* renamed from: b  reason: collision with root package name */
    private final d f12753b;

    /* renamed from: e  reason: collision with root package name */
    private final int f12756e;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f12754c = new a();

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f12755d = new b();

    /* renamed from: f  reason: collision with root package name */
    e.f.j.i.d f12757f = null;

    /* renamed from: g  reason: collision with root package name */
    int f12758g = 0;

    /* renamed from: h  reason: collision with root package name */
    f f12759h = f.IDLE;

    /* renamed from: i  reason: collision with root package name */
    long f12760i = 0;

    /* renamed from: j  reason: collision with root package name */
    long f12761j = 0;

    /* compiled from: JobScheduler.java */
    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            u.this.d();
        }
    }

    /* compiled from: JobScheduler.java */
    /* loaded from: classes2.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            u.this.j();
        }
    }

    /* compiled from: JobScheduler.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[f.values().length];
            a = iArr;
            try {
                iArr[f.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[f.QUEUED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[f.RUNNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[f.RUNNING_AND_PENDING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: JobScheduler.java */
    /* loaded from: classes2.dex */
    public interface d {
        void a(e.f.j.i.d dVar, int i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JobScheduler.java */
    /* loaded from: classes2.dex */
    public static class e {
        private static ScheduledExecutorService a;

        static ScheduledExecutorService a() {
            if (a == null) {
                a = Executors.newSingleThreadScheduledExecutor();
            }
            return a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JobScheduler.java */
    /* loaded from: classes2.dex */
    public enum f {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    public u(Executor executor, d dVar, int i2) {
        this.a = executor;
        this.f12753b = dVar;
        this.f12756e = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        e.f.j.i.d dVar;
        int i2;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            dVar = this.f12757f;
            i2 = this.f12758g;
            this.f12757f = null;
            this.f12758g = 0;
            this.f12759h = f.RUNNING;
            this.f12761j = uptimeMillis;
        }
        try {
            if (i(dVar, i2)) {
                this.f12753b.a(dVar, i2);
            }
        } finally {
            e.f.j.i.d.c(dVar);
            g();
        }
    }

    private void e(long j2) {
        if (j2 > 0) {
            e.a().schedule(this.f12755d, j2, TimeUnit.MILLISECONDS);
        } else {
            this.f12755d.run();
        }
    }

    private void g() {
        long j2;
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            if (this.f12759h == f.RUNNING_AND_PENDING) {
                j2 = Math.max(this.f12761j + this.f12756e, uptimeMillis);
                z = true;
                this.f12760i = uptimeMillis;
                this.f12759h = f.QUEUED;
            } else {
                this.f12759h = f.IDLE;
                j2 = 0;
                z = false;
            }
        }
        if (z) {
            e(j2 - uptimeMillis);
        }
    }

    private static boolean i(e.f.j.i.d dVar, int i2) {
        return e.f.j.l.b.d(i2) || e.f.j.l.b.m(i2, 4) || e.f.j.i.d.d0(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.a.execute(this.f12754c);
    }

    public void c() {
        e.f.j.i.d dVar;
        synchronized (this) {
            dVar = this.f12757f;
            this.f12757f = null;
            this.f12758g = 0;
        }
        e.f.j.i.d.c(dVar);
    }

    public synchronized long f() {
        return this.f12761j - this.f12760i;
    }

    public boolean h() {
        long max;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            boolean z = false;
            if (i(this.f12757f, this.f12758g)) {
                int i2 = c.a[this.f12759h.ordinal()];
                if (i2 != 1) {
                    if (i2 == 3) {
                        this.f12759h = f.RUNNING_AND_PENDING;
                    }
                    max = 0;
                } else {
                    max = Math.max(this.f12761j + this.f12756e, uptimeMillis);
                    this.f12760i = uptimeMillis;
                    this.f12759h = f.QUEUED;
                    z = true;
                }
                if (z) {
                    e(max - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    public boolean k(e.f.j.i.d dVar, int i2) {
        e.f.j.i.d dVar2;
        if (i(dVar, i2)) {
            synchronized (this) {
                dVar2 = this.f12757f;
                this.f12757f = e.f.j.i.d.b(dVar);
                this.f12758g = i2;
            }
            e.f.j.i.d.c(dVar2);
            return true;
        }
        return false;
    }
}