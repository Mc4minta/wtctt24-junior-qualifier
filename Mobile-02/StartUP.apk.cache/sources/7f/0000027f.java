package androidx.core.os;

import android.os.Build;
import android.os.CancellationSignal;

/* compiled from: CancellationSignal.java */
/* loaded from: classes.dex */
public final class c {
    private boolean a;

    /* renamed from: b  reason: collision with root package name */
    private a f1532b;

    /* renamed from: c  reason: collision with root package name */
    private Object f1533c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1534d;

    /* compiled from: CancellationSignal.java */
    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    private void e() {
        while (this.f1534d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void a() {
        synchronized (this) {
            if (this.a) {
                return;
            }
            this.a = true;
            this.f1534d = true;
            a aVar = this.f1532b;
            Object obj = this.f1533c;
            if (aVar != null) {
                try {
                    aVar.a();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f1534d = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            if (obj != null && Build.VERSION.SDK_INT >= 16) {
                ((CancellationSignal) obj).cancel();
            }
            synchronized (this) {
                this.f1534d = false;
                notifyAll();
            }
        }
    }

    public Object b() {
        Object obj;
        if (Build.VERSION.SDK_INT < 16) {
            return null;
        }
        synchronized (this) {
            if (this.f1533c == null) {
                CancellationSignal cancellationSignal = new CancellationSignal();
                this.f1533c = cancellationSignal;
                if (this.a) {
                    cancellationSignal.cancel();
                }
            }
            obj = this.f1533c;
        }
        return obj;
    }

    public boolean c() {
        boolean z;
        synchronized (this) {
            z = this.a;
        }
        return z;
    }

    public void d(a aVar) {
        synchronized (this) {
            e();
            if (this.f1532b == aVar) {
                return;
            }
            this.f1532b = aVar;
            if (this.a && aVar != null) {
                aVar.a();
            }
        }
    }
}