package e.f.h.b;

import android.os.Handler;
import android.os.Looper;
import e.f.d.c.i;
import java.util.HashSet;
import java.util.Set;

/* compiled from: DeferredReleaser.java */
/* loaded from: classes2.dex */
public class a {
    private static a a;

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f12186d = new RunnableC0265a();

    /* renamed from: b  reason: collision with root package name */
    private final Set<b> f12184b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    private final Handler f12185c = new Handler(Looper.getMainLooper());

    /* compiled from: DeferredReleaser.java */
    /* renamed from: e.f.h.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class RunnableC0265a implements Runnable {
        RunnableC0265a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.d();
            for (b bVar : a.this.f12184b) {
                bVar.a();
            }
            a.this.f12184b.clear();
        }
    }

    /* compiled from: DeferredReleaser.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d() {
        i.i(Looper.getMainLooper().getThread() == Thread.currentThread());
    }

    public static synchronized a e() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public void c(b bVar) {
        d();
        this.f12184b.remove(bVar);
    }

    public void f(b bVar) {
        d();
        if (this.f12184b.add(bVar) && this.f12184b.size() == 1) {
            this.f12185c.post(this.f12186d);
        }
    }
}