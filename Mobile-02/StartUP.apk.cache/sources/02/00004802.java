package e.g.a.e.d.e;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
final class f implements e {
    private f() {
    }

    @Override // e.g.a.e.d.e.e
    public final ScheduledExecutorService D(int i2, int i3) {
        return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
    }
}