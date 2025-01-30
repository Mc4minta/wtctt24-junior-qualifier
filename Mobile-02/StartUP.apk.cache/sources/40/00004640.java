package e.f.j.e;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: PriorityThreadFactory.java */
/* loaded from: classes2.dex */
public class l implements ThreadFactory {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12535b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f12536c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicInteger f12537d = new AtomicInteger(1);

    /* compiled from: PriorityThreadFactory.java */
    /* loaded from: classes2.dex */
    class a implements Runnable {
        final /* synthetic */ Runnable a;

        a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Process.setThreadPriority(l.this.a);
            } catch (Throwable unused) {
            }
            this.a.run();
        }
    }

    public l(int i2, String str, boolean z) {
        this.a = i2;
        this.f12535b = str;
        this.f12536c = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str;
        a aVar = new a(runnable);
        if (this.f12536c) {
            str = this.f12535b + "-" + this.f12537d.getAndIncrement();
        } else {
            str = this.f12535b;
        }
        return new Thread(aVar, str);
    }
}