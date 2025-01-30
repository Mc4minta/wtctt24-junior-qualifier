package kotlinx.coroutines;

/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public final class l0 implements m0 {
    private final y0 a;

    public l0(y0 y0Var) {
        this.a = y0Var;
    }

    @Override // kotlinx.coroutines.m0
    public boolean a() {
        return false;
    }

    @Override // kotlinx.coroutines.m0
    public y0 b() {
        return this.a;
    }

    public String toString() {
        return x.b() ? b().q("New") : super.toString();
    }
}