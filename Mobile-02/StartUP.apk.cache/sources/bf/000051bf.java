package kotlin.c0.i.a;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes3.dex */
public abstract class i extends a {
    public i(kotlin.c0.d<Object> dVar) {
        super(dVar);
        if (dVar != null) {
            if (!(dVar.e() == kotlin.c0.g.a)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // kotlin.c0.d
    public kotlin.c0.f e() {
        return kotlin.c0.g.a;
    }
}