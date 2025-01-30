package c.o.b;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.os.OperationCanceledException;
import androidx.core.util.i;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* compiled from: AsyncTaskLoader.java */
/* loaded from: classes.dex */
public abstract class a<D> extends b<D> {

    /* renamed from: j  reason: collision with root package name */
    private final Executor f3161j;

    /* renamed from: k  reason: collision with root package name */
    volatile a<D>.RunnableC0079a f3162k;

    /* renamed from: l  reason: collision with root package name */
    volatile a<D>.RunnableC0079a f3163l;
    long m;
    long n;
    Handler o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AsyncTaskLoader.java */
    /* renamed from: c.o.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class RunnableC0079a extends c<Void, Void, D> implements Runnable {

        /* renamed from: l  reason: collision with root package name */
        private final CountDownLatch f3164l = new CountDownLatch(1);
        boolean m;

        RunnableC0079a() {
        }

        @Override // c.o.b.c
        protected void h(D d2) {
            try {
                a.this.x(this, d2);
            } finally {
                this.f3164l.countDown();
            }
        }

        @Override // c.o.b.c
        protected void i(D d2) {
            try {
                a.this.y(this, d2);
            } finally {
                this.f3164l.countDown();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // c.o.b.c
        /* renamed from: n */
        public D b(Void... voidArr) {
            try {
                return (D) a.this.C();
            } catch (OperationCanceledException e2) {
                if (f()) {
                    return null;
                }
                throw e2;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.m = false;
            a.this.z();
        }
    }

    public a(Context context) {
        this(context, c.f3174c);
    }

    public abstract D A();

    public void B(D d2) {
    }

    protected D C() {
        return A();
    }

    @Override // c.o.b.b
    @Deprecated
    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.g(str, fileDescriptor, printWriter, strArr);
        if (this.f3162k != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f3162k);
            printWriter.print(" waiting=");
            printWriter.println(this.f3162k.m);
        }
        if (this.f3163l != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f3163l);
            printWriter.print(" waiting=");
            printWriter.println(this.f3163l.m);
        }
        if (this.m != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            i.c(this.m, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            i.b(this.n, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    @Override // c.o.b.b
    protected boolean k() {
        if (this.f3162k != null) {
            if (!this.f3168e) {
                this.f3171h = true;
            }
            if (this.f3163l != null) {
                if (this.f3162k.m) {
                    this.f3162k.m = false;
                    this.o.removeCallbacks(this.f3162k);
                }
                this.f3162k = null;
                return false;
            } else if (this.f3162k.m) {
                this.f3162k.m = false;
                this.o.removeCallbacks(this.f3162k);
                this.f3162k = null;
                return false;
            } else {
                boolean a = this.f3162k.a(false);
                if (a) {
                    this.f3163l = this.f3162k;
                    w();
                }
                this.f3162k = null;
                return a;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // c.o.b.b
    public void m() {
        super.m();
        b();
        this.f3162k = new RunnableC0079a();
        z();
    }

    public void w() {
    }

    void x(a<D>.RunnableC0079a runnableC0079a, D d2) {
        B(d2);
        if (this.f3163l == runnableC0079a) {
            s();
            this.n = SystemClock.uptimeMillis();
            this.f3163l = null;
            e();
            z();
        }
    }

    void y(a<D>.RunnableC0079a runnableC0079a, D d2) {
        if (this.f3162k != runnableC0079a) {
            x(runnableC0079a, d2);
        } else if (i()) {
            B(d2);
        } else {
            c();
            this.n = SystemClock.uptimeMillis();
            this.f3162k = null;
            f(d2);
        }
    }

    void z() {
        if (this.f3163l != null || this.f3162k == null) {
            return;
        }
        if (this.f3162k.m) {
            this.f3162k.m = false;
            this.o.removeCallbacks(this.f3162k);
        }
        if (this.m > 0 && SystemClock.uptimeMillis() < this.n + this.m) {
            this.f3162k.m = true;
            this.o.postAtTime(this.f3162k, this.n + this.m);
            return;
        }
        this.f3162k.c(this.f3161j, null);
    }

    private a(Context context, Executor executor) {
        super(context);
        this.n = -10000L;
        this.f3161j = executor;
    }
}