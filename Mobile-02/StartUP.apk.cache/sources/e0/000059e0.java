package kotlinx.coroutines;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public final class e0 implements m0 {
    private final boolean a;

    public e0(boolean z) {
        this.a = z;
    }

    @Override // kotlinx.coroutines.m0
    public boolean a() {
        return this.a;
    }

    @Override // kotlinx.coroutines.m0
    public y0 b() {
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(a() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}