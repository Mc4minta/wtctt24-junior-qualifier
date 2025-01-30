package e.f.d.b;

import android.os.Handler;
import android.os.Looper;

/* compiled from: UiThreadImmediateExecutorService.java */
/* loaded from: classes2.dex */
public class e extends b {

    /* renamed from: b  reason: collision with root package name */
    private static e f12067b;

    private e() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static e g() {
        if (f12067b == null) {
            f12067b = new e();
        }
        return f12067b;
    }

    @Override // e.f.d.b.b, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (a()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}