package e.a.a;

import java.util.Arrays;

/* compiled from: LottieResult.java */
/* loaded from: classes.dex */
public final class m<V> {
    private final V a;

    /* renamed from: b  reason: collision with root package name */
    private final Throwable f11575b;

    public m(V v) {
        this.a = v;
        this.f11575b = null;
    }

    public Throwable a() {
        return this.f11575b;
    }

    public V b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (b() == null || !b().equals(mVar.b())) {
                if (a() == null || mVar.a() == null) {
                    return false;
                }
                return a().toString().equals(a().toString());
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{b(), a()});
    }

    public m(Throwable th) {
        this.f11575b = th;
        this.a = null;
    }
}