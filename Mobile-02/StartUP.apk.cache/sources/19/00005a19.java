package kotlinx.coroutines.internal;

import kotlinx.coroutines.y;

/* compiled from: Atomic.kt */
/* loaded from: classes3.dex */
public abstract class l {
    public abstract c<?> a();

    public final boolean b(l lVar) {
        c<?> a;
        c<?> a2 = a();
        return (a2 == null || (a = lVar.a()) == null || a2.f() >= a.f()) ? false : true;
    }

    public abstract Object c(Object obj);

    public String toString() {
        return y.a(this) + '@' + y.b(this);
    }
}