package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CompletionState.kt */
/* loaded from: classes3.dex */
public class n {
    private static final AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(n.class, "_handled");
    private volatile int _handled;

    /* renamed from: b  reason: collision with root package name */
    public final Throwable f17525b;

    public n(Throwable th, boolean z) {
        this.f17525b = th;
        this._handled = z ? 1 : 0;
    }

    public final boolean a() {
        return a.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return y.a(this) + '[' + this.f17525b + ']';
    }

    public /* synthetic */ n(Throwable th, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, (i2 & 2) != 0 ? false : z);
    }
}