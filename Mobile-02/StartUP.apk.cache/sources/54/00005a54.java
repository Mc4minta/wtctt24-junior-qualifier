package kotlinx.coroutines;

/* compiled from: Job.kt */
/* loaded from: classes3.dex */
public final class z0 implements d0, i {
    public static final z0 a = new z0();

    private z0() {
    }

    @Override // kotlinx.coroutines.d0
    public void dispose() {
    }

    @Override // kotlinx.coroutines.i
    public boolean n(Throwable th) {
        return false;
    }

    public String toString() {
        return "NonDisposableHandle";
    }
}