package h.c.t0;

import kotlin.e0.c.l;
import kotlin.jvm.internal.m;

/* compiled from: subscribers.kt */
/* loaded from: classes3.dex */
final class i implements h.c.m0.f {
    private final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(l lVar) {
        this.a = lVar;
    }

    @Override // h.c.m0.f
    public final /* synthetic */ void accept(T t) {
        m.d(this.a.invoke(t), "invoke(...)");
    }
}