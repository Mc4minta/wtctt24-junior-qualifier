package e.g.a.e.d.f;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
/* loaded from: classes2.dex */
public interface b {
    ScheduledExecutorService a(int i2, ThreadFactory threadFactory, int i3);

    ExecutorService b(ThreadFactory threadFactory, int i2);
}