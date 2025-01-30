package e.f.j.e;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: DefaultExecutorSupplier.java */
/* loaded from: classes2.dex */
public class b implements f {

    /* renamed from: b  reason: collision with root package name */
    private final Executor f12465b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f12466c;
    private final Executor a = Executors.newFixedThreadPool(2, new l(10, "FrescoIoBoundExecutor", true));

    /* renamed from: d  reason: collision with root package name */
    private final Executor f12467d = Executors.newFixedThreadPool(1, new l(10, "FrescoLightWeightBackgroundExecutor", true));

    public b(int i2) {
        this.f12465b = Executors.newFixedThreadPool(i2, new l(10, "FrescoDecodeExecutor", true));
        this.f12466c = Executors.newFixedThreadPool(i2, new l(10, "FrescoBackgroundExecutor", true));
    }

    @Override // e.f.j.e.f
    public Executor a() {
        return this.f12465b;
    }

    @Override // e.f.j.e.f
    public Executor b() {
        return this.f12467d;
    }

    @Override // e.f.j.e.f
    public Executor c() {
        return this.f12466c;
    }

    @Override // e.f.j.e.f
    public Executor d() {
        return this.a;
    }

    @Override // e.f.j.e.f
    public Executor e() {
        return this.a;
    }
}