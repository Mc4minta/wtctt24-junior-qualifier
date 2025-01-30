package kotlinx.coroutines;

import java.util.Objects;
import kotlinx.coroutines.r0;

/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public abstract class v0<J extends r0> extends p implements d0, m0 {

    /* renamed from: d  reason: collision with root package name */
    public final J f17530d;

    public v0(J j2) {
        this.f17530d = j2;
    }

    @Override // kotlinx.coroutines.m0
    public boolean a() {
        return true;
    }

    @Override // kotlinx.coroutines.m0
    public y0 b() {
        return null;
    }

    @Override // kotlinx.coroutines.d0
    public void dispose() {
        J j2 = this.f17530d;
        Objects.requireNonNull(j2, "null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
        ((w0) j2).T(this);
    }

    @Override // kotlinx.coroutines.internal.i
    public String toString() {
        return y.a(this) + '@' + y.b(this) + "[job@" + y.b(this.f17530d) + ']';
    }
}