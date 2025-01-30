package e.f.h.b;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/* compiled from: DraweeEventTracker.java */
/* loaded from: classes2.dex */
public class b {
    private static final b a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f12187b = true;

    /* renamed from: c  reason: collision with root package name */
    private final Queue<a> f12188c = new ArrayBlockingQueue(20);

    /* compiled from: DraweeEventTracker.java */
    /* loaded from: classes2.dex */
    public enum a {
        ON_SET_HIERARCHY,
        ON_CLEAR_HIERARCHY,
        ON_SET_CONTROLLER,
        ON_CLEAR_OLD_CONTROLLER,
        ON_CLEAR_CONTROLLER,
        ON_INIT_CONTROLLER,
        ON_ATTACH_CONTROLLER,
        ON_DETACH_CONTROLLER,
        ON_RELEASE_CONTROLLER,
        ON_DATASOURCE_SUBMIT,
        ON_DATASOURCE_RESULT,
        ON_DATASOURCE_RESULT_INT,
        ON_DATASOURCE_FAILURE,
        ON_DATASOURCE_FAILURE_INT,
        ON_HOLDER_ATTACH,
        ON_HOLDER_DETACH,
        ON_DRAWABLE_SHOW,
        ON_DRAWABLE_HIDE,
        ON_ACTIVITY_START,
        ON_ACTIVITY_STOP,
        ON_RUN_CLEAR_CONTROLLER,
        ON_SCHEDULE_CLEAR_CONTROLLER,
        ON_SAME_CONTROLLER_SKIPPED,
        ON_SUBMIT_CACHE_HIT
    }

    private b() {
    }

    public static b a() {
        return f12187b ? new b() : a;
    }

    public void b(a aVar) {
        if (f12187b) {
            if (this.f12188c.size() + 1 > 20) {
                this.f12188c.poll();
            }
            this.f12188c.add(aVar);
        }
    }

    public String toString() {
        return this.f12188c.toString();
    }
}