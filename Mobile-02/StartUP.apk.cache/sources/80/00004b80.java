package h.a.a.a;

import kotlin.jvm.internal.m;

/* compiled from: TaskOnSubscribe.kt */
/* loaded from: classes2.dex */
public abstract class g<Result, Emitter> {
    private final com.google.android.gms.tasks.g<Result> a;

    /* renamed from: b  reason: collision with root package name */
    private final f<Result, Emitter> f14027b;

    /* JADX WARN: Multi-variable type inference failed */
    public g(com.google.android.gms.tasks.g<Result> task, f<Result, ? super Emitter> factory) {
        m.h(task, "task");
        m.h(factory, "factory");
        this.a = task;
        this.f14027b = factory;
    }

    public final void a(Emitter emitter) {
        this.a.f(this.f14027b.a(emitter));
        this.a.d(this.f14027b.b(emitter));
    }
}