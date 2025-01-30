package kotlin.c0.i.a;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes3.dex */
public final class b implements kotlin.c0.d<Object> {
    public static final b a = new b();

    private b() {
    }

    @Override // kotlin.c0.d
    public void b(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // kotlin.c0.d
    public kotlin.c0.f e() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}