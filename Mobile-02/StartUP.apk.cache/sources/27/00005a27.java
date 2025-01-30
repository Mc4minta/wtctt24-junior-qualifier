package kotlinx.coroutines.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThreadContext.kt */
/* loaded from: classes3.dex */
public final class v {
    private Object[] a;

    /* renamed from: b  reason: collision with root package name */
    private int f17513b;

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.c0.f f17514c;

    public v(kotlin.c0.f fVar, int i2) {
        this.f17514c = fVar;
        this.a = new Object[i2];
    }

    public final void a(Object obj) {
        Object[] objArr = this.a;
        int i2 = this.f17513b;
        this.f17513b = i2 + 1;
        objArr[i2] = obj;
    }

    public final kotlin.c0.f b() {
        return this.f17514c;
    }

    public final void c() {
        this.f17513b = 0;
    }

    public final Object d() {
        Object[] objArr = this.a;
        int i2 = this.f17513b;
        this.f17513b = i2 + 1;
        return objArr[i2];
    }
}