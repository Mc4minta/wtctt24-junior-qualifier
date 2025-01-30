package kotlinx.coroutines.i1;

import kotlinx.coroutines.y;

/* compiled from: Tasks.kt */
/* loaded from: classes3.dex */
public final class k extends i {

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f17474c;

    public k(Runnable runnable, long j2, j jVar) {
        super(j2, jVar);
        this.f17474c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f17474c.run();
        } finally {
            this.f17473b.d();
        }
    }

    public String toString() {
        return "Task[" + y.a(this.f17474c) + '@' + y.b(this.f17474c) + ", " + this.a + ", " + this.f17473b + ']';
    }
}