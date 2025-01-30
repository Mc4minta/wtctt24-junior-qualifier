package e.f.m.w;

import android.os.Handler;
import android.util.SparseArray;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactSoftException;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.appregistry.AppRegistry;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: HeadlessJsTaskContext.java */
/* loaded from: classes2.dex */
public class b {
    private static final WeakHashMap<ReactContext, b> a = new WeakHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<ReactContext> f12899b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<e.f.m.w.c> f12900c = new CopyOnWriteArraySet();

    /* renamed from: d  reason: collision with root package name */
    private final AtomicInteger f12901d = new AtomicInteger(0);

    /* renamed from: e  reason: collision with root package name */
    private final Handler f12902e = new Handler();

    /* renamed from: f  reason: collision with root package name */
    private final Set<Integer> f12903f = new CopyOnWriteArraySet();

    /* renamed from: g  reason: collision with root package name */
    private final Map<Integer, e.f.m.w.a> f12904g = new ConcurrentHashMap();

    /* renamed from: h  reason: collision with root package name */
    private final SparseArray<Runnable> f12905h = new SparseArray<>();

    /* compiled from: HeadlessJsTaskContext.java */
    /* loaded from: classes2.dex */
    class a implements Runnable {
        final /* synthetic */ e.f.m.w.a a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f12906b;

        a(e.f.m.w.a aVar, int i2) {
            this.a = aVar;
            this.f12906b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.l(this.a, this.f12906b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HeadlessJsTaskContext.java */
    /* renamed from: e.f.m.w.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0287b implements Runnable {
        final /* synthetic */ int a;

        RunnableC0287b(int i2) {
            this.a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (e.f.m.w.c cVar : b.this.f12900c) {
                cVar.onHeadlessJsTaskFinish(this.a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HeadlessJsTaskContext.java */
    /* loaded from: classes2.dex */
    public class c implements Runnable {
        final /* synthetic */ int a;

        c(int i2) {
            this.a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.d(this.a);
        }
    }

    private b(ReactContext reactContext) {
        this.f12899b = new WeakReference<>(reactContext);
    }

    public static b e(ReactContext reactContext) {
        WeakHashMap<ReactContext, b> weakHashMap = a;
        b bVar = weakHashMap.get(reactContext);
        if (bVar == null) {
            b bVar2 = new b(reactContext);
            weakHashMap.put(reactContext, bVar2);
            return bVar2;
        }
        return bVar;
    }

    private void i(int i2) {
        Runnable runnable = this.f12905h.get(i2);
        if (runnable != null) {
            this.f12902e.removeCallbacks(runnable);
            this.f12905h.remove(i2);
        }
    }

    private void k(int i2, long j2) {
        c cVar = new c(i2);
        this.f12905h.append(i2, cVar);
        this.f12902e.postDelayed(cVar, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l(e.f.m.w.a aVar, int i2) {
        UiThreadUtil.assertOnUiThread();
        ReactContext reactContext = (ReactContext) e.f.k.a.a.d(this.f12899b.get(), "Tried to start a task on a react context that has already been destroyed");
        if (reactContext.getLifecycleState() == LifecycleState.RESUMED && !aVar.e()) {
            throw new IllegalStateException("Tried to start task " + aVar.c() + " while in foreground, but this is not allowed.");
        }
        this.f12903f.add(Integer.valueOf(i2));
        this.f12904g.put(Integer.valueOf(i2), new e.f.m.w.a(aVar));
        if (reactContext.hasActiveCatalystInstance()) {
            ((AppRegistry) reactContext.getJSModule(AppRegistry.class)).startHeadlessTask(i2, aVar.c(), aVar.a());
        } else {
            ReactSoftException.logSoftException("HeadlessJsTaskContext", new RuntimeException("Cannot start headless task, CatalystInstance not available"));
        }
        if (aVar.d() > 0) {
            k(i2, aVar.d());
        }
        for (e.f.m.w.c cVar : this.f12900c) {
            cVar.onHeadlessJsTaskStart(i2);
        }
    }

    public void c(e.f.m.w.c cVar) {
        this.f12900c.add(cVar);
    }

    public synchronized void d(int i2) {
        boolean remove = this.f12903f.remove(Integer.valueOf(i2));
        e.f.k.a.a.b(remove, "Tried to finish non-existent task with id " + i2 + ".");
        boolean z = this.f12904g.remove(Integer.valueOf(i2)) != null;
        e.f.k.a.a.b(z, "Tried to remove non-existent task config with id " + i2 + ".");
        i(i2);
        UiThreadUtil.runOnUiThread(new RunnableC0287b(i2));
    }

    public boolean f() {
        return this.f12903f.size() > 0;
    }

    public synchronized boolean g(int i2) {
        return this.f12903f.contains(Integer.valueOf(i2));
    }

    public void h(e.f.m.w.c cVar) {
        this.f12900c.remove(cVar);
    }

    public synchronized boolean j(int i2) {
        e.f.m.w.a aVar = this.f12904g.get(Integer.valueOf(i2));
        boolean z = aVar != null;
        e.f.k.a.a.b(z, "Tried to retrieve non-existent task config with id " + i2 + ".");
        d b2 = aVar.b();
        if (b2.b()) {
            i(i2);
            UiThreadUtil.runOnUiThread(new a(new e.f.m.w.a(aVar.c(), aVar.a(), aVar.d(), aVar.e(), b2.a()), i2), b2.c());
            return true;
        }
        return false;
    }
}