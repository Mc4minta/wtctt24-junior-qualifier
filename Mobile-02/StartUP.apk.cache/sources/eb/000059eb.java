package kotlinx.coroutines;

/* compiled from: Unconfined.kt */
/* loaded from: classes3.dex */
public final class g1 extends t {

    /* renamed from: b  reason: collision with root package name */
    public static final g1 f17434b = new g1();

    private g1() {
    }

    @Override // kotlinx.coroutines.t
    public void A(kotlin.c0.f fVar, Runnable runnable) {
        h1 h1Var = (h1) fVar.get(h1.a);
        if (h1Var != null) {
            h1Var.f17436b = true;
            return;
        }
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    @Override // kotlinx.coroutines.t
    public boolean G(kotlin.c0.f fVar) {
        return false;
    }

    @Override // kotlinx.coroutines.t
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}